package com.kc345ws.dao.impl;

import com.kc345ws.dao.StudentDao;
import com.kc345ws.domain.Student;
import com.kc345ws.jdbc.util.JDBCUtil02;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> getAll() throws SQLException {
        //不抓取异常而是向上抛出异常
        Connection conn = JDBCUtil02.getConn();

        QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getComboPooledDataSource());

        String sql = "select * from t_stu";
        List<Student> studentList = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));


        return studentList;
    }

    @Override
    public boolean insert(Student student) throws SQLException {
        Connection conn = JDBCUtil02.getConn();

        QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getComboPooledDataSource());

        int update = queryRunner.update("insert into t_stu values(null,?,?,?,?,?,? )"
                , student.getName()
                , student.getSex()
                , student.getTelnum()
                , student.getBirthday()
                , student.getHoby()
                , student.getInfo());

        if (update != -1){
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {

        Connection connection = JDBCUtil02.getConn();
        QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getComboPooledDataSource());

        int update = queryRunner.update("delete from t_stu where id = ?", id);

        if(update != -1){
            return  true;
        }

        return false;
    }

    @Override
    public Student findByID(int id) throws SQLException {
        Connection connection = JDBCUtil02.getConn();

        QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getComboPooledDataSource());


        Student student = queryRunner.query("select * from t_stu where id = ?", new BeanHandler<Student>(Student.class), id);
        return  student;
    }
}
