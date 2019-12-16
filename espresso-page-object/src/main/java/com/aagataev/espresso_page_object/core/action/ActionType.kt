package com.aagataev.espresso_page_object.core.action

import com.aagataev.espresso_page_object.core.OperationType

enum class ActionType : OperationType {
    CLICK, LONG_CLICK, DOUBLE_CLICK,
    TYPE_TEXT, REPLACE_TEXT, CLEAR_TEXT, PRESS_KEY, CLOSE_SOFT_KEYBOARD,
    SWIPE_LEFT, SWIPE_RIGHT, SWIPE_UP, SWIPE_DOWN, SCROLL, CUSTOM
}