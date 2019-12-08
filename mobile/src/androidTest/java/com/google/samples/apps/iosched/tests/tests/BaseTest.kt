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

package com.google.samples.apps.iosched.tests.tests

import com.google.samples.apps.iosched.ui.onboarding.OnboardingActivity
import com.google.samples.apps.iosched.tests.core.resources.AnnouncementIdlingResource

import io.qameta.allure.espresso.FailshotRule

import org.junit.After
import org.junit.Before
import org.junit.Rule

import android.content.Context

import androidx.test.espresso.IdlingRegistry
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.UiDevice

open class BaseTest {
    private val idlingRes = AnnouncementIdlingResource.getInstanceFromTest()
    private val KEY_PACKAGE = "PrivateStorage"
    protected var mDevice: UiDevice? = null

    @get:Rule
    val activityRule: ActivityTestRule<OnboardingActivity> = ActivityTestRule(OnboardingActivity::class.java)

    @get:Rule
    val failshot = FailshotRule()

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(idlingRes)
        clearSharedPref()
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(idlingRes)
        clearSharedPref()
    }

    fun clearSharedPref() {
        val sharedPreferences = InstrumentationRegistry
                .getInstrumentation()
                .targetContext
                .getSharedPreferences(KEY_PACKAGE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.commit()
    }
}