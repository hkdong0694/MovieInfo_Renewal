package com.example.movieinfo_renewal.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.movieinfo_renewal.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_baseline_list_alt_24))
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_search_black_24dp))
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_favorite_black_24dp))
        tab_layout.setTabGravity(TabLayout.GRAVITY_FILL)
    }



}