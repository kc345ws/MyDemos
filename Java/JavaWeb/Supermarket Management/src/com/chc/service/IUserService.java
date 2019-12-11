package com.chc.service;

import com.chc.domain.User;

import java.sql.SQLException;

public interface IUserService {
    boolean check(int id, String pwd,int identity) throws SQLException;
}
