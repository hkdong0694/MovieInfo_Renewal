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
import com.example.movieinfo_renewal.network.def.Constants
import com.example.movieinfo_renewal.network.model.dto.KMovieOfficeItem
import java.text.DecimalFormat

/**
 * MovieInfo_renewal
 * Class: MovieListHolder
 * Created by 한경동 (Joel) on 2021/06/13.
 * Description:
 */
class DailyMovieListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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
    private val tvNew = itemView.findViewById<TextView>(R.id.tv_new)

    /*
        rank	        String	        해당일자의 박스오피스 순위를 출력합니다.
        movieNm	        String	        영화명(국문)을 출력합니다.
        openDt	        String	        영화의 개봉일을 출력합니다.
        audiAcc	        String	        누적관객수를 출력합니다.
        link	        String	        검색 결과 영화의 하이퍼텍스트 link를 나타낸다.
        image	        String	        검색 결과 영화의 썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타난다.
        director	    String	        검색 결과 영화의 감독이다.
        actor	        String	        검색 결과 영화의 출연 배우이다.
        userRating	    String	        검색 결과 영화에 대한 유저들의 평점이다.
        startYear       String          검색 영화 시작 연도
        endYear         String          검색 영화 종료 연도
        pubDate	        String	        영화의 개봉년도를 출력합니다.
        subtitle        String          영화의 부제목을 출력한다.
        check           Boolean         ??
        rankOldAndNew   String          "OLD" or "NEW"
    */
    fun onBind(daily: KMovieOfficeItem) {
        var rating = 0.0
        if(daily.userRating != "") {
            rating = ((daily.userRating).toFloat() / 2).toDouble()
            tvRating.text = daily.userRating
            rbItem.rating = rating.toFloat()
        }
        if(daily.rankOldAndNew == Constants.MOVIE_LIST_NEW) tvNew.visibility = View.VISIBLE
        if(daily.rank != "") tvIndex.text = daily.rank
        if(daily.movieNm!= "") tvTitle.text = daily.movieNm
        if(daily.openDt != "" && daily.audiAcc != "") {
            if(rating <= 0) {
                tvOpenDt.text = "${daily.openDt} 개봉 예정"
                rbItem.visibility = View.GONE
                tvRating.visibility = View.GONE
            }
            else tvOpenDt.text = "${daily.openDt} 개봉 (${decimalFormat.format(Integer.parseInt(daily.audiAcc))}명)"
        }
        if(daily.image != "")
            Glide.with(itemView.context)
            .load(daily.image)
            .format(DecodeFormat.PREFER_ARGB_8888)
            .transform(CenterCrop(), RoundedCorners(20))
            .into(ivItem)
        if(daily.director != "") tvDirector.text = "${daily.director.replace("|", " ")}감독"
        vgItem.setOnClickListener {
            onItemListener?.onItemClick(adapterPosition)
        }
    }

}