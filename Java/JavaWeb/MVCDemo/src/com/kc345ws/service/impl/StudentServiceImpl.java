package com.kc345ws.service.impl;



import com.kc345ws.dao.StudentDao;
import com.kc345ws.dao.impl.StudentDaoImpl;
import com.kc345ws.domain.Student;
import com.kc345ws.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {




    @Override
    public List<Student> getall() throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.getAll();
    }

    @Override
    public boolean insert(Student student) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.insert(student);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.delete(id);
    }

    @Override
    public Student findByID(int id) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.findByID(id);
    }
}
