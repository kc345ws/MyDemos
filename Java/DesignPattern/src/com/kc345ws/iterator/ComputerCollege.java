package com.kc345ws.iterator;

import java.util.Iterator;

public class ComputerCollege implements College {
    Department[] departments;
    int numOfDepartment = 0;//数组对象个数


    public ComputerCollege(){
        departments = new Department[3];
        addDepartment("Java","Java");
        addDepartment("Java","Java");
        addDepartment("Java","Java");
    }
    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name,desc);
        departments[numOfDepartment] =department;
        numOfDepartment++;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
