package ChcDB2;
import java.sql.*;
import java.io.*;
import java.lang.*;

public class _01_MyJDBC {
    public static void main(String []args) throws Exception {
        //MyJDBC myJDBC = new MyJDBC();
        Class.forName("com.ibm.db2.jcc.DB2Driver");
        Connection con = null;
        String url = "jdbc:db2://127.0.0.1:50000/sample";
        String user="administrator";
        String password="qhw739t";
        con = DriverManager.getConnection(url,user,password);
        System.out.println("连接数据库成功");
    }
}
