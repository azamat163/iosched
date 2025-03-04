package com.aagataev.espresso_page_object.recyclerview

import android.view.View
import org.hamcrest.Matcher

interface RecyclerViewItemExecutor {
    fun scrollToItem()
    fun getItemMatcher(): Matcher<View>
    fun getItemChildMatcher(childMatcher: Matcher<View>): Matcher<View>
}