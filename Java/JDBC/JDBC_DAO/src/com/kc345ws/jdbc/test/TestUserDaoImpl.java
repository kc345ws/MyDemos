package com.kc345ws.jdbc.test;

import com.kc345ws.jdbc.dao.UserDao;
import com.kc345ws.jdbc.impl.UserDaoImpl;
import org.junit.Test;

public class TestUserDaoImpl {
    @Test
    public void testLogin(){
        UserDao userDao = new UserDaoImpl();
        //userDao.login("zhangsan","111");
        //SQL注入
        userDao.login("zhangsan","1112' or '1=1");
    }
}
