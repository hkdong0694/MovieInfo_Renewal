package com.example.movieinfo_renewal.ui.activity

import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.network.def.Constants
import com.example.movieinfo_renewal.network.model.dto.KMovieOfficeItem
import com.example.movieinfo_renewal.ui.contract.MovieDetailContract
import com.example.movieinfo_renewal.ui.presenter.MovieDetailPresenter
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : YouTubeBaseActivity(), MovieDetailContract.View {

    private lateinit var movieDetail : KMovieOfficeItem

    private val presenter: MovieDetailPresenter by lazy { MovieDetailPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        if(intent != null) movieDetail = intent.getSerializableExtra(Constants.MOVIE_DETAIL) as KMovieOfficeItem

        initDataView()
        presenter.setView(this)
    }

    private fun initDataView() {
        Glide.with(this).load(movieDetail.image)
            .format(DecodeFormat.PREFER_ARGB_8888)
            .transform(CenterCrop(), RoundedCorners(25))
            .into(iv_thumbnail)
        tv_title.text = movieDetail.movieNm
        tv_e_title.text = "( ${movieDetail.subtitle} )"

        ytv_player.initialize("develop", object: YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider, player: YouTubePlayer, wasRestored: Boolean) {
                if (!wasRestored) {
                    player.cueVideo("F-KjYNmsi0U")
                }
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
            }
        })
    }
}