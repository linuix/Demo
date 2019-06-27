package com.test.xposed;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Author: link
 * Create: 2019-2019/6/2-1:06
 * Changes (from 2019/6/2)
 * 2019/6/2 : Create APP.java (link);
 **/
public class APP extends Application {

    private static final String TAG = "APP-----------";

    @Override
    protected void attachBaseContext(Context base) {
        Log.d(TAG, "attachBaseContext: ");
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }
}
