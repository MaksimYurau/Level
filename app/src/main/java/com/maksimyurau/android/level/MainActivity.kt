package com.maksimyurau.android.level

import android.hardware.Sensor
import android.hardware.Sensor.TYPE_ACCELEROMETER
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.hardware.SensorManager.SENSOR_DELAY_NORMAL
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var sManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvSensor = findViewById<TextView>(R.id.tvSensor)
        sManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensor = sManager.getDefaultSensor(TYPE_ACCELEROMETER)
        val sListener = object : SensorEventListener {
            override fun onSensorChanged(sEvent: SensorEvent?) {
                val value = sEvent?.values
                val sData = "X: ${value?.get(0)}\nY: ${value?.get(1)}\nZ: ${value?.get(2)}"
                tvSensor.text = sData
            }

            override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

            }

        }
        sManager.registerListener(sListener, sensor, SENSOR_DELAY_NORMAL)
    }
}