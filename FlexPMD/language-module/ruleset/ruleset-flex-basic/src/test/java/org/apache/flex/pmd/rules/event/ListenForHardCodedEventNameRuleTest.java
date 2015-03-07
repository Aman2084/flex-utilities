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
package org.apache.flex.pmd.rules.event;

import org.apache.flex.pmd.rules.AbstractRegExpBasedRuleTest;
import org.apache.flex.pmd.rules.core.AbstractRegexpBasedRule;
import org.apache.flex.pmd.rules.core.ViolationPosition;

public class ListenForHardCodedEventNameRuleTest extends AbstractRegExpBasedRuleTest {
    @Override
    protected ExpectedViolation[] getExpectedViolatingFiles() {
        return new ExpectedViolation[]
                {new ExpectedViolation("AbstractRowData.as", new ViolationPosition[]
                        {new ViolationPosition(97)})};
    }

    @Override
    protected String[] getMatchableLines() {
        return new String[]
                {"addEventListener( \"change\", handleChange );",
                        "addEventListener( 'change', handleChange );",
                        "addEventListener(\"change\",handleChange);",
                        "addEventListener( \"change\","};
    }

    @Override
    protected AbstractRegexpBasedRule getRegexpBasedRule() {
        return new ListenForHardCodedEventNameRule();
    }

    @Override
    protected String[] getUnmatchableLines() {
        return new String[]
                {"addEventListener( CHANGE, handleChange );",
                        "addEventListener(CHANGE,handleChange);",
                        "addEventListener( CHANGE,"};
    }
}
