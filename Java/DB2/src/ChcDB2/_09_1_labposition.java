package ChcDB2;
/**********************************************************************/
/* labposition.java                                                   */
/* Sample Java program for "DB2 UDB PROGRAMMING USING JAVA"           */
/*                          ( CG11 )                                  */
/*                                                                    */
/* Learn how to establish in position in a ResultSet                  */
/*                                                                    */
/*                                                                    */
/* Last update = 01/31/2000                                           */
/*                                                                    */
/**********************************************************************/
/*  Notes:                                                            */
/*                                                                    */
/*  This program is intended to be completed with the lab guide       */
/*  as a reference.  The lab guide is the set of instructions that    */
/*  should be followed.  The comments in this program are intended    */
/*  to clarify statements made in the lab guide.                      */
/**********************************************************************/

/**********************************************************************/
/* Import Java Classes                                                */
/**********************************************************************/
import java.sql.*;
        import sqlj.runtime.*;
        import sqlj.runtime.ref.*;
        import java.io.*;
        import java.util.*;
        import java.math.*;



/**********************************************************************/
/* Class definition                                                   */
/**********************************************************************/
public class _09_1_labposition
{
/**********************************************************************/
    /* Register the class with the db2 Driver                             */
    /**********************************************************************/
    static
    {   try
    {   Class.forName ("com.ibm.db2.jcc.DB2Driver");
    }
    catch (Exception e)
    {   System.out.println ("\n  Error loading DB2 Driver...\n");
        System.out.println (e);
        System.exit(1);
    }
    }

/**********************************************************************/
    /* Main routine                                                       */
    /**********************************************************************/
    public static void main( String args[]) throws Exception
    {
/**********************************************************************/
        /* Define variable declarations for the variable which will be used   */
        /* to pass data to and from the stored procedure:                     */
        /* A character string for passing the department in.                  */
        /* A double for returning the median salary.                          */
        /* An integer for returning the number of employees.                  */
/**********************************************************************/
        String name = "";
        java.lang.String deptno  = "";
        short id = 0;
        String  salary = "";
        String job = "";
        short NumEmp = 0;
        BufferedReader in = new BufferedReader( new InputStreamReader (System.in));
        String s;
/***********************************************************************/
        /* Header line                                                         */
/***********************************************************************/
        String  intext =
                "\n NAME     JOB       SALARY\n";
        String  indash =
                "--------  --------  --------------\n";
        String blanks = "                                                        ";
        String outline = "";


        /*  Establish connection and set default context  */
        System.out.println("Connect statement follows:");
        /********************* ???????????????? ************************/
        /* ( 1 )  Code the connect statement to the database SAMPLE    */
        /*        use the Connection object named sample.              */
        /***************************************************************/
   //?????????? ?????? = ?????????????.?????????????("????:???:??????","udba","udba");
        Connection sample = DriverManager.getConnection("jdbc:db2://127.0.0.1:50000/sample","administrator","qhw739t");

        System.out.println("Connect completed");
        sample.setAutoCommit(false);


        /*  Issue Select statement  */
        System.out.println("Statement stmt follows");
        try
        {


            /************************** ???????????????????? ***********************/
            /* ( 2 ) Define the ResultSet object named rs.                         */
            /*       Initialize the rs object to null.                             */
            /***********************************************************************/

     //????????? ?? = null;
            ResultSet rs = null;

            /************************** ???????????????????? ***********************/
            /* ( 3 ) Define the variable sql which contain the select statement    */
            /*       SELECT NAME, JOB, SALARY FROM STAFF                           */
            /***********************************************************************/

//     ?????? ??? = "select NAME, JOB, SALARY from staff ";
            String sql = "select NAME, JOB, SALARY from staff ";

            /************************** ???????????????????? ***********************/
            /* ( 4 ) Instantiate the PreparedStatement object stmt.                */
            /*       Make the cursor allow for scrollable backward and forward     */
            /***********************************************************************/

//     ????????????? ???? = ??????.????????????????(sql,
//                       ??.????_??????_???????????, ??.??????_????_????);
            PreparedStatement stmt = sample.prepareStatement(sql,
                    rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            //光标可以前后移动且只读


            System.out.println( intext );
            System.out.println( indash );

            rs = stmt.executeQuery( );

            /************************** ???????????????????? ***********************/
            /* ( 5 ) Scrollforward through the result set.                         */
            /*                                                                     */
            /***********************************************************************/

//     ??.????();
            //第一行数据
            rs.next();

            name = rs.getString(1);
            job = rs.getString(2);
            salary = rs.getString(3);
            outline = (name + blanks.substring(0, 10 - name.length())) +
                    (job + blanks.substring(0, 10 - job.length()))   +
                    (salary + blanks.substring(0, 12 - salary.length()));
            System.out.println("\n" + outline);

            /************************** ???????????????????? ***********************/
            /* ( 6 ) Retrieve the last row of the result set                       */
            /*                                                                     */
            /***********************************************************************/

//     ??.????();
            rs.next();
            //第二行数据

            name = rs.getString(1);
            job = rs.getString(2);
            salary = rs.getString(3);
            outline = (name + blanks.substring(0, 10 - name.length())) +
                    (job + blanks.substring(0, 10 - job.length()))   +
                    (salary + blanks.substring(0, 12 - salary.length()));
            System.out.println("\n" + outline);
            /************************** ???????????????????? ***********************/
            /* ( 7 ) Scroll backward through the result set.                        */
            /*                                                                     */
            /***********************************************************************/

            rs.previous();

            name = rs.getString(1);
            job = rs.getString(2);
            salary = rs.getString(3);
            outline = (name + blanks.substring(0, 10 - name.length())) +
                    (job + blanks.substring(0, 10 - job.length()))   +
                    (salary + blanks.substring(0, 12 - salary.length()));
            System.out.println("\n" + outline);
            /************************** ???????????????????? ***********************/
            /* ( 8 ) Retrieve the first row of the result set.                     */
            /*                                                                     */
            /***********************************************************************/

     //??.?????();
            rs.first();//第一行数据

            name = rs.getString(1);
            job = rs.getString(2);
            salary = rs.getString(3);
            outline = (name + blanks.substring(0, 10 - name.length())) +
                    (job + blanks.substring(0, 10 - job.length()))   +
                    (salary + blanks.substring(0, 12 - salary.length()));
            System.out.println("\n" + outline);
        }  // end try
        catch ( SQLException x )
        {
            System.out.println("Error on call " + x.getErrorCode()
                    + " and sqlstate of " + x.getSQLState()  + " message " + x.getMessage() );
        }

        System.exit(0);
    } // end main


}  // end of kegstaff class




