package com.furture.patch;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by furture on 16/9/19.
 */
public class HackMethods {

    /**
     * hack 方法的回调函数
     * */
    private  static Map<String, Callback> hackCallbacks = new ConcurrentHashMap<String, Callback>();

    /**
     * 设置hack方法的调用回调
     * */
    public static void putHackCallback(String key, Callback callback){
          hackCallbacks.put(key, callback);
    }


    /**
     * 找到一个方法签名的例子
     * */
    public static Method findHackMethod(Method originMethod){
        int modifier =  originMethod.getModifiers();
        int length = originMethod.getParameterTypes().length;
        if(!Modifier.isStatic(modifier)){
            length +=1;
        }
        int  index = 0;
        Method  targetMethod = null;
        String key = "hack" + length + "0";
        while (hackCallbacks.get(key) != null){
            Callback callback = hackCallbacks.get(key);
            if(originMethod.getName().equals(callback.getMethod().getName())){
                Class<?>[] srcTypes = originMethod.getParameterTypes();
                Class<?>[] hackTypes = callback.getMethod().getParameterTypes();
                if(srcTypes.length == hackTypes.length){
                    boolean okType = true;
                    for(int i=0; i<srcTypes.length; i++){
                        Class<?> srcType  = srcTypes[i];
                        Class<?> hackType  = hackTypes[i];
                        if(srcType != hackType){
                            okType = false;
                            break;
                        }
                    }
                    if(okType){
                        targetMethod = callback.getMethod();
                        break;
                    }
                }
            }
            index++;
            key = "hack" + length + index;
            if(index >= 10){
                break;
            }
        }

        if(targetMethod == null){
            Method[] methods = HackMethods.class.getMethods();
            for (Method method : methods) {
                if (!key.equals(method.getName())) {
                    continue;
                }
                targetMethod = method;
            }
        }
        return  targetMethod;
    }




    public static Object hack00(){
        Callback call = hackCallbacks.get("hack00");
        return  call.call();
    }

    public static Object hack01(){
        Callback call = hackCallbacks.get("hack01");
        return  call.call();
    }

    public static Object hack02(){
        Callback call = hackCallbacks.get("hack02");
        return  call.call();
    }


    public static Object hack03(){
        Callback call = hackCallbacks.get("hack03");
        return  call.call();
    }

    public static Object hack04(){
        Callback call = hackCallbacks.get("hack04");
        return  call.call();
    }

    public static Object hack05(){
        Callback call = hackCallbacks.get("hack05");
        return  call.call();
    }

    public static Object hack06(){
        Callback call = hackCallbacks.get("hack06");
        return  call.call();
    }

    public static Object hack07(Object thisObject){
        Callback call = hackCallbacks.get("hack07");
        return  call.call();
    }

    public static Object hack08(){
        Callback call = hackCallbacks.get("hack08");
        return  call.call();
    }

    public static Object hack09(){
        Callback call = hackCallbacks.get("hack09");
        return  call.call();
    }

    public static Object hack10(Object argsOne){
        Callback call = hackCallbacks.get("hack10");
        return call.call(argsOne);
    }

    public static Object hack11(Object argsOne){
        Callback call = hackCallbacks.get("hack11");
        return call.call(argsOne);
    }

    public static Object hack12(Object argsOne){
        Callback call = hackCallbacks.get("hack12");
        return call.call(argsOne);
    }


    public static Object hack13(Object argsOne){
        Callback call = hackCallbacks.get("hack13");
        return call.call(argsOne);
    }

    public static Object hack14(Object argsOne){
        Callback call = hackCallbacks.get("hack14");
        return call.call(argsOne);
    }

    public static Object hack15(Object argsOne){
        Callback call = hackCallbacks.get("hack15");
        return call.call(argsOne);
    }

    public static Object hack16(Object argsOne){
        Callback call = hackCallbacks.get("hack16");
        return call.call(argsOne);
    }

    public static Object hack17(Object argsOne){
        Callback call = hackCallbacks.get("hack17");
        return call.call(argsOne);
    }

    public static Object hack18(Object argsOne){
        Callback call = hackCallbacks.get("hack18");
        return call.call(argsOne);
    }

    public static Object hack19(Object argsOne){
        Callback call = hackCallbacks.get("hack19");
        return call.call(argsOne);
    }

    public static Object hack110(Object argsOne){
        Callback call = hackCallbacks.get("hack110");
        return call.call(argsOne);
    }

    public static Object hack111(Object argsOne){
        Callback call = hackCallbacks.get("hack111");
        return call.call(argsOne);
    }

    public static Object hack112(Object argsOne){
        Callback call = hackCallbacks.get("hack112");
        return call.call(argsOne);
    }

    public static Object hack113(Object argsOne){
        Callback call = hackCallbacks.get("hack113");
        return call.call(argsOne);
    }

    public static Object hack114(Object argsOne){
        Callback call = hackCallbacks.get("hack114");
        return call.call(argsOne);
    }

    public static Object hack115(Object argsOne){
        Callback call = hackCallbacks.get("hack115");
        return call.call(argsOne);
    }

    public static Object hack116(Object argsOne){
        Callback call = hackCallbacks.get("hack116");
        return call.call(argsOne);
    }

    public static Object hack117(Object argsOne){
        Callback call = hackCallbacks.get("hack117");
        return call.call(argsOne);
    }

    public static Object hack118(Object argsOne){
        Callback call = hackCallbacks.get("hack118");
        return call.call(argsOne);
    }

    public static Object hack119(Object argsOne){
        Callback call = hackCallbacks.get("hack119");
        return call.call(argsOne);
    }

    public static Object hack20(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack20");
        return call.call(args1, args2);
    }

    public static Object hack21(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack21");
        return call.call(args1, args2);
    }

    public static Object hack22(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack22");
        return call.call(args1, args2);
    }


    public static Object hack23(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack23");
        return call.call(args1, args2);
    }

    public static Object hack24(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack24");
        return call.call(args1, args2);
    }

    public static Object hack25(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack25");
        return call.call(args1, args2);
    }

    public static Object hack26(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack26");
        return call.call(args1, args2);
    }

    public static Object hack27(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack27");
        return call.call(args1, args2);
    }

    public static Object hack28(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack28");
        return call.call(args1, args2);
    }

    public static Object hack29(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack29");
        return call.call(args1, args2);
    }

    public static Object hack210(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack210");
        return call.call(args1, args2);
    }

    public static Object hack211(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack211");
        return call.call(args1, args2);
    }

    public static Object hack212(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack212");
        return call.call(args1, args2);
    }

    public static Object hack213(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack213");
        return call.call(args1, args2);
    }

    public static Object hack214(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack214");
        return call.call(args1, args2);
    }

    public static Object hack215(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack215");
        return call.call(args1, args2);
    }

    public static Object hack216(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack216");
        return call.call(args1, args2);
    }

    public static Object hack217(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack217");
        return call.call(args1, args2);
    }

    public static Object hack218(Object args1, Object args2){
        Callback call = hackCallbacks.get("hack218");
        return call.call(args1, args2);
    }


    public static Object hack30(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack30");
        return call.call(args1, args2, args3);
    }

    public static Object hack31(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack31");
        return call.call(args1, args2, args3);
    }

    public static Object hack32(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack32");
        return call.call(args1, args2, args3);
    }


    public static Object hack33(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack33");
        return call.call(args1, args2, args3);
    }

    public static Object hack34(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack34");
        return call.call(args1, args2, args3);
    }

    public static Object hack35(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack35");
        return call.call(args1, args2, args3);
    }

    public static Object hack36(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack36");
        return call.call(args1, args2, args3);
    }

    public static Object hack37(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack37");
        return call.call(args1, args2, args3);
    }

    public static Object hack38(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack38");
        return call.call(args1, args2, args3);
    }

    public static Object hack39(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack39");
        return call.call(args1, args2, args3);
    }

    public static Object hack310(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack310");
        return call.call(args1, args2, args3);
    }

    public static Object hack311(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack311");
        return call.call(args1, args2, args3);
    }


    public static Object hack312(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack312");
        return call.call(args1, args2, args3);
    }

    public static Object hack313(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack313");
        return call.call(args1, args2, args3);
    }

    public static Object hack314(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack314");
        return call.call(args1, args2, args3);
    }

    public static Object hack315(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack315");
        return call.call(args1, args2, args3);
    }

    public static Object hack316(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack316");
        return call.call(args1, args2, args3);
    }

    public static Object hack317(Object args1, Object args2, Object args3){
        Callback call = hackCallbacks.get("hack317");
        return call.call(args1, args2, args3);
    }

    public static Object hack40(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack40");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack41(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack41");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack42(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack42");
        return call.call(args1, args2, args3, args4);
    }


