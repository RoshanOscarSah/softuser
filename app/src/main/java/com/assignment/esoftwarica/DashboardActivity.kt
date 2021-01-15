package com.assignment.esoftwarica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.FrameMetrics
import android.view.View
import android.view.Window
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.assignment.esoftwarica.adapter.ViewPagerAdapter
import com.assignment.esoftwarica.fragments.AboutFragment
import com.assignment.esoftwarica.fragments.HomeFragment
import com.assignment.esoftwarica.fragments.StudentFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DashboardActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager;
    private lateinit var tabLayout: TabLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide();
        setContentView(R.layout.activity_dashboard)

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        loadViewPagerAdapter();
    }

    private fun loadViewPagerAdapter() {

        val adapter = ViewPagerAdapter(supportFragmentManager);
        adapter.addFragment(HomeFragment(), "Home");
        adapter.addFragment(StudentFragment(), "Add Student");
        adapter.addFragment(AboutFragment(), "About Us");
        viewPager.adapter = adapter;
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_icons8_student_registration_100);
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_notifications_24);
    }

}