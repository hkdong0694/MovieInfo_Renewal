package com.example.movieinfo_renewal.network.api

import com.example.movieinfo_renewal.network.def.Constants
import com.example.movieinfo_renewal.network.def.Constants.BOX_OFFICE_URL
import com.example.movieinfo_renewal.network.model.dto.MovieDetail
import com.example.retrofit2_mvp.network.model.dto.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * MovieInfo_renewal
 * Class: MovieInfoOpenApiService
 * Created by 한경동 (Joel) on 2021/06/13.
 * Description:
 */
interface MovieInfoOpenApiService {

    @GET(BOX_OFFICE_URL)
    fun getBoxOffice(
        @Query("key")key: String,
        @Query("targetDt")target: String?
    ) : Call<Result>

    @Headers(
        "X-Naver-Client-Id: " + Constants.CLIENT_ID,
        "X-Naver-Client-Secret: " + Constants.CLIENT_SECRET
    )
    @GET("movie.json")
    fun getMovies(
        @Query("query") movieName: String?,
        @Query("display") display: Int,
        @Query("yearfrom") yearfrom: Int,
        @Query("yearto") yearto: Int
    ): Call<MovieDetail?>?


}