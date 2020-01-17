package io.syndesis.dv.lsp.completion.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.lsp4j.CompletionItem;
import org.teiid.query.parser.Token;

import io.syndesis.dv.lsp.completion.DdlCompletionConstants;
import io.syndesis.dv.lsp.parser.DdlTokenAnalyzer;
import io.syndesis.dv.lsp.parser.statement.CreateViewStatement;
import io.syndesis.dv.lsp.parser.statement.TableElement;
import io.syndesis.dv.lsp.parser.statement.TokenContext;

public class TableElementCompletionProvider extends CompletionItemBuilder implements DdlCompletionConstants {
    CreateViewStatement statement;

    public TableElementCompletionProvider(CreateViewStatement statement) {
        super();
        this.statement = statement;
    }

    public List<CompletionItem> getCompletionItems(TokenContext context) {
        List<CompletionItem> items = new ArrayList<CompletionItem>();

        Token targetToken = context.getToken();
        TableElement tableElement = (TableElement)context.getTargetObject();
        /*
        AUTO_INCREMENT,
        DEFAULT_KEYWORD,
        NOT,
        NULL,
        PRIMARY,
        KEY,
        INDEX,
        UNIQUE
        */
        switch(targetToken.kind) {
            case NOT: {
                    String[] notWords= {"NULL"};
                    items.addAll(generateCompletionItems(notWords));
                } break;
            case NULL:  {
                    String[] nullWords = {
                        getLabel(AUTO_INCREMENT),
                        getLabel(DEFAULT_KEYWORD)};
                    items.addAll(generateCompletionItems(nullWords));
                } break;
            case ID: {
                    String[] dtypeLabels = getAnalyzer().getKeywordLabels(DATATYPES, false);
                    List<CompletionItem> newItems = generateCompletionItems(dtypeLabels);
                    items.addAll(newItems);
                } break;
            default: {
                if( isDatatype(targetToken, tableElement.getDatatypeTokens()) ) {
                    items.addAll(generateCompletionItems(getAnalyzer().getKeywordLabels(COLUMN_DEFINITION_EXTRAS, true)));
                } else {
                    items.addAll(generateCompletionItems(getAnalyzer().getKeywordLabels(COLUMN_DEFINITION_EXTRAS, true)));
                }

                items.add(generateCompletionItem("OPTIONS", null, null, "OPTIONS('${1:key}', '${2:value}')"));
            }
        }

        return items;
    }

    private DdlTokenAnalyzer getAnalyzer() {
        return statement.getAnalyzer();
    }
    
    public boolean isDatatype(Token token, Token[] datatypeTokens) {
        for( int dType: DATATYPES) {
            if( token.kind == dType) {
                return true;
            }
        }
        
        // Check if token index is in the tableElement.getDatatypeTokens() list
        int tknIndex = statement.getTokenIndex(token);
        int firstIndex = statement.getTokenIndex(datatypeTokens[0]);
        int lastIndex = statement.getTokenIndex(datatypeTokens[datatypeTokens.length-1]);
        return tknIndex >= firstIndex && tknIndex <= lastIndex;
    }
    
    public String getLabel(int keywordId) {
        String tokenImageStr = tokenImage[keywordId].toUpperCase();
        return tokenImageStr.substring(1, tokenImageStr.length()-1);
    }
}
