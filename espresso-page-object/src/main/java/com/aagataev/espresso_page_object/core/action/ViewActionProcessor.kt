package com.aagataev.espresso_page_object.core.action

import com.aagataev.espresso_page_object.core.executors.ActionExecutor

interface ViewActionProcessor {
    fun process(actionExecutor: ActionExecutor)
}