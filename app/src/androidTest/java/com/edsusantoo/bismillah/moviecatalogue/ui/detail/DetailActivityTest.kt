package com.edsusantoo.bismillah.moviecatalogue.ui.detail

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.edsusantoo.bismillah.moviecatalogue.R
import com.edsusantoo.bismillah.moviecatalogue.ui.utils.FakeConstants
import com.edsusantoo.bismillah.moviecatalogue.ui.utils.FakeDataDummy
import org.junit.Rule
import org.junit.Test

class DetailActivityTest {
    private val dummyDetailMovies = FakeDataDummy.getMovies()[0]

    @get:Rule
    var activityRule: ActivityTestRule<DetailActivity> =
        object : ActivityTestRule<DetailActivity>(DetailActivity::class.java) {
            override fun getActivityIntent(): Intent {
                val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
                val result = Intent(targetContext, DetailActivity::class.java)
                result.putExtra(FakeConstants.EXTRAS_MOVIE, dummyDetailMovies)
                return result
            }
        }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyDetailMovies.title)))
    }
}