package ChcDB2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

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
    private JButton selectBTN;

    private JTable ElementTable;

    public File selectedFile;

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

        /*DeleteBTN.setEnabled(false);
        RollBackBTN.setEnabled(false);
        FitterBTN.setEnabled(false);
        MoreBTN.setEnabled(false);
        CloseBTN.setEnabled(false);
        HelpBTN.setEnabled(false);*/

    }

    public ChcGUI(int index){
        CenterPanel.setName("CenterPanel");

        Object[][] tableData =
                {


                };
        //定义一维数据作为列标题
        Object[] columnTitle = {"EmployeeNO" , "photo_format","photo"};

        DefaultTableModel tableModel = new DefaultTableModel(tableData,columnTitle);
        ElementTable = new JTable(tableModel);

        //向中间面板添加JTable
        CenterPanel.add(new JScrollPane(ElementTable));

        /*DeleteBTN.setEnabled(false);
        RollBackBTN.setEnabled(false);
        FitterBTN.setEnabled(false);
        MoreBTN.setEnabled(false);
        CloseBTN.setEnabled(false);
        HelpBTN.setEnabled(false);*/

        selectBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser("./");
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("图片","jpg","png","gif");
                jFileChooser.setFileFilter(fileNameExtensionFilter);

                jFileChooser.showDialog(null, "选择照片");
                //System.out.println(showDialog);
                selectedFile = jFileChooser.getSelectedFile();
                System.out.println(selectedFile.getName());
            }
        });

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
