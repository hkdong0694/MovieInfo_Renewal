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

        // 영화 정보 리스트 API 성공
        fun getMovieListSuccess(data: List<DailyBoxOfficeList>)

        // 영화 정보 리스트 API 실패
        fun getMovieListFail(code: String, msg: String)

        // 네이버 영화 검색 API 성공
        fun getNaverSearchSuccess(detail: MovieDetail)

        // 네이버 영화 검색 API 실패
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