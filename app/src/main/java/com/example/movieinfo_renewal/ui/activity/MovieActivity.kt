package com.example.movieinfo_renewal.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.adapter.MovieMainPagerAdapter
import com.example.movieinfo_renewal.ui.fragment.MovieLikeFragment
import com.example.movieinfo_renewal.ui.fragment.DailyMovieListFragment
import com.example.movieinfo_renewal.ui.fragment.SearchFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    private lateinit var adapter : MovieMainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_baseline_list_alt_24))
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_search_black_24dp))
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_favorite_black_24dp))
        tab_layout.tabGravity = TabLayout.GRAVITY_FILL

        adapter = MovieMainPagerAdapter(supportFragmentManager)
        adapter.addItems(DailyMovieListFragment(), "영화")
        adapter.addItems(SearchFragment(), "검색")
        adapter.addItems(MovieLikeFragment(), "좋아하는 영화")

        vp_main.adapter = adapter
        vp_main.offscreenPageLimit = adapter.count
        tab_layout.setupWithViewPager(vp_main)
    }
}