package com.aagataev.espresso_page_object.core.executors

import com.aagataev.espresso_page_object.core.assertion.EspressoAssertion

interface AssertionExecutor{
    fun execute()
    fun getEspressoAssertion() : EspressoAssertion
}