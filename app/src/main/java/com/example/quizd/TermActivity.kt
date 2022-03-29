package com.example.quizd

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


var countDown = true//A boolean to keep track of whether or not the player can give an answer at this moment
val speed = 2.0f //How fast the player needs to move the phone for there to be input registered
val timeDelay: Long = 1000 //Won't allow players to reenter in data for this long (in Milliseconds)
var totalPoints = 0

class TermActivity : AppCompatActivity(), SensorEventListener {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.term_screen)

            val timer: Long = intent.getLongExtra("Timer", 31000) //how long the game will last
            var time_holder = timer/1000 //This is a variable that converts the time from miliseconds to whole seconds (mostly for the Textview)
            var timer_string = time_holder.toString() //Changes the Time Value into a string for It's associated text box to use

            setTerm()
            val timer_box: TextView = findViewById<TextView>(R.id.timer)
            object: CountDownTimer(31000, 1000){//Delays for timeDelay (in milliseconds)
            override fun onTick(millisUtilFinished: Long){
                time_holder -= 1
                timer_string = time_holder.toString()
                timer_box.text = timer_string
            }
                override fun onFinish() { //resets countdown so that a new answer can be received
                    val point_screen = Intent(this@TermActivity, PointScreen::class.java)
                    point_screen.putExtra("totalPoints", totalPoints)
                    startActivity(point_screen)
                    finish()
                }
            }.start() //starts the timer

            val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager//This and three lines down setup the gyroscope
            sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)?.also { accelerometer ->
                sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI)
            }
        }

        var countDown = true//A boolean to keep track of whether or not the player can give an answer at this moment
        val speed = 4.0f //How fast the player needs to move the phone for there to be input registered
        val timeDelay: Long = 3000 //Won't allow players to reenter in data for this long (in Milliseconds)

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
            totalPoints += 1
            val newDelay = timeDelay/2 //The time the screen will be green, MUST BE LOWER THAN TIME DELAY
            val myConstraint = findViewById<ConstraintLayout>(R.id.Constraint)
            myConstraint.setBackgroundResource(R.color.correct_green)
            val textView: TextView = findViewById<TextView>(R.id.animal_term)
            textView.text = "Correct"
            object: CountDownTimer(newDelay, 3000){//Delays for timeDelay (in milliseconds)
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
        object: CountDownTimer(newDelay, 3000){//Delays for timeDelay (in milliseconds)
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
            val number = intent.getIntExtra("choice", 1) //Gets a number depending on category screen button pressed
            var terms = setOf("hello")
            if(number == 1) { //Checks to see if the number is 1 (associated with animals
                terms = setOf("Koala", "Emu", "Turtle", "Dog")

            }
            else if(number == 2)
            {
                terms = setOf("Egypt", "Lebanon", "etc", "America")

            }
            else if(number == 3)
            {
                terms = setOf("Bob", "Lebron James", "Kanye West", "Ed Sheeran")

            }
            else
            {
                terms = setOf("My oh my", "Something", "Amazing Movie", "A great movie")
            }
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
