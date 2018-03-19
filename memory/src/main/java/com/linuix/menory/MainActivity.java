package com.linuix.menory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String TAG = "mainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void test(View view) {
        for (int i = 0; i<10000;i++){
            UserManger userManger = UserManger.getInstance(this);
//            User u = new User();
            Log.d(TAG, "test: i="+i);
        }

    }
}
