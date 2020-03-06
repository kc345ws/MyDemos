package com.kc345ws.JSP.dao;

import com.kc345ws.domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface StuDao {
    List<Student> FindAll() throws SQLException;
}
