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

public class _08_2_GUIALL {
    private static int SumCount ;//总的元素数量
    private static int ElementCount;//未提交前的元素数量
    public static void main(String[] args) throws SQLException {
        ChcGUI MyGUI = new ChcGUI();
        JPanel rootpanel = MyGUI.getRootPanel();

        JFrame frame = new JFrame("_08_2_GUIALL");
        frame.setContentPane(rootpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //System.out.println(rootpanel.getComponents().length);
        //Component[] components = rootpanel.getComponents();
        JTable ElementTable = MyGUI.getElementTable();
        //ElementTable.isCellEditable(0,0);
        DefaultTableModel tableModel = (DefaultTableModel)ElementTable.getModel();

        Object[][] elements = MyDB2.Instance.getElements();
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
                MyDB2.Instance.newEmployee.add(new Employee());//添加空的雇员信息
                SumCount++;
            }
        });

        //获取提交按钮
        JButton commitBTN = MyGUI.getCommitBTN();
        commitBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //存入修改后的旧的雇员信息
                MyDB2.Instance.oldEmployee.clear();
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


