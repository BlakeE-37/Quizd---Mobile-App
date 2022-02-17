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

//    Just create an instance of the class and it will immediately
//    start the countdown
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.timer)
    setTimer()
    }


        fun setTimer() {
        _timer = object : CountDownTimer(4000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
//                Edit the number displayed in the XML layout file (3...2...1)
//                Make sure to add 1000 to millisUntilFinished, then divide by
//                1000 to display the correct number of seconds remaining
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