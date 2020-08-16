package com.linuix.demo;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;


public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: start ");
        try {

//            setContentView(getResources().getIdentifier("activity_main","layout",getPackageName()));
            XmlResourceParser xmlResourceParser = getResources().getLayout(R.layout.activity_main);
            View view = LayoutInflater.from(this).inflate(xmlResourceParser,null);
            setContentView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onCreate: end");
    }


    public void open(View view) {
        Log.d(TAG, "open: "+getClass().getCanonicalName());
    }
}
