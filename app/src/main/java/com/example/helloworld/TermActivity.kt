package com.example.helloworld

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class TermActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.term_screen)
            setTerm()
        }
        fun termSelect(): String {
            val terms = setOf("Zebra", "Antelope", "Gorilla", "Koala")
            val r = (0..3).random()
            return terms.elementAt(r)

        }
        fun setTerm()
        {
            val term = termSelect()
            val textView: TextView = findViewById<TextView>(R.id.animal_term)
            textView.text = term
        }
        fun displayCorrect() { // *** Not tested
//            Display the correct screen for 2 seconds
            setContentView(R.layout.correct_screen)
            object : CountDownTimer(2000, 1000) {
                override fun onFinish() {
                    return
                }
                override fun onTick(millisUntilFinished: Long) {}
            }.start()
        }
        fun displayIncorrect() { // *** Not tested
//            Change the color of the correct screen to green, and change the
//            text to 'Incorrect', then display it
            val screen = findViewById<ConstraintLayout>(R.id.correct_screen)
            screen.setBackgroundColor(Color.RED)
            val textValue = findViewById<ConstraintLayout>(R.id.text)
        }
    }
