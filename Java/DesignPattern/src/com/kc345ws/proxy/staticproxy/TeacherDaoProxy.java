package com.kc345ws.proxy.staticproxy;

//代理对象，静态代理
public class TeacherDaoProxy implements ITeacherDao {
    private ITeacherDao target;//聚合一个目标对象，被代理对象


    public TeacherDaoProxy(ITeacherDao target){
        this.target = target;
    }
    @Override
    public void teach() {
        //代理可以增加一些额外的方法
        //目的：增加一些额外的方法
        //共同方法写在被被代理对象里
        System.out.println("代理开始,完成某些操作");
        target.teach();
        System.out.println("代理结束");
    }
}
