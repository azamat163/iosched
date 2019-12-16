package com.aagataev.espresso_page_object.core.assertion

import android.view.View
import com.aagataev.espresso_page_object.core.Description
import com.aagataev.espresso_page_object.core.OperationType
import org.hamcrest.Matcher

open class EspressoAssertion(val type: OperationType, val matcher: Matcher<View>){
    val description: Description =
        Description(
            type,
            "Assertion with type '$type' using matcher '$matcher'"
        )
}