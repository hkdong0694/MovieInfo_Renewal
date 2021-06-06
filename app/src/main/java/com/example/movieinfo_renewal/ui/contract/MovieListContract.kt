package com.example.movieinfo_renewal.ui.contract

/**
 * MovieInfo_renewal
 * Class: MovieListContract
 * Created by 한경동 (Joel) on 2021/06/06.
 * Description:
 */
interface MovieListContract {

    interface View {

    }

    interface Presenter {
        fun setView(view: View)
    }

}