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
package org.apache.flex.pmd.rules.architecture;

import org.apache.flex.pmd.rules.IFlexViolation;
import org.apache.flex.pmd.rules.core.AbstractFlexRule;
import org.apache.flex.pmd.rules.core.ViolationPosition;
import org.apache.flex.pmd.rules.core.ViolationPriority;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xagnetti
 */
public class MonkeyPatchingRule extends AbstractFlexRule {
    /*
     * (non-Javadoc)
     * @see
     * com.adobe.ac.pmd.rules.core.AbstractFlexRule#findViolationsInCurrentFile()
     */
    @Override
    protected final List<IFlexViolation> findViolationsInCurrentFile() {
        final List<IFlexViolation> violations = new ArrayList<IFlexViolation>();

        if (getCurrentFile().getPackageName().startsWith("mx.")
                && !getCurrentFile().getClassName().equals("Version.as")
                && !getCurrentFile().getClassName().endsWith("Style.as")) {
            addViolation(violations,
                    new ViolationPosition(0));
        }
        return violations;
    }

    /*
     * (non-Javadoc)
     * @see com.adobe.ac.pmd.rules.core.AbstractFlexRule#getDefaultPriority()
     */
    @Override
    protected final ViolationPriority getDefaultPriority() {
        return ViolationPriority.HIGH;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.adobe.ac.pmd.rules.core.AbstractFlexRule#isConcernedByTheCurrentFile()
     */
    @Override
    protected final boolean isConcernedByTheCurrentFile() {
        return !getCurrentFile().isMxml();
    }
}
