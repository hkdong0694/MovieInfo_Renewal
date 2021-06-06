package com.example.movieinfo_renewal.ui.presenter

import com.example.movieinfo_renewal.ui.contract.MovieLikeContract

/**
 * MovieInfo_renewal
 * Class: MovieLikePresenter
 * Created by 한경동 (Joel) on 2021/06/06.
 * Description:
 */
class MovieLikePresenter : MovieLikeContract.Presenter {

    private lateinit var view: MovieLikeContract.View

    override fun setView(view: MovieLikeContract.View) {
        this.view = view
    }

}