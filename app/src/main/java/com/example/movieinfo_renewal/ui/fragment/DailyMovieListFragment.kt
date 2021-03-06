package com.example.movieinfo_renewal.ui.fragment

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieinfo_renewal.R
import com.example.movieinfo_renewal.adapter.DailyMovieListAdapter
import com.example.movieinfo_renewal.network.def.Constants.MOVIE_DETAIL
import com.example.movieinfo_renewal.network.model.dto.KMovieOfficeItem
import com.example.movieinfo_renewal.network.model.dto.MovieDetail
import com.example.movieinfo_renewal.ui.activity.MovieDetailActivity
import com.example.movieinfo_renewal.ui.contract.DailyMovieListContract
import com.example.movieinfo_renewal.ui.presenter.DailyMovieListPresenter
import com.example.retrofit2_mvp.network.model.dto.DailyBoxOfficeList
import kotlinx.android.synthetic.main.fragment_daily_movie_list.*
import kotlinx.android.synthetic.main.fragment_daily_movie_list.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.LinkedHashMap

/**
 * A simple [Fragment] subclass.
 * Use the [DailyMovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DailyMovieListFragment : Fragment(),View.OnClickListener, DailyMovieListContract.View, DailyMovieListAdapter.OnItemClickListener {

    private var tvDate : TextView?= null
    private val presenterDaily: DailyMovieListPresenter by lazy { DailyMovieListPresenter(requireActivity()) }
    private var adapterDaily: DailyMovieListAdapter?= null
    private val cal = Calendar.getInstance()
    private lateinit var dateSet: String
    private lateinit var listener: DatePickerDialog.OnDateSetListener
    private var index = 0
    private var listData : LinkedHashMap<String, KMovieOfficeItem>?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        listData = LinkedHashMap()
        return inflater.inflate(R.layout.fragment_daily_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tvDate = view.findViewById(R.id.tv_date)
        adapterDaily = DailyMovieListAdapter()
        adapterDaily?.setItemClickListener(this)
        cal.time = Date()
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        cal.add(Calendar.DATE, -1)
        tvDate?.text = "?????? ?????? (${df.format(cal.time)})"
        dateSet = df.format(cal.time).toString().replace("-","")
        view.rv_main.layoutManager = LinearLayoutManager(activity)
        view.fb_date.setOnClickListener(this)
        view.prog.setOnClickListener(this)
        view.rv_main.adapter = adapterDaily
        presenterDaily.setView(this)
        listData?.clear()
        initializeListener()
        // ?????? ?????? ???????????? ????????????.
        prog.visibility = View.VISIBLE
        presenterDaily.getMovieList(dateSet)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initializeListener() {
        listener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            val cMonth = if( month / 10 == 0 ) "0${month + 1}" else month + 1
            val cDayOhMonth = if( dayOfMonth / 10 == 0) "0$dayOfMonth" else dayOfMonth
            tvDate?.text = "?????? ?????? ($year-$cMonth-$cDayOhMonth)"
            dateSet = "$year$cMonth$cDayOhMonth"
            index = 0
            adapterDaily?.clearData()
            listData?.clear()
            prog.visibility = View.VISIBLE
            presenterDaily.getMovieList(dateSet)
        }
    }

    override fun onResume() {
        index = 0
        super.onResume()
    }

    private fun naverSearch(item: DailyBoxOfficeList) {
        presenterDaily.getNaverSearch(item.movieNm, dateSet.substring(0,4))
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.prog -> {}
            R.id.fb_date -> {
                // DatePickerDialog ??????!!
                val c = Calendar.getInstance()
                val maxDate = Calendar.getInstance()
                // ?????? ?????? maxDate ??????
                maxDate.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH) - 1)
                DatePickerDialog(requireActivity(),
                    listener,
                    dateSet.substring(0,4).toInt(),
                    dateSet.substring(4,6).toInt(),
                    dateSet.substring(6,8).toInt()).apply {
                    this.datePicker.maxDate = maxDate.timeInMillis
                }.show()
            }
        }
    }

    /**
     * ?????? ????????? API ??????
     */
    override fun getMovieListSuccess(data: List<DailyBoxOfficeList>) {
        data.forEach { i ->
            var datesub = dateSet.substring(0,4)
            listData?.put(i.movieNm.replace(" ", ""), KMovieOfficeItem(i.rank, i.movieNm, i.openDt, i.audiAcc, datesub, datesub, i.rankOldAndNew))
            naverSearch(i)
        }
    }

    /**
     * ?????? ????????? API ??????
     */
    override fun getMovieListFail(code: String, msg: String) {
        Toast.makeText(activity, "$code : $msg", Toast.LENGTH_SHORT).show()
        prog.visibility = View.GONE
    }

    /**
     * ????????? ?????? API ??????
     */
    override fun getNaverSearchSuccess(title1: String, detail: MovieDetail) {
        var items = detail.items
        for( i in 0 until items.size) {
            val data = items[i]
            val regex1 = data.title.replace(Regex("<b>"), "")
            val regex2 = regex1.replace(Regex("</b>"), "")
            val title = regex2.replace(" ", "")
            val adapterModel = listData?.get(title)
            if(adapterModel != null) {
                adapterModel.movieNm = regex2
                adapterModel.image = data.image
                adapterModel.subtitle = data.subtitle
                adapterModel.link = data.link
                adapterModel.director = data.director
                adapterModel.actor = data.actor
                adapterModel.userRating = data.userRating
                adapterModel.pubDate = data.pubDate
                listData?.put(title, adapterModel)
                break
            }
        }
        index++
        if(listData?.size == index) {
            settingAdapterData()
        }
    }

    private fun settingAdapterData() {
        listData?.keys?.apply {
            for(i in indices) {
                var data = listData?.get(elementAt(i))
                if (data != null) adapterDaily?.setData(data)
            }
            adapterDaily?.dataNotify()
            prog.visibility = View.GONE
        }
    }

    /**
     * ????????? ?????? API ??????
     */
    override fun getNaverSearchFail(code: String, msg: String) {
        Toast.makeText(activity, "$code : $msg", Toast.LENGTH_SHORT).show()
        prog.visibility = View.GONE
    }

    /**
     * ????????? Click ??? ???????????? ????????? ( ?????? ???????????? ?????? )
     */
    override fun onItemClick(item: KMovieOfficeItem) {
        val intent = Intent(activity, MovieDetailActivity::class.java)
        intent.putExtra(MOVIE_DETAIL, item)
        startActivity(intent)
    }

}