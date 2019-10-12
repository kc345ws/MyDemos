package com.kc345ws.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//释放资源
public class JDBCUtil {
    static String driverClass = null;
    static String url = null;
    static String user = null;
    static String password = null;

    static {

        try {
            Properties properties = new Properties();

            //读取根目录下的资源文件
            //InputStream is = new FileInputStream("jdbc.properties");
            //使用类加载器，读取src下的资源文件
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");

            //导入输入流
            properties.load(is);

            //读取属性
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        //1.注册驱动
        // DriverManager.registerDriver(new Driver());
        Connection connection = null;
        try {
            //Class.forName(driverClass);//可以不用注册驱动
            //多个不同数据库时要写
            //2.建立连接 协议+要访问的数据库
            connection = DriverManager.getConnection(url ,user , password);//自动注册
        } catch (Exception e) {
            e.printStackTrace();
        }


        return  connection;
    }


    public static void Release(ResultSet rs , Statement st , Connection conn){
        closeRS(rs);
        closeST(st);
        closeConn(conn);
    }



    private static void closeRS(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                rs = null;
            }
        }
    }

    private static void closeST(Statement st){
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                st = null;
            }
        }
    }

    private static void closeConn(Connection Conn){
        if(Conn!=null){
            try {
                Conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                Conn = null;
            }
        }
    }
}
