package com.kc345ws.jdbc;

import com.kc345ws.jdbc.util.JDBCUtil;
import com.kc345ws.jdbc.util.MyDataSource;
import com.kc345ws.jdbc.util.MyDataSource02;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPool {

    @org.junit.Test
    public void test(){
        DataSource myDataSource = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            myDataSource = new MyDataSource02();
            connection = myDataSource.getConnection();

            String sql = "select * from t_stu";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            try {
//                rs.close();
//                ps.close();
//                myDataSource.addBack(connection);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            JDBCUtil.Release(rs,ps,connection);
        }
    }
}
