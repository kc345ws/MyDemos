# DBUtils

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
    
## 元数据(Meta Data)
> 描述数据的数据,String sql ,描述sql字符串的数据叫元数据

* 数据库元数据 DataBaseMetaData
* 参数元数据 ParameterMetaData
* 结果集元数据 ResultMetaData



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


        //数据集结果处理类
		public interface MyResultHandler<T> {
			T handle(ResultSet rs);
		}
    
    
    

