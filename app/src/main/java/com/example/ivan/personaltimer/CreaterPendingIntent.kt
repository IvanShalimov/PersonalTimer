package com.example.ivan.personaltimer

import android.app.PendingIntent
import android.content.Context
import android.content.Intent

class CreaterPendingIntent {

    companion object {
        fun create(applicationContext: Context) =
                PendingIntent.getActivity(applicationContext,
                0,
                Intent(applicationContext, AlarmActivity::class.java),
                0)
    }
}