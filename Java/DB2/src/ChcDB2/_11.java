package ChcDB2;

import java.sql.*;

public class _11 {
    static String resume = null;
    static String empnum = "000130";
    static int startper , startper1 , startdpt = 0;
    static PreparedStatement stmt1 , stmt2 , stmt3 = null;
    static  String sql1 , sql2 , sql3 = null;
    static String empno , resumefmt = null;
    static Clob resumelob = null;
    static ResultSet rs1 , rs2 , rs3 = null;

    public static void main(String[] args) throws SQLException {
        try {
            //导入DB2驱动
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //连接数据库
        Connection connection = DriverManager.getConnection("jdbc:db2://127.0.0.1:50000/sample","administrator","qhw739t");


        sql1 = "select posstr(resume,'Personal') from emp_resume where empno = ? and resume_format = 'ascii'";

        stmt1 = connection.prepareStatement(sql1);
        stmt1.setString(1,empnum);

        final ResultSet rs1 = stmt1.executeQuery();
        while(rs1.next()){
            startper = rs1.getInt(1);
        }

        sql2 = "select posstr(resume,'Department') from emp_resume " +
                "where empno = ? and resume_format = 'ascii'";

        stmt2 = connection.prepareStatement(sql2);
        stmt2.setString(1,empnum);
        final ResultSet rs2 = stmt2.executeQuery();
        while(rs2.next()){
            startdpt = rs2.getInt(1);
        }

        startper1 = startper - 1;
        sql3 = "select empno,resume_format,substr(resume,1,?) " +
                "||substr(resume,?) as resume from emp_resume " +
                "where empno = ? and resume_format = 'ascii'";

        stmt3 = connection.prepareStatement(sql3);
        stmt3.setInt(1,startper1);
        stmt3.setInt(2,startdpt);
        stmt3.setString(3,empnum);

        rs3 = stmt3.executeQuery();
        String resumeout = "";
        while(rs3.next()){
            empno = rs3.getString(1);
            resumefmt = rs3.getString(2);
            resumelob = rs3.getClob(3);

            final long length = resumelob.length();
            int lent1 = (int)length;
            resumeout = resumelob.getSubString(1,lent1);
        }

        System.out.println(resumeout);
    }

}
