package com.kc345ws.iterator;

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator {
    List<Department> departments;//信息工程学院
    int index = -1;

    public InfoCollegeIterator(List<Department>departments){
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        //先hasNext再next
        if(index >= departments.size() - 1){
            return false;
        }
        else {
            index++;
            return true;
        }
    }

    @Override
    public Object next() {
        return departments.get(index);
    }
}
