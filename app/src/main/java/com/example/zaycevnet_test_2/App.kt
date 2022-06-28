package com.example.zaycevnet_test_2

import android.app.Application
import android.content.Context
import android.widget.Toast

class App : Application() {

    private val sharedPreferences by lazy {
        applicationContext.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    }

    override fun onCreate() {
        super.onCreate()
        val count = sharedPreferences.getInt(COLD_START_COUNT, 0)
        if (count == 2){
            Toast.makeText(this, "TOAST", Toast.LENGTH_SHORT).show()
        }else{
            sharedPreferences.edit().putInt(COLD_START_COUNT, count + 1).apply()
        }
    }

    companion object {
        const val SHARED_PREFS_NAME = "shared_prefs_name"
        const val COLD_START_COUNT = "cold_start_count"
    }
}