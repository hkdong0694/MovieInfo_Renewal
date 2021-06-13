package com.example.movieinfo_renewal.network.model.repository

import android.content.Context
import com.example.movieinfo_renewal.network.ApiRepository
import com.example.movieinfo_renewal.network.NetworkCallback
import com.example.movieinfo_renewal.network.api.MovieInfoOpenApiService
import com.example.movieinfo_renewal.network.def.Constants
import com.example.movieinfo_renewal.network.model.request.MovieListRequest
import com.example.retrofit2_mvp.network.model.dto.Result

/**
 * MovieInfo_renewal
 * Class: MovieListRepository
 * Created by 한경동 (Joel) on 2021/06/13.
 * Description: Model
 */
class MovieListRepository(context: Context) {

    var repository: ApiRepository<MovieInfoOpenApiService>? = null
    var apiInterface: MovieInfoOpenApiService?= null

    init {
        repository = ApiRepository()
        apiInterface = repository?.initBuild(context, MovieInfoOpenApiService::class.java )
    }

    fun getDailyBox(targetDt: String, callback: NetworkCallback<Result>) {
        if( null != repository && null != apiInterface && null != callback ) {
            var request = MovieListRequest(Constants.KEY, targetDt)
            apiInterface?.getBoxOffice(Constants.KEY, targetDt)?.enqueue(callback)
        }
    }
}