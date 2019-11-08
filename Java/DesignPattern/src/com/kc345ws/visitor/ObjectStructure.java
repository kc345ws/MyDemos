package com.kc345ws.visitor;

import java.util.LinkedList;
import java.util.List;


//数据结构类，用来存储评价结果
public class ObjectStructure {
    private List<Person> personList = new LinkedList<>();

    public void attach(Person p){
        personList.add(p);
    }

    public void detach(Person p){
        personList.remove(p);
    }

    public void display(Action action){
        for(Person p : personList){
            //接受访问者
            p.accept(action);
        }
    }
}
