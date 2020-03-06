package com.kc345ws.jdbc.impl;

import com.kc345ws.jdbc.dao.UserDao;
import com.kc345ws.jdbc.util.JDBCUtil;
import org.junit.Test;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    @Test
    public void findAll() {


        try {
            Connection connection = JDBCUtil.getConn();
            Statement statement = connection.createStatement();
            String sql = "select * from t_user";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                final String username = resultSet.getString("username");
                final String pwd = resultSet.getString("password");
                System.out.println("username:"+username+" password:"+pwd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @Override
    @Test
    public void login(String user, String pwd) {
        try {
            Connection connection = JDBCUtil.getConn();

            String sql = "select * from t_user where username = ? and password = ?";
            //先对sql语句进行预处理
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pwd);
            final ResultSet resultSet = preparedStatement.executeQuery();

            /*Statement statement = connection.createStatement();
            String sql2 = "select * from t_user where username = '"+user+"'and password = '"+pwd+"';";
            ResultSet resultSet = statement.executeQuery(sql2);*/

            if(resultSet.next()){
                System.out.println("登陆成功");
            }else{
                System.out.println("登陆失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
