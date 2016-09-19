package com.furture.patch;



import com.furture.react.JSRef;

import java.lang.reflect.Method;

/**
 * Created by furture on 16/9/19.
 */
public class Callback {

    public static final String METHOD_NAME = "onCall";

    private JSRef jsRef;

    private Method method;

    public Callback(JSRef jsRef, Method method) {
        this.jsRef = jsRef;
        this.method = method;
    }

    public Object call(){
        synchronized (JSPatch.class){
            return jsRef.call(METHOD_NAME);
        }
    }

    public Object call(Object thisObject){
        synchronized (JSPatch.class){
            return jsRef.call(METHOD_NAME, thisObject);
        }
    }

    public Object call(Object args1, Object args2){
        synchronized (JSPatch.class) {
            return jsRef.call(METHOD_NAME, args1, args2);
        }
    }

    public Object call(Object args1, Object args2, Object args3){
        synchronized (JSPatch.class) {
            return jsRef.call(METHOD_NAME, args1, args2, args3);
        }
    }

    public Object call(Object args1, Object args2, Object args3, Object args4){
        synchronized (JSPatch.class) {
            return jsRef.call(METHOD_NAME, args1, args2, args3, args4);
        }
    }

    public Object call(Object args1, Object args2, Object args3, Object args4, Object args5){
        synchronized (JSPatch.class) {
            return jsRef.call(METHOD_NAME, args1, args2, args3, args4, args5);
        }
    }

    public Object call(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6){
        synchronized (JSPatch.class) {
            return jsRef.call(METHOD_NAME, args1, args2, args3, args4, args5, args6);
        }
    }

    public Object call(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6, Object args7){
        synchronized (JSPatch.class) {
            return jsRef.call(METHOD_NAME, args1, args2, args3, args4, args5, args6, args7);
        }
    }

    public Object call(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6, Object args7, Object args8){
        synchronized (JSPatch.class) {
            return jsRef.call(METHOD_NAME, args1, args2, args3, args4, args5, args6, args7, args8);
        }
    }

    public Method getMethod() {
        return method;
    }

    public Object getJSRef() {
        return jsRef;
    }
}
