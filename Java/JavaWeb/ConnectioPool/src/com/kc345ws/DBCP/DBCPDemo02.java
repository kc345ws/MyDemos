package com.kc345ws.DBCP;

import com.kc345ws.jdbc.util.JDBCUtil;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBCPDemo02 {

    @Test
    public void test(){
       // BasicDataSource basicDataSource = new BasicDataSource();

        BasicDataSourceFactory basicDataSourceFactory = new BasicDataSourceFactory();
        Properties properties = new Properties();

        DataSource dataSource = null;

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            InputStream inputStream = new FileInputStream("src/dbcpconfig.properties");
            properties.load(inputStream);
            dataSource = basicDataSourceFactory.createDataSource(properties);

            connection = dataSource.getConnection();

            String sql = "select * from t_stu";
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.Release(rs,ps,connection);
        }

    }
}
