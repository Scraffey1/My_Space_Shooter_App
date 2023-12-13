package com.example.myapplication;

import android.app.Activity;
import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Input implements SensorEventListener {

    public double bx;
    public double by;
    public double bz;

    Activity activity;

    public Input(Activity activity)
    {
        this.activity = activity;
        sensorManager = (SensorManager) activity.getSystemService(Activity.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    }

    private SensorManager sensorManager;
    private Sensor sensor;


    public void pause()
    {
        sensorManager.unregisterListener(this);
    }

    public void resume()
    {
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        bx = event.values[0];
        by = event.values[1];
        bz = event.values[2];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
