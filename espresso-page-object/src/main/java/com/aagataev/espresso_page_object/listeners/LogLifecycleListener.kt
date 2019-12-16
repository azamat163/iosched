package com.aagataev.espresso_page_object.listeners

import android.util.Log
import com.aagataev.espresso_page_object.core.Description
import com.aagataev.espresso_page_object.core.action.ViewActionConfig
import com.aagataev.espresso_page_object.core.assertion.ViewAssertionConfig

class LogLifecycleListener : AbstractLifecycleListener(){
    override fun before(description: Description) {
        doInCase(description.type,
            { Log.d(ViewActionConfig.LOGCAT_TAG, "Before execution of ${description.description}") },
            { Log.d(ViewAssertionConfig.LOGCAT_TAG, "Before execution of ${description.description}") }
        )
    }

    override fun afterSuccess(description: Description) {
        doInCase(description.type,
            { Log.d(ViewActionConfig.LOGCAT_TAG, "Successfully executed ${description.description}") },
            { Log.d(ViewAssertionConfig.LOGCAT_TAG, "Successfully executed ${description.description}") }
        )
    }

    override fun afterFailure(description: Description, throwable: Throwable) {
        doInCase(description.type,
            { Log.d(ViewActionConfig.LOGCAT_TAG, "Failed execution of ${description.description} " +
                    "with exception message ${throwable.cause} cause ${throwable.cause}") },
            { Log.d(ViewAssertionConfig.LOGCAT_TAG, "Failed execution of ${description.description}" +
                    "with exception message ${throwable.cause} cause ${throwable.cause}") }
        )
    }
}