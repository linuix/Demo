package com.linuix.menory;

import android.util.Log;

/**
 * Created by linuix on 18-3-19.
 */

public class User {

    public static String a = "1";

    String name;
    String age;
    byte[] data = new byte[2048*10];

    static {
        Log.d("user", "static initializer: user 加载");
    }

}
