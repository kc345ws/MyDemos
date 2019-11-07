package com.kc345ws.proxy.dynamic;

public class Client {
    public static void main(String[]args){
        //创建一个目标对象
        ITeacherDao target = new TeacherDao();

        //给目标对象创建代理对象,可以转成ITeacherDao
        ITeacherDao proxyInstancenew = (ITeacherDao) new ProxyFactory(target).getProxyInstance();

        //内存中动态生成了代理对象
        //proxyInstnce = class com.sun.proxy.$Proxy0
        System.out.println("proxyInstnce = " + proxyInstancenew.getClass());

        //通过代理对象，调用目标对象方法
        proxyInstancenew.teach();
        final boolean returnval = proxyInstancenew.sayHello("倪司令");
        System.out.println(returnval);
    }
}
