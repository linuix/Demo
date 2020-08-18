package com.demo.processmessage.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.demo.processmessage.ICallBackInterface;
import com.demo.processmessage.IMessageInterface;

public class RemoteService2 extends Service {
    public RemoteService2() {
    }

    IMessageInterface.Stub iMessageInterface = new IMessageInterface.Stub() {
        @Override
        public int sendMsg(byte[] data) throws RemoteException {
            return 0;
        }

        @Override
        public void setCallBack(ICallBackInterface callback) throws RemoteException {

        }
    };



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.


        return iMessageInterface;
    }
}
