package com.demo.processmessage.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

import com.demo.processmessage.MainActivity;

public class RemoteService extends Service {
    private static final String TAG = "RemoteService";

    public RemoteService() {
        MainActivity.DataMSG dataMSG = new MainActivity.DataMSG("test");
        Log.d(TAG, "RemoteService: "+dataMSG.getMsg());
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage: what = "+msg.what);
//            MainActivity.DataMSG dataMSG = (MainActivity.DataMSG) msg.obj;
            Bundle bundle = msg.getData();
            Log.d(TAG, "handleMessage: msg = "+bundle.getString("keytest"));
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Messenger messenger = new Messenger(handler);
        return  messenger.getBinder();
    }
}
