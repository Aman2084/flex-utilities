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
package org.apache.flex.pmd.rules.naming;

import net.sourceforge.pmd.PropertyDescriptor;
import org.apache.flex.pmd.rules.core.AbstractRegexpBasedRule;
import org.apache.flex.pmd.rules.core.ViolationPriority;
import org.apache.flex.pmd.rules.core.thresholded.IThresholdedRule;

import java.util.regex.Matcher;

/**
 * @author xagnetti
 */
public class TooShortVariableRule extends AbstractRegexpBasedRule implements IThresholdedRule {
    public static final int DEFAULT_THRESHOLD = 3;
    private int length;

    /*
     * (non-Javadoc)
     * @seecom.adobe.ac.pmd.rules.core.thresholded.IThresholdedRule#
     * getActualValueForTheCurrentViolation()
     */
    public final int getActualValueForTheCurrentViolation() {
        return length;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.adobe.ac.pmd.rules.core.thresholded.IThresholdedRule#getDefaultThreshold
     * ()
     */
    public final int getDefaultThreshold() {
        return DEFAULT_THRESHOLD;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.adobe.ac.pmd.rules.core.thresholded.IThresholdedRule#getThreshold()
     */
    public final int getThreshold() {
        return getProperty((PropertyDescriptor<Integer>) getPropertyDescriptor(getThresholdName()));
    }

    /*
     * (non-Javadoc)
     * @see
     * com.adobe.ac.pmd.rules.core.thresholded.IThresholdedRule#getThresholdName
     * ()
     */
    public final String getThresholdName() {
        return MINIMUM;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.adobe.ac.pmd.rules.core.AbstractFlexRule#isConcernedByTheCurrentFile()
     */
    @Override
    public final boolean isConcernedByTheCurrentFile() {
        return true;
    }

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
     * @see com.adobe.ac.pmd.rules.core.AbstractRegexpBasedRule#getRegexp()
     */
    @Override
    protected final String getRegexp() {
        return ".*var (.*):.*";
    }

    /*
     * (non-Javadoc)
     * @see
     * com.adobe.ac.pmd.rules.core.AbstractRegexpBasedRule#isCurrentLineConcerned
     * (java.lang.String)
     */
    @Override
    protected boolean isCurrentLineConcerned(final String line) {
        return line.contains("var");
    }

    /*
     * (non-Javadoc)
     * @seecom.adobe.ac.pmd.rules.core.AbstractRegexpBasedRule#
     * isViolationDetectedOnThisMatchingLine(java.lang.String)
     */
    @Override
    protected final boolean isViolationDetectedOnThisMatchingLine(final String line) {
        final Matcher matcher = getMatcher(line);
        boolean result = false;

        if (!line.contains("for")
                && matcher.matches()) {
            length = matcher.group(1).trim().length();

            result = length < getThreshold();
        }
        return result;
    }
}
