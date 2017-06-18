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
            R.drawable.semana_4_v2,
            R.drawable.semana_5_v2,
            R.drawable.semana_6_v2,
            R.drawable.semana_7_v2,
            R.drawable.semana_8_v2,
            R.drawable.semana_9_v2,
            R.drawable.semana_10_v2,
            R.drawable.semana_11_v2,
            R.drawable.semana_12_v2,
            R.drawable.semana_13_v2,
            R.drawable.semana_14_v2,
            R.drawable.semana_15_v2,
            R.drawable.semana_16_v2,
            R.drawable.semana_17_v2,
            R.drawable.semana_18_v2,
            R.drawable.semana_19_v2,
            R.drawable.semana_20_v2,
            R.drawable.semana_21_v2,
            R.drawable.semana_22_v2,
            R.drawable.semana_23_v2,
            R.drawable.semana_24_v2,
            R.drawable.semana_25_v2,
            R.drawable.semana_26_v2,
            R.drawable.semana_27_v2,
            R.drawable.semana_28_v2,
            R.drawable.semana_29_v2,
            R.drawable.semana_30_v2,
            R.drawable.semana_31_v2,
            R.drawable.semana_32_v2,
            R.drawable.semana_33_v2,
            R.drawable.semana_34_v2,
            R.drawable.semana_35_v2,
            R.drawable.semana_36_v2,
            R.drawable.semana_37_v2,
            R.drawable.semana_38_v2,
            R.drawable.semana_39_v2,
            R.drawable.semana_40_v2)
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
