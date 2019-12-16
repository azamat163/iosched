package com.aagataev.espresso_page_object.listeners

import com.aagataev.espresso_page_object.core.Description
import com.aagataev.espresso_page_object.core.OperationType
import com.aagataev.espresso_page_object.core.action.ActionType
import com.aagataev.espresso_page_object.core.assertion.AssertionType

internal interface LifecycleListener{

    fun before(description: Description)

    fun afterSuccess(description: Description)


    fun afterFailure(description: Description, throwable: Throwable)


    fun after(description: Description)

    fun doInCase(type: OperationType, caseAction: () -> Unit, caseAssertion: () -> Unit) {
        if (type is ActionType) {
            caseAction()
        } else if (type is AssertionType) {
            caseAssertion()
        }
    }
}