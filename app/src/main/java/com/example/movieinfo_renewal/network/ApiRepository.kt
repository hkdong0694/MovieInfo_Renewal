package com.example.movieinfo_renewal.network

import android.content.Context
import com.example.movieinfo_renewal.network.def.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * MovieInfo_renewal
 * Class: ApiRepository
 * Created by 한경동 (Joel) on 2021/05/31.
 * Description:
 */
class ApiRepository<T> {

    var retrofit: Retrofit?= null
    var apiInterface: T?= null
    var interceptor: HttpLoggingInterceptor?= null
    var url: String?= null

    fun setBaseUrl(url: String) {
        this.url = url
    }

    fun initBuild(context: Context, service : Class<T>) : T {
        interceptor = HttpLoggingInterceptor()
        interceptor?.level = HttpLoggingInterceptor.Level.BODY
        var builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
        var client = builder.build()
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create() )
            .baseUrl(url)
            .client(client).build()
        apiInterface = retrofit?.create(service)
        return (apiInterface as T)
    }

}