package com.example.quizd

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
                val number = intent.getIntExtra("choice", -1)
                val time: Long = intent.getLongExtra("Timer", 31000)
                val startActivity = Intent(this@TimerActivity, TermActivity::class.java)
                startActivity.putExtra("choice",number)
                startActivity.putExtra("Timer",time)
                startActivity(startActivity)
                finish()
            }

        }
            _timer.start()
    }
}