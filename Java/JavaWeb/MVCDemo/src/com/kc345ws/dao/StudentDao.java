package com.kc345ws.dao;

import com.kc345ws.domain.Student;

import java.sql.SQLException;
import java.util.List;

/*
*
* 针对数据库的操作
*/
public interface StudentDao {

    ///获取表中所有数据
    List<Student> getAll() throws SQLException;

    boolean insert(Student student) throws SQLException;

    boolean delete(int id) throws SQLException;

    Student findByID(int id)throws SQLException;
}
