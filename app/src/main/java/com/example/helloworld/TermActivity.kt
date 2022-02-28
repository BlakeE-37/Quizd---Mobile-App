package com.example.helloworld

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


class TermActivity : AppCompatActivity(), SensorEventListener {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.term_screen)
            setTerm()

            val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager//This and three lines down setup the gyroscope
            sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)?.also { accelerometer ->
                sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI)
            }
        }

        var countDown = true//A boolean to keep track of whether or not the player can give an answer at this moment
        val speed = 2.0f //How fast the player needs to move the phone for there to be input registered
        val timeDelay: Long = 1000 //Won't allow players to reenter in data for this long (in Milliseconds)

        override fun onSensorChanged(p0: SensorEvent?) { //whenever the phone moves
            if (p0 != null && countDown) { //if the phone actually has moved
                if (p0.values[1] >= speed) { //if the movement is greater than our speed
                    on_correct_answer(timeDelay) // What To do on a correct Answer
                    countDown = false //Disables any other answers
                    object: CountDownTimer(timeDelay, 1000){//Delays for timeDelay (in milliseconds)
                    override fun onTick(millisUtilFinished: Long){

                    }
                        override fun onFinish() { //resets countdown so that a new answer can be received
                            countDown = true
                        }
                    }.start() //starts the timer
                }else if(p0.values[1] <= -speed) { //Flip down
                    on_incorrect_answer(timeDelay) //What to do on a flip-down event
                    countDown = false
                    object: CountDownTimer(timeDelay, 1000){
                        override fun onTick(millisUtilFinished: Long){

                        }
                        override fun onFinish() {
                            countDown = true
                        }
                    }.start()
                }
            }
        }

        fun on_correct_answer(timeDelay: Long) {
            val newDelay = timeDelay/2 //The time the screen will be green, MUST BE LOWER THAN TIME DELAY
            val myConstraint = findViewById<ConstraintLayout>(R.id.Constraint)
            myConstraint.setBackgroundResource(R.color.correct_green)
            val textView: TextView = findViewById<TextView>(R.id.animal_term)
            textView.text = "Correct"
            object: CountDownTimer(newDelay, 1000){//Delays for timeDelay (in milliseconds)
            override fun onTick(millisUtilFinished: Long){

            }
                override fun onFinish() { //resets countdown so that a new answer can be received
                    reset_background()
                }
            }.start() //starts the timer
            //ADD POINTS
        }

    fun on_incorrect_answer(timeDelay: Long) {
        val newDelay = timeDelay/2 //The time the screen will be red, MUST BE LESS THAN TIMEDELAY
        val myConstraint = findViewById<ConstraintLayout>(R.id.Constraint)
        myConstraint.setBackgroundResource(R.color.incorrect_red)
        val textView: TextView = findViewById<TextView>(R.id.animal_term)
        textView.text = "Incorrect"
        object: CountDownTimer(newDelay, 1000){//Delays for timeDelay (in milliseconds)
        override fun onTick(millisUtilFinished: Long){

        }
            override fun onFinish() { //resets countdown so that a new answer can be received
                reset_background()
            }
        }.start() //starts the timer
    }

    fun reset_background() {
        val myConstraint = findViewById<ConstraintLayout>(R.id.Constraint)
        myConstraint.setBackgroundResource(R.color.quizd_blue)
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

        override fun onAccuracyChanged(p0: Sensor?, p1: Int) { //This line is needed for some reason
        }
    }
