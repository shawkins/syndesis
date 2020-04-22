/*
 * Copyright (C) 2016 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.syndesis.server.logging.jaeger.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.opentracing.tag.Tags;
import io.syndesis.server.endpoint.v1.handler.activity.Activity;
import io.syndesis.server.endpoint.v1.handler.activity.ActivityStep;
import io.syndesis.server.endpoint.v1.handler.activity.ActivityTrackingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * Implements a dblogging service for the Activity JAXRS service.
 */
@Component
@ConditionalOnProperty(value = "endpoints.jaeger-activity-tracing.enabled", havingValue = "true", matchIfMissing = true)
public class JaegerActivityTrackingService implements ActivityTrackingService {

    private static final Logger LOG = LoggerFactory.getLogger(JaegerActivityTrackingService.class);

    private final JaegerQueryAPI jaegerQueryApi;

    public JaegerActivityTrackingService(JaegerQueryAPI jaegerQueryApi) {
        this.jaegerQueryApi = jaegerQueryApi;
    }

    // NOPMD
    @Override
    @SuppressWarnings({"PMD.NPathComplexity"})
    public List<Activity> getActivities(String integrationId, String from, Integer requestedLimit) {

        int lookbackDays = 30;
        int limit = 10;
        if (requestedLimit != null) {
            limit = requestedLimit;
        }
        if (limit > 1000) {
            limit = 1000; // max out to 1000 per request.
        }

        // http://localhost:16686/api/traces?end=1548280423588000&limit=20&lookback=1h&maxDuration&minDuration&service=io.syndesis.integration.runtime.tracing.ActivityTracingWithSplitTest&start=1548276823588000
        ArrayList<JaegerQueryAPI.Trace> traces = jaegerQueryApi.tracesForService(integrationId, lookbackDays, limit);

        ArrayList<Activity> rc = new ArrayList<>();
        for (JaegerQueryAPI.Trace trace : traces) {
            Activity activity = null;
            ArrayList<ActivityStep> steps = new ArrayList<>();

            if (trace.spans != null && trace.spans.size() >= 1) {

                for (JaegerQueryAPI.Span span : trace.spans) {
                    String kind = span.findTag(Tags.SPAN_KIND.getKey(), String.class);
                    if (kind == null) {
                        LOG.debug("Cannot find tag 'span.kind' in trace: {} and span: {}", trace.traceID, span);
                        continue;
                    }
                    switch (kind) {
                        case "activity": {
                            activity = new Activity();
                            activity.setId(trace.traceID);
                            // activity.setVer();
                            JaegerQueryAPI.JaegerProcess process = trace.processes.get(span.processID);
                            String version = process.findTag("integration.version", String.class);
                            activity.setVer(version);
                            String hostname = process.findTag("hostname", String.class);
                            activity.setPod(hostname);
                            activity.setStatus("done");
                            activity.setAt(span.startTime/1000);
                            Boolean failed = span.findTag(Tags.ERROR.getKey(), Boolean.class);
                            if (failed != null) {
                                activity.setFailed(failed);
                            }
                        }
                        break;
                        case "step": {
                            ActivityStep step = new ActivityStep();
                            step.setId(span.operationName);
                            // use microseconds precision to improve accuracy for ordering purposes
                            // do not divide to 1000 at this moment, as the span can run in the same millisecond moment
                            step.setAt(span.startTime);
                            step.setDuration(span.duration*1000);

                            List<String> messages = span.findLogs("event");
                            Boolean failed = span.findTag(Tags.ERROR.getKey(), Boolean.class);
                            if (failed != null && failed) {
                                String msg = messages != null && !messages.isEmpty() ? messages.get(0) : "";
                                step.setFailure(msg);
                            } else {
                                step.setMessages(messages);
                            }
                            steps.add(step);
                        }
                        break;
                        default:
                            LOG.debug("Unknown span: " + span);
                            break;
                    }

                }
            }

            if (activity != null) {
                steps.sort(Comparator.comparing(ActivityStep::getAt));
                // set time to milliseconds to correctly display in UI
                for (ActivityStep step: steps) {
                    step.setAt(step.getAt()/1000);
                }
                activity.setSteps(steps);
                rc.add(activity);
            }

        }
        // sort by most recent on top
        rc.sort(Comparator.comparing(Activity::getAt));
        Collections.reverse(rc);
        return rc;
    }

}
