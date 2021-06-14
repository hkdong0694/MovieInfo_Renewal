package com.example.movieinfo_renewal.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.adapter.MovieListAdapter
import com.example.movieinfo_renewal.network.model.dto.MovieDetail
import com.example.movieinfo_renewal.ui.activity.MovieDetailActivity
import com.example.movieinfo_renewal.ui.contract.MovieListContract
import com.example.movieinfo_renewal.ui.presenter.MovieListPresenter
import com.example.retrofit2_mvp.network.model.dto.DailyBoxOfficeList
import kotlinx.android.synthetic.main.fragment_movie_list.*
import kotlinx.android.synthetic.main.fragment_movie_list.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment(), MovieListContract.View, MovieListAdapter.OnItemClickListener {

    private val presenter: MovieListPresenter by lazy { MovieListPresenter(requireActivity()) }
    private var adapter: MovieListAdapter?= null
    private val cal = Calendar.getInstance()
    private lateinit var dateSet: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MovieListAdapter()
        adapter?.setItemClickListener(this)
        cal.time = Date()
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        cal.add(Calendar.DATE, -1)
        dateSet = df.format(cal.time).toString().replace("-","")
        view.rv_main.layoutManager = LinearLayoutManager(activity)
        view.rv_main.adapter = adapter
        presenter.setView(this)
        // 영화 정보 리스트를 뽑아온다.
        prog.visibility = View.VISIBLE
        presenter.getMovieList(dateSet)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun naverSearch(item: DailyBoxOfficeList) {
        presenter.getNaverSearch(item.movieNm, dateSet)
    }

    /**
     * 영화 진흥원 API 성공
     */
    override fun getMovieListSuccess(data: List<DailyBoxOfficeList>) {
        adapter?.setData(data as MutableList<DailyBoxOfficeList>)
        data.forEach { i -> naverSearch(i) }
        prog.visibility = View.GONE
    }

    /**
     * 영화 진흥원 API 실패
     */
    override fun getMovieListFail(code: String, msg: String) {
        Toast.makeText(activity, "$code : $msg", Toast.LENGTH_SHORT).show()
        prog.visibility = View.GONE
    }

    /**
     * 네이버 검색 API 성공
     */
    override fun getNaverSearchSuccess(detail: MovieDetail) {
        Log.d("asd", detail.items[0].title)
    }

    /**
     * 네이버 검색 API 실패
     */
    override fun getNaverSearchFail(code: String, msg: String) {
        Toast.makeText(activity, "$code : $msg", Toast.LENGTH_SHORT).show()
        prog.visibility = View.GONE
    }

    // 아이템 Click 시 발생하는 리스너
    override fun onItemClick(item: DailyBoxOfficeList) {
        val intent = Intent(activity, MovieDetailActivity::class.java)
        intent.putExtra("data", item)
        startActivity(intent)
    }

}