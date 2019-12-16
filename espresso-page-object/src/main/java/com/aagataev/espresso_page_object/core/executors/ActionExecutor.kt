package com.aagataev.espresso_page_object.core.executors

import com.aagataev.espresso_page_object.core.action.EspressoAction

interface ActionExecutor{
    fun execute()
    fun getEspressoAction() : EspressoAction
}