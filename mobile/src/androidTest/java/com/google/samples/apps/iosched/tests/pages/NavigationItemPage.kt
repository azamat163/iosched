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
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.matcher.ViewMatchers.*

import com.aagataev.espresso_page_object.extensions.isDisplayed

import com.google.samples.apps.iosched.R
import com.google.samples.apps.iosched.tests.core.Page
import io.qameta.allure.android.step

class NavigationItemPage: Page {
    val navigationView = withId(R.id.navigation)

    override fun assertPageDisplayed() = apply {
        step("Assert navigation item page displayed") {
            navigationView.isDisplayed()
        }
    }

    fun clickNavigationInfoBtn() = apply {
        step("Click navigation button Info") {
            onView(navigationView).perform(NavigationViewActions.navigateTo(R.id.navigation_info))
        }
    }

}