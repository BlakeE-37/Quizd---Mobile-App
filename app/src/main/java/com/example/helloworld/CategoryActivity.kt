package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category)

        val peopleButton: Button = findViewById(R.id.button3)
        peopleButton.setOnClickListener(){ timerScreen() }
    }
    private fun timerScreen(){
        val startActivity = Intent(this@CategoryActivity, TimerActivity::class.java)
//        intent.putExtra("choice","0")
        startActivity(startActivity)
    }
}