package ChcDB2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class _07_GUI_SQLCA {
    private static int SumCount ;//总的元素数量
    private static int ElementCount;//未提交前的元素数量
    public static void main(String[] args) throws SQLException {
        ChcGUI MyGUI = new ChcGUI();
        JPanel rootpanel = MyGUI.getRootPanel();

        JFrame frame = new JFrame("07_GUI_SQLCA--5170933陈鸿超");
        frame.setContentPane(rootpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //System.out.println(rootpanel.getComponents().length);
        //Component[] components = rootpanel.getComponents();
        JTable ElementTable = MyGUI.getElementTable();
        //ElementTable.isCellEditable(0,0);
        DefaultTableModel tableModel = (DefaultTableModel)ElementTable.getModel();

        Object[][] elements = MyDB2_07.Instance.getElements();
        //向表格添加数据
        for(var item: elements){
            tableModel.addRow(item);
        }
        //tableModel.addRow(new Object[]{0002 , "Chen" , "L","HongChao"});
        //tableModel.addRow(new Object[]{});

        //元素数量
        ElementCount = elements.length;
        SumCount = ElementCount;
        //System.out.println(ElementCount);
        //获取添加行按钮
        JButton addLineBTN = MyGUI.getInsertBTN();
        addLineBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.addRow(new Object[]{});
                MyDB2_07.Instance.newEmployee.add(new Employee());//添加空的雇员信息
                SumCount++;
            }
        });

        //获取提交按钮
        JButton commitBTN = MyGUI.getCommitBTN();
        commitBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //存入修改后的旧的雇员信息
                MyDB2_07.Instance.oldEmployee.clear();
                for(int i = 0 ; i < ElementCount;i++){
                    String nostr;
                    int no;
                    String fn = "";
                    String mid ="";
                    String ln ="";

                    if(tableModel.getValueAt(i, 0) != null){
                        nostr = tableModel.getValueAt(i, 0).toString();
                        no = Integer.parseInt(nostr);
                    }else{
                        JOptionPane.showMessageDialog(null, "雇员编号不合法", "错误提示", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if(tableModel.getValueAt(i,1) !=null){
                        fn = tableModel.getValueAt(i,1).toString();
                    }

                    if(tableModel.getValueAt(i,2) != null){
                        mid = tableModel.getValueAt(i,2).toString();
                    }

                    if(tableModel.getValueAt(i,3) != null){
                        ln = tableModel.getValueAt(i,3).toString();
                    }
                    Employee employee = new Employee(no,fn,mid,ln);
                    MyDB2_07.Instance.oldEmployee.add(employee);
                }

                //存入新添加的雇员信息
                int count = 0;
                for(int i = ElementCount ; i < SumCount ;i++){
                    /*if(tableModel.getValueAt(i,0)==null || tableModel.getValueAt(i,1)==null
                            ||tableModel.getValueAt(i,2)==null ||tableModel.getValueAt(i,3)==null){
                        JOptionPane.showMessageDialog(null, "请先输入所有空行，输入完后按回车", "错误提示", JOptionPane.ERROR_MESSAGE);
                        return;
                    }*/


                    String nostr;
                    int no;
                    String fn = "";
                    String mid = "";
                    String ln = "";

                    if(tableModel.getValueAt(i, 0) != null){
                        nostr = tableModel.getValueAt(i, 0).toString();
                        no = Integer.parseInt(nostr);
                    }else{
                        JOptionPane.showMessageDialog(null, "雇员编号不合法", "错误提示", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if(tableModel.getValueAt(i , 1) != null){
                        fn = tableModel.getValueAt(i,1).toString();
                    }

                    if(tableModel.getValueAt(i,2)!=null){
                        mid = tableModel.getValueAt(i,2).toString();
                    }

                    if(tableModel.getValueAt(i,3) !=null){
                        ln = tableModel.getValueAt(i,3).toString();
                    }
                    Employee employee = new Employee(no,fn,mid,ln);
                    MyDB2_07.Instance.newEmployee.set(count,employee);
                    count++;
                }
                ElementCount = SumCount;

                //更新//插入
                MyDB2_07.Instance.Update();
                MyDB2_07.Instance.Insert();
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}

class MyDB2_07{
    public static MyDB2_07 Instance;
    public LinkedList<Employee> newEmployee = new LinkedList<>();//新添加雇员信息
    public LinkedList<Employee> oldEmployee = new LinkedList<>();//原有雇员信息
    static {
        try {
            Instance = new MyDB2_07();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection connection = null;

    static {

    }

    private MyDB2_07() throws SQLException {
        try {
            //导入DB2驱动
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //连接数据库
        connection = DriverManager.getConnection("jdbc:db2://127.0.0.1:50000/sample","administrator","qhw739t");
    }

    //获得数据库中的数据
    public Object[][] getElements() throws SQLException {

        //SQL查询语句
        String sqlstmt = "select EMPNO,FIRSTNME,MIDINIT,LASTNAME from EMPLOYEE";


        Statement statement = connection.createStatement();

        //执行并获取结果
        ResultSet resultSet = statement.executeQuery(sqlstmt);

        int no;
        String firstname;
        String midinit;
        String lastname;

        //int elementcount = 0;
        //Employee employee = new Employee();
        LinkedList<Employee> employees = new LinkedList<>();
        while(resultSet.next()){
            /*if(resultSet.wasNull()){
                JOptionPane.showMessageDialog(null,"数据为空","错误提示",JOptionPane.ERROR_MESSAGE);
                break;
            }*/
            no = resultSet.getInt(1);

            if(resultSet.getString(2)!=null) {
                firstname = resultSet.getString(2);
            }
            else{
                firstname = "";
            }

            if(resultSet.getString(3) !=null){
                midinit = resultSet.getString(3);
            }else{
                midinit ="";
            }

            if(resultSet.getString(4)!=null){
                lastname = resultSet.getString(4);
            }else{
                lastname ="";
            }

            //构造数据
            //employee.Change(no,firstname,midinit,lastname);
            Employee employee = new Employee(no,firstname,midinit,lastname);
            //newEmployee.add(employee);
            oldEmployee.add(employee);
            employees.add(employee);

            Object []element = {no,firstname,midinit,lastname};
            //elements[elementcount] = element;
            //elementcount++;
        }

        Object[][] elements = new Object[employees.size()][];
        for(int i = 0 ; i < employees.size();i++){
            Object [] element = {employees.get(i).NO,employees.get(i).FirstName,employees.get(i).MidInit,employees.get(i).LastName};
            elements[i] = element;
        }

        return elements;
    }


    //更新数据
    public void Update(){
        String sql = "update employee set firstnme = ? , midinit = ? , lastname = ? where empno = ?";
        PreparedStatement preparedStatement = null;
        String errorstr ="";
        try {
            preparedStatement = connection.prepareStatement(sql);

            for(int i = 0 ; i < oldEmployee.size();i++){
                errorstr ="";
                int no = oldEmployee.get(i).NO;
                String fn = oldEmployee.get(i).FirstName;
                String mid = oldEmployee.get(i).MidInit;
                String ln = oldEmployee.get(i).LastName;


                if(fn.equals("")){
                    preparedStatement.setNull(1,Types.CHAR);
                }else{
                    preparedStatement.setString(1,fn);
                }

                if(mid.equals("")){
                    preparedStatement.setNull(2,Types.CHAR);
                }else{
                    preparedStatement.setString(2,mid);
                }

                if(ln.equals("")){
                    preparedStatement.setNull(3,Types.CHAR);
                }else{
                    preparedStatement.setString(3,ln);
                }

                preparedStatement.setInt(4,no);

                preparedStatement.executeUpdate();//执行更新
                //System.out.println(code);
                if (preparedStatement.getWarnings()!=null){
                    errorstr += "错误信息:" + preparedStatement.getWarnings().toString() +"/n";
                }
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();

            errorstr += "错误代码:" + e.getErrorCode() +"\n";
            errorstr += "错误状态:" + e.getSQLState();
            JOptionPane.showMessageDialog(null,errorstr,"错误信息",JOptionPane.ERROR_MESSAGE);
        }


    }

    //插入数据
    public void Insert(){
        String sql = "insert into employee values(?, ? , ? , ?, 'D11' ,8888,'2019-09-24','PRES ',18,'F','1998-10-11',21512,432,5242)";
        String errorstr = "";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);

            for(int i = 0 ; i < newEmployee.size();i++){
                errorstr = "";
                int no = newEmployee.get(i).NO;
                String fn = newEmployee.get(i).FirstName;
                String mid = newEmployee.get(i).MidInit;
                String ln = newEmployee.get(i).LastName;

                preparedStatement.setInt(1,no);
                preparedStatement.setString(2,fn);
                preparedStatement.setString(3,mid);
                preparedStatement.setString(4,ln);



                if (preparedStatement.getWarnings()!=null){
                    errorstr += "错误信息:" + preparedStatement.getWarnings().toString() +"/n";
                }
                oldEmployee.add(newEmployee.get(i));
            }
            newEmployee.clear();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            errorstr += "错误代码:" + e.getErrorCode();
            JOptionPane.showMessageDialog(null,errorstr,"错误信息",JOptionPane.ERROR_MESSAGE);
        }

    }
}


