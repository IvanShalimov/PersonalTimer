package com.example.ivan.personaltimer

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View?) {
        AlarmingManager(applicationContext,getSystemService(Context.ALARM_SERVICE)).setupAlarming()
        finish()
    }
}
