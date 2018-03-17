package com.example.ivan.personaltimer

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmingManager(private val context: Context, private val service:Any) {
    
    fun setupAlarming(){
        val intent = Intent(context, AlarmActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context,0,intent,0)

        val am: AlarmManager = service as AlarmManager
        val numeric:Long = R.integer.interval.toLong()
        am.set(AlarmManager.RTC,numeric, pendingIntent)

        Toast.makeText(context, R.string.start_timer, Toast.LENGTH_LONG).show()
    } 
}