package com.kc345ws.DBCP;

import com.kc345ws.jdbc.util.JDBCUtil;
import com.mysql.cj.protocol.Resultset;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCPDemo {

    @Test
    public void test(){
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://127.0.0.1/studnet?serverTimezone=UTC");

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = basicDataSource.getConnection();

            String sql = "select * from t_stu";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Release(rs,ps,connection);
        }
    }
}
