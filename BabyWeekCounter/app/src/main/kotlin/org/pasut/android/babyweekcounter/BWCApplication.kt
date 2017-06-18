package org.pasut.android.babyweekcounter

import android.app.Application
import android.content.SharedPreferences
import org.androidannotations.annotations.EApplication

@EApplication
open class BWCApplication : Application() {
    val DB = "BWC_DB"
    val DATE = "date"

    fun helper(): SharedPreferences {
        return getSharedPreferences(DB, 4)
    }
}
