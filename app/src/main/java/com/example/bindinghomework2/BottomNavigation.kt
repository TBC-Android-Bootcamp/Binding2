package com.example.bindinghomework2

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.example.bindinghomework2.ui.dashboard.DashboardFragment
import com.example.bindinghomework2.ui.home.HomeFragment
import com.example.bindinghomework2.ui.notifications.NotificationsFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        init()
    }

    private fun init(){
        val fragments = mutableListOf<Fragment>()
        fragments.add(HomeFragment())
        fragments.add(DashboardFragment())
        fragments.add(NotificationsFragment())

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, fragments)
        viewPager.offscreenPageLimit = 3

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
                d("scroll", "onPageScrollStateChanged")
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                d("scroll", "onPageScrollStateChanged")
            }

            override fun onPageSelected(position: Int) {
                navView.menu.getItem(position).isChecked = true
            }
        })

        navView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> viewPager.currentItem = 0
                R.id.navigation_dashboard -> viewPager.currentItem = 1
                R.id.navigation_notifications -> viewPager.currentItem = 2
            }

            true
        }
    }
}
