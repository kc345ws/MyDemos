package com.kc345ws.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class InfoCollege implements College {
    List<Department> list;

    public InfoCollege(){
        list = new LinkedList<>();
        addDepartment("电子工程","电子工程");
        addDepartment("电子工程","电子工程");
        addDepartment("电子工程","电子工程");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name ,desc);
        list.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(list);
    }
}
