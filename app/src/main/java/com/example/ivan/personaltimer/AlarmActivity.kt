package com.example.ivan.personaltimer

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class AlarmActivity : AppCompatActivity(), View.OnClickListener {

    var mediaPlayer:MediaPlayer? = null
    //var audioManager: AudioManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

       // audioManager = (getSystemService(Context.AUDIO_SERVICE) as AudioManager)
        mediaPlayer = MediaPlayer.create(this,R.raw.topsy_turvy_s_like_a_living_dead)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button2 ->{
                releaseMediaPlayer()
                finish()
            }
            R.id.textView ->{
                releaseMediaPlayer()

                val pendingIntent = PendingIntent.getActivity(applicationContext,
                        0,
                        Intent(applicationContext, AlarmActivity::class.java),
                        0)

                (getSystemService(Context.ALARM_SERVICE) as AlarmManager)
                        .set(AlarmManager.RTC, 10000, pendingIntent)//AlarmManager.HOUR
                finish()
            }

        }

    }

    private fun releaseMediaPlayer(){
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseMediaPlayer()
    }

}
