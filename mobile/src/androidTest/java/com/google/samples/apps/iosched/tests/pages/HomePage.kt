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

package com.google.samples.apps.iosched.tests.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId

import com.aagataev.espresso_page_object.extensions.click
import com.aagataev.espresso_page_object.extensions.isDisplayed

import com.google.samples.apps.iosched.R
import com.google.samples.apps.iosched.tests.core.extension.Matchers.Companion.recyclerViewAtPositionOnView
import com.google.samples.apps.iosched.tests.core.extension.Matchers.Companion.recyclerViewItemCount
import com.google.samples.apps.iosched.tests.core.Page


import io.qameta.allure.android.step

class HomePage: Page {
    private val expectedCount = 5

    override fun assertPageDisplayed() = apply {
        step("Assert announcements list page displayed") {
            announcementsList.isDisplayed()
        }
    }

    val announcementsList = withId(R.id.recyclerView)
    val menuBtn = withContentDescription("Open navigation drawer")

    fun assertAnnouncementsCount() = apply {
        step("Assert announcements count") {
            onView(announcementsList).check(matches(recyclerViewItemCount(expectedCount)))
        }
    }

    fun assertRecyclerViewAtPositionView(expectedText: String, position: Int) = apply {
        step("Assert item view by position") {
            onView(announcementsList).check(matches(recyclerViewAtPositionOnView(
                    expectedText,
                    position
            )))
        }
    }

    fun clickMenuBtn() = apply {
        step("Click menu button") {
            menuBtn.click()
        }
    }
}