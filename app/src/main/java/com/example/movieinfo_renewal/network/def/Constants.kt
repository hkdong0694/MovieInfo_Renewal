package com.example.movieinfo_renewal.network.def

/**
 * MovieInfo_renewal
 * Class: Constants
 * Created by 한경동 (Joel) on 2021/05/31.
 * Description:
 */
object Constants {
    //영화진흥원 Open Api key, url
    const val KEY = "fa8553cd3eeb5bae09e4c876fa84fe94"
    const val BASE_URL = "https://www.kobis.or.kr"

    //네이버 검색 Open Api url, id, secret
    const val N_BASE_URL = "https://openapi.naver.com/v1/search/"
    const val CLIENT_ID = "lG13u0c7cEx3hy0QKlul"
    const val CLIENT_SECRET = "0PcQCNqMS1"
    const val NAVER_SEARCH_DEFAULT = 10

    //영화 DB Open Api url, servicekey, collection
    const val MOVIE_DB_URL = "http://api.koreafilm.or.kr"
    const val MOVIE_DB_SERVICE_KEY = "A47D7T5Y5C99GRB77608"
    const val MOVIE_DB_COLLECTION = "kmdb_new"

    const val BOX_OFFICE_URL = "/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"

    const val MOVIE_LIST_NEW = "NEW"
    const val MOVIE_LIST_OLD = "OLD"

    const val MOVIE_DETAIL = "movieDetail"

}