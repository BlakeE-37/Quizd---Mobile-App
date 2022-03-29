package com.example.quizd

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class PlayScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        val playButton: Button = findViewById(R.id.button5)
        playButton.setOnClickListener(){ categoryScreen() }
    }
    private fun categoryScreen(){
        val startActivity = Intent(this@PlayScreen, CategoryActivity::class.java)
        startActivity(startActivity, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
    private fun buttonAnimation()
    {
        val playButton: Button = findViewById(R.id.button5)
        playButton.width = 10

    }
}