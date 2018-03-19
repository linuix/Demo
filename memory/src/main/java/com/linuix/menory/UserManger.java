package com.linuix.menory;

import android.content.Context;

/**
 * Created by linuix on 18-3-19.
 */

public class UserManger {

//    private static UserManger instance;
//
//    private Context context;
//
//    private UserManger(Context context) {
//        this.context = context;
//    }
//
//    public static UserManger getInstance(Context context) {
//        if (instance == null) {
//            instance = new UserManger(context);
//        }
//        return instance;
//    }
private static UserManger instance;

    private Context context;

    private UserManger(Context context) {
        this.context = context;
    }

    public static UserManger getInstance(Context context) {
        if (instance == null) {
            if(context!=null){
                instance = new UserManger(context.getApplicationContext());
            }
        }
        return instance;
    }
}
