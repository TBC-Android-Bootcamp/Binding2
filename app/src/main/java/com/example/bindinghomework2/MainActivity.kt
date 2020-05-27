package com.example.bindinghomework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.bindinghomework2.ui.dashboard.DashboardFragment
import com.example.bindinghomework2.ui.home.HomeFragment
import com.example.bindinghomework2.ui.notifications.NotificationsFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        val fragments= mutableListOf<Fragment>()
        fragments.add(HomeFragment())
        fragments.add(DashboardFragment())
        fragments.add(NotificationsFragment())
        viewPager.adapter=ViewPagerAdapter(supportFragmentManager,fragments)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                navView.menu.getItem(position).isChecked=true
            }
        })
        navView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home->viewPager.currentItem=0
                R.id.navigation_dashboard->viewPager.currentItem=1
                R.id.navigation_notifications->viewPager.currentItem=2
            }
            true
        }


    }
}
