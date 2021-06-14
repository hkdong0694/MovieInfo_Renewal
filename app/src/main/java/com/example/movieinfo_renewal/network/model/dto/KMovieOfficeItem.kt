package com.example.movieinfo_renewal.network.model.dto

/**
 * MovieInfo_renewal
 * Class: KMovieOfficeItem
 * Created by 한경동 (Joel) on 2021/06/14.
 * Description:
 */
data class KMovieOfficeItem(
    /*
    rank	        String	        해당일자의 박스오피스 순위를 출력합니다.
    movieNm	        String	        영화명(국문)을 출력합니다.
    openDt	        String	        영화의 개봉일을 출력합니다.
    audiAcc	        String	        누적관객수를 출력합니다.
    link	        String	        검색 결과 영화의 하이퍼텍스트 link를 나타낸다.
    image	        String	        검색 결과 영화의 썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타난다.
    director	    String	        검색 결과 영화의 감독이다.
    actor	        String	        검색 결과 영화의 출연 배우이다.
    userRating	    String	        검색 결과 영화에 대한 유저들의 평점이다.
    pubDate	        String	        영화의 개봉년도를 출력합니다.
*/
    var rank: String,
    var movieNm: String,
    var openDt: String,
    var audiAcc: String,
    var link: String,
    var image: String,
    var director: String,
    var actor: String,
    var userRating: String,
    var startYear: String,
    var endYear: String,
    var pubDate: String,
    var subtitle: String,
    var check: Boolean
) {
    constructor(
        rank: String,
        movieNm: String,
        openDt: String,
        audiAcc: String,
        startYear: String,
        endYear: String
    ) : this(
        rank,
        movieNm,
        openDt,
        audiAcc,
        "",
        "",
        "",
        "",
        "",
        startYear,
        endYear,
        "",
        "",
        true
    )
}