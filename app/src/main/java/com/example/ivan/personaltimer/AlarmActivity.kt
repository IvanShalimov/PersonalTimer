package com.example.ivan.personaltimer

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.alarmlayout.*


class AlarmActivity : AppCompatActivity(){

    var mode = START_STATE

    companion object {

        const val KEY = "data"
        const val ALARM_STATE = "ALARM"
        const val START_STATE = "START"

        fun createPendingIntent(applicationContext: Context): PendingIntent {
            val intent = Intent(applicationContext, AlarmActivity::class.java)
            intent.putExtra(KEY,ALARM_STATE)

            return PendingIntent.getActivity(applicationContext,
                    0,
                    intent,
                    0)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alarmlayout)

        if(intent != null && intent.hasExtra(KEY)){
            mode = intent.getStringExtra(KEY)
        }
    }

    override fun onResume() {
        super.onResume()
        init()
    }

    private fun init() {
        when (mode){
            START_STATE -> {
                buttonTimer.text = getString(R.string.go)
                replyLabel.visibility = View.GONE
            }
            ALARM_STATE  -> {
                startService(Intent(this,MusicService::class.java))
                buttonTimer.text = getString(R.string.close_label)
                replyLabel.visibility = View.VISIBLE
            }
        }
    }

    fun onClick(v: View?) {
        when(v?.id) {
            R.id.buttonTimer -> {
                if (mode == ALARM_STATE ) {
                    stopService(Intent(this, MusicService::class.java))
                } else {
                    (getSystemService(Context.ALARM_SERVICE) as AlarmManager)
                            .set(AlarmManager.RTC,
                                    System.currentTimeMillis()+AlarmManager.INTERVAL_HOUR,
                                    createPendingIntent(applicationContext))

                }
            }
            R.id.replyLabel -> {
                (getSystemService(Context.ALARM_SERVICE) as AlarmManager)
                        .set(AlarmManager.RTC,
                                System.currentTimeMillis()+AlarmManager.INTERVAL_HOUR,
                                createPendingIntent(applicationContext))
            }
        }

        mode = START_STATE
        finish()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        outState?.putString(KEY,mode)
        super.onSaveInstanceState(outState, outPersistentState)
    }
}
