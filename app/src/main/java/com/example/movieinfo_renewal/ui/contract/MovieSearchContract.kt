package com.example.movieinfo_renewal.ui.contract

import com.example.movieinfo_renewal.network.model.dto.MovieDetail

/**
 * MovieInfo_renewal
 * Class: SearchContract
 * Created by 한경동 (Joel) on 2021/06/06.
 * Description:
 */
interface MovieSearchContract {

    interface View {
        // 네이버 영화 검색 API 실패
        fun getNaverSearchFail(code: String, message: String)

        // 네이버 영화 검색 API 성공
        fun getNaverSearchSuccess(title: String, detail: MovieDetail)
    }

    interface Presenter {
        fun setView( view : View )

        fun getSearchMovie( movieNm : String, searchYear: Int )
    }

}