package com.example.movieinfo_renewal.ui.contract

import com.example.movieinfo_renewal.network.model.dto.MovieDetail
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

        fun getNaverSearchSuccess(detail: MovieDetail)
        fun getNaverSearchFail(code: String, msg: String)
    }

    interface Presenter {

        // setView
        fun setView(view: View)

        // 영화정보 리스트 ( 영화진흥원 API )
        fun getMovieList(dateSet: String)

        // 영화 정보 검색 ( 네이버 API )
        fun getNaverSearch(title: String, dateSet: String)
    }

}