package com.aagataev.espresso_page_object.extensions

import android.view.View
import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.EspressoKey
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.aagataev.espresso_page_object.core.action.ActionType
import com.aagataev.espresso_page_object.core.action.EspressoAction
import com.aagataev.espresso_page_object.core.action.ViewActionLifecycle.actionOnView
import com.aagataev.espresso_page_object.core.assertion.AssertionType
import com.aagataev.espresso_page_object.core.assertion.EspressoAssertion
import com.aagataev.espresso_page_object.core.assertion.ViewAssertionLifecycle.assertView
import com.aagataev.espresso_page_object.core.executors.DataInteractionActionExecutor
import com.aagataev.espresso_page_object.core.executors.DataInteractionAssertionExecutor
import org.hamcrest.Matcher

fun DataInteraction.click() = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.CLICK,
                ViewActions.click()
            )
        )
    )
}

fun DataInteraction.doubleClick() = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.DOUBLE_CLICK,
                ViewActions.doubleClick()
            )
        )
    )
}

fun DataInteraction.longClick() = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.LONG_CLICK,
                ViewActions.longClick()
            )
        )
    )
}

fun DataInteraction.typeText(text: String) = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.TYPE_TEXT,
                ViewActions.typeText(text)
            )
        )
    )
}

fun DataInteraction.replaceText(text: String) = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.REPLACE_TEXT,
                ViewActions.replaceText(text)
            )
        )
    )
}

fun DataInteraction.clearText() = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.CLEAR_TEXT,
                ViewActions.clearText()
            )
        )
    )
}

fun DataInteraction.pressKey(keyCode: Int) = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.PRESS_KEY,
                ViewActions.pressKey(keyCode)
            )
        )
    )
}

fun DataInteraction.pressKey(key: EspressoKey) = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.PRESS_KEY,
                ViewActions.pressKey(key)
            )
        )
    )
}

fun DataInteraction.closeSoftKeyboard() = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.CLOSE_SOFT_KEYBOARD,
                ViewActions.closeSoftKeyboard()
            )
        )
    )
}

fun DataInteraction.swipeLeft() = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.SWIPE_LEFT,
                ViewActions.swipeLeft()
            )
        )
    )
}

fun DataInteraction.swipeRight() = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.SWIPE_RIGHT,
                ViewActions.swipeRight()
            )
        )
    )
}

fun DataInteraction.swipeUp() = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.SWIPE_UP,
                ViewActions.swipeUp()
            )
        )
    )
}

fun DataInteraction.swipeDown() = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.SWIPE_DOWN,
                ViewActions.swipeDown()
            )
        )
    )
}

fun DataInteraction.scrollTo() = apply {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.SCROLL,
                ViewActions.scrollTo()
            )
        )
    )
}

fun DataInteraction.execute(viewAction: ViewAction) {
    actionOnView(
        DataInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.CUSTOM,
                viewAction
            )
        )
    )
}
//assertions

fun DataInteraction.isDisplayed() = apply {
    assertView(
        DataInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_DISPLAYED,
                ViewMatchers.isDisplayed()
            )
        )
    )
}

fun DataInteraction.isCompletelyDisplayed() = apply {
    assertView(
        DataInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_COMPLETELY_DISPLAYED,
                ViewMatchers.isCompletelyDisplayed()
            )
        )
    )
}

fun DataInteraction.isDisplayingAtLeast(percentage: Int) = apply {
    assertView(
        DataInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_DISPLAYING_AT_LEAST,
                ViewMatchers.isDisplayingAtLeast(percentage)
            )
        )
    )
}

fun DataInteraction.isEnabled() = apply {
    assertView(
        DataInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_ENABLED,
                ViewMatchers.isEnabled()
            )
        )
    )
}

fun DataInteraction.isSelected() = apply {
    assertView(
        DataInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_SELECTED,
                ViewMatchers.isSelected()
            )
        )
    )
}

fun DataInteraction.isClickable() = apply {
    assertView(
        DataInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_CLICKABLE,
                ViewMatchers.isClickable()
            )
        )
    )
}

fun DataInteraction.isChecked() = apply {
    assertView(
        DataInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_CHECKED,
                ViewMatchers.isChecked()
            )
        )
    )
}

fun DataInteraction.isNotChecked() = apply {
    assertView(
        DataInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_NOT_CHECKED,
                ViewMatchers.isNotChecked()
            )
        )
    )
}

fun DataInteraction.isFocusable() = apply {
    assertView(
        DataInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_FOCUSABLE,
                ViewMatchers.isFocusable()
            )
        )
    )
}

fun DataInteraction.isJavascriptEnabled() = apply {
    assertView(
        DataInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_JS_ENABLED,
                ViewMatchers.isJavascriptEnabled()
            )
        )
    )
}

fun DataInteraction.hasText(text: String) = apply {
    assertView(
        DataInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.HAS_TEXT,
                ViewMatchers.withText(text)
            )
        )
    )
}

fun DataInteraction.assertMatches(condition: Matcher<View>) = apply {
    assertView(
        DataInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.ASSERT_MATCHES,
                condition
            )
        )
    )
}