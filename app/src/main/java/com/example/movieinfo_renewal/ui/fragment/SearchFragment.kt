package com.example.movieinfo_renewal.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.ui.contract.SearchContract
import com.example.movieinfo_renewal.ui.presenter.SearchPresenter

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment(), SearchContract.View {

    private val presenter: SearchPresenter by lazy { SearchPresenter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.setView(this)
        super.onViewCreated(view, savedInstanceState)
    }

}