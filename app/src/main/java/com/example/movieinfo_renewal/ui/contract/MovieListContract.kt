package com.example.movieinfo_renewal.ui.contract

import com.example.retrofit2_mvp.network.model.dto.DailyBoxOfficeList

/**
 * MovieInfo_renewal
 * Class: MovieListContract
 * Created by 한경동 (Joel) on 2021/06/06.
 * Description:
 */
interface MovieListContract {

    interface View {
        fun getMovieListSuccess(data: List<DailyBoxOfficeList>)
        fun getMovieListFail(code: String, msg: String)
    }

    interface Presenter {

        // setView
        fun setView(view: View)

        // 영화정보 리트
        fun getMovieList()
    }

}