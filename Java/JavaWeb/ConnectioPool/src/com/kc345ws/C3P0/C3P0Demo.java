package com.kc345ws.C3P0;

import com.kc345ws.jdbc.util.JDBCUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.xml.transform.Result;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//不使用配置文件
public class C3P0Demo {

    @Test
    public void test(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            comboPooledDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1/studnet?serverTimezone=UTC");
            comboPooledDataSource.setUser("root");
            comboPooledDataSource.setPassword("qhw739t");

            connection = comboPooledDataSource.getConnection();

            String sql = "select * from t_stu";
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();



        } catch (Exception e) {
            e.printStackTrace();
        }   finally {
            JDBCUtil.Release(resultSet,ps,connection);
        }
    }
}
