package com.mcmo.headtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.mcmo.headtracker.library.sensor.HeadTracker;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private HeadTracker headTracker;
    private float[] mHeadViewMatrix=new float[16];
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headTracker=HeadTracker.createFromContext(this);
        timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                headTracker.getLastHeadView(mHeadViewMatrix, 0);
                Log.e("HeadTracker", "run "+ Arrays.toString(mHeadViewMatrix));
            }
        };
        timer.scheduleAtFixedRate(task,1000,100);
    }

    @Override
    protected void onResume() {
        super.onResume();
        headTracker.startTracking();
    }

    @Override
    protected void onStop() {
        super.onStop();
        timer.cancel();
        headTracker.stopTracking();
    }

}
