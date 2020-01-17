package io.syndesis.dv.lsp.completion.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.InsertTextFormat;
import org.teiid.query.parser.Token;

import io.syndesis.dv.lsp.completion.DdlCompletionConstants;
import io.syndesis.dv.lsp.completion.DdlSnippetUtils;
import io.syndesis.dv.lsp.parser.DdlTokenAnalyzer;
import io.syndesis.dv.lsp.parser.statement.CreateViewStatement;
import io.syndesis.dv.lsp.parser.statement.TableBody;
import io.syndesis.dv.lsp.parser.statement.TokenContext;

public class TableBodyCompletionProvider  extends CompletionItemBuilder implements DdlCompletionConstants {
    CreateViewStatement statement;

    public TableBodyCompletionProvider(CreateViewStatement statement) {
        super();
        this.statement = statement;
    }

    public List<CompletionItem> getCompletionItems(TokenContext context) {
        List<CompletionItem> items = new ArrayList<CompletionItem>();

        Token targetToken = context.getToken();
        TableBody tableBody = (TableBody)context.getTargetObject();

        switch(targetToken.kind) {
            case RPAREN: {
                items.add(generateCompletionItem("OPTIONS", null, null, "OPTIONS('${1:key}', '${2:value}')"));
            } break;
            default: {
                //  1) COLUMN DEFINITION snippet
                items.add(getColumnCompletionItem(0));
            }
        }

        return items;
    }

    private DdlTokenAnalyzer getAnalyzer() {
        return statement.getAnalyzer();
    }
    
    public CompletionItem getColumnCompletionItem(int data) {
        CompletionItem ci = new CompletionItem();
        ci.setLabel("column definition");
        ci.setInsertText("${1:column_name} ${2:datatype}");
        ci.setKind(CompletionItemKind.Snippet);
        ci.setInsertTextFormat(InsertTextFormat.Snippet);
        ci.setDocumentation(DdlSnippetUtils.beautifyDocument(ci.getInsertText()));
        ci.setData(data);
        ci.setPreselect(true);
        return ci;
    }
    
    public String getLabel(int keywordId) {
        String tokenImageStr = tokenImage[keywordId].toUpperCase();
        return tokenImageStr.substring(1, tokenImageStr.length()-1);
    }
}