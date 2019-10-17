package com.kc345ws.service.impl;



import com.kc345ws.dao.StudentDao;
import com.kc345ws.dao.impl.StudentDaoImpl;
import com.kc345ws.domain.PageBean;
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

    @Override
    public boolean update(Student student) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return  studentDao.update(student);
    }

    @Override
    public List<Student> search(String name, String sex) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return  studentDao.search(name,sex);
    }

    @Override
    public PageBean getByPage(int currentPage) throws SQLException {
        //DAO只包含单一逻辑，service可以包含多个单一逻辑
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.getByPage(currentPage);
        int totalCount = studentDao.getCount();
        PageBean pageBean = new PageBean(students,currentPage,
                (totalCount % studentDao.PAGE_SIZE)==0?(totalCount / studentDao.PAGE_SIZE):(totalCount / studentDao.PAGE_SIZE)+1,
                students.size(),totalCount);

        return  pageBean;
    }
}
