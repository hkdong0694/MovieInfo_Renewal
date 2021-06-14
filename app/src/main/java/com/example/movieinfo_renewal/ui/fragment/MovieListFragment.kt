package com.example.movieinfo_renewal.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.adapter.MovieListAdapter
import com.example.movieinfo_renewal.ui.contract.MovieListContract
import com.example.movieinfo_renewal.ui.presenter.MovieListPresenter
import com.example.retrofit2_mvp.network.model.dto.DailyBoxOfficeList
import kotlinx.android.synthetic.main.fragment_movie_list.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment(), MovieListContract.View {

    private val presenter: MovieListPresenter by lazy { MovieListPresenter(requireActivity()) }
    private var adapter: MovieListAdapter?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MovieListAdapter()
        view.rv_main.layoutManager = LinearLayoutManager(activity)
        view.rv_main.adapter = adapter
        presenter.setView(this)
        // 영화 정보 리스트를 뽑아온다.
        presenter.getMovieList()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getMovieListSuccess(data: List<DailyBoxOfficeList>) {
        adapter?.setData(data as MutableList<DailyBoxOfficeList>)
    }

    override fun getMovieListFail(code: String, msg: String) {
        Toast.makeText(activity, "$code : $msg", Toast.LENGTH_SHORT).show()
    }

}