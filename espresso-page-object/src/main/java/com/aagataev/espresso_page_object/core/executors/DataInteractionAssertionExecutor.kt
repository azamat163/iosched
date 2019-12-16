package com.aagataev.espresso_page_object.core.executors

import android.os.SystemClock
import androidx.test.espresso.DataInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import com.aagataev.espresso_page_object.core.assertion.EspressoAssertion
import com.aagataev.espresso_page_object.core.assertion.ViewAssertionConfig

class DataInteractionAssertionExecutor(
    val dataInteraction: DataInteraction,
    val assertion: EspressoAssertion
) : AssertionExecutor {
    var exception: Throwable? = null
    override fun execute() {
        var result: Boolean
        val endTime = SystemClock.elapsedRealtime() + ViewAssertionConfig.ASSERTION_TIMEOUT
        do {
            result = true
            try {
                dataInteraction.check(matches(assertion.matcher))
            } catch (th: Throwable) {
                if (th::class.java in ViewAssertionConfig.allowedExceptions) {
                    result = false
                    exception = th
                } else throw th
            }
            if (!result) Thread.sleep(50)
        } while (SystemClock.elapsedRealtime() < endTime && !result)
        if (!result && exception != null) {
            throw exception as Throwable
        }
    }

    override fun getEspressoAssertion(): EspressoAssertion {
        return assertion
    }
}