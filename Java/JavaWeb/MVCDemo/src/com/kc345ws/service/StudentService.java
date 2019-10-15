package com.kc345ws.service;

import com.kc345ws.domain.Student;

import java.sql.SQLException;
import java.util.List;

//DAO对应单一逻辑，Service可以包含多个单一逻辑
public interface StudentService {
    List<Student> getall() throws SQLException;

    boolean insert(Student student)throws SQLException;

    boolean delete(int id) throws  SQLException;

    Student findByID(int id)throws SQLException;
}
