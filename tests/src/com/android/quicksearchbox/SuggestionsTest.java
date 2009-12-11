/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.quicksearchbox;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;

/**
 * Tests for {@link Suggestions}.
 *
 */
@SmallTest
public class SuggestionsTest extends AndroidTestCase {

    private Suggestions mSuggestions;

    @Override
    protected void setUp() throws Exception {
        mSuggestions = new Suggestions(null, 0, "foo", 2);
    }

    @Override
    protected void tearDown() throws Exception {
        mSuggestions.close();
        mSuggestions = null;
    }

    public void testProgress() {
        assertEquals(0, mSuggestions.getProgress());
        mSuggestions.addSourceResult(new DataSuggestionCursor("foo"));
        assertEquals(50, mSuggestions.getProgress());
        mSuggestions.addSourceResult(new DataSuggestionCursor("foo"));
        assertEquals(100, mSuggestions.getProgress());
        mSuggestions.close();
    }

    public void testGetExpectedSourceCount() {
        assertEquals(2, mSuggestions.getExpectedSourceCount());
    }

    public void testGetUserQuery() {
        assertEquals("foo", mSuggestions.getQuery());
    }

}
