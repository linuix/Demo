package com.test.xposed;

import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Author: link
 * Create: 2019-2019/6/1-22:47
 * Changes (from 2019/6/1)
 * 2019/6/1 : Create XposedHookUtil.java (link);
 **/
public class XposedHookUtil implements IXposedHookLoadPackage {

    private static final String TAG = "XposedHookUtil";
    String class_name = "wy.experiment.xposed.activity.LoginActivity";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        Log.d(TAG, "handleLoadPackage: loadPackageParam.packageName = "+loadPackageParam.packageName);
        if (!loadPackageParam.packageName.equals("wy.experiment.xposed")){
            return;
        }
        Class clazz = loadPackageParam.classLoader.loadClass(class_name);
        Log.d(TAG, "hook成功！: ");
        XposedHelpers.findAndHookMethod(clazz, "hookTest", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                Log.d(TAG, "replaceHookedMethod: ");
                return "被hook了";
            }
        });
    }
}
