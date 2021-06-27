package com.example.movieinfo_renewal.ui.presenter

import android.content.Context
import com.example.movieinfo_renewal.network.NetworkCallback
import com.example.movieinfo_renewal.network.model.dto.MovieDetail
import com.example.movieinfo_renewal.network.model.repository.MovieListRepository
import com.example.movieinfo_renewal.ui.contract.MovieSearchContract
import retrofit2.Response

/**
 * MovieInfo_renewal
 * Class: SearchPresenter
 * Created by 한경동 (Joel) on 2021/06/06.
 * Description:
 */
class MovieSearchPresenter(context1: Context) : MovieSearchContract.Presenter {


    private var context: Context = context1
    private lateinit var view: MovieSearchContract.View
    private lateinit var model: MovieListRepository


    override fun setView(view: MovieSearchContract.View) {
        this.view = view
        model = MovieListRepository()
    }

    override fun getSearchMovie(movieNm: String, searchYear: Int) {
        model.setTypeUrl(context, false)
        model.getSearchMovieInfo(movieNm, searchYear - 100, searchYear, object : NetworkCallback<MovieDetail>() {
            override fun onSuccess(responseBody: MovieDetail?) {
                view.getNaverSearchSuccess(movieNm, responseBody!!)
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