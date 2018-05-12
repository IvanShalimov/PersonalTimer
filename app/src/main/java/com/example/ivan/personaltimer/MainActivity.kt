package com.example.ivan.personaltimer

import android.app.AlarmManager
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(v: View?) {
        (getSystemService(Context.ALARM_SERVICE) as AlarmManager).
                set(AlarmManager.RTC,
                        AlarmManager.INTERVAL_HOUR,
                        CreaterPendingIntent.create(applicationContext))
        finish()
    }
}
