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
import androidx.test.espresso.matcher.ViewMatchers.withId

import com.aagataev.espresso_page_object.extensions.isDisplayed

import com.google.samples.apps.iosched.R
import com.google.samples.apps.iosched.tests.core.extension.CustomAction.Companion.scrollTo
import com.google.samples.apps.iosched.tests.core.Page
import io.qameta.allure.android.step

class InfoEventPage: Page {

    override fun assertPageDisplayed() = apply {
        step("Assert info event page displayed ") {
            eventHeaderText.isDisplayed()
            eventSession.isDisplayed()
        }
    }

    val eventHeaderText = withId(R.id.event_types_header)
    val eventSession = withId(R.id.event_sessions)
    val eventMeals = withId(R.id.event_meals)


    fun scrollToMeals() = apply {
        step("Scroll to Meals") {
            onView(eventMeals).perform(scrollTo())
        }
    }

    fun assertEventMealsDisplayed() = apply {
        step("Assert event meals") {
            eventMeals.isDisplayed()
        }
    }
}