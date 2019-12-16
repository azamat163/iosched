package com.aagataev.espresso_page_object.listeners

import com.aagataev.espresso_page_object.core.Description

abstract class AbstractLifecycleListener : LifecycleListener{
    var id: String
    constructor(id: String){
        this.id = id
    }
    constructor(){
        this.id = this::class.java.name
    }

    override fun before(description: Description) {
    }

    override fun afterSuccess(description: Description) {
    }

    override fun afterFailure(description: Description, throwable: Throwable) {
    }

    override fun after(description: Description) {
    }
}