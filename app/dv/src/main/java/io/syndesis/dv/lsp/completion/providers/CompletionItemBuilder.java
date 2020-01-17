package io.syndesis.dv.lsp.completion.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.InsertTextFormat;

import io.syndesis.dv.lsp.completion.DdlCompletionConstants;
import io.syndesis.dv.lsp.completion.DdlSnippetUtils;

public class CompletionItemBuilder implements DdlCompletionConstants {

    public CompletionItemBuilder() {
    }
    
    public CompletionItem createKeywordItem(String label, String detail, String documentation) {
        CompletionItem ci = new CompletionItem();
        ci.setLabel(label);
        ci.setKind(CompletionItemKind.Keyword);
        if (detail != null) {
            ci.setDetail(detail);
        }
        if (documentation != null) {
            ci.setDocumentation(documentation);
        }
        return ci;
    }

    public CompletionItem createKeywordItemFromItemData(String label) {
        String[] itemData = getItemData(label);
        CompletionItem ci = new CompletionItem();
        ci.setLabel(label);
        ci.setKind(CompletionItemKind.Keyword);
        
        if( itemData != null ) {
            if( itemData.length > 1 ) {
                String detail = itemData[1];
                if (detail != null) {
                    ci.setDetail(detail);
                }
            }
    
            if( itemData.length > 2 ) {
                String documentation = itemData[2];
                if (documentation != null) {
                    ci.setDocumentation(documentation);
                }
            }
            
            if( itemData.length > 3 ) {
                String insertText = itemData[3];
                if (insertText != null) {
                    ci.setInsertText(insertText);
                    ci.setKind(CompletionItemKind.Snippet);
                }
            }
        }

        return ci;
    }

    public CompletionItem createFieldItem(String label, String detail,
            String documentation) {
        CompletionItem ci = new CompletionItem();
        ci.setLabel(label);
        ci.setKind(CompletionItemKind.Field);
        if (detail != null) {
            ci.setDetail(detail);
        }
        if (documentation != null) {
            ci.setDocumentation(documentation);
        }
        return ci;
    }

    public CompletionItem createSnippetItem(String label, String detail,
            String documentation, String insertText) {
        CompletionItem ci = new CompletionItem();
        ci.setLabel(label);
        ci.setKind(CompletionItemKind.Snippet);
        ci.setInsertTextFormat(InsertTextFormat.Snippet);
        ci.setInsertText(insertText);
        if (documentation != null) {
            ci.setDocumentation(documentation);
        } else {
            ci.setDocumentation(DdlSnippetUtils.beautifyDocument(ci.getInsertText()));
        }
        if (detail != null) {
            ci.setDetail(detail);
        }

        return ci;
    }

    public List<CompletionItem> generateCompletionItems(String[] words) {
        List<CompletionItem> items = new ArrayList<CompletionItem>(); 

        for(String word: words ) {
            items.add(createKeywordItemFromItemData(word));
        }

        return items;
    }
    
    public CompletionItem generateCompletionItem(String word) {
        return createKeywordItem(word, null, null);
    }
    
    public CompletionItem generateCompletionItem(String[] itemData) {
        // String[] >> label, detail, documentation, insertText
        return generateCompletionItem(itemData[0], itemData[1], itemData[2], itemData[3]);
    }
    
    public CompletionItem generateCompletionItem(String label, String details, String documentation, String insertText) {
        // String[] >> label, detail, documentation, insertText
        if( insertText != null ) {
            return createSnippetItem(label, details, documentation, insertText);
        }
        
        return createKeywordItem(label, details, documentation);
    }

    /**
     * 
     * @param label
     * @return    String[] array >>>>  
        String[0] label;
        String[1] detail;
        String[2] documentation;
        String[3] insertText;
        String[4] insertTextFormat;
     */
    public String[] getItemData(String label) {
        String[] result = KEYWORDS_ITEM_DATA.get(label.toUpperCase());

        if( result == null ) {
            result = DATATYPES_ITEM_DATA.get(label);
        }

        return result;
    }
}
