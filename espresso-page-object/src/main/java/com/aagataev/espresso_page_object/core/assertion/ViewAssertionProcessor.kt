package com.aagataev.espresso_page_object.core.assertion

import com.aagataev.espresso_page_object.core.executors.AssertionExecutor

interface ViewAssertionProcessor {
    fun assert(assertionExecutor: AssertionExecutor)
}