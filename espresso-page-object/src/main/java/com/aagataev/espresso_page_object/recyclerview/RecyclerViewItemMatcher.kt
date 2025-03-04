package com.aagataev.espresso_page_object.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.util.TreeIterables
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

open class RecyclerViewItemMatcher(val recyclerViewMatcher: Matcher<View>) {
    var recyclerView: RecyclerView? = null
    var itemView: View? = null

    open fun atItem(itemMatcher: Matcher<View>): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description?) {
                if (recyclerView == null) {
                    description?.appendText("No matching recycler view with : [$recyclerViewMatcher]. ")
                    return
                }
                description?.appendText("Found recycler view matches : [$recyclerViewMatcher]. ")
                if (itemView == null) {
                    description?.appendText("No matching recycler view item with : [$itemMatcher]")
                    return
                }
            }

            override fun matchesSafely(view: View?): Boolean {
                if (itemView == null) itemView = findItemView(itemMatcher, view?.rootView)
                return if (itemView != null) {
                    itemView == view
                } else false
            }
        }
    }

    open fun atItemChild(itemMatcher: Matcher<View>, childMatcher: Matcher<View>): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            var childView: View? = null
            override fun describeTo(description: Description?) {
                if (recyclerView == null) {
                    description?.appendText("No matching recycler view with : [$recyclerViewMatcher]. ")
                    return
                }
                description?.appendText("Found recycler view matches : [$recyclerViewMatcher]. ")
                if (itemView == null) {
                    description?.appendText("No matching recycler view item with : [$itemMatcher]")
                    return
                }
                description?.appendText("Found recycler view item matches : [$itemMatcher]. ")
                if (childView == null) {
                    description?.appendText("No matching item child view with : [$childMatcher]")
                    return
                }
            }

            override fun matchesSafely(view: View?): Boolean {
                if (itemView == null) itemView = findItemView(itemMatcher, view?.rootView)
                if (itemView != null) {
                    if (childView == null) {
                        for (childView in TreeIterables.breadthFirstViewTraversal(itemView)) {
                            if (childMatcher.matches(childView)) {
                                this.childView = childView
                                break
                            }
                        }
                    }
                }
                return if (childView != null) {
                    childView == view
                } else false
            }
        }
    }

    open fun atPosition(position: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description?) {
                if (recyclerView == null) {
                    description?.appendText("No matching recycler view with : [$recyclerViewMatcher]. ")
                    return
                }
                description?.appendText("Found recycler view matches : [$recyclerViewMatcher]. ")
                if (itemView == null) {
                    description?.appendText("No recycler view item at position : [$position]")
                    return
                }
            }

            override fun matchesSafely(view: View?): Boolean {
                if (itemView == null) itemView = findItemViewAtPosition(position, view?.rootView)
                return if (itemView != null) {
                    itemView == view
                } else false
            }
        }
    }

    open fun atPositionItemChild(position: Int, childMatcher: Matcher<View>): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            var childView: View? = null
            override fun describeTo(description: Description?) {
                if (recyclerView == null) {
                    description?.appendText("No matching recycler view with : [$recyclerViewMatcher]. ")
                    return
                }
                description?.appendText("Found recycler view matches : [$recyclerViewMatcher]. ")
                if (itemView == null) {
                    description?.appendText("No recycler view item at position : [$position]")
                    return
                }
                description?.appendText("Found recycler view item at position : [$position]. ")
                if (childView == null) {
                    description?.appendText("No matching item child view with : [$childMatcher]")
                    return
                }
            }

            override fun matchesSafely(view: View?): Boolean {
                if (itemView == null) itemView = findItemViewAtPosition(position, view?.rootView)
                if (itemView != null) {
                    if (childView == null) {
                        for (childView in TreeIterables.breadthFirstViewTraversal(itemView)) {
                            if (childMatcher.matches(childView)) {
                                this.childView = childView
                                break
                            }
                        }
                    }
                }
                return if (childView != null) {
                    childView == view
                } else false
            }
        }
    }

    private fun findItemView(itemMatcher: Matcher<View>, rootView: View?): View? {
        for (childView in TreeIterables.breadthFirstViewTraversal(rootView)) {
            if (recyclerViewMatcher.matches(childView)) {
                val recyclerView = childView as RecyclerView
                this.recyclerView = recyclerView
                val viewHolderMatcher: Matcher<RecyclerView.ViewHolder> = viewHolderMatcher(itemMatcher)
                val matchedItems: List<MatchedItem> =
                    itemsMatching(recyclerView, viewHolderMatcher, 1)
                if (matchedItems.isEmpty()) return null
                return recyclerView.findViewHolderForAdapterPosition(matchedItems[0].position)
                    ?.itemView
            }
        }
        return null
    }

    private fun findItemViewAtPosition(position: Int, rootView: View?): View? {
        for (childView in TreeIterables.breadthFirstViewTraversal(rootView)) {
            if (recyclerViewMatcher.matches(childView)) {
                val recyclerView = childView as RecyclerView
                this.recyclerView = recyclerView    // to describe the error
                return recyclerView.findViewHolderForAdapterPosition(position)?.itemView
            }
        }
        return null
    }
}