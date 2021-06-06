package com.example.movieinfo_renewal.network.model.dto

/**
 * MovieInfo_renewal
 * Class: KMovieData
 * Created by 한경동 (Joel) on 2021/06/06.
 * Description:
 */
data class KMovieData (
    var TotalCount: Int,
    var Result: List<KMovieResult>
    )