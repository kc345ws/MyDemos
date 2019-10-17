package ChcDB2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.LinkedList;

public class _10 {
    private static int SumCount ;//总的元素数量
    private static int ElementCount;//未提交前的元素数量

    public static void main(String[]args) throws SQLException {
        ChcGUI MyGUI = new ChcGUI(1);
        JPanel rootpanel = MyGUI.getRootPanel();

        JFrame frame = new JFrame("_10--55170933陈鸿超");
        frame.setContentPane(rootpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //System.out.println(rootpanel.getComponents().length);
        //Component[] components = rootpanel.getComponents();
        JTable ElementTable = MyGUI.getElementTable();
        //ElementTable.isCellEditable(0,0);
        DefaultTableModel tableModel = (DefaultTableModel)ElementTable.getModel();

        Object[][] elements = MyDB2_PHOTO.Instance.getElements();
        //向表格添加数据
        for(var item: elements){
            tableModel.addRow(item);
        }


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
                MyDB2_PHOTO.Instance.newEmployee.add(new Employee_PHOTO());//添加空的雇员信息
                SumCount++;
            }
        });

        //获取提交按钮
        JButton commitBTN = MyGUI.getCommitBTN();
        commitBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //存入修改后的旧的雇员信息
                MyDB2_PHOTO.Instance.oldEmployee.clear();
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
                    MyDB2.Instance.oldEmployee.add(employee);
                }

                //存入新添加的雇员信息
                int count = 0;
                for(int i = ElementCount ; i < SumCount ;i++){
                    if(tableModel.getValueAt(i,0)==null || tableModel.getValueAt(i,1)==null
                            ||tableModel.getValueAt(i,2)==null ||tableModel.getValueAt(i,3)==null){
                        JOptionPane.showMessageDialog(null, "请先输入所有空行，输入完后按回车", "错误提示", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String nostr = tableModel.getValueAt(i, 0).toString();
                    int no = Integer.parseInt(nostr);


                    String fn = tableModel.getValueAt(i,1).toString();
                    String mid = tableModel.getValueAt(i,2).toString();
                    String ln = tableModel.getValueAt(i,3).toString();
                    Employee employee = new Employee(no,fn,mid,ln);
                    MyDB2.Instance.newEmployee.set(count,employee);
                    count++;
                }
                ElementCount = SumCount;




                //更新//插入
                try {
                    MyDB2.Instance.Update();
                    MyDB2.Instance.Insert();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


            }
        });


        frame.pack();
        frame.setVisible(true);
    }
}


class MyDB2_PHOTO{
    public static MyDB2_PHOTO Instance;
    public LinkedList<Employee_PHOTO> newEmployee = new LinkedList<>();//新添加雇员信息
    public LinkedList<Employee_PHOTO> oldEmployee = new LinkedList<>();//原有雇员信息
    static {
        try {
            Instance = new MyDB2_PHOTO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection connection = null;

    static {

    }

    private MyDB2_PHOTO() throws SQLException {
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
        String sqlstmt = "select * from emp_photo";


        Statement statement = connection.createStatement();

        //执行并获取结果
        ResultSet resultSet = statement.executeQuery(sqlstmt);

        int no;
        String phtot_format;
        Blob photo;

        //int elementcount = 0;
        //Employee employee = new Employee();
        LinkedList<Employee_PHOTO> employees = new LinkedList<>();
        while(resultSet.next()){
            no = resultSet.getInt(1);
            phtot_format = resultSet.getString(2);
            photo = resultSet.getBlob(3);



            //构造数据
            //employee.Change(no,firstname,midinit,lastname);
            Employee_PHOTO employee = new Employee_PHOTO(no,phtot_format,photo);
            //newEmployee.add(employee);
            oldEmployee.add(employee);
            employees.add(employee);

            Object []element = {no,phtot_format,photo};
            //elements[elementcount] = element;
            //elementcount++;
        }

        Object[][] elements = new Object[employees.size()][];
        for(int i = 0 ; i < employees.size();i++){
            Object [] element = {employees.get(i).NO,employees.get(i).phtot_format,employees.get(i).photo};
            elements[i] = element;
        }

        return elements;
    }


    //插入数据
    public void Insert(File photofile) throws SQLException, FileNotFoundException {
        String sql = "insert into emp_photo values(?, ? , ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for(int i = 0 ; i < newEmployee.size();i++){
            int no = newEmployee.get(i).NO;
            String phtot_format = newEmployee.get(i).phtot_format;

            BufferedInputStream bufferedInputStream = new BufferedInputStream(
                    new FileInputStream(photofile)
            );



            //Blob photo = newEmployee.get(i).photo;

            preparedStatement.setInt(1,no);
            preparedStatement.setString(2,phtot_format);
            preparedStatement.setBlob(3,bufferedInputStream,(int)photofile.length());

            preparedStatement.executeUpdate();

            oldEmployee.add(newEmployee.get(i));
        }
        newEmployee.clear();

        preparedStatement.close();
    }
}

class Employee_PHOTO{
    public int NO;
    public String phtot_format;
    public Blob photo;


    public Employee_PHOTO(){

    }

    public Employee_PHOTO(int no ,String phtot_format,Blob photo){
        NO = no;
        this.phtot_format = phtot_format;
        this.photo = photo;
    }

    public void Change(int no ,String phtot_format,Blob photo){
        NO = no;
        this.phtot_format = phtot_format;
        this.photo = photo;
    }
}
