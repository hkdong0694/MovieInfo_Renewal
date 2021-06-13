package com.example.movieinfo_renewal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.adapter.holder.MovieListHolder
import com.example.retrofit2_mvp.network.model.dto.DailyBoxOfficeList

/**
 * MovieInfo_renewal
 * Class: MovieListAdapter
 * Created by 한경동 (Joel) on 2021/06/13.
 * Description:
 */
class MovieListAdapter : RecyclerView.Adapter<MovieListHolder>() {

    private var movieList = mutableListOf<DailyBoxOfficeList>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListHolder = MovieListHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.dailymovie_item, parent, false))

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieListHolder, position: Int) = holder.onBind(movieList[position])

    fun setData(list: MutableList<DailyBoxOfficeList>) {
        this.movieList = list
        notifyDataSetChanged()
    }


}