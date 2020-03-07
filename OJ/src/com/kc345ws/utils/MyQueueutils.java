package com.kc345ws.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//队列工具
public class MyQueueutils {
    public static void DebugQueue(String[] operates , Object operatenum[] ,QueueReflectBase target){
        try {
            Class clazz = target.getClass();
            for(int i = 0 ; i < operates.length ; i++){
                 if(operates[i].equals("push_back")) {
                     Method method = clazz.getDeclaredMethod("push_back",int.class);
                     method.invoke(target,Integer.parseInt(operatenum[i].toString()));
                 }
                 else if(operates[i].equals("pop_front")){
                     Method method = clazz.getDeclaredMethod("pop_front");
                     method.invoke(target);
                }else if(operates[i].equals("max_value")){
                     Method method = clazz.getDeclaredMethod("max_value");
                     method.invoke(target);
                 }
            }

            }
             catch (Exception e) {
            e.printStackTrace();
        }
    }
}
