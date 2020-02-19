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
package io.syndesis.dv.lsp.parser.statement;

import org.eclipse.lsp4j.Position;
import org.teiid.query.parser.Token;

import io.syndesis.dv.lsp.parser.DdlTokenAnalyzer;

public class OptionsClause extends AbstractStatementObject {
    private Token[] optionsTokens;

    public OptionsClause(DdlTokenAnalyzer analyzer) {
        super(analyzer);
    }

    @Override
    protected void parseAndValidate() {
    }

    public Token[] getOptionsTokens() {
        return optionsTokens;
    }

    public void setOptionsTokens(Token[] optionsTokens) {
        this.optionsTokens = optionsTokens;
    }

    @Override
    protected TokenContext getTokenContext(Position position) {
        // TODO Auto-generated method stub
        return null;
    }
}