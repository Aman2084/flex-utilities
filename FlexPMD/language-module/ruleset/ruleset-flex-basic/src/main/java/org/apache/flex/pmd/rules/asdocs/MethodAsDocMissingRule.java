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
package org.apache.flex.pmd.rules.asdocs;

import org.apache.flex.pmd.nodes.IFunction;
import org.apache.flex.pmd.nodes.Modifier;
import org.apache.flex.pmd.rules.core.ViolationPriority;

/**
 * @author xagnetti
 */
public class MethodAsDocMissingRule extends AbstractAsDocRule {
    /*
     * (non-Javadoc)
     * @see
     * com.adobe.ac.pmd.rules.core.AbstractAstFlexRule#findViolations(com.adobe
     * .ac.pmd.nodes.IFunction)
     */
    @Override
    protected void findViolations(final IFunction function) {
        if ((function.isPublic() || function.is(Modifier.PROTECTED))
                && !function.isGetter() && !function.isSetter() && function.getAsDoc() == null) {
            addViolation(function);
        }
    }

    /*
     * (non-Javadoc)
     * @see com.adobe.ac.pmd.rules.core.AbstractFlexRule#getDefaultPriority()
     */
    @Override
    protected ViolationPriority getDefaultPriority() {
        return ViolationPriority.NORMAL;
    }
}
