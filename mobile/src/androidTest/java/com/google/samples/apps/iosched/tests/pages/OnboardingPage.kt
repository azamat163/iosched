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
import androidx.test.espresso.matcher.ViewMatchers.withId

import com.aagataev.espresso_page_object.extensions.isDisplayed
import com.aagataev.espresso_page_object.extensions.click


import com.google.samples.apps.iosched.R
import com.google.samples.apps.iosched.tests.core.extension.Matchers.Companion.withCustomText
import com.google.samples.apps.iosched.tests.core.Page

import io.qameta.allure.android.step

class OnBoardingPage: Page {
    private val welcomeMessageText = "Watch the I/O \'19 recap and check out #io19 on social"
    private val getStartedText = "Get started"

    override fun assertPageDisplayed() = apply {
        step("Assert onBoarding page content displayed") {
            welcomePostText.isDisplayed()
            getStartedBtn.isDisplayed()
            io19Image.isDisplayed()
        }
    }

    val welcomePostText = withId(R.id.welcome_post_message)
    val getStartedBtn = withId(R.id.get_started)
    val io19Image = withId(R.id.io_hashtag)

    fun assertWelcomeMessageText() = apply {
        step("Assert welcome message") {
            onView(welcomePostText).check(matches(withCustomText(welcomeMessageText)))
        }
    }

    fun assertGetStartedText() = apply {
        step("Assert Get Started button text") {
            onView(getStartedBtn).check(matches(withCustomText(getStartedText)))
        }
    }

    fun clickGetStarted() = apply {
        step("I click button with name Get Started") {
            getStartedBtn.click()
        }
    }

    fun assertAnnouncementsList() = apply {
        val homePage = HomePage()
        homePage.assertPageDisplayed()
    }
}