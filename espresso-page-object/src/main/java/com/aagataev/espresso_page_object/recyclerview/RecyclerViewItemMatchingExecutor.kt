package com.aagataev.espresso_page_object.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.contrib.RecyclerViewActions
import com.aagataev.espresso_page_object.extensions.execute
import org.hamcrest.Matcher

class RecyclerViewItemMatchingExecutor(
    private val recyclerViewMatcher: Matcher<View>,
    private val itemViewMatcher: Matcher<View>
) : RecyclerViewItemExecutor {
    override fun scrollToItem() {
        recyclerViewMatcher.execute(
            RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(itemViewMatcher)
        )
    }

    override fun getItemMatcher(): Matcher<View> {
        return withRecyclerView(recyclerViewMatcher).atItem(itemViewMatcher)
    }

    override fun getItemChildMatcher(childMatcher: Matcher<View>): Matcher<View> {
        return withRecyclerView(recyclerViewMatcher).atItemChild(itemViewMatcher, childMatcher)
    }
}