package com.linuix.dexclassloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {


//        DLoadJar();

        DLoadDex();

//        ClassTest classTest = new ClassTest();
//        classTest.test();

    }

    public static void DLoadJar(){
        // 动态加载jar
        try {
            // 包路径定义
            URL urls = new URL("file:/sdcard/Test.jar");
            //GetPI.class
            URLClassLoader urlLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            Class<URLClassLoader> sysclass = URLClassLoader.class;
            Method method = sysclass.getDeclaredMethod("addURL", new Class[]{URL.class});
            method.setAccessible(true);
            method.invoke(urlLoader, urls);
            /*
             * 实例化一个对象 ，这个类(yerasel.GetPI)可以是串行化传来的多个类的一个，运行时才知道需要哪个类
             * 或者从xml 配置文件中获得字符串
             * 例如
             * String className = readfromXMlConfig;//从xml 配置文件中获得字符串
             * class c = Class.forName(className);
             * factory = (ExampleInterface)c.newInstance();
             * 上面代码已经不存在类名称，它的优点是，无论Example类怎么变化，上述代码不变，
             * 甚至可以更换Example的兄弟类Example2 , Example3 , Example4……，只要他们继承ExampleInterface就可以。
             */
            // 输入类名
            String className = "com.txznet.test.ClassTest";
            Class<?> tidyClass = urlLoader.loadClass(className);
            Object obj = tidyClass.newInstance();
            // 被调用函数的参数
            Class[] parameterTypes = {};
            Method method2 = tidyClass.getDeclaredMethod("test", parameterTypes);
            method2.invoke(obj);

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void DLoadDex(){
        Log.d(TAG, "DLoadDex: ");
        String libPath = "/sdcard/Test.jar"; // 要动态加载的jar
        File f = new File(libPath);
        if (f.exists()){
            Log.d(TAG, "DLoadDex: file exists");
        }

        File dexDir = getDir("dex", MODE_PRIVATE); // 优化后dex的路径
        /**
         * 进行动态加载，利用java的反射调用com.test.dynamic.MyClass的方法
         */
        DexClassLoader dexClassLoader = new DexClassLoader(libPath, dexDir.getAbsolutePath(), null, getClassLoader());
        try {
            Class<Object> cls = (Class<Object>) dexClassLoader.loadClass("com.txznet.test.ClassTest");
            Object object = cls.newInstance();
            Method method = cls.getMethod("test");
            method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
