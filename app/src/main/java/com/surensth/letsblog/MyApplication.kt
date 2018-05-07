package com.surensth.letsblog

import android.app.Application
import com.chibatching.kotpref.Kotpref

/**
 * Created by surensth on 5/7/18.
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)

    }
}