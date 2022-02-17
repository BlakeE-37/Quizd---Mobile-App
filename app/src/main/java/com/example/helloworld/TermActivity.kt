package com.example.helloworld

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


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
    }
