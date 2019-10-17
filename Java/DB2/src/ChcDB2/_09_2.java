package ChcDB2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _09_2 {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.ibm.db2.jcc.DB2Driver");

        Connection sample = DriverManager.getConnection("jdbc:db2://127.0.0.1:50000/sample","administrator","qhw739t");

        sample.setAutoCommit(false);

        Statement stmt = sample.createStatement();

        stmt.addBatch("insert into DEPARTMENT VALUES('BT6','BRANCH OFFICE J2','000100','E01','NEWYORK CITY5')");
        stmt.addBatch("insert into DEPARTMENT VALUES('BT7','BRANCH OFFICE J2','000100','E01','NEWYORK CITY7')");
        stmt.addBatch("insert into DEPARTMENT VALUES('BT8','BRANCH OFFICE J2','000100','E01','NEWYORK CITY8')");
        stmt.addBatch("insert into DEPARTMENT VALUES('BT9','BRANCH OFFICE J2','000100','E01','NEWYORK CITY9')");
        stmt.addBatch("insert into DEPARTMENT VALUES('BT1','BRANCH OFFICE J2','000100','E01','NEWYORK CITY10')");

        //BRANCE OFFICE J2
        int[] executeCount = stmt.executeBatch();
//        stmt.executeUpdate("insert into DEPARTMENT VALUES('BT6','BATCH6 NEWYORK','BBBBB1','BTT','NEWYORK CITY6')");
        //stmt.execute("insert into DEPARTMENT VALUES('J21','BRANCH OFFICE J2','000100','E01','NEWYORK CITY6')");

        sample.commit();
        sample.close();
    }
}
