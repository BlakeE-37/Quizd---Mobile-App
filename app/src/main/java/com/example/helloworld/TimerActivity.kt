package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class TimerActivity : AppCompatActivity() {
    lateinit var _timer : CountDownTimer

//    Just create an instance of the class and it will immediately
//    start the countdown
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        setTimer()
    }


    fun setTimer() {
        _timer = object : CountDownTimer(3000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
//                Edit the number displayed in the XML layout file (3...2...1)
//                Make sure to add 1000 to millisUntilFinished, then divide by
//                1000 to display the correct number of seconds remaining
            }
            override fun onFinish() {
//                Move on to the next activity
            }
        }
    }
}