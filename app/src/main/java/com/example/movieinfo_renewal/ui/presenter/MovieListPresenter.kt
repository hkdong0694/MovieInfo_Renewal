package com.example.movieinfo_renewal.ui.presenter

import android.content.Context
import com.example.movieinfo_renewal.network.NetworkCallback
import com.example.movieinfo_renewal.network.model.dto.MovieDetail
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
        model = MovieListRepository()
    }

    override fun getMovieList(dateSet: String) {
        model.setTypeUrl(context, true)
        model.getDailyBox(dateSet,  object : NetworkCallback<Result>() {
            override fun onSuccess(responseBody: Result?) {
                var data = responseBody?.boxOfficeResult?.dailyBoxOfficeList
                if (data != null) {
                    view.getMovieListSuccess(data)
                }
            }

            override fun onFailure(code: Int, msg: String?) {
                if (msg != null) {
                    view.getMovieListFail("$code", msg)
                }
            }

            override fun onThrowable(t: Throwable?) {
                t?.message?.let { view.getMovieListFail("실패", it) }
            }

            override fun errorResponse(response: Response<*>?) {
                response?.message()?.let { view.getMovieListFail("${response?.code()}", it) }
            }

        })
    }

    override fun getNaverSearch(title: String, dateSet: String) {
        var yearFrom = Integer.parseInt(dateSet) - 100
        var yearTo = Integer.parseInt(dateSet)
        model.setTypeUrl(context, false)
        model.getSearchMovieInfo(title, yearFrom, yearTo, object : NetworkCallback<MovieDetail>() {
            override fun onSuccess(responseBody: MovieDetail?) {
                view.getNaverSearchSuccess(responseBody!!)
            }

            override fun onFailure(code: Int, msg: String?) {
                if (msg != null) {
                    view.getNaverSearchFail("$code", msg)
                }
            }

            override fun onThrowable(t: Throwable?) {
                t?.message?.let { view.getNaverSearchFail("실패", it) }
            }

            override fun errorResponse(response: Response<*>?) {
                response?.message()?.let { view.getNaverSearchFail("${response?.code()}", it) }
            }

        })
    }

}