package com.aagataev.espresso_page_object.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.contrib.RecyclerViewActions
import com.aagataev.espresso_page_object.extensions.execute
import org.hamcrest.Matcher

class RecyclerViewItemPositionalExecutor(
    private val recyclerViewMatcher: Matcher<View>,
    private val position: Int
) : RecyclerViewItemExecutor {

    init {
        if (position < 0){
            throw Exception("Position value can't be negative: '$position'")
        }
    }
    override fun scrollToItem() {
        recyclerViewMatcher.execute(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(position)
        )
    }

    override fun getItemMatcher(): Matcher<View> {
        return withRecyclerView(recyclerViewMatcher).atPosition(position)
    }

    override fun getItemChildMatcher(childMatcher: Matcher<View>): Matcher<View> {
        return withRecyclerView(recyclerViewMatcher).atPositionItemChild(position, childMatcher)
    }
}