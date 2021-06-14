package com.example.movieinfo_renewal.network.model.request

/**
 * MovieInfo_renewal
 * Class: MovieSearchRequest
 * Created by 한경동 (Joel) on 2021/06/15.
 * Description:
 */
data class MovieSearchRequest(
    var movieName: String?,
    var display: Int,
    var yearfrom: Int,
    var yearto: Int
)