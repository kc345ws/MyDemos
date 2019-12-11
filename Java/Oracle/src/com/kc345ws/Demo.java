package com.kc345ws;


import java.sql.*;

public class Demo {
    public static void main(String[]args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";// Oracle地址
        String user = "scott";// 数据库用户名
        String password = "123456";// 数据库密码
        final Connection connection = DriverManager.getConnection(url, user, password);
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("select * from dept");

        //查看当前登录的用户的表:
        //select table_name from user_tables;
        while(resultSet.next()){
            String first = resultSet.getString(1);
            String second = resultSet.getString(2);
            String third = resultSet.getString(3);
            System.out.println(first +" "+second+" "+third);
        }
    }
}
