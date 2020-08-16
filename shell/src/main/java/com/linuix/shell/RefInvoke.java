package com.linuix.shell;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Author: link
 * Create: 2020-2020/8/8 0008-18:49
 * Changes (from 2020/8/8 0008)
 * 2020/8/8 0008 : Create RefInvoke.java (link);
 **/
class RefInvoke {
    public static Object invokeStaticMethod(String clsStr, String methodName, Class[] classes, Object[] objects) {
        try {
            Class cls = Class.forName(clsStr);
            Method method = cls.getDeclaredMethod(methodName, classes);
            return method.invoke(null, objects);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getObjectField(String clsStr, Object obj, String fieldName) {
        try {
            Class cls = Class.forName(clsStr);
            Field field = cls.getDeclaredField(fieldName);
            Object fieldObj = null;
            if (!field.isAccessible()) {
                field.setAccessible(true);
                fieldObj = field.get(obj);
                field.setAccessible(false);
            } else {
                fieldObj = field.get(obj);
            }
            return fieldObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setObjectField(String clsStr, String fieldName, Object obj, Object fieldObj) {
        try {
            Class cls = Class.forName(clsStr);
            Field field = cls.getDeclaredField(fieldName);
            if (!field.isAccessible()) {
                field.setAccessible(true);
                field.set(obj, fieldObj);
                field.setAccessible(false);
            } else {
                field.set(obj, fieldObj);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Object invokeMethod(String clsStr, String methodStr, Object obj, Class[] parameterTypes, Object[] args) {
        try {
            Class cls = Class.forName(clsStr);
            Method method = cls.getDeclaredMethod(methodStr,parameterTypes);
            Object resultObj = method.invoke(obj,args);
            return resultObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
