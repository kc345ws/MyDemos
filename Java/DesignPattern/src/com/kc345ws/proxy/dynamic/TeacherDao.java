package com.kc345ws.proxy.dynamic;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("授课中");
    }

    @Override
    public boolean sayHello(String name) {
        System.out.println("hello" + name);
        return true;
    }
}
