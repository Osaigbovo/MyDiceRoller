package com.osaigbovo.diceroller

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class DrawableMatcher(private var expectedId: Int) : TypeSafeMatcher<View>() {

    private var resourceName: String? = null

    override fun matchesSafely(target: View?): Boolean {
        if (target !is ImageView) {
            return false
        }
        val imageView: ImageView = target
        if (expectedId.equals(EMPTY)) {
            return imageView.drawable == null
        } else if (expectedId.equals(ANY)) {
            return imageView.drawable != null
        }

        val resources: Resources = target.context.resources
        val expectedDrawable: Drawable = resources.getDrawable(expectedId, null)

        resourceName = resources.getResourceEntryName(expectedId)
        val bitmap = getBitmap(imageView.drawable)
        val otherBitmap = getBitmap(expectedDrawable)
        return bitmap!!.sameAs(otherBitmap)
    }

    override fun describeTo(description: Description?) {
        description?.appendText("with drawable from resource id: ")
        description?.appendValue(expectedId)
        if (resourceName != null) {
            description?.appendText("[")
            description?.appendText(resourceName)
            description?.appendText("]")
        }
    }

    private fun getBitmap(drawable: Drawable): Bitmap? {
        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )

        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        return bitmap
    }

    companion object {
        val EMPTY: Int = -1
        val ANY = -2
    }

}