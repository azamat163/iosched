package com.aagataev.espresso_page_object.core.action

import com.aagataev.espresso_page_object.core.AbstractOperationLifecycle
import com.aagataev.espresso_page_object.core.executors.ActionExecutor

object ViewActionLifecycle : AbstractOperationLifecycle() {
    var currentEspressoAction: EspressoAction? = null

    fun actionOnView(actionExecutor: ActionExecutor) {
        currentEspressoAction = actionExecutor.getEspressoAction()
        val description = actionExecutor.getEspressoAction().description
        getListeners().forEach { it.before(description) }
        try {
            actionProcessor.process(actionExecutor)
            getListeners().forEach { it.afterSuccess(description) }
        } catch (th: Throwable) {
            getListeners().forEach { it.afterFailure(description, th) }
            throw th
        } finally {
            getListeners().forEach { it.after(description) }
        }
    }

    private var actionProcessor: ViewActionProcessor = object :
        ViewActionProcessor {
        override fun process(actionExecutor: ActionExecutor) {
            actionExecutor.execute()
        }
    }
}