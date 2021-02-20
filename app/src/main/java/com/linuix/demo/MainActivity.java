package com.linuix.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";


    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");


        new Thread(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG, "onCreate run: thread id =" + Thread.currentThread().getId());

                Looper.prepare();
                handler = new Handler();
                Looper.loop();
                Log.d(TAG, "run: end");
            }
        }).start();


    }


    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: ");
        super.onRestart();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: event = "+event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }


    public void open(final View view) {
//        Intent intent = new Intent("com.txznet.adapter.BootService");
//
//        startService(intent);

        Log.d(TAG, "open: ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, " open run: thread id =" + Thread.currentThread().getId());

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run: thread id =" + Thread.currentThread().getId());
                        ((Button) view).setText("aaaaaaaa");
                    }
                });
            }
        }).start();
    }
}
