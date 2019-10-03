package com.kc345ws.jdbc.test;

import com.kc345ws.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
* 使用junit进行单元测试
* */
public class TestDemo {

    @org.junit.Test
    public void testQuery1(){
        try {
            Connection connection = JDBCUtil.getConn();
            Statement statement = connection.createStatement();

            String sql = "select * from t_stu";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                final int id = resultSet.getInt("id");
                final String name = resultSet.getString("name");
                final int age = resultSet.getInt("age");

                System.out.println("id:"+id + " name:"+name+" age:"+age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void testQuery(){
        try {
            Connection connection = JDBCUtil.getConn();
            Statement statement = connection.createStatement();

            String sql = "select * from t_stu";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                final int id = resultSet.getInt("id");
                final String name = resultSet.getString("name");
                final int age = resultSet.getInt("age");

                System.out.println("id:"+id + " name:"+name+" age:"+age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
