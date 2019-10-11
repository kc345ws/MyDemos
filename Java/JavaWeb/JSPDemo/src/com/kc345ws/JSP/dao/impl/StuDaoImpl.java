package com.kc345ws.JSP.dao.impl;

import com.kc345ws.JSP.dao.StuDao;
import com.kc345ws.domain.Student;
import com.kc345ws.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StuDaoImpl implements StuDao {
    @Override
    public List<Student> FindAll(){

        Connection conn = null;


        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        LinkedList<Student> studentLinkedList = new LinkedList<>();
        try {
            conn = JDBCUtil.getConn();
            String sql = "select * from t_stu";
            preparedStatement = conn.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();


            while(resultSet.next()){
                Student student = new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("adress"));
                studentLinkedList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.Release(resultSet,preparedStatement,conn);
        }


        return studentLinkedList;
    }
}
