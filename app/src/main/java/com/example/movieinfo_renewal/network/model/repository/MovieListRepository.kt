package com.example.movieinfo_renewal.network.model.repository

import android.content.Context
import com.example.movieinfo_renewal.network.ApiRepository
import com.example.movieinfo_renewal.network.NetworkCallback
import com.example.movieinfo_renewal.network.api.MovieInfoOpenApiService
import com.example.movieinfo_renewal.network.def.Constants
import com.example.movieinfo_renewal.network.def.Constants.KEY
import com.example.movieinfo_renewal.network.def.Constants.NAVER_SEARCH_DEFAULT
import com.example.movieinfo_renewal.network.model.dto.MovieDetail
import com.example.movieinfo_renewal.network.model.request.MovieListRequest
import com.example.movieinfo_renewal.network.model.request.MovieSearchRequest
import com.example.retrofit2_mvp.network.model.dto.Result

/**
 * MovieInfo_renewal
 * Class: MovieListRepository
 * Created by 한경동 (Joel) on 2021/06/13.
 * Description: Model
 */
class MovieListRepository() {

    var repository: ApiRepository<MovieInfoOpenApiService>? = null
    var apiInterface: MovieInfoOpenApiService?= null

    init {
        repository = ApiRepository()
    }

    fun setTypeUrl(context: Context, check : Boolean) {
        if(check) repository?.setBaseUrl(Constants.BASE_URL)
        else repository?.setBaseUrl(Constants.N_BASE_URL)
        apiInterface = repository?.initBuild(context, MovieInfoOpenApiService::class.java )
    }

    fun getDailyBox(targetDt: String, callback: NetworkCallback<Result>) {
        if( null != repository && null != apiInterface && null != callback ) {
            var request = MovieListRequest(KEY, targetDt)
            // apiInterface?.getBoxOffice(request)?.enqueue(callback)
            apiInterface?.getBoxOffice(KEY, targetDt)?.enqueue(callback)
        }
    }

    fun getSearchMovieInfo(title: String, yearFrom: Int, yearTo: Int, callback: NetworkCallback<MovieDetail>) {
        if( null != repository && null != apiInterface && null != callback ) {
            var request = MovieSearchRequest(title, NAVER_SEARCH_DEFAULT, yearFrom, yearTo)
            // apiInterface?.getMovies(request)?.enqueue(callback)
            apiInterface?.getMovies(title, NAVER_SEARCH_DEFAULT, yearFrom, yearTo)?.enqueue(callback)
        }
    }
}