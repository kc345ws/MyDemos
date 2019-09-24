package ChcDB2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ChcGUI {
    private JPanel rootPanel;
    private JPanel TopPanel;
    private JPanel BottomPanel;
    private JButton CommitBTN;
    private JPanel RightPanel;
    private JButton InsertBTN;
    private JPanel CenterPanel;
    private JButton DeleteBTN;
    private JButton RollBackBTN;
    private JCheckBox AutoCommitCheckBox;
    private JButton FitterBTN;
    private JButton MoreBTN;
    private JButton CloseBTN;
    private JButton HelpBTN;

    private JTable ElementTable;

    public ChcGUI(){
        CenterPanel.setName("CenterPanel");

        Object[][] tableData =
                {


                };
        //定义一维数据作为列标题
        Object[] columnTitle = {"EmployeeNO" , "FirstName" , "MidInit","LastName"};

        DefaultTableModel tableModel = new DefaultTableModel(tableData,columnTitle);
        ElementTable = new JTable(tableModel);

        //向中间面板添加JTable
        CenterPanel.add(new JScrollPane(ElementTable));

        DeleteBTN.setEnabled(false);
        RollBackBTN.setEnabled(false);
        FitterBTN.setEnabled(false);
        MoreBTN.setEnabled(false);
        CloseBTN.setEnabled(false);
        HelpBTN.setEnabled(false);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("05GUI");
        frame.setContentPane(new ChcGUI().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JTable getElementTable() {
        return ElementTable;
    }

    public JButton getInsertBTN() {
        return InsertBTN;
    }

    public JButton getCommitBTN() {
        return CommitBTN;
    }
}
