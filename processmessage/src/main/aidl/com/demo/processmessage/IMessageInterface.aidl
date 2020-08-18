// IMessageInterface.aidl
package com.demo.processmessage;

// Declare any non-default types here with import statements
import com.demo.processmessage.ICallBackInterface;
interface IMessageInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */

     int sendMsg(in byte []data);

    void setCallBack(ICallBackInterface callback);


}
