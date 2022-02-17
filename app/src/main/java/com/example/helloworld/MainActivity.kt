package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        object : CountDownTimer(2000, 1000) {
            override fun onFinish() {
                val startActivity = Intent(this@MainActivity, PlayScreen::class.java)
                startActivity(startActivity)
                finish()
            }

            override fun onTick(millisUntilFinished: Long) {}
        }.start()
    }
    //This is a comment!
}