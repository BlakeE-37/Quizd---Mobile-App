package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import java.util.concurrent.TimeUnit

class TimerActivity : AppCompatActivity() {
    lateinit var _timer : CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.timer)
    setTimer()
    }


        fun setTimer() {
        _timer = object : CountDownTimer(4000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val textView: TextView = findViewById<TextView>(R.id.textView_timer)
                var time = (millisUntilFinished/1000).toString()
                textView.text = time
            }
            override fun onFinish() {
                val startActivity = Intent(this@TimerActivity, TermActivity::class.java)
                startActivity(startActivity)
            }

        }
            _timer.start()
    }
}