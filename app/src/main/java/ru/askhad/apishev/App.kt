package ru.askhad.apishev

import android.app.Application
import android.util.Log
import com.facebook.stetho.Stetho

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        instance = this
    }
}
