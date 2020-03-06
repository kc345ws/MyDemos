package com.kc345ws.dao.impl;

import com.kc345ws.dao.UserDao;
import com.kc345ws.jdbc.util.JDBCUtil02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean checkUserExist(String user)throws SQLException {


        QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getComboPooledDataSource());

        final Long query = (Long) queryRunner.query("select count(*) from t_user where username = ?", new ScalarHandler(),user);

        return query > 0;
    }
}
