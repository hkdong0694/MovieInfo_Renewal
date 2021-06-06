package com.example.movieinfo_renewal.network.model.dto

import java.io.Serializable

/**
 * MovieInfo_renewal
 * Class: MovieItem
 * Created by 한경동 (Joel) on 2021/06/06.
 * Description:
 */
data class MovieItem (
    /*
      title	        문자열	        검색 결과 영화의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
      link	        문자열	        검색 결과 영화의 하이퍼텍스트 link를 나타낸다.
      image	        문자열	        검색 결과 영화의 썸네일 이미지의 URL이다. 이미지가 있는 경우만 나타난다.
      subtitle	    문자열	        검색 결과 영화의 영문 제목이다.
      pubDate	    문자열	        검색 결과 영화의 제작년도이다.
      director	    문자열	        검색 결과 영화의 감독이다.
      actor	        문자열	        검색 결과 영화의 출연 배우이다.
      userRating	문자열	        검색 결과 영화에 대한 유저들의 평점이다.
    */
    var title: String,
    var link: String,
    var image: String,
    var subtitle: String,
    var pubDate: String,
    var director: String,
    var actor: String,
    var userRating: String
) : Serializable