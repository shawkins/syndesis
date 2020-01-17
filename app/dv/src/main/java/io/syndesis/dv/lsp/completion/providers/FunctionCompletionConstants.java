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
package io.syndesis.dv.lsp.completion.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.InsertTextFormat;
import org.eclipse.lsp4j.MarkupContent;
import org.eclipse.lsp4j.MarkupKind;
import org.eclipse.lsp4j.jsonrpc.messages.Either;

import io.syndesis.dv.lsp.parser.DdlAnalyzerConstants;

/**
 * This class provides Snippet item data for Teiid Functions
 * 
 * Functions don't have unique Token ID's and all are identified as "ID" (see
 * generated SQLParserConstants.java)
 *
 */
public interface FunctionCompletionConstants extends DdlAnalyzerConstants {

//    static List<CompletionItem> functionCompletionItems = new ArrayList<CompletionItem>();

    static String getLabel(int keywordId) {
        return DdlAnalyzerConstants.getLabel(keywordId, false);
    }

    String CURRENT_DATE_TEXT = "CURRENT_DATE()";
    String CURRENT_TIME_TEXT = "CURRENT_TIME()";
    String CURRENT_TIMESTAMP_TEXT = "CURRENT_TIMESTAMP()";
//    String XXX = "ST_GEOMFROMBINARY(?param1)
//    String XXX = "ST_GEOMFROMBINARY(?param1, ?param2)
    String ABS_TEXT = "abs(${1:number})";
    String ACOS_TEXT = "acos(${1:number})";
//    String XXX = "aes_decrypt(?param1, ?param2)
//    String XXX = "aes_encrypt(?param1, ?param2)
//    String XXX = "array_get(?array, ?index)
//    String XXX = "array_length(?array)
//    String XXX = "ascii(?string)
//    String XXX = "asin(?number)
//    String XXX = "atan(?number)
//    String XXX = "atan2(?number1, ?number2)
//    String XXX = "bitand(?integer1, ?integer2)
//    String XXX = "bitnot(?integer)
//    String XXX = "bitor(?integer1, ?integer2)
//    String XXX = "bitxor(?integer1, ?integer2)
//    String XXX = "cast(?value, ?target)
//    String XXX = "ceiling(?number)
//    String XXX = "char(?code)
//    String XXX = "char_length(?string)
//    String XXX = "character_length(?string)
//    String XXX = "chr(?code)
//    String XXX = "coalesce(?op1, ?op2, ?op3)
//    String XXX = "commandpayload()
//    String XXX = "commandpayload(?property)
    String CONCAT_TEXT = "concat(${1:string1}, ${2:string2})";
//    String XXX = "concat2(?string1, ?string2)
//    String XXX = "convert(?value, ?target)
//    String XXX = "cos(?number)
//    String XXX = "cot(?number)
//    String XXX = "curdate()
//    String XXX = "current_database()
//    String XXX = "current_time(?param1)
//    String XXX = "current_timestamp(?param1)
//    String XXX = "curtime()
//    String XXX = "dayname(?date)
//    String XXX = "dayofmonth(?date)
//    String XXX = "dayofweek(?date)
//    String XXX = "dayofyear(?date)
//    String XXX = "decodeInteger(?input, ?decodeString)
//    String XXX = "decodeInteger(?input, ?decodeString, ?delimiter)
//    String XXX = "decodeString(?input, ?decodeString)
//    String XXX = "decodeString(?input, ?decodeString, ?delimiter)
//    String XXX = "degrees(?number)
//    String XXX = "endswith(?substring, ?string)
//    String XXX = "env(?variablename)
//    String XXX = "env_var(?variablename)
//    String XXX = "exp(?number)
//    String XXX = "floor(?number)
//    String XXX = "formatbigdecimal(?bigdecimal, ?format)
//    String XXX = "formatbiginteger(?biginteger, ?format)
//    String XXX = "formatdate(?date, ?format)
//    String XXX = "formatdouble(?double, ?format)
//    String XXX = "formatfloat(?float, ?format)
//    String XXX = "formatinteger(?integer, ?format)
//    String XXX = "formatlong(?long, ?format)
//    String XXX = "formattime(?time, ?format)
//    String XXX = "formattimestamp(?timestamp, ?format)
//    String XXX = "from_millis(?param1)
//    String XXX = "from_unixtime(?param1)
//    String XXX = "generated_key()
//    String XXX = "generated_key(?param1)
//    String XXX = "hasRole(?roleType, ?roleName)
//    String XXX = "hasRole(?roleName)
//    String XXX = "hour(?time)
//    String XXX = "ifnull(?value, ?valueIfNull)
//    String XXX = "initcap(?string)
//    String XXX = "insert(?str1, ?start, ?length, ?str2)
//    String XXX = "jsonArray(?param1)
//    String XXX = "jsonParse(?param1, ?param2)
//    String XXX = "jsonpathvalue(?param1, ?param2)
//    String XXX = "jsonpathvalue(?param1, ?param2, ?param3)
//    String XXX = "jsonquery(?param1, ?param2)
//    String XXX = "jsonquery(?param1, ?param2, ?param3)
//    String XXX = "jsontoarray(?param1, ?param2, ?param3, ?param4)
//    String XXX = "jsontoxml(?rootElementName, ?json)
//    String XXX = "lcase(?string)
//    String XXX = "left(?string, ?length)
//    String XXX = "length(?string)
//    String XXX = "locate(?substring, ?string, ?index)
//    String XXX = "locate(?substring, ?string)
//    String XXX = "log(?number)
//    String XXX = "log10(?number)
//    String XXX = "lookup(?codetable, ?returnelement, ?keyelement, ?keyvalue)
//    String XXX = "lower(?string)
//    String XXX = "lpad(?string, ?length)
//    String XXX = "lpad(?string, ?length, ?char)
//    String XXX = "ltrim(?string)
//    String XXX = "md5(?param1)
//    String XXX = "minute(?time)
//    String XXX = "mod(?op1, ?op2)
//    String XXX = "modifytimezone(?timestamp, ?startTimeZone, ?endTimeZone)
//    String XXX = "modifytimezone(?timestamp, ?endTimeZone)
//    String XXX = "month(?date)
//    String XXX = "monthname(?date)
//    String XXX = "mvstatus(?param1, ?param2)
//    String XXX = "node_id()
//    String XXX = "now()
//    String XXX = "nullif(?op1, ?op2)
//    String XXX = "nvl(?value, ?valueIfNull)
//    String XXX = "parsebigdecimal(?bigdecimal, ?format)
//    String XXX = "parsebiginteger(?biginteger, ?format)
//    String XXX = "parsedate(?date, ?format)
//    String XXX = "parsedouble(?double, ?format)
//    String XXX = "parsefloat(?float, ?format)
//    String XXX = "parseinteger(?integer, ?format)
//    String XXX = "parselong(?long, ?format)
//    String XXX = "parsetime(?time, ?format)
//    String XXX = "parsetimestamp(?timestamp, ?format)
//    String XXX = "pi()
//    String XXX = "power(?base, ?power)
//    String XXX = "quarter(?date)
//    String XXX = "radians(?number)
//    String XXX = "rand(?seed)
//    String XXX = "rand()
//    String XXX = "regexp_replace(?param1, ?param2, ?param3)
//    String XXX = "regexp_replace(?param1, ?param2, ?param3, ?param4)
//    String XXX = "repeat(?string, ?count)
//    String XXX = "replace(?string, ?substring, ?replacement)
//    String XXX = "right(?string, ?length)
//    String XXX = "round(?number, ?places)
//    String XXX = "rpad(?string, ?length)
//    String XXX = "rpad(?string, ?length, ?char)
//    String XXX = "rtrim(?string)
//    String XXX = "second(?time)
//    String XXX = "session_id()
//    String XXX = "sha1(?param1)
//    String XXX = "sha2_256(?param1)
//    String XXX = "sha2_512(?param1)
//    String XXX = "sign(?number)
//    String XXX = "sin(?number)
//    String XXX = "space(?count)
//    String XXX = "sqrt(?number)
//    String XXX = "st_area(?param1)
//    String XXX = "st_asbinary(?param1)
//    String XXX = "st_asewkb(?param1)
//    String XXX = "st_asewkt(?param1)
//    String XXX = "st_asgeojson(?param1)
//    String XXX = "st_asgml(?param1)
//    String XXX = "st_askml(?param1)
//    String XXX = "st_astext(?param1)
//    String XXX = "st_boundary(?param1)
//    String XXX = "st_buffer(?param1, ?param2)
//    String XXX = "st_centroid(?param1)
//    String XXX = "st_contains(?param1, ?param2)
//    String XXX = "st_convexhull(?param1)
//    String XXX = "st_coorddim(?param1)
//    String XXX = "st_crosses(?param1, ?param2)
//    String XXX = "st_curvetoline(?param1)
//    String XXX = "st_difference(?param1, ?param2)
//    String XXX = "st_dimension(?param1)
//    String XXX = "st_disjoint(?param1, ?param2)
//    String XXX = "st_distance(?param1, ?param2)
//    String XXX = "st_dwithin(?param1, ?param2, ?param3)
//    String XXX = "st_endpoint(?param1)
//    String XXX = "st_envelope(?param1)
//    String XXX = "st_equals(?param1, ?param2)
//    String XXX = "st_extent(?param1)
//    String XXX = "st_exteriorring(?param1)
//    String XXX = "st_force_2d(?param1)
//    String XXX = "st_geogfromtext(?param1)
//    String XXX = "st_geogfromwkb(?param1)
//    String XXX = "st_geometryn(?param1, ?param2)
//    String XXX = "st_geometrytype(?param1)
//    String XXX = "st_geomfromewkb(?param1)
//    String XXX = "st_geomfromewkt(?param1)
//    String XXX = "st_geomfromgeojson(?param1)
//    String XXX = "st_geomfromgeojson(?param1, ?param2)
//    String XXX = "st_geomfromgml(?param1)
//    String XXX = "st_geomfromgml(?param1, ?param2)
//    String XXX = "st_geomfromtext(?param1)
//    String XXX = "st_geomfromtext(?param1, ?param2)
//    String XXX = "st_geomfromwkb(?param1)
//    String XXX = "st_geomfromwkb(?param1, ?param2)
//    String XXX = "st_hasarc(?param1)
//    String XXX = "st_interiorringn(?param1, ?param2)
//    String XXX = "st_intersection(?param1, ?param2)
//    String XXX = "st_intersects(?param1, ?param2)
//    String XXX = "st_isclosed(?param1)
//    String XXX = "st_isempty(?param1)
//    String XXX = "st_isring(?param1)
//    String XXX = "st_issimple(?param1)
//    String XXX = "st_isvalid(?param1)
//    String XXX = "st_length(?param1)
//    String XXX = "st_makeenvelope(?param1, ?param2, ?param3, ?param4)
//    String XXX = "st_makeenvelope(?param1, ?param2, ?param3, ?param4, ?param5)
//    String XXX = "st_numgeometries(?param1)
//    String XXX = "st_numinteriorrings(?param1)
//    String XXX = "st_numpoints(?param1)
//    String XXX = "st_orderingequals(?param1, ?param2)
//    String XXX = "st_overlaps(?param1, ?param2)
//    String XXX = "st_perimeter(?param1)
//    String XXX = "st_point(?param1, ?param2)
//    String XXX = "st_pointn(?param1, ?param2)
//    String XXX = "st_pointonsurface(?param1)
//    String XXX = "st_polygon(?param1, ?param2)
//    String XXX = "st_relate(?param1, ?param2, ?param3)
//    String XXX = "st_relate(?param1, ?param2)
//    String XXX = "st_setsrid(?param1, ?param2)
//    String XXX = "st_simplify(?param1, ?param2)
//    String XXX = "st_simplifypreservetopology(?param1, ?param2)
//    String XXX = "st_snaptogrid(?param1, ?param2)
//    String XXX = "st_srid(?param1)
//    String XXX = "st_startpoint(?param1)
//    String XXX = "st_symdifference(?param1, ?param2)
//    String XXX = "st_touches(?param1, ?param2)
//    String XXX = "st_transform(?param1, ?param2)
//    String XXX = "st_union(?param1, ?param2)
//    String XXX = "st_within(?param1, ?param2)
//    String XXX = "st_x(?param1)
//    String XXX = "st_y(?param1)
//    String XXX = "st_z(?param1)
//    String XXX = "substr(?string, ?index, ?length)
//    String XXX = "substr(?string, ?index)
//    String XXX = "substring(?string, ?index, ?length)
//    String XXX = "substring(?string, ?index)
//    String XXX = "sys_prop(?variablename)
//    String XXX = "tan(?number)
//    String XXX = "teiid_session_get(?param1)
//    String XXX = "teiid_session_set(?param1, ?param2)
//    String XXX = "timestampadd(?interval, ?count, ?timestamp)
//    String XXX = "timestampcreate(?date, ?time)
//    String XXX = "timestampdiff(?interval, ?timestamp1, ?timestamp2)
//    String XXX = "to_bytes(?param1, ?param2)
//    String XXX = "to_bytes(?param1, ?param2, ?param3)
//    String XXX = "to_chars(?param1, ?param2)
//    String XXX = "to_chars(?param1, ?param2, ?param3)
//    String XXX = "to_millis(?param1)
//    String XXX = "tokenize(?param1, ?param2)
//    String XXX = "translate(?string, ?source, ?destination)
//    String XXX = "trim(?spec, ?trimChar, ?string)
//    String XXX = "ucase(?string)
//    String XXX = "unescape(?string)
//    String XXX = "unix_timestamp(?param1)
//    String XXX = "upper(?string)
//    String XXX = "user()
//    String XXX = "user(?includeSecurityDomain)
//    String XXX = "uuid()
//    String XXX = "week(?date)
//    String XXX = "xmlText(?param1)
//    String XXX = "xmlcomment(?value)
//    String XXX = "xmlconcat(?param1, ?param2)
//    String XXX = "xmlpi(?name)
//    String XXX = "xmlpi(?name, ?value)
//    String XXX = "xpathvalue(?document, ?xpath)
//    String XXX = "xsltransform(?document, ?xsl)
//    String XXX = "year(?date)

    /*
     * public CompletionItem getColumnCompletionItem(int data) { CompletionItem ci =
     * new CompletionItem(); ci.setLabel("column definition");
     * ci.setInsertText("\\t${1:name} ${2:type}");
     * ci.setKind(CompletionItemKind.Snippet);
     * ci.setInsertTextFormat(InsertTextFormat.Snippet);
     * ci.setDetail(" insert new column definition ....");
     * ci.setDocumentation(beautifyDocument(ci.getInsertText()));
     * 
     * return ci; }
     */

    String[] CURRENT_DATE_ITEM_DATA = {
            /*
             * The label of this completion item. By default also the text that is inserted
             * when selecting this completion.
             */
            getLabel(CURRENT_DATE).toUpperCase(), // String label;

            /*
             * A human-readable string with additional information about this item, like
             * type or symbol information.
             */
            null, // String detail;

            /*
             * A string that should be inserted a document when selecting this completion.
             * When `falsy` the label is used.
             */
            CURRENT_DATE_TEXT, // String insertText;
    };

    String[] CURRENT_TIME_ITEM_DATA = { getLabel(CURRENT_TIME).toUpperCase(), null, CURRENT_TIME_TEXT};
    String[] CURRENT_TIMESTAMP_ITEM_DATA = { getLabel(CURRENT_TIMESTAMP).toUpperCase(), null, CURRENT_TIMESTAMP_TEXT};
    String[] ABS_ITEM_DATA = { "ABS", null, ABS_TEXT };
    String[] ACOS_ITEM_DATA = { "ACOS", null, ACOS_TEXT };
    String[] CONCAT_ITEM_DATA = { "CONCAT", null, CONCAT_TEXT };

    static List<CompletionItem> getCompletionItems() {
        List<CompletionItem> items = new ArrayList<CompletionItem>();
        
        items.add(getCompletionItem(CURRENT_DATE_ITEM_DATA));
        items.add(getCompletionItem(CURRENT_TIME_ITEM_DATA));
        items.add(getCompletionItem(CURRENT_TIMESTAMP_ITEM_DATA));
        items.add(getCompletionItem(ABS_ITEM_DATA));
        items.add(getCompletionItem(ACOS_ITEM_DATA));
        items.add(getCompletionItem(CONCAT_ITEM_DATA));
        
        return items;
//        if (functionCompletionItems.isEmpty()) {
//            generateCompletionItems();
//        }
//
//        return functionCompletionItems;
    }

//    static void generateCompletionItems() {
//        addCompletionItem(CURRENT_DATE_ITEM_DATA);
//        addCompletionItem(CURRENT_TIME_ITEM_DATA);
//        addCompletionItem(CURRENT_TIMESTAMP_ITEM_DATA);
//        addCompletionItem(ABS_ITEM_DATA);
//        addCompletionItem(ACOS_ITEM_DATA);
//        addCompletionItem(CONCAT_ITEM_DATA);
//    }

    static Either<String, MarkupContent> beautifyDocument(String raw) {
        // remove the placeholder for the plain cursor like: ${0}, ${1:variable}
        String escapedString = raw.replaceAll("\\$\\{\\d:?(.*?)\\}", "$1");

        MarkupContent markupContent = new MarkupContent();
        markupContent.setKind(MarkupKind.MARKDOWN);
        markupContent.setValue(String.format("```%s\n%s\n```", "java", escapedString));
        return Either.forRight(markupContent);
    }
    
    static CompletionItem getCompletionItem(String[] itemData) {
        CompletionItem ci = new CompletionItem();
        ci.setLabel(itemData[0]);
        ci.setInsertText(itemData[2]);
        ci.setKind(CompletionItemKind.Snippet);
        ci.setInsertTextFormat(InsertTextFormat.Snippet);
        ci.setDetail(itemData[1]);
        ci.setDocumentation(beautifyDocument(ci.getInsertText()));
        return ci;
    }

//    static void addCompletionItem(String[] itemData) {
//        CompletionItem ci = new CompletionItem();
//        ci.setLabel(itemData[0]);
//        ci.setInsertText(itemData[2]);
//        ci.setKind(CompletionItemKind.Snippet);
//        ci.setInsertTextFormat(InsertTextFormat.Snippet);
//        ci.setDetail(itemData[1]);
//        ci.setDocumentation(beautifyDocument(ci.getInsertText()));
//        System.out.println(" >> FCIC.addCompletionItem()  item = " + ci.getLabel());
//
//        functionCompletionItems.add(ci);
//    }
}
