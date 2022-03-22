package com.example.helloworld

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PointScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_point_screen)

        var num_points = intent.getIntExtra("totalPoints", 0)

        var points: TextView = findViewById(R.id.points)
        points.text = num_points.toString()
    }
}