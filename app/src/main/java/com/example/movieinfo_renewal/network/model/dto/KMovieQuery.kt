package com.example.movieinfo_renewal.network.model.dto

import com.google.gson.annotations.SerializedName

/**
 * MovieInfo_renewal
 * Class: KMovieQuery
 * Created by 한경동 (Joel) on 2021/06/06.
 * Description:
 */
data class KMovieQuery (
    @SerializedName("TotalCount")
    var totalcount: String,
    @SerializedName("Data")
    var movieData: List<KMovieData>
    )