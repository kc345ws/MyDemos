package com.kc345ws.domain;

import java.util.List;

public class PageBean {
    private List<Student> students;//数据
    private int currentPage;//当前页数
    private int totalPage;//总页数
    private int dataCount;//每页数据数量
    private int totalData;//总数据数

    public  PageBean(){}
    public PageBean(List<Student> students,int currentPage,int totalPage,int dataCount,int totalData){
        this.students = students;
        this.currentPage =currentPage;
        this.totalPage = totalPage;
        this.dataCount = dataCount;
        this.totalData = totalData;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }
}