    public static Object hack43(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack43");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack44(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack44");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack45(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack45");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack46(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack46");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack47(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack47");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack48(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack48");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack49(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack49");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack410(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack410");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack411(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack411");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack412(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack412");
        return call.call(args1, args2, args3, args4);
    }


    public static Object hack413(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack413");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack414(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack414");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack415(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack415");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack416(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack416");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack417(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack417");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack418(Object args1, Object args2, Object args3, Object args4){
        Callback call = hackCallbacks.get("hack418");
        return call.call(args1, args2, args3, args4);
    }

    public static Object hack50(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack50");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack51(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack51");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack52(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack52");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack53(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack53");
        return call.call(args1, args2, args3, args4, args5);
    }


    public static Object hack54(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack54");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack55(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack55");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack56(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack56");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack57(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack57");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack58(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack58");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack59(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack59");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack510(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack510");
        return call.call(args1, args2, args3, args4, args5);
    }


    public static Object hack511(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack511");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack512(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack512");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack513(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack513");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack514(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack514");
        return call.call(args1, args2, args3, args4, args5);
    }


    public static Object hack515(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack515");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack516(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack516");
        return call.call(args1, args2, args3, args4, args5);
    }

    public static Object hack517(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack517");
        return call.call(args1, args2, args3, args4, args5);
    }


    public static Object hack518(Object args1, Object args2, Object args3, Object args4, Object args5){
        Callback call = hackCallbacks.get("hack518");
        return call.call(args1, args2, args3, args4, args5);
    }


    public static Object hack60(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6){
        Callback call = hackCallbacks.get("hack60");
        return call.call(args1, args2, args3, args4, args5, args6);
    }

    public static Object hack61(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6){
        Callback call = hackCallbacks.get("hack61");
        return call.call(args1, args2, args3, args4, args5, args6);
    }

    public static Object hack62(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6){
        Callback call = hackCallbacks.get("hack62");
        return call.call(args1, args2, args3, args4, args5, args6);
    }

    public static Object hack63(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6){
        Callback call = hackCallbacks.get("hack63");
        return call.call(args1, args2, args3, args4, args5, args6);
    }


    public static Object hack64(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6){
        Callback call = hackCallbacks.get("hack64");
        return call.call(args1, args2, args3, args4, args5, args6);
    }

    public static Object hack65(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6){
        Callback call = hackCallbacks.get("hack65");
        return call.call(args1, args2, args3, args4, args5, args6);
    }


    public static Object hack66(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6){
        Callback call = hackCallbacks.get("hack66");
        return call.call(args1, args2, args3, args4, args5, args6);
    }

    public static Object hack67(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6){
        Callback call = hackCallbacks.get("hack67");
        return call.call(args1, args2, args3, args4, args5, args6);
    }

    public static Object hack68(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6){
        Callback call = hackCallbacks.get("hack68");
        return call.call(args1, args2, args3, args4, args5, args6);
    }

    public static Object hack69(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6){
        Callback call = hackCallbacks.get("hack69");
        return call.call(args1, args2, args3, args4, args5, args6);
    }

    public static Object hack70(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6, Object args7){
        Callback call = hackCallbacks.get("hack70");
        return call.call(args1, args2, args3, args4, args5, args6, args7);
    }

    public static Object hack71(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6, Object args7){
        Callback call = hackCallbacks.get("hack71");
        return call.call(args1, args2, args3, args4, args5, args6, args7);
    }

    public static Object hack72(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6, Object args7){
        Callback call = hackCallbacks.get("hack72");
        return call.call(args1, args2, args3, args4, args5, args6, args7);
    }

    public static Object hack73(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6, Object args7){
        Callback call = hackCallbacks.get("hack73");
        return call.call(args1, args2, args3, args4, args5, args6, args7);
    }

    public static Object hack74(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6, Object args7){
        Callback call = hackCallbacks.get("hack74");
        return call.call(args1, args2, args3, args4, args5, args6, args7);
    }

    public static Object hack75(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6, Object args7){
        Callback call = hackCallbacks.get("hack75");
        return call.call(args1, args2, args3, args4, args5, args6, args7);
    }

    public static Object hack80(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6, Object args7, Object args8){
        Callback call = hackCallbacks.get("hack80");
        return call.call(args1, args2, args3, args4, args5, args6, args7, args8);
    }

    public static Object hack81(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6, Object args7, Object args8){
        Callback call = hackCallbacks.get("hack81");
        return call.call(args1, args2, args3, args4, args5, args6, args7, args8);
    }

    public static Object hack82(Object args1, Object args2, Object args3, Object args4, Object args5, Object args6, Object args7, Object args8){
        Callback call = hackCallbacks.get("hack82");
        return call.call(args1, args2, args3, args4, args5, args6, args7, args8);
    }
}
