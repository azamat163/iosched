package com.aagataev.espresso_page_object.core.action

import androidx.test.espresso.ViewAction
import com.aagataev.espresso_page_object.core.Description
import com.aagataev.espresso_page_object.core.OperationType

open class EspressoAction(val type: OperationType, val viewAction: ViewAction) {
    val description: Description =
        Description(
            type,
            "Action with type '$type', espresso view action '$viewAction'"
        )
}