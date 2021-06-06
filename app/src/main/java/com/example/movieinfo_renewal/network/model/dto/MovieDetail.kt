package com.example.movieinfo_renewal.network.model.dto

/**
 * MovieInfo_renewal
 * Class: MovieDetail
 * Created by 한경동 (Joel) on 2021/06/06.
 * Description:
 */
data class MovieDetail(
    var start: Int,
    var total: Int,
    var display: Int,
    var lastBuildDate: String,
    var items: ArrayList<MovieItem>
)