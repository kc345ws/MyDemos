package com.kc345ws.dbutils;

import com.kc345ws.domain.Account;
import com.kc345ws.jdbc.util.JDBCUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBUtilsDemo {

    @Test
    public void test() throws SQLException, IllegalAccessException, InstantiationException {


        //DBTUIL 只是简化CURD ，创建以及获取工作不在范畴
        QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());

        //增加 删除 修改
        //queryRunner.update("insert into t_stu (name,age) values(?,?)","发顺丰",23);

        //查询数据，查询到的数据在ResultSet里，需要用户手动封装数据
//        Account account = queryRunner.query("select * from t_stu where id = ?",
//                new ResultSetHandler<Account>() {
//                    @Override
//                    public Account handle(ResultSet resultSet) throws SQLException {
//                        Account account = null;
//                        while (resultSet.next()) {
//                            int id = resultSet.getInt("id");
//                            String name = resultSet.getString("name");
//                            int age = resultSet.getInt("age");
//                            account = new Account();
//                            account.setId(id);
//                            account.setName(name);
//                            account.setAge(age);
//                        }
//                        return account;
//                    }
//                }, 1);
//        System.out.println(account.getName());

        //通过具体实现类
        //单个对象
        Account account = queryRunner.query("select * from t_stu where id = ?", new BeanHandler<>(Account.class), 1);
        System.out.println(account.getName());

        //通过反射创建一个对象
        //Account a = Account.class.newInstance();

        //多个对象
        List<Account> accountList = queryRunner.query("select * from t_stu", new BeanListHandler<>(Account.class));

        for (var item : accountList){
            System.out.println(item.getName());
        }
    }
}
