package com.example.movieinfo_renewal.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.ui.contract.MovieListContract
import com.example.movieinfo_renewal.ui.presenter.MovieListPresenter

/**
 * A simple [Fragment] subclass.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment(), MovieListContract.View {

    private val presetner: MovieListPresenter by lazy { MovieListPresenter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presetner.setView(this)
        super.onViewCreated(view, savedInstanceState)
    }

}