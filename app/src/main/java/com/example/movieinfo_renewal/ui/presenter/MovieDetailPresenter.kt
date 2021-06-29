package com.example.movieinfo_renewal.ui.presenter

import android.content.Context
import com.example.movieinfo_renewal.ui.contract.MovieDetailContract

/**
 * MovieInfo_renewal
 * Class: MovieDetailPresenter
 * Created by 한경동 (Joel) on 2021/06/29.
 * Description:
 */
class MovieDetailPresenter(context: Context) : MovieDetailContract.Presenter {

    private var view: MovieDetailContract.View?= null

    override fun setView(view: MovieDetailContract.View) {
        this.view = view
    }
}