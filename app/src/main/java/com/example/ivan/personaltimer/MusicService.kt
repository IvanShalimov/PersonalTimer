package com.example.ivan.personaltimer

import android.app.Service
import android.content.Intent
<<<<<<< HEAD
import android.os.IBinder

class MusicService : Service() {
=======
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service(), MediaPlayer.OnCompletionListener {
    override fun onCompletion(mp: MediaPlayer?) {
        //releaseMediaPlayer()
        stopSelf()
    }

    private val mediaPlayer: MediaPlayer by lazy {
        MediaPlayer.create(this,R.raw.topsy_turvy_s_like_a_living_dead)
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer.isLooping = false
        mediaPlayer.setOnCompletionListener(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(!mediaPlayer.isPlaying)
            mediaPlayer.start()

        return super.onStartCommand(intent, flags, startId)
    }
>>>>>>> b9d532627307a3c3ab952063a005be99bbc97d48

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
<<<<<<< HEAD
=======

    override fun onDestroy() {
        super.onDestroy()
        releaseMediaPlayer()
    }

    private fun releaseMediaPlayer(){
        mediaPlayer.stop()
        mediaPlayer.release()
    }
>>>>>>> b9d532627307a3c3ab952063a005be99bbc97d48
}
