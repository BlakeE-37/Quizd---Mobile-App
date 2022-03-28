package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class difficultySelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.difficulty)

        val easyButton: Button = findViewById(R.id.Easy)
        easyButton.setOnClickListener() {

            val number = intent.getIntExtra("choice", -1)
            val Time: Long = 31000
            val startActivity = Intent(this@difficultySelect, TimerActivity::class.java)
            startActivity.putExtra("choice", number)
            startActivity.putExtra("Timer", Time)
            startActivity(startActivity)
        }
        val mediumButton: Button = findViewById(R.id.Medium)
        mediumButton.setOnClickListener() {

            val number = intent.getIntExtra("choice", -1)
            val Time: Long = 46000
            val startActivity = Intent(this@difficultySelect, TimerActivity::class.java)
            startActivity.putExtra("choice", number)
            startActivity.putExtra("Timer", Time)
            startActivity(startActivity)
        }
        val hardButton: Button = findViewById(R.id.Hard)
        hardButton.setOnClickListener() {

            val number = intent.getIntExtra("choice", -1)
            val Time: Long = 61000
            val startActivity = Intent(this@difficultySelect, TimerActivity::class.java)
            startActivity.putExtra("choice", number)
            startActivity.putExtra("Timer", Time)
            startActivity(startActivity)
        }
    }
}