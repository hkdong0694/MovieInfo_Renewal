package com.example.movieinfo_renewal.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.ui.contract.MovieLikeContract

/**
 * A simple [Fragment] subclass.
 * Use the [MovieLikeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieLikeFragment : Fragment(), MovieLikeContract.View {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_like, container, false)
    }

}