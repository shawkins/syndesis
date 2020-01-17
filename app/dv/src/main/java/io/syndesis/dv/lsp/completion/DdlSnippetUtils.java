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
package io.syndesis.dv.lsp.completion;

import org.eclipse.lsp4j.MarkupContent;
import org.eclipse.lsp4j.MarkupKind;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

/**
 * This class provides utilities to access various details, lists and information around Teiid DDL snippets
 *
 * These snippets are defined primarily by the Teiid BNF definition and pertain specifically to the
 * CREATE VIEW xxxx () AS ..... DDL statement.
 *
 *
 *
 */
public class DdlSnippetUtils {

    // List of Keywords that can be used in the CREATE VIEW .....
    public interface CreateClauseKeyWords {

    }
    
	public static Either<String, MarkupContent> beautifyDocument(String raw) {
        // remove the placeholder for the plain cursor like: ${0}, ${1:variable}
        String escapedString = raw.replaceAll("\\$\\{\\d:?(.*?)\\}", "$1");

        MarkupContent markupContent = new MarkupContent();
        markupContent.setKind(MarkupKind.MARKDOWN);
        markupContent.setValue(
                String.format("```%s\n%s\n```", "java", escapedString));
        return Either.forRight(markupContent);
    }
}
