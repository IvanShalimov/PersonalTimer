package com.example.ivan.personaltimer

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class AlarmActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button2 ->{
                finish()
            }
            R.id.textView ->{
                val intent = Intent(applicationContext, AlarmActivity::class.java)
                val pendingIntent = PendingIntent.getActivity(applicationContext,0,intent,0)

                val am: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
                am.set(AlarmManager.RTC, AlarmManager.INTERVAL_HOUR, pendingIntent)//
                finish()
            }

        }

    }

}
