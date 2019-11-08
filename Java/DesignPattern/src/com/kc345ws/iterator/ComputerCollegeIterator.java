package com.kc345ws.iterator;

import java.util.Iterator;

public class ComputerCollegeIterator implements Iterator {
    //这里需要需要知道department是怎样存放的
    Department[] departments;
    int position = 0;//遍历的位置
    public ComputerCollegeIterator(Department[] departments){
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if(position >= departments.length || departments[position] == null){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        Department department = departments[position];
        position++;
        return department;
    }

    public void remove(){}
}
