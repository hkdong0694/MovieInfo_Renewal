package com.example.movieinfo_renewal.ui.presenter

import android.content.Context
import android.net.ConnectivityManager
import com.example.movieinfo_renewal.network.NetworkCallback
import com.example.movieinfo_renewal.network.def.Constants
import com.example.movieinfo_renewal.network.model.repository.MovieListRepository
import com.example.movieinfo_renewal.ui.contract.MovieListContract
import com.example.retrofit2_mvp.network.model.dto.Result
import retrofit2.Response

/**
 * MovieInfo_renewal
 * Class: MovieListPresenter
 * Created by 한경동 (Joel) on 2021/06/06.
 * Description:
 */
class MovieListPresenter(context1: Context) : MovieListContract.Presenter {

    private var context: Context = context1
    private lateinit var view: MovieListContract.View
    private lateinit var model : MovieListRepository

    override fun setView(view: MovieListContract.View) {
        this.view = view
        model = MovieListRepository(context)
    }

    override fun getMovieList() {
        model.getDailyBox(Constants.KEY, object : NetworkCallback<Result>() {
            override fun onSuccess(responseBody: Result?) {

            }

            override fun onFailure(code: Int, msg: String?) {

            }

            override fun onThrowable(t: Throwable?) {

            }

            override fun errorResponse(response: Response<*>?) {

            }

        })
    }

}