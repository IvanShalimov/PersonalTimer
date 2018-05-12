package com.example.ivan.personaltimer

import android.app.AlarmManager
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class AlarmActivity : AppCompatActivity(){

    private val mediaPlayer:MediaPlayer by lazy {
        MediaPlayer.create(this,R.raw.topsy_turvy_s_like_a_living_dead)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }

    fun onClick(v: View?) {
        releaseMediaPlayer()

        if(v?.id == R.id.textView)
                (getSystemService(Context.ALARM_SERVICE) as AlarmManager)
                        .set(AlarmManager.RTC,
                                AlarmManager.INTERVAL_HOUR,
                                CreaterPendingIntent.create(applicationContext))

        finish()

    }

    private fun releaseMediaPlayer(){
        mediaPlayer.stop()
        mediaPlayer.release()
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseMediaPlayer()
    }

}
