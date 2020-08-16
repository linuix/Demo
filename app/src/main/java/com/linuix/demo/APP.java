package com.linuix.demo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Author: link
 * Create: 2020-2020/8/8 0008-22:59
 * Changes (from 2020/8/8 0008)
 * 2020/8/8 0008 : Create APP.java (link);
 **/
public class APP extends Application {

    private static final String TAG = APP.class.getName();


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.d(TAG, "attachBaseContext: ");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    
    }
}
