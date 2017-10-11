package com.mcmo.headtracker.library.sensor;

/**
 * Created by ZhangWei on 2017/2/28.
 */

public class SystemClock implements Clock {
    public SystemClock() {
    }

    @Override
    public long nanoTime() {
        return System.nanoTime();
    }
}
