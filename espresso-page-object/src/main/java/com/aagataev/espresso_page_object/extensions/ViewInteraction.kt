package com.aagataev.espresso_page_object.extensions

import android.view.View
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.EspressoKey
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.aagataev.espresso_page_object.core.action.ActionType
import com.aagataev.espresso_page_object.core.action.EspressoAction
import com.aagataev.espresso_page_object.core.action.ViewActionLifecycle.actionOnView
import com.aagataev.espresso_page_object.core.assertion.AssertionType
import com.aagataev.espresso_page_object.core.assertion.EspressoAssertion
import com.aagataev.espresso_page_object.core.assertion.ViewAssertionLifecycle.assertView
import com.aagataev.espresso_page_object.core.executors.ViewInteractionActionExecutor
import com.aagataev.espresso_page_object.core.executors.ViewInteractionAssertionExecutor
import org.hamcrest.Matcher
import org.hamcrest.Matchers.not


fun ViewInteraction.click() = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.CLICK,
                ViewActions.click()
            )
        )
    )
}

fun ViewInteraction.doubleClick() = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.DOUBLE_CLICK,
                ViewActions.doubleClick()
            )
        )
    )
}

fun ViewInteraction.longClick() = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.LONG_CLICK,
                ViewActions.longClick()
            )
        )
    )
}

fun ViewInteraction.typeText(text: String) = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.TYPE_TEXT,
                ViewActions.typeText(text)
            )
        )
    )
}

fun ViewInteraction.replaceText(text: String) = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.REPLACE_TEXT,
                ViewActions.replaceText(text)
            )
        )
    )
}

fun ViewInteraction.clearText() = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.CLEAR_TEXT,
                ViewActions.clearText()
            )
        )
    )
}

fun ViewInteraction.pressKey(keyCode: Int) = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.PRESS_KEY,
                ViewActions.pressKey(keyCode)
            )
        )
    )
}

fun ViewInteraction.pressKey(key: EspressoKey) = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.PRESS_KEY,
                ViewActions.pressKey(key)
            )
        )
    )
}

fun ViewInteraction.closeSoftKeyboard() = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.CLOSE_SOFT_KEYBOARD,
                ViewActions.closeSoftKeyboard()
            )
        )
    )
}

fun ViewInteraction.swipeLeft() = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.SWIPE_LEFT,
                ViewActions.swipeLeft()
            )
        )
    )
}

fun ViewInteraction.swipeRight() = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.SWIPE_RIGHT,
                ViewActions.swipeRight()
            )
        )
    )
}

fun ViewInteraction.swipeUp() = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.SWIPE_UP,
                ViewActions.swipeUp()
            )
        )
    )
}

fun ViewInteraction.swipeDown() = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.SWIPE_DOWN,
                ViewActions.swipeDown()
            )
        )
    )
}

fun ViewInteraction.scrollTo() = apply {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.SCROLL,
                ViewActions.scrollTo()
            )
        )
    )
}

fun ViewInteraction.execute(viewAction: ViewAction) {
    actionOnView(
        ViewInteractionActionExecutor(
            this,
            EspressoAction(
                ActionType.CUSTOM,
                viewAction
            )
        )
    )
}
//assertions

fun ViewInteraction.isDisplayed() = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_DISPLAYED,
                ViewMatchers.isDisplayed()
            )
        )
    )
}

fun ViewInteraction.isNotDisplayed() = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_DISPLAYED,
                not(ViewMatchers.isDisplayed())
            )
        )
    )
}

fun ViewInteraction.isCompletelyDisplayed() = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_COMPLETELY_DISPLAYED,
                ViewMatchers.isCompletelyDisplayed()
            )
        )
    )
}

fun ViewInteraction.isDisplayingAtLeast(percentage: Int) = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_DISPLAYING_AT_LEAST,
                ViewMatchers.isDisplayingAtLeast(percentage)
            )
        )
    )
}

fun ViewInteraction.isEnabled() = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_ENABLED,
                ViewMatchers.isEnabled()
            )
        )
    )
}

fun ViewInteraction.isSelected() = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_SELECTED,
                ViewMatchers.isSelected()
            )
        )
    )
}

fun ViewInteraction.isClickable() = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_CLICKABLE,
                ViewMatchers.isClickable()
            )
        )
    )
}

fun ViewInteraction.isChecked() = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_CHECKED,
                ViewMatchers.isChecked()
            )
        )
    )
}

fun ViewInteraction.isNotChecked() = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_NOT_CHECKED,
                ViewMatchers.isNotChecked()
            )
        )
    )
}

fun ViewInteraction.isFocusable() = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_FOCUSABLE,
                ViewMatchers.isFocusable()
            )
        )
    )
}

fun ViewInteraction.isJavascriptEnabled() = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.IS_JS_ENABLED,
                ViewMatchers.isJavascriptEnabled()
            )
        )
    )
}

fun ViewInteraction.hasText(text: String) = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.HAS_TEXT,
                ViewMatchers.withText(text)
            )
        )
    )
}

fun ViewInteraction.assertMatches(condition: Matcher<View>) = apply {
    assertView(
        ViewInteractionAssertionExecutor(
            this,
            EspressoAssertion(
                AssertionType.ASSERT_MATCHES,
                condition
            )
        )
    )
}