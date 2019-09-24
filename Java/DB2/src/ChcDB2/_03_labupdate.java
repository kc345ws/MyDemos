package ChcDB2;

/**********************************************************************/
/* labupdate.java                                                     */
/* Sample Java program for "DB2 UDB PROGRAMMING USING JAVA"           */
/*                          ( CG11 )                                  */
/*                                                                    */
/*                                                                    */
/* Last update = 01/01/2003                                           */
/*                                                                    */
/**********************************************************************/
/*  Notes:                                                            */
/*                                                                    */
/*  Update the salary of all the employees of a department.           */
/*                                                                    */
/*  This program is intended to be completed with the lab guide       */
/*  as a reference.  The lab guide is the set of instructions that    */
/*  should be followed.  The comments in this program are intended    */
/*  to clarify statements made in the lab guide.                      */
/**********************************************************************/

/*********************??????????????????*******************************/
/*  ( 1 ) Import Java Classes                                         */
/**********************************************************************/
//导入sql包
import  java.sql.*;
import java.io.*;
import java.util.*;
import java.math.*;



/**********************************************************************/
/* Class definition                                                   */
/**********************************************************************/
public class _03_labupdate
{
/**********************************************************************/
    /* Register the class with the db2 Driver                             */
    /**********************************************************************/
    static
    {   try
    {
        /*********************??????????????????????**************/
        /* ( 2 ) Load the DB2 Driver                             */
        /*********************************************************/
        //导入db2驱动
        Class.forName("com.ibm.db2.jcc.DB2Driver");
              //?????.??????? ("???.???.???.????.???.????????");
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
/***************************************** ****************************/
        /* Define variable declarations for the variable which will be used   */
        /* to pass data to and from the stored procedure:                     */
        /* A character string for passing the department in.                  */
        /* A double for returning the median salary.                          */
        /* An integer for returning the number of employees.                  */
/**********************************************************************/
        String name = "";
        java.lang.String deptno  = "";
        short id = 0;
        double salary = 0;
        String job = "";
        short NumEmp = 0;
        String sqlstmt = "UPDATE STAFF SET SALARY = SALARY * 1.05 WHERE DEPT = ?";
        String s = " ";
        int mydeptno = 0;
        int SQLCode = 0;
        String SQLState = "     ";
        BufferedReader in = new BufferedReader( new InputStreamReader (System.in));


        /*  Establish connection and set default context  */
        System.out.println("Connect statement follows:");

        /************************** ???????????????? ************************/
        /* ( 3 ) Code a statement that will connect to the database SAMPLE. */
        /*       Define the connection object named sample.                 */
        /*       Use the userid udba and the password udba                  */
        /********************************************************************/
        //连接数据库
        Connection sample = DriverManager.getConnection("jdbc:db2://127.0.0.1:50000/sample","administrator","qhw739t");
   //???????? sample = ?????????????.?????????????("????:???:??????","udba","udba");
        System.out.println("Connect completed");

        /************************** ???????????????? ************************/
        /* ( 4 ) Turn autocommit to off                                     */
        /*                                                                  */
        /********************************************************************/
        //关闭自动提交
        sample.setAutoCommit(false);
   //??????.?????????????(?????);


        /*   Print instruction lines                       */
        System.out.println("This program will update the salaries for a department");
        System.out.println("\n");
        System.out.println("Please enter a department number: \n ");

        /*  Get the department number from the input data */


        s = in.readLine();
        //deptno = s.substring(0,2);
        deptno = s;
        mydeptno = Integer.parseInt(deptno);


        /*  Issue Select statement  */
        System.out.println("Statement stmt follows");
        try
        {

            /************************ ?????????????????????? ***********************/
            /* ( 5 ) Create the PreparedStatment object name pstmt using the       */
            /* prepareStatement method                                             */
            /*                                                                     */
            /***********************************************************************/
            //创建PreparedStatment
            PreparedStatement pstmt = sample.prepareStatement(sqlstmt);
            // ????????????????? ????? = ??????.????????????????( sqlstmt );


            /********************** ????????????????? ******************************/
            /* (6) Set the parameter marker to be value of the department.         */
            /*     This value is placed in the field deptno                        */
            /*                                                                     */
            /***********************************************************************/
            //设置pstmt参数
            pstmt.setString(1,deptno);
     //?????.??????(?, ??????);

            /********************** ????????????????? ******************************/
            /* (7) Execute the SQL statement                                       */
            /*     The number of rows modified by the update statment should be    */
            /*     saved in the variable named updateCount                         */
            /***********************************************************************/
            //执行sql语句并获取结果
            int updateCount = pstmt.executeUpdate();
            //int ??????????? = ?????.?????????????();

            System.out.println("\nNumber of rows updated: " + updateCount);
        }  // end try
        catch ( SQLException x )
        {
            /********************** ??????????????????  ***************************/
            /* (8) An error has occurred.  Retrieve the SQLCode                   */
            /**********************************************************************/
            //若发生错误打印错误码喝错误状态
            SQLCode = x.getErrorCode();
            //SQLCode = x.????????????();
            SQLState = x.getSQLState();
            //SQLState = x.????????????();
            String Message = x.getMessage();
            //String Message = x.??????????();
            System.out.println("\nSQLCODE:  " + SQLCode );
            System.out.println("\nSQLSTATE: " + SQLState);
            System.out.println("\nSQLERRM:  " + Message);
        }

        System.exit(0);
    } // end main


}  // end of kegstaff class




