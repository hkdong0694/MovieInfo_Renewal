package com.example.movieinfo_renewal.ui.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.network.def.Constants
import com.example.movieinfo_renewal.network.model.dto.KMovieOfficeItem
import com.example.movieinfo_renewal.ui.contract.MovieDetailContract
import com.example.movieinfo_renewal.ui.presenter.MovieDetailPresenter

class MovieDetailActivity : AppCompatActivity(), MovieDetailContract.View {

    private lateinit var movieDetail : KMovieOfficeItem
    private lateinit var ivThumbnail : ImageView

    private val presenter: MovieDetailPresenter by lazy { MovieDetailPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        if(intent != null) movieDetail = intent.getSerializableExtra(Constants.MOVIE_DETAIL) as KMovieOfficeItem

        initDataView()
        presenter.setView(this)
    }

    private fun initDataView() {
        ivThumbnail = findViewById( R.id.iv_thumbnail )
        Glide.with(this).load(movieDetail.image)
            .format(DecodeFormat.PREFER_ARGB_8888)
            .transform(CenterCrop(), RoundedCorners(20))
            .into(ivThumbnail)
    }
}