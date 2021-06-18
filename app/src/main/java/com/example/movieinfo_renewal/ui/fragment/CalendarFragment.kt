package com.example.movieinfo_renewal.ui.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.movieinfo_renewal.ui.activity.MovieActivity
import java.util.*

/**
 * MovieInfo_renewal
 * Class: CalendarFragment
 * Created by 한경동 (Joel) on 2021/06/17.
 * Description:
 */
class CalendarFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c: Calendar = Calendar.getInstance()
        val year: Int = c.get(Calendar.YEAR)
        val month: Int = c.get(Calendar.MONTH)
        val day: Int = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(requireActivity(), this, year, month, day)
    }


    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        var activity = requireActivity() as MovieActivity
    }


}