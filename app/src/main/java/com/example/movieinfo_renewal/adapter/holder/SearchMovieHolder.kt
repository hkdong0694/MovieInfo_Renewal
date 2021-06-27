package com.example.movieinfo_renewal.adapter.holder

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.network.model.dto.MovieItem
import java.text.DecimalFormat

/**
 * MovieInfo_renewal
 * Class: SearchMovieHolder
 * Created by 한경동 (Joel) on 2021/06/27.
 * Description:
 */
class SearchMovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    interface OnItemClick {
        fun onItemClick(position: Int)
    }

    var onItemListener: OnItemClick?= null

    fun setItemListener(listener: OnItemClick) {
        this.onItemListener = listener
    }

    private val decimalFormat = DecimalFormat("###,###")
    private val vgItem = itemView.findViewById<ViewGroup>(R.id.vg_item)
    private val ivItem = itemView.findViewById<ImageView>(R.id.iv_item)
    private val tvIndex = itemView.findViewById<TextView>(R.id.tv_index)
    private val tvTitle = itemView.findViewById<TextView>(R.id.tv_name)
    private val tvOpenDt = itemView.findViewById<TextView>(R.id.tv_openDt)
    private val tvDirector = itemView.findViewById<TextView>(R.id.tv_director)
    private val rbItem = itemView.findViewById<RatingBar>(R.id.rb_item)
    private val tvRating = itemView.findViewById<TextView>(R.id.tv_rating)

    fun onBind(item: MovieItem) {
        var rating = 0.0
        if(item.userRating != "") {
            rating = ((item.userRating).toFloat() / 2).toDouble()
            tvRating.text = item.userRating
            rbItem.rating = rating.toFloat()
        }
        tvIndex.visibility = View.GONE
        if(item.title!= "") {
            val regex1 = item.title.replace(Regex("<b>"), "")
            val regex2 = regex1.replace(Regex("</b>"), "")
            val title = regex2.replace(" ", "")
            tvTitle.text = title
        }
        if(item.pubDate!= "") tvOpenDt.text = item.pubDate
        if(item.image != "")
            Glide.with(itemView.context)
                .load(item.image)
                .format(DecodeFormat.PREFER_ARGB_8888)
                .transform(CenterCrop(), RoundedCorners(20))
                .into(ivItem)
        if(item.director != "") tvDirector.text = "${item.director.replace("|", " ")}감독"
        vgItem.setOnClickListener {
            onItemListener?.onItemClick(adapterPosition)
        }
    }

}