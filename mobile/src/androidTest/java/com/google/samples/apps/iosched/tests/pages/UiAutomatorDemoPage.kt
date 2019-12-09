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

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector

class UiAutomatorDemoPage {
    val allAppsButton = UiObject(UiSelector().description("Apps"))
    val appsTab = UiObject(UiSelector().text("Apps"))
    val appViews = UiScrollable(UiSelector().scrollable(true))
    val settingsApp = appViews.getChildByText(UiSelector().className(android.widget.TextView::class.java.name), "Settings")
    val googleAppValidation = UiObject(UiSelector().packageName("com.google.samples.iosched"))
}