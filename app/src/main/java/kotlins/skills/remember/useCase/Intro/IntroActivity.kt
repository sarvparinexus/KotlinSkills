package kotlins.skills.remember.useCase.Intro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlins.skills.remember.MainActivity
import kotlins.skills.remember.R
import kotlinx.android.synthetic.main.activity_intro.*
import javax.inject.Inject

class IntroActivity : AppCompatActivity(), HasAndroidInjector {

    var introViewPagerAdapter: IntroViewPagerAdapter? = null

    @Inject
    internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
//        if (restorePreData()) {
//            val mainActivity = Intent(applicationContext, MainActivity::class.java)
//            startActivity(mainActivity)
//            finish()
//        }
        setContentView(R.layout.activity_intro)

        // Data
        val mList: MutableList<ScreenItem> = ArrayList()
        mList.add(
            ScreenItem(
                "Plan Your Trip",
                "Choose your destination, plan your trip.\nPick the best place to your holiday",
                R.drawable.travel_page_one
            )
        )
        mList.add(
            ScreenItem(
                "Select the Date",
                "Select the day, book your ticket. We give\nthe best price for you",
                R.drawable.travel_page_two
            )
        )
        mList.add(
            ScreenItem(
                "Enjoy Your Trip",
                "Enjoy your holiday! Take a photo, share to\nthe world and tag me",
                R.drawable.travel_page_three
            )
        )

        // Setup viewPager
        introViewPagerAdapter = IntroViewPagerAdapter(this, mList)
        screen_viewpager.setAdapter(introViewPagerAdapter)

        // Setup tab indicator
        tab_indicator.setupWithViewPager(screen_viewpager)

        // Button Next
        btn_next.setOnClickListener(
            View.OnClickListener {
                screen_viewpager.setCurrentItem(
                    screen_viewpager.getCurrentItem() + 1,
                    true
                )
            }
        )
        tab_indicator.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab!!.position == mList.size - 1) {
                    loadLastScreen()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        // Button Get Started
        btn_get_started.setOnClickListener(
            View.OnClickListener {
                val mainActivity = Intent(applicationContext, MainActivity::class.java)
                startActivity(mainActivity)
                savePrefsData()
                finish()
            }
        )
    }

    private fun restorePreData(): Boolean {
        val preferences =
            applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE)
        return preferences.getBoolean("isIntroOpened", false)
    }

    private fun savePrefsData() {
        val preferences = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putBoolean("isIntroOpened", true)
        editor.apply()
    }

    private fun loadLastScreen() {
        linear_layout_next!!.visibility = View.INVISIBLE
        linear_layout_get_started!!.visibility = View.VISIBLE
    }

    override fun androidInjector() = dispatchingAndroidInjector
}
