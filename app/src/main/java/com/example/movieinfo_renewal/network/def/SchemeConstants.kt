package com.example.movieinfo_renewal.network.def

/**
 * MovieInfo_renewal
 * Class: SchemeConstants
 * Created by 한경동 (Joel) on 2021/05/31.
 * Description:
 */
object SchemeConstants {

    /* NetworkCallback.class */
    const val RESPONSE_SUCCESS = 200 // 성공
    const val RESPONSE_INVALID_PARAMETER = 400 // 요청 오류
    const val RESPONSE_AUTHENTICATION_FAILURE = 401 // 인증 실패
    const val RESPONSE_UNAUTHORIZED = 403 // 권한 없음
    const val RESPONSE_NOT_FOUND = 404 // 요청한 API가 없음
    const val RESPONSE_INTERNAL_SERVER_ERROR = 500 // 서버 오류
    const val RESPONSE_PARAMETER_ERROR = 422 // 파라미터 에러

}