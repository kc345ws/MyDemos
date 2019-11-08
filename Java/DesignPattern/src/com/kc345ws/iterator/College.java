package com.kc345ws.iterator;

import java.util.Iterator;

public interface College {
    String getName();

    //增加系
    void addDepartment(String name ,String desc);

    //返回一个迭代器
    Iterator createIterator();
}
