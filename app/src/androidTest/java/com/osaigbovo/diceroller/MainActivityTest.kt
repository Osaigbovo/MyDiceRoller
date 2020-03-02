package com.osaigbovo.diceroller

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    // Context of the app under test.
    val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun useAppContext() {
        assertEquals("com.osaigbovo.diceroller", appContext.packageName)
    }

    @Test
    fun rollDice(){

        onView(withId(R.id.dice_image))
            .check(matches(isDisplayed()))

        onView(withId(R.id.roll_button))
            .check(matches(withText("Let's Roll!")))

    }

    @Test
    fun onClick(){
            
    }

}
