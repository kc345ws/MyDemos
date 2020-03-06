package com.kc345ws.commancurd;

import com.kc345ws.domain.Account;
import com.kc345ws.jdbc.util.JDBCUtil;
import org.junit.Test;

import java.sql.*;

//通用CRUD
public class CommanDBUtilCRUD {

    @Test
    public void test(){
        //Update("insert into t_stu (name,age) values(?,?)","埃索达群",42);
        //Update("delete from t_stu where id = ?",7);
        //Update("update t_stu set name=?,age = ? where id = ?","气味V型的",634,6);

        //Update("update t_stu set name=?,age = ? where id = ?","未确认发",634,6,2);
        //Update02("update t_stu set name=?,age = ? where id = ?","未确认发",634,6,2);

        Account account = Execute("select * from t_stu where id = ?",
                new MyResultHandler<Account>() {
                    @Override
                    public Account handle(ResultSet rs) {
                        //通过匿名实现类，实现处理类的方法对数据进行封装并返回给Execute方法
                        try {
                            if(rs.next()){
                                int id = rs.getInt("id");
                                String name = rs.getString("name");
                                int age = rs.getInt("age");
                                Account ac = new Account(id,name,age);
                                return  ac;
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return  null;
                    }
                }, 1);
        if(account !=null){
            System.out.println(account.toString());
        }
    }
    //通用增删改查
    /*
    * 以参数个数为准
    * */
    public void Update(String sql , Object ... args){
        Connection conn = JDBCUtil.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement(sql);
            for(int i = 0 ; i < args.length ;i++){
                preparedStatement.setObject(i+1,args[i]);
            }

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //以?个数为准
    public void Update02(String sql , Object ... args){
        Connection conn = JDBCUtil.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement(sql);

            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            int parameterCount = parameterMetaData.getParameterCount();//获取参数个数

            for(int i = 0 ; i < parameterCount ;i++){
                preparedStatement.setObject(i+1,args[i]);
            }

            preparedStatement.executeUpdate();



        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //通用查询
    public <T>T Execute(String sql,MyResultHandler<T> myResultHandler,Object ...args){
        Connection conn = JDBCUtil.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement(sql);

            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            int parameterCount = parameterMetaData.getParameterCount();//获取参数个数

            for(int i = 0 ; i < parameterCount ;i++){
                preparedStatement.setObject(i+1,args[i]);
            }

            //获取结果存入结果集
            resultSet = preparedStatement.executeQuery();

            //需要进行数据封装并返回给用户
            T t = (T)myResultHandler.handle(resultSet);
            //先通过数据集处理类封装数据，然后再通过Execute方法返回查询到的数据集

            return t;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
