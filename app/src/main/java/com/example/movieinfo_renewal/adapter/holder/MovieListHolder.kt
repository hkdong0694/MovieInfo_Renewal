package com.example.movieinfo_renewal.adapter.holder

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.network.model.dto.KMovieOfficeItem
import com.example.retrofit2_mvp.network.model.dto.DailyBoxOfficeList
import java.text.DecimalFormat

/**
 * MovieInfo_renewal
 * Class: MovieListHolder
 * Created by 한경동 (Joel) on 2021/06/13.
 * Description:
 */
class MovieListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    interface OnItemClick {
        fun onItemClick(position: Int)
    }

    var onItemListener: OnItemClick?= null

    fun setItemListener(listener: OnItemClick) {
        this.onItemListener = listener
    }

    private val vgItem = itemView.findViewById<ViewGroup>(R.id.vg_item)
    private val ivItem = itemView.findViewById<ImageView>(R.id.iv_item)
    private val tvIndex = itemView.findViewById<TextView>(R.id.tv_index)
    private val tvTitle = itemView.findViewById<TextView>(R.id.tv_name)
    private val tvOpenDt = itemView.findViewById<TextView>(R.id.tv_openDt)
    private val tvDirector = itemView.findViewById<TextView>(R.id.tv_director)
    private val rbItem = itemView.findViewById<RatingBar>(R.id.rb_item)
    private val tvRating = itemView.findViewById<TextView>(R.id.tv_rating)

    /*
    rnum	        문자열	        순번을 출력합니다.
    rank	        문자열	        해당일자의 박스오피스 순위를 출력합니다.
    rankInten	    문자열	        전일대비 순위의 증감분을 출력합니다.
    rankOldAndNew	문자열	        랭킹에 신규진입여부를 출력합니다. “OLD” : 기존 , “NEW” : 신규
    movieCd	        문자열	        영화의 대표코드를 출력합니다.
    movieNm	        문자열	        영화명(국문)을 출력합니다.
    openDt	        문자열	        영화의 개봉일을 출력합니다.
    salesAmt	    문자열	        해당일의 매출액을 출력합니다.
    salesShare	    문자열	        해당일자 상영작의 매출총액 대비 해당 영화의 매출비율을 출력합니다.
    salesInten	    문자열	        전일 대비 매출액 증감분을 출력합니다.
    salesChange	    문자열	        전일 대비 매출액 증감 비율을 출력합니다.
    salesAcc	    문자열	        누적매출액을 출력합니다.
    audiCnt	        문자열	        해당일의 관객수를 출력합니다.
    audiInten	    문자열	        전일 대비 관객수 증감분을 출력합니다.
    audiChange	    문자열	        전일 대비 관객수 증감 비율을 출력합니다.
    audiAcc	        문자열	        누적관객수를 출력합니다.
    scrnCnt	        문자열	        해당일자에 상영한 스크린수를 출력합니다.
    showCnt	        문자열	        해당일자에 상영된 횟수를 출력합니다.
    */
    fun onBind(daily: KMovieOfficeItem) {
        val decimalFormat = DecimalFormat("###,###")
        if(daily.userRating != "") {
            val rating = (daily.userRating).toFloat() / 2
            tvRating.text = daily.userRating
            rbItem.rating = rating
        }
        if(daily.rank != "") tvIndex.text = daily.rank
        if(daily.movieNm!= "") tvTitle.text = daily.movieNm
        if(daily.openDt != "" && daily.audiAcc != "")
            tvOpenDt.text = "${daily.openDt} 개봉 (${decimalFormat.format(Integer.parseInt(daily.audiAcc))}명)"
        if(daily.image != "") Glide.with(itemView.context).load(daily.image).format(DecodeFormat.PREFER_ARGB_8888).diskCacheStrategy(
            DiskCacheStrategy.ALL).into(ivItem)
        if(daily.director != "") tvDirector.text = "${daily.director.replace("|", " ")}감독"

        vgItem.setOnClickListener {
            onItemListener?.onItemClick(adapterPosition)
        }
    }

}