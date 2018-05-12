package com.example.ivan.personaltimer

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View?) {
        //1000*60*60 - hour
        val intent = Intent(applicationContext, AlarmActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(applicationContext,0,intent,0)

        val am:AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        am.set(AlarmManager.RTC,10000 , pendingIntent)//AlarmManager.INTERVAL_HOUR
        finish()
    }
}
