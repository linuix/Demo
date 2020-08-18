package com.linuix.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        new Thread(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG, "onCreate run: thread id ="+Thread.currentThread().getId());

                Looper.prepare();
                handler = new Handler();
                Looper.loop();
            }
        }).start();


    }


    public void open(final View view) {
//        Intent intent = new Intent("com.txznet.adapter.BootService");
//
//        startService(intent);

        Log.d(TAG, "open: ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run: thread id ="+Thread.currentThread().getId());
                        ((Button)view).setText("aaaaaaaa");
                    }
                });
            }
        }).start();
    }
}
