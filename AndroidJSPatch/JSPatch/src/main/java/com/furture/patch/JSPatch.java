package com.furture.patch;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.alipay.euler.andfix.AndFix;
import com.alipay.euler.andfix.Compat;
import com.furture.react.DuktapeEngine;
import com.furture.react.JSRef;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * Created by furture on 16/8/24.
 * JSPatch For Android Based On Android
 */
public class JSPatch {

    /**
     * 已经patch的方法列表,防止重复patch
     * */
    private static Map<String, Method> patchedMethods = new ConcurrentHashMap<String, Method>();

    private static Context context;
    private static DuktapeEngine patchEngine;


    /**
     *  init patch
     * */
    public static  void  init(Context applicationContext){
        context = applicationContext.getApplicationContext();
        patchEngine = new DuktapeEngine();
        patchEngine.put("JSPatch", JSPatch.class);
    }

    /**
     *  execute patch
     * */
    public  static void execute(String script){
        synchronized (JSPatch.class){
            patchEngine.execute(script);
        }
    }

    /**
     * destory when application exit
     * */
    public  static void destory(){
        synchronized (JSPatch.class){
            if(patchEngine != null){
                patchEngine.destory();
            }
        }
    }



    /**
     * 替换现有方法，把方法回调到JavaScript回调
     *
     * methodSign  methodName(classNameKeyword,classNameKeyWord);
     * */
    public static void  replaceMethod(String className, String methodNameWithSign, JSRef callback){
        if(!Compat.isSupport()){
            Log.e("JSPatch", "JSPatch AndFix is Not Support");
            return;
        }
        try{
            String key = className + "@" + methodNameWithSign;
            Method  targetMethod = patchedMethods.get(key);
            if(targetMethod == null){
                Class<?>   targetClass = context.getClassLoader().loadClass(className);
                String []  methodSign = CALL_METHOD_SIGN_SPLIT_PATTERN.split(methodNameWithSign);
                String methodName = methodSign[0];
                String[] argsTypes = null;
                if(methodSign.length == 2){
                    argsTypes = TYPES_SPLIT_PATTERN.split(methodSign[1], -1);
                }
                Method[] methods = targetClass.getDeclaredMethods();

                for (Method method : methods) {
                    if (!methodName.equals(method.getName())) {
                        continue;
                    }
                    if(argsTypes == null){
                        targetMethod = method;
                        break;
                    }
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != argsTypes.length) {
                        continue;
                    }
                    boolean okMethod = true;
                    for (int i = 0; i < parameterTypes.length; i++) {
                        Class<?> parameterType = parameterTypes[i];
                        String   argsType = argsTypes[i];
                        if(TextUtils.isEmpty(argsType)){
                            continue;
                        }
                        String name = parameterType.getName();
                        if(name.lastIndexOf(argsType) >= 0){
                            continue;
                        }
                        okMethod = false;
                        break;
                    }
                    if (okMethod) {
                        targetMethod = method;
                        break;
                    }
                }
                if(targetMethod == null){
                    throw new RuntimeException("method " + methodNameWithSign +  " cann't find on class " + className);
                }
            }

            Method hackMethod = HackMethods.findHackMethod(targetMethod);
            if(hackMethod == null){
                throw new RuntimeException("none more hack method available for method " + methodNameWithSign);
            }
            HackMethods.putHackCallback(hackMethod.getName(), new Callback(callback, targetMethod));
            if(!patchedMethods.containsKey(key)){
                AndFix.addReplaceMethod(targetMethod, hackMethod);
                patchedMethods.put(key, targetMethod);
            }
        }catch (Throwable e){
            Log.e("JSPatch", "JSPatch exception", e);
        }
    }

    private static final Pattern CALL_METHOD_SIGN_SPLIT_PATTERN = Pattern.compile("\\(|\\)");
    private static final Pattern TYPES_SPLIT_PATTERN = Pattern.compile(",");

}
