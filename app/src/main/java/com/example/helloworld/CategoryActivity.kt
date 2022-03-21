package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category)

        val animalsButton: Button = findViewById(R.id.button)
        animalsButton.setOnClickListener(){timerScreenAnimals()}

        val placesButton: Button = findViewById(R.id.button2)
        placesButton.setOnClickListener(){timerScreenPlaces()}

        val peopleButton: Button = findViewById(R.id.button3)
        peopleButton.setOnClickListener(){ timerScreenPeople() }

        val moviesButton: Button = findViewById(R.id.button4)
        moviesButton.setOnClickListener(){timerScreenMovies()}




    }
    private fun timerScreenAnimals(){
        val startActivity = Intent(this@CategoryActivity, TimerActivity::class.java)
        startActivity.putExtra("choice",1)
        startActivity(startActivity)
    }
    private fun timerScreenPlaces()
    {
        val startActivity = Intent(this@CategoryActivity, TimerActivity::class.java)
        startActivity.putExtra("choice",2)
        startActivity(startActivity)
    }
    private fun timerScreenPeople(){
        val startActivity = Intent(this@CategoryActivity, TimerActivity::class.java)
        startActivity.putExtra("choice",3)
        startActivity(startActivity)
    }
    private fun timerScreenMovies(){
        val startActivity = Intent(this@CategoryActivity, TimerActivity::class.java)
        startActivity.putExtra("choice",4)
        startActivity(startActivity)
    }
}