package com.example.movieinfo_renewal.network.api

import com.example.movieinfo_renewal.network.def.Constants.BOX_OFFICE_URL
import com.example.retrofit2_mvp.network.model.dto.Result
import retrofit2.Call
import retrofit2.http.GET
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

}