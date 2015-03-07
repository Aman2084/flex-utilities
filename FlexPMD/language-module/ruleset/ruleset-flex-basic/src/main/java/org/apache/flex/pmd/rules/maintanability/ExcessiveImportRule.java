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

import org.apache.flex.pmd.nodes.IPackage;
import org.apache.flex.pmd.rules.core.ViolationPriority;
import org.apache.flex.pmd.rules.core.thresholded.AbstractMaximizedAstFlexRule;

/**
 * @author xagnetti
 */
public class ExcessiveImportRule extends AbstractMaximizedAstFlexRule {
    private static final int DEFAULT_THRESHOLD = 15;
    private int importNumber;

    /*
     * (non-Javadoc)
     * @seecom.adobe.ac.pmd.rules.core.thresholded.IThresholdedRule#
     * getActualValueForTheCurrentViolation()
     */
    @Override
    public final int getActualValueForTheCurrentViolation() {
        return importNumber;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.adobe.ac.pmd.rules.core.thresholded.IThresholdedRule#getDefaultThreshold
     * ()
     */
    @Override
    public final int getDefaultThreshold() {
        return DEFAULT_THRESHOLD;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.adobe.ac.pmd.rules.core.AbstractAstFlexRule#findViolations(com.adobe
     * .ac.pmd.nodes.IPackage)
     */
    @Override
    protected final void findViolations(final IPackage packageNode) {
        importNumber = packageNode.getImports().size();

        if (importNumber > getThreshold()) {
            addViolation(packageNode.getClassNode());
        }
    }

    /*
     * (non-Javadoc)
     * @see com.adobe.ac.pmd.rules.core.AbstractFlexRule#getDefaultPriority()
     */
    @Override
    protected final ViolationPriority getDefaultPriority() {
        return ViolationPriority.NORMAL;
    }
}
