/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.iosched.tests.core

import android.view.View
import android.widget.TextView

import androidx.test.espresso.matcher.BoundedMatcher
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_feed_announcement.view.*

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

open class Matchers {
    companion object {
        fun withCustomText(expectedText: String): Matcher<View> {
            return object : TypeSafeMatcher<View>() {
                override fun matchesSafely(view: View): Boolean {
                    return (view as TextView).text == expectedText
                }

                override fun describeTo(description: Description) {
                    description.appendText("TextView should have $expectedText")
                }
            }
        }

        fun recyclerViewItemCount(expectedCount: Int): Matcher<View> {
            return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
                override fun matchesSafely(item: RecyclerView): Boolean {
                    val adapter = item.adapter
                    val actualCount = adapter!!.itemCount
                    return actualCount == expectedCount
                }

                override fun describeTo(description: Description) {
                    description.appendText("Should be size: $expectedCount")
                }
            }
        }


        fun recyclerViewAtPositionOnView(expectedText: String, position: Int): Matcher<View> {
            return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
                override fun matchesSafely(item: RecyclerView): Boolean {
                    val viewHolder = item.findViewHolderForAdapterPosition(position)
                    viewHolder?.let {
                        return viewHolder.itemView.message.text == expectedText
                    }
                    return false
                }

                override fun describeTo(description: Description) {
                    description.appendText("has item at position: $position has text: $expectedText")
                }
            }
        }
    }
}