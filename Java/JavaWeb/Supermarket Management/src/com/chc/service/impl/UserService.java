package com.chc.service.impl;

import com.chc.dao.IUserDao;
import com.chc.dao.impl.ManagerDaoImpl;
import com.chc.dao.impl.SalerDaoImpl;
import com.chc.domain.User;
import com.chc.service.IUserService;

import java.sql.SQLException;

public class UserService implements IUserService {
    @Override
    public boolean check(int id, String pwd, int identity) throws SQLException {
        if(identity == 0){//售货员
            IUserDao dao = new SalerDaoImpl();
            return dao.check(id,pwd);
        }else{//管理者
            IUserDao dao = new ManagerDaoImpl();
            return dao.check(id,pwd);
        }
    }
}
