package com.mcmo.headtracker.library.sensor;

import android.hardware.SensorEventListener;

/**
 * Created by ZhangWei on 2017/2/28.
 */

public interface SensorEventProvider {
    void start();

    void stop();

    void registerListener(SensorEventListener var1);

    void unregisterListener(SensorEventListener var1);
}
