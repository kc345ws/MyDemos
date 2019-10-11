package com.kc345ws.JSP.dao.impl;

import com.kc345ws.JSP.dao.UserDao;
import com.kc345ws.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean Login(String username ,String password) {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConn();

            String sql = "select * from t_user where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);

            resultSet = ps.executeQuery();

            return  resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.Release(resultSet,ps,conn);
        }
        return false;
    }
}
