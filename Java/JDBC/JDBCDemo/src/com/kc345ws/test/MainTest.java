package com.kc345ws.test;
import com.kc345ws.util.JDBCUtil;
import com.mysql.jdbc.Driver;

import java.sql.*;

public class MainTest {
    public static void main(String[] args){
        Connection connection = null;
        Statement statement =null;
        ResultSet resultSet = null;
        try {
            /*
            //1.注册驱动

           // DriverManager.registerDriver(new Driver());
            Class.forName("com.mysql.jdbc.Driver");

            //2.建立连接 协议+要访问的数据库
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/studnet?serverTimezone=UTC", "root", "qhw739t");
            */
            connection = JDBCUtil.getConn();


            //3.创建statement 和数据库打交道一定要这个对象
            statement = connection.createStatement();

            //4.执行查询
            String sql = "select * from t_stu";
            resultSet = statement.executeQuery(sql);

            //5.遍历查询每一条记录
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println("id:"+id+" name:"+name+" age:"+age);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            //释放资源
            JDBCUtil.Release(resultSet,statement,connection);
        }
    }
}
