package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class PointScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_point_screen)

        val num_points = intent.getIntExtra("totalPoints", 0)
        //changing the points number to the amount of points received in previous line
        val points: TextView = findViewById(R.id.points)
        points.text = num_points.toString()

        //function to start PlayScreen activity
        fun goBack() {
        val play = Intent(this@PointScreen, PlayScreen::class.java)
            startActivity(play)
        }

        //back button - takes you to play screen - starts goBack function
        val backButton: Button = findViewById(R.id.arrow)
        backButton.setOnClickListener(){ goBack() }


    }
}