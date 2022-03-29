package com.example.quizd

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DifficultySelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.difficulty)

        val easyButton: Button = findViewById(R.id.Easy)
        easyButton.setOnClickListener() {

            val number = intent.getIntExtra("choice", -1)
            val Time: Long = 31000
            val startActivity = Intent(this@DifficultySelect, TimerActivity::class.java)
            startActivity.putExtra("choice", number)
            startActivity.putExtra("Timer", Time)
            startActivity(startActivity, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        val mediumButton: Button = findViewById(R.id.Medium)
        mediumButton.setOnClickListener() {

            val number = intent.getIntExtra("choice", -1)
            val Time: Long = 46000
            val startActivity = Intent(this@DifficultySelect, TimerActivity::class.java)
            startActivity.putExtra("choice", number)
            startActivity.putExtra("Timer", Time)
            startActivity(startActivity, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        val hardButton: Button = findViewById(R.id.Hard)
        hardButton.setOnClickListener() {

            val number = intent.getIntExtra("choice", -1)
            val Time: Long = 61000
            val startActivity = Intent(this@DifficultySelect, TimerActivity::class.java)
            startActivity.putExtra("choice", number)
            startActivity.putExtra("Timer", Time)
            startActivity(startActivity, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}