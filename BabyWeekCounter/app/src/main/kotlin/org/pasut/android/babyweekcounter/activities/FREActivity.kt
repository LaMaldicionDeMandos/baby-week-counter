package org.pasut.android.babyweekcounter.activities

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.widget.DatePicker
import android.widget.Toast

import org.androidannotations.annotations.EActivity
import org.androidannotations.annotations.App
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.Click
import org.androidannotations.annotations.ViewById

import org.pasut.android.babyweekcounter.BWCApplication
import org.pasut.android.babyweekcounter.R
import java.util.Calendar

@EActivity(R.layout.activity_fre)
open class FREActivity : AppCompatActivity() {

    private lateinit var app: BWCApplication

    @ViewById
    protected lateinit var date: DatePicker

    @App
    protected fun setApp(app: BWCApplication) {
        this.app = app
        if (app.helper().contains(app.DATE)) {
            start()
        }
    }

    @AfterViews
    protected fun populateDatePicker() {
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.WEEK_OF_YEAR, -1)
        date.maxDate = calendar.timeInMillis
        calendar.add(Calendar.MONTH, -9)
        date.minDate = calendar.timeInMillis
    }

    @Click(R.id.apply)
    protected fun onNext() {
        val calendar = Calendar.getInstance()
        calendar.set(date.year, date.month, date.dayOfMonth)
        val helper = app.helper()
        helper.edit().putLong(app.DATE, calendar.timeInMillis).commit()
        start()
    }

    private fun start() {
        MainActivity_.intent(this).start()
        finish()
    }
}
