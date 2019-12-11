package com.chc.dao.impl;

import com.chc.dao.ISalerDao;
import com.chc.domain.User;
import com.chc.jdbc.util.JDBCUtil02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class SalerDaoImpl implements ISalerDao {
    @Override
    public boolean check(int id, String pwd) throws SQLException {
        Connection con = JDBCUtil02.getConn();
        QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getComboPooledDataSource());

        String sql = "select * from gsaler where mid = ? and mpassword = ?";

        User user = queryRunner.query(sql, new BeanHandler<User>(User.class), id, pwd);
        if(user==null){
            return false;
        }else{
            return true;
        }
    }
}
