package com.example.ivan.personaltimer

import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View


class AlarmActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        startService(Intent(this,MusicService::class.java))
    }

    fun onClick(v: View?) {

        stopService(Intent(this,MusicService::class.java))

        if(v?.id == R.id.textView)
                (getSystemService(Context.ALARM_SERVICE) as AlarmManager)
                        .set(AlarmManager.RTC,
                                AlarmManager.INTERVAL_HOUR,
                                CreaterPendingIntent.create(applicationContext))

        finish()
    }
}
