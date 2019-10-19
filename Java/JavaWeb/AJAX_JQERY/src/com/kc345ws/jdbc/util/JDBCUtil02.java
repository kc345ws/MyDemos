package com.kc345ws.jdbc.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class JDBCUtil02 {

    static ComboPooledDataSource comboPooledDataSource = null;
    static {
        //自动使用类加载器加载c3p0-config.xml
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    }

    public static ComboPooledDataSource getComboPooledDataSource(){
        if(comboPooledDataSource == null){
            comboPooledDataSource = new ComboPooledDataSource();
        }
        return  comboPooledDataSource;
    }

    public static Connection getConn(){
        Connection connection = null;
        try {
            if(comboPooledDataSource == null){
                comboPooledDataSource = new ComboPooledDataSource();
            }

            connection =  comboPooledDataSource.getConnection();
        } catch (SQLException e) {
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
