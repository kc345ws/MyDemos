package com.kc345ws.iterator;

import java.util.Iterator;
import java.util.List;

public class Outputimpl {
    //学院集合
    List<College> collegeList;

    public Outputimpl(List<College> collegeList){
        this.collegeList = collegeList;
    }
    //遍历所有学院
    public void printCollege(){
        //从Collegelist取出学院
        final Iterator<College> iterator = collegeList.iterator();
        while(iterator.hasNext()){
            College college = iterator.next();
            System.out.println(college.getName());
            System.out.println("-------------------------");
            //获取系的迭代器
            final Iterator iterator1 = college.createIterator();
            printDepartment(iterator1);
        }
    }

    //输出 学院 输出系
    public void printDepartment(Iterator iterator) {
        while(iterator.hasNext()){
            Department department = (Department) iterator.next();
            System.out.println(department.getName());
        }
    }
}
