package com.example.movieinfo_renewal.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.network.def.Constants
import com.example.movieinfo_renewal.network.model.dto.KMovieOfficeItem

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movieDetail : KMovieOfficeItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        if(intent != null) {
            movieDetail = intent.getSerializableExtra(Constants.MOVIE_DETAIL) as KMovieOfficeItem
            Log.d("asd", movieDetail.movieNm)
        }

    }
}