package com.osaigbovo.diceroller

import android.view.View
import org.hamcrest.Matcher

class EspressoTestsMatchers {

    companion object {
        fun hasDrawable(): Matcher<View?>? {
            return DrawableMatcher(DrawableMatcher.ANY)
        }

        fun withDrawable(resourceId: Int): Matcher<View?>? {
            return DrawableMatcher(resourceId)
        }

        fun noDrawable(): Matcher<View?>? {
            return DrawableMatcher(DrawableMatcher.EMPTY)
        }
    }

}