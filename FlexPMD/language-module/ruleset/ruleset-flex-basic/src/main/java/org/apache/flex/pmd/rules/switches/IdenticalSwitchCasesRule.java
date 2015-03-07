/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.flex.pmd.rules.switches;

import org.apache.flex.pmd.parser.IParserNode;
import org.apache.flex.pmd.rules.core.AbstractAstFlexRule;
import org.apache.flex.pmd.rules.core.ViolationPriority;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xagnetti
 */
public class IdenticalSwitchCasesRule extends AbstractAstFlexRule {
    /*
     * (non-Javadoc)
     * @see com.adobe.ac.pmd.rules.core.AbstractFlexRule#getDefaultPriority()
     */
    @Override
    protected final ViolationPriority getDefaultPriority() {
        return ViolationPriority.LOW;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.adobe.ac.pmd.rules.core.AbstractAstFlexRule#visitSwitch(com.adobe.
     * ac.pmd.parser.IParserNode)
     */
    @Override
    protected final void visitSwitch(final IParserNode ast) {
        super.visitSwitch(ast);

        if (ast.numChildren() > 0) {
            final Map<String, IParserNode> cases = new LinkedHashMap<String, IParserNode>();

            for (final IParserNode caseStatement : ast.getChild(1).getChildren()) {
                final String label = caseStatement.getChild(0).toString();

                if (cases.containsKey(label)) {
                    addViolation(caseStatement);
                    break;
                } else {
                    cases.put(label,
                            caseStatement);
                }
            }
        }
    }
}
