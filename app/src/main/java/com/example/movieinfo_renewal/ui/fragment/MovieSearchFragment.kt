package com.example.movieinfo_renewal.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.adapter.SearchMovieAdapter
import com.example.movieinfo_renewal.network.model.dto.MovieDetail
import com.example.movieinfo_renewal.network.model.dto.MovieItem
import com.example.movieinfo_renewal.ui.contract.MovieSearchContract
import com.example.movieinfo_renewal.ui.presenter.MovieSearchPresenter
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [MovieSearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieSearchFragment : Fragment(), MovieSearchContract.View, View.OnClickListener, SearchMovieAdapter.OnItemClickListener {

    private val presenterMovie: MovieSearchPresenter by lazy { MovieSearchPresenter(requireActivity()) }
    private var adapter: SearchMovieAdapter?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenterMovie.setView(this)
        tv_search.setOnClickListener(this)
        adapter = SearchMovieAdapter()
        adapter?.setItemClickListener(this)
        rv_main.layoutManager = LinearLayoutManager(requireContext())
        rv_main.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tv_search -> {
                var movieNm = et_search.text.toString()
                val c = Calendar.getInstance()
                prog.visibility = View.VISIBLE
                presenterMovie.getSearchMovie(movieNm, c.get(Calendar.YEAR))
            }
        }
    }

    override fun getNaverSearchSuccess(title: String, detail: MovieDetail) {
        prog.visibility = View.GONE
        adapter?.setData(detail.items)
    }

    override fun getNaverSearchFail(code: String, message: String) {
        prog.visibility = View.GONE
        Toast.makeText(requireContext(), "$code 에러", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(item: MovieItem) {

    }

}