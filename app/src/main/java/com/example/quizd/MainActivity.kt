package com.example.quizd

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //starts music
        val music1 = Intent(this@MainActivity, BackgroundMusic::class.java)
        startService(music1)

        object : CountDownTimer(2000, 1000) {
            override fun onFinish() {
                val startActivity = Intent(this@MainActivity, PlayScreen::class.java)
                startActivity(startActivity)
                finish()
            }

            override fun onTick(millisUntilFinished: Long) {}
        }.start()
    }
}