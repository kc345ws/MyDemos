package com.kc345ws.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object object){
        target = object;
    }


    //给目标对象，生成一个代理对象
    public Object getProxyInstance(){

        /*
        * public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h) {
        * */
        //1.ClassLoader loader:指定当前目标对象使用的类加载器,互获取加载器的方法固定
        //2.Class<?>[] interfaces：目标对象实现的接口类型，使用泛型方法确认类型
        //3.InvocationHandler h (委托)事件处理，执行目标的对象的方法时，会触发事件处理器的方法，会把当前执行的目标对象方法作为参数传入

        //返回一个Proxy代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK代理开始");

                        //通过反射机制调用目标对象的方法
                        Object returnval =null;
                        if(method.getName() == "teach"){
                            returnval = method.invoke(target);
                        }else if(method.getName() == "sayHello"){
                            returnval = method.invoke(target,args[0].toString());
                        }

                        System.out.println("JDK代理结束");
                        return returnval;
                    }
                });
        /*
        * 根据注解描述可知，InvocationHandler作用就是，
        * 当代理对象的原本方法被调用的时候，会绑定执行一个方法，
        * 这个方法就是InvocationHandler里面定义的内容，同时会替代原本方法的结果返回。
            InvocationHandler接收三个参数
            proxy，代理后的实例对象。
            method，对象被调用方法。
            args，调用时的参数。
        * */
    }
}
