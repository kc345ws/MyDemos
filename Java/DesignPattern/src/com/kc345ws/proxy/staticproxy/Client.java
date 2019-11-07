package com.kc345ws.proxy.staticproxy;

public class Client {
    public static void main(String[]args){

        //创建目标对象（被代理对象）
        final TeacherDao teacherDao = new TeacherDao();

        //创建代理对象,同时将被代理对象传递给传递对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        //通过代理对象，调用被代理对象的方法
        //执行的是代理对象的方法，代理对象执行被代理对象的方法
        teacherDaoProxy.teach();
    }
}
