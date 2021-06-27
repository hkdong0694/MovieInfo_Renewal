package com.example.movieinfo_renewal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.adapter.holder.SearchMovieHolder
import com.example.movieinfo_renewal.network.model.dto.MovieItem

/**
 * MovieInfo_renewal
 * Class: SearchMovieAdapter
 * Created by 한경동 (Joel) on 2021/06/27.
 * Description:
 */
class SearchMovieAdapter : RecyclerView.Adapter<SearchMovieHolder>(), SearchMovieHolder.OnItemClick {

    interface OnItemClickListener {
        fun onItemClick(item : MovieItem)
    }

    var itemListener : OnItemClickListener?= null

    fun setItemClickListener(listener: OnItemClickListener) {
        this.itemListener = listener
    }

    private var searchList = ArrayList<MovieItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieHolder {
        val holder = SearchMovieHolder(LayoutInflater.from(parent.context).inflate(R.layout.dailymovie_item, parent, false))
        holder.setItemListener(this)
        return holder
    }

    override fun onBindViewHolder(holder: SearchMovieHolder, position: Int) {
        holder.onBind(searchList.get(position))
    }

    override fun getItemCount(): Int = searchList.size

    fun setData( movieList: ArrayList<MovieItem>) {
        this.searchList = movieList
        notifyDataSetChanged()
    }

    override fun onItemClick(position: Int) {
        itemListener?.onItemClick(searchList.get(position))
    }


}