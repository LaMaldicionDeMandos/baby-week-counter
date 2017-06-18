package org.pasut.android.babyweekcounter.activities

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.androidannotations.annotations.*

import org.pasut.android.babyweekcounter.BWCApplication
import org.pasut.android.babyweekcounter.R

import java.util.Date
import java.util.Calendar

@EActivity(R.layout.activity_main)
open class MainActivity : AppCompatActivity() {
    private val weekImages:List<Int> = listOf(
            R.drawable.semana_1,
            R.drawable.semana_2,
            R.drawable.semana_3,
            R.drawable.semana_4,
            R.drawable.semana_5,
            R.drawable.semana_6,
            R.drawable.semana_7,
            R.drawable.semana_8,
            R.drawable.semana_9,
            R.drawable.semana_10,
            R.drawable.semana_11,
            R.drawable.semana_12,
            R.drawable.semana_13,
            R.drawable.semana_14,
            R.drawable.semana_15,
            R.drawable.semana_16,
            R.drawable.semana_17,
            R.drawable.semana_18,
            R.drawable.semana_19,
            R.drawable.semana_20,
            R.drawable.semana_21,
            R.drawable.semana_22,
            R.drawable.semana_23,
            R.drawable.semana_24,
            R.drawable.semana_25,
            R.drawable.semana_26,
            R.drawable.semana_27,
            R.drawable.semana_28,
            R.drawable.semana_29,
            R.drawable.semana_30,
            R.drawable.semana_31,
            R.drawable.semana_32,
            R.drawable.semana_33,
            R.drawable.semana_34,
            R.drawable.semana_35,
            R.drawable.semana_36,
            R.drawable.semana_37,
            R.drawable.semana_38,
            R.drawable.semana_39,
            R.drawable.semana_40)
    @ViewById
    lateinit var image: ImageView

    @ViewById
    lateinit var week: TextView

    @App
    lateinit var app: BWCApplication

    @AfterViews
    fun fullScreen() {
        image.getRootView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

    @AfterViews
    fun settingWeek() {
        val date: Date = Date(app.helper().getLong(app.DATE, 0))
        val calendar:Calendar = Calendar.getInstance()
        calendar.time = Date(Date().time - date.time)
        val weekOfYear:Int = calendar.get(Calendar.DAY_OF_YEAR)/7
        week.setText("$weekOfYear")
        if (weekOfYear > 0) image.setImageResource(weekImages.get(weekOfYear - 1))
    }

    @Click
    protected fun reset() {
        app.helper().edit().clear().commit()
        FREActivity_.intent(this).start()
        finish()
    }
}
