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
package org.apache.flex.pmd.rules.maintanability;

import org.apache.flex.pmd.parser.IParserNode;
import org.apache.flex.pmd.rules.core.AbstractAstFlexRule;
import org.apache.flex.pmd.rules.core.ViolationPriority;

/**
 * @author xagnetti
 */
public class EmptyStatementRule extends AbstractAstFlexRule {
    /*
     * (non-Javadoc)
     * @see com.adobe.ac.pmd.rules.core.AbstractFlexRule#getDefaultPriority()
     */
    @Override
    protected ViolationPriority getDefaultPriority() {
        return ViolationPriority.LOW;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.adobe.ac.pmd.rules.core.AbstractAstFlexRule#visitEmptyStatetement(
     * com.adobe.ac.pmd.parser.IParserNode)
     */
    @Override
    protected void visitEmptyStatetement(final IParserNode statementNode) {
        addViolation(statementNode);
    }
}
