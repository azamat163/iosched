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
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiSelector
import com.google.samples.apps.iosched.tests.pages.HomePage
import com.google.samples.apps.iosched.tests.pages.OnBoardingPage
import junit.framework.Assert.assertEquals

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeTest: BaseTest() {
    private val homePage = HomePage()

    @Test
    fun testCheckCountList() {
        OnBoardingPage().clickGetStarted()
        homePage
                .assertPageDisplayed()
                .assertAnnouncementsCount()
    }

    @Test
    fun testDisplayedItemPositions() {
        OnBoardingPage().clickGetStarted()
        homePage.assertRecyclerViewAtPositionView("First item", 1)
    }

    @Test
    fun testPressButtonMenu() {
        OnBoardingPage().clickGetStarted()
        val UiMenuBtn = this.mDevice!!.findObject(UiSelector().resourceId("com.google.samples.apps.iosched:id/toolbar"))
        UiMenuBtn.click()

        val UiScheduleBtn = this.mDevice!!.findObject(UiSelector().resourceId("com.google.samples.apps.iosched:id/navigation_schedule"))
        assertEquals("Schedule", UiScheduleBtn.text)
    }

}