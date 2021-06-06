package com.example.movieinfo_renewal.network.model.dto

import com.google.gson.annotations.SerializedName

/**
 * MovieInfo_renewal
 * Class: KMovieResult
 * Created by 한경동 (Joel) on 2021/06/06.
 * Description:
 */
data class KMovieResult (

    @SerializedName("DOCID")
    var docid: String,
    var movieId: String,
    var movieSeq: String,
    var title: String,
    var titleEng: String,
    var titleOrg: String,
    var titleEtc: String,
    var plot: String,
    var prodYear: String,
    @SerializedName("director")
    var director: List<KMovieDirector>,
    @SerializedName("actor")
    var actor: List<KMovieActor>,
    var nation: String,
    var company: String,
    var genre: String,
    var kmdbUrl: String,
    var type: String,
    var use: String,
    var episodes: String,
    var keywords: String,
    @SerializedName("posters")
    var posters: String,
    var stlls: String,
    var staff: List<KMovieStaff>

    )