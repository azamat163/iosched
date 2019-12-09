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

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.samples.apps.iosched.tests.pages.UiAutomatorDemoPage

import junit.framework.Assert.assertTrue
import org.junit.Ignore

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UiAutomatorDemoTest: BaseTest() {
    val uiAutomatorDemoPage = UiAutomatorDemoPage()

    @Ignore
    @Test
    fun testDemo() {
        this.mDevice!!.pressHome()
        uiAutomatorDemoPage.allAppsButton.clickAndWaitForNewWindow()
        uiAutomatorDemoPage.appsTab.click()
        uiAutomatorDemoPage.appViews.setAsHorizontalList()
        uiAutomatorDemoPage.settingsApp.clickAndWaitForNewWindow()
        assertTrue("Unable to detect Settings", uiAutomatorDemoPage.googleAppValidation.exists())
    }
}