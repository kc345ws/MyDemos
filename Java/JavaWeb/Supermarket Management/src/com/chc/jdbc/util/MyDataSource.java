package com.chc.jdbc.util;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/*
*
* 数据库连接池
*
* 问题
*
* 1.无法面向接口编程
* */
public class MyDataSource implements DataSource {

    List<Connection> list = new ArrayList<>();
    public MyDataSource(){

        for(int i = 0 ; i < 10 ; i++){
            list.add(JDBCUtil.getConn());
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        if(list.size() ==0){
            //池子里没有连接对象，再创建几个
            for(int i = 0 ; i < 5 ; i++){
                list.add(JDBCUtil.getConn());
            }
        }
        //移除并返回连接对象
        Connection connection = list.remove(0);
        return connection;
    }

    @Override
    //获取连接的方法

    public Connection getConnection(String username, String password) throws SQLException {
        return  null;
    }

    //归还连接对象
    public void addBack(Connection connection){
        list.add(connection);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
