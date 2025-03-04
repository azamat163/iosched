package com.aagataev.espresso_page_object.core.executors

import android.os.SystemClock
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import com.aagataev.espresso_page_object.core.assertion.EspressoAssertion
import com.aagataev.espresso_page_object.core.assertion.ViewAssertionConfig

open class ViewInteractionAssertionExecutor(val viewInteraction: ViewInteraction, val assertion: EspressoAssertion):
    AssertionExecutor {
    override fun execute(){
        var result: Boolean
        var exception: Throwable? = null
        val endTime = SystemClock.elapsedRealtime() + ViewAssertionConfig.ASSERTION_TIMEOUT
        do {
            result = true
            viewInteraction.withFailureHandler { error, _ ->
                if (error::class.java in ViewAssertionConfig.allowedExceptions){
                    result = false
                    exception = error
                } else throw error
            }.check(matches(assertion.matcher))
            if (!result) Thread.sleep(50)
        } while (SystemClock.elapsedRealtime() < endTime && !result)
        if (!result && exception != null){
            throw exception as Throwable
        }
    }

    override fun getEspressoAssertion(): EspressoAssertion {
        return assertion
    }

}