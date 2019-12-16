package com.aagataev.espresso_page_object.core.assertion

import com.aagataev.espresso_page_object.core.AbstractOperationLifecycle
import com.aagataev.espresso_page_object.core.executors.AssertionExecutor

object ViewAssertionLifecycle : AbstractOperationLifecycle() {
    var currentEspressoAssertion: EspressoAssertion? = null

    fun assertView(assertionExecutor: AssertionExecutor) {
        currentEspressoAssertion = assertionExecutor.getEspressoAssertion()
        val description = assertionExecutor.getEspressoAssertion().description
        getListeners().forEach { it.before(description) }
        try {
            assertionProcessor.assert(assertionExecutor)
            getListeners().forEach { it.afterSuccess(description) }
        } catch (th: Throwable) {
            getListeners().forEach { it.afterFailure(description, th) }
            throw th
        } finally {
            getListeners().forEach { it.after(description) }
        }
    }

    var assertionProcessor = object : ViewAssertionProcessor {
        override fun assert(assertionExecutor: AssertionExecutor) {
            assertionExecutor.execute()
        }
    }

}