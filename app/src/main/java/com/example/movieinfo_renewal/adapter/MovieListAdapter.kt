package com.example.movieinfo_renewal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.adapter.holder.MovieListHolder
import com.example.movieinfo_renewal.network.model.dto.KMovieOfficeItem
import com.example.retrofit2_mvp.network.model.dto.DailyBoxOfficeList

/**
 * MovieInfo_renewal
 * Class: MovieListAdapter
 * Created by 한경동 (Joel) on 2021/06/13.
 * Description:
 */
class MovieListAdapter : RecyclerView.Adapter<MovieListHolder>(), MovieListHolder.OnItemClick {

    interface OnItemClickListener {
        fun onItemClick(item : KMovieOfficeItem)
    }

    var itemListener : OnItemClickListener?= null

    fun setItemClickListener(listener: OnItemClickListener) {
        this.itemListener = listener
    }

    private var movieList = mutableListOf<KMovieOfficeItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListHolder {
        var holder = MovieListHolder(LayoutInflater.from(parent.context).inflate(R.layout.dailymovie_item, parent, false))
        holder.setItemListener(this)
        return holder
    }
    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieListHolder, position: Int) = holder.onBind(movieList[position])

    fun setData(list: KMovieOfficeItem) {
        movieList.add(list)
    }

    fun clearData() {
        movieList = mutableListOf()
    }

    fun dataNotify() {
        notifyDataSetChanged()
    }

    override fun onItemClick(position: Int) {
        itemListener?.onItemClick(movieList[position])
    }


}