package org.pasut.android.babyweekcounter

import android.app.Application
import org.androidannotations.annotations.EApplication

@EApplication
open class BWCApplication : Application() {
    val DB = "BWC_DB"
    val DATE = "date"

    fun helper() = getSharedPreferences(DB, 4)
}
