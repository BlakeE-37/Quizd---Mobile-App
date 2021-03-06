package com.example.quizd

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

class AccelerometerActivity : AppCompatActivity(), SensorEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager//This and three lines down setup the gyroscope
        sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)?.also { accelerometer ->
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI)
        }
    }


    var countDown = true//A boolean to keep track of whether or not the player can give an answer at this moment
    val speed = 2.0f //How fast the player needs to move the phone for there to be input registered
    val timeDelay: Long = 5000 //Won't allow players to reenter in data for this long (in Milliseconds)

    override fun onSensorChanged(p0: SensorEvent?) { //whenever the phone moves
        if (p0 != null && countDown) { //if the phone actually has moved
            if (p0.values[1] >= speed) { //if the movement is greater than our speed
                println("Correct Answer!") // What To do on a correct Answer
                countDown = false //Disables any other answers
                object: CountDownTimer(timeDelay, 1000){//Delays for timeDelay (in milliseconds)
                override fun onTick(millisUtilFinished: Long){

                }
                    override fun onFinish() { //resets countdown so that a new answer can be received
                        countDown = true
                    }
                }.start() //starts the timer
            }else if(p0.values[1]  <= -speed) { //Flip down
                println("Skip Question!") //What to do on a flip-down event
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

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) { //This line is needed for some reason
    }
}