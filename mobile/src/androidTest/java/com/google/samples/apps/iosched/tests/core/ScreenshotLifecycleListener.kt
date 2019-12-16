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

import android.util.Log
import com.aagataev.espresso_page_object.core.Description
import com.aagataev.espresso_page_object.listeners.AbstractLifecycleListener
import io.qameta.allure.espresso.deviceScreenshot

class ScreenshotLifecycleListener : AbstractLifecycleListener() {
    override fun before(description: Description) {
        Log.d(
                "EspressoScreenshot",
                "Taking screenshot before execution of ${description.description}"
        )
        deviceScreenshot(description.type.toString())
    }


    override fun afterFailure(description: Description, throwable: Throwable) {
        //do nothing
    }
}