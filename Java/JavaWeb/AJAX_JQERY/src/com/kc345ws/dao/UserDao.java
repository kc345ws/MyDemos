package com.kc345ws.dao;

import java.sql.SQLException;

public interface UserDao {
    boolean checkUserExist(String user)throws SQLException;
}
