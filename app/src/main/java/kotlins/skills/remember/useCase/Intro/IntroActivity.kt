package kotlins.skills.remember.useCase.Intro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayout
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlins.skills.remember.MainActivity
import kotlins.skills.remember.R
import kotlins.skills.remember.useCase.Login.LoginActivity
import kotlins.skills.remember.utils.UserDataStore
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class IntroActivity : AppCompatActivity(), HasAndroidInjector {

    val TAG = IntroActivity::class.java.simpleName

    var introViewPagerAdapter: IntroViewPagerAdapter? = null

    @Inject
    internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var userDataStore: UserDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        Log.d(TAG, "onStart: ")
        // Updates Intro
//        userDataStore.userIntroFlow.asLiveData().observe(this, {
//            Log.d(TAG, "onStart: userIntroFlow " + it)
//            if (it) {
//                val mainActivity = Intent(applicationContext, MainActivity::class.java)
//                startActivity(mainActivity)
//                finish()
//            }
//        })

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

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
            {
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
            {
                lifecycleScope.launch {
                    userDataStore.storeIntro(true)
                }
                val mainActivity = Intent(applicationContext, LoginActivity::class.java)
                startActivity(mainActivity)
                finish()
            }
        )
    }

    private fun loadLastScreen() {
        linear_layout_next!!.visibility = View.INVISIBLE
        linear_layout_get_started!!.visibility = View.VISIBLE
    }

    override fun androidInjector() = dispatchingAndroidInjector
}
