package com.anubhav.hike

import android.app.Application
import android.content.Context

class HikeApplication: Application() {

    @Override
    override fun onCreate() {
        super.onCreate()
        setContext(this)
    }

    companion object {

        lateinit var context: HikeApplication
            private set

        fun setContext(context: Context) {
            this.context = context as HikeApplication
        }
    }
}