package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category)

        val animalsButton: Button = findViewById(R.id.Hard)
        animalsButton.setOnClickListener(){timerScreen(1)}

        val placesButton: Button = findViewById(R.id.Medium)
        placesButton.setOnClickListener(){timerScreen(2)}

        val peopleButton: Button = findViewById(R.id.button3)
        peopleButton.setOnClickListener(){ timerScreen(3) }

        val moviesButton: Button = findViewById(R.id.Easy)
        moviesButton.setOnClickListener(){timerScreen(4)}
    }
    private fun timerScreen(x: Int){
        val startActivity = Intent(this@CategoryActivity,difficultySelect::class.java)
        startActivity.putExtra("choice",x)
        startActivity(startActivity)
        finish()
    }

}