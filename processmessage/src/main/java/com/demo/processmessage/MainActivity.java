package com.demo.processmessage;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.demo.processmessage.service.RemoteService;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Messenger messenger;

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            Log.d(TAG, "onServiceConnected: ");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            messenger = null;
            Log.d(TAG, "onServiceDisconnected: ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService(new Intent(this, RemoteService.class),serviceConnection, Service.BIND_AUTO_CREATE);
    }

    public static class DataMSG implements Parcelable{

        private String msg;

        public DataMSG(String msg) {
            this.msg = msg;
        }

        protected DataMSG(Parcel in) {
            this.msg = in.readString();
        }

        public String getMsg() {
            return msg;
        }

        @Override
        public String toString() {
            return "DataMSG{" +
                    "msg='" + msg + '\'' +
                    '}';
        }

        public static final Creator<DataMSG> CREATOR = new Creator<DataMSG>() {
            @Override
            public DataMSG createFromParcel(Parcel in) {
                return new DataMSG(in);
            }

            @Override
            public DataMSG[] newArray(int size) {
                return new DataMSG[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(msg);
        }
    }


    public void test(View view) {
        Message msg = Message.obtain();
        msg.replyTo = messenger;
        msg.what = 1;
        DataMSG dataMSG = new DataMSG("test for activity");
        Bundle bundle = new Bundle();
        bundle.putString("keytest","value1111111111111111111");
        msg.setData(bundle);
        try {
            messenger.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
