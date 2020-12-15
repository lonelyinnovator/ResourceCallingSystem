/*
 * Created by JFormDesigner on Thu Oct 01 14:38:16 CST 2020
 */

package com.resourceCallingSystem.java;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;

/**
 * @author Brainrain
 */
public class ResourceCallingSystem extends JFrame {
    private UserList userList;
    private User user;
    private ResourceCatalog resourceCatalog;
    private Calling calling;
    private Display display;
    private ResourceDisplayList resourceDisplayList;
    private Administrator administrator;
    private DefaultListModel model1;
    private DefaultListModel model2;
    private DefaultListModel model3;
    public ResourceCallingSystem(UserList initialUserList, User initialUser, ResourceCatalog initialResourceCatalog) {
        initComponents();
        userList = initialUserList;
        user = initialUser;
        resourceCatalog = initialResourceCatalog;
        textField1.setBorder(new EmptyBorder(0,0,0,0));
        textField2.setBorder(new EmptyBorder(0,0,0,0));
        textField2.setText(user.getUsrName());
        model1 = new DefaultListModel();
        for(Resource resource : resourceCatalog){
            model1.addElement(resource.getCode() + " " + resource.getType() + " " + resource.getSize() + "MB");
        }
        list1.setModel(model1);
        model2 = new DefaultListModel();
        model3 = new DefaultListModel();
        administrator = new Administrator();
    }

    public ResourceCallingSystem(){
    }

    private void list1ValueChanged(ListSelectionEvent e) {

        int index = list1.getSelectedIndex();
        if(resourceCatalog.getResource(index) instanceof Picture){
            textArea1.setText("Code: " + resourceCatalog.getResource(index).getCode() + '\n'
                    + "Name: " + resourceCatalog.getResource(index).getName() + '\n'
                    + "Type: " + resourceCatalog.getResource(index).getType() + '\n'
                    + "Size: " + resourceCatalog.getResource(index).getSize()  + "MB"+ '\n'
                    + "modifiedDate: " + resourceCatalog.getResource(index).getModifiedDate() + '\n'
                    + "Suffix: " + resourceCatalog.getResource(index).getSuffix() + '\n'
                    + "Flavor: " + ((Picture) resourceCatalog.getResource(index)).getPixel());
        }
        else if(resourceCatalog.getResource(index) instanceof Music){
            textArea1.setText("Code: " + resourceCatalog.getResource(index).getCode() + '\n'
                    + "Name: " + resourceCatalog.getResource(index).getName() + '\n'
                    + "Type: " + resourceCatalog.getResource(index).getType() + '\n'
                    + "Size: " + resourceCatalog.getResource(index).getSize()  + "MB"+ '\n'
                    + "Modified Date: " + resourceCatalog.getResource(index).getModifiedDate() + '\n'
                    + "Suffix: " + resourceCatalog.getResource(index).getSuffix() + '\n'
                    + "Type: " + ((Music) resourceCatalog.getResource(index)).getPlayTime() + '\n'
                    + "Bit rate:" + ((Music) resourceCatalog.getResource(index)).getBitRate());
        }
        else if(resourceCatalog.getResource(index) instanceof Video){
            textArea1.setText("Code: " + resourceCatalog.getResource(index).getCode() + '\n'
                    + "Name: " + resourceCatalog.getResource(index).getName() + '\n'
                    + "Type: " + resourceCatalog.getResource(index).getType() + '\n'
                    + "Size: " + resourceCatalog.getResource(index).getSize()  + "MB"+ '\n'
                    + "modifiedDate: " + resourceCatalog.getResource(index).getModifiedDate() + '\n'
                    + "Suffix: " + resourceCatalog.getResource(index).getSuffix() + '\n'
                    + "Play time: " + ((Video) resourceCatalog.getResource(index)).getPlayTime() + '\n'
                    + "Frame: " + ((Video) resourceCatalog.getResource(index)).getFrame());
        }
        else if(resourceCatalog.getResource(index) instanceof Document){
            textArea1.setText("Code: " + resourceCatalog.getResource(index).getCode() + '\n'
                    + "Name: " + resourceCatalog.getResource(index).getName() + '\n'
                    + "Type: " + resourceCatalog.getResource(index).getType() + '\n'
                    + "Size: " + resourceCatalog.getResource(index).getSize()  + "MB"+ '\n'
                    + "modifiedDate: " + resourceCatalog.getResource(index).getModifiedDate() + '\n'
                    + "Suffix: " + resourceCatalog.getResource(index).getSuffix() + '\n'
                    + "Word number: " + ((Document) resourceCatalog.getResource(index)).getWordNumber());
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        int i;
        int index = list1.getSelectedIndex();
        if(index == -1){
            return;
        }
        display = new Display(resourceCatalog.getResource(index), 1);
        if(user.getCalling() == null){
            resourceDisplayList = new ResourceDisplayList();
            resourceDisplayList.addDisplay(display);
            calling = new Calling(resourceDisplayList, 1);
            user.setCalling(calling);
            model2.addElement(display.getResource().getCode() + " " + display.getResource().getType() + " "
                    + display.getResource().getSize() + "MB " + display.getQuantity());
            list2.setModel(model2);
            textField1.setBorder(new EmptyBorder(0,0,0,0));
            textField1.setText("Total: " + decimalFormat.format(user.getCalling().getResourceDisplayList().getTotalCost()) + "MB");
            return;
        }
        for(i = 0; i < user.getCalling().getResourceDisplayList().getNumberOfItems(); i++){
            if(display.getResource().getCode().equals(user.getCalling().getResourceDisplayList().getDisplay(i).getResource().getCode())){
                user.getCalling().getResourceDisplayList().getDisplay(i).setQuantity(user.getCalling().getResourceDisplayList().getDisplay(i).getQuantity() + 1);
                model2.setElementAt(user.getCalling().getResourceDisplayList().getDisplay(i).getResource().getCode() + " "
                                    + user.getCalling().getResourceDisplayList().getDisplay(i).getResource().getType() + " "
                                    + user.getCalling().getResourceDisplayList().getDisplay(i).getResource().getSize() + "MB "
                                    + user.getCalling().getResourceDisplayList().getDisplay(i).getQuantity(), i);
                list2.setModel(model2);
                textField1.setBorder(new EmptyBorder(0,0,0,0));
                textField1.setText("Total: " + decimalFormat.format(user.getCalling().getResourceDisplayList().getTotalCost()) + "MB");
                return;
            }
        }
        user.getCalling().getResourceDisplayList().addDisplay(display);
        model2.addElement(display.getResource().getCode() + " " + display.getResource().getType() + " " +
                display.getResource().getSize() + "MB " + display.getQuantity());
        list2.setModel(model2);
        textField1.setBorder(new EmptyBorder(0,0,0,0));
        textField1.setText("Total: " + decimalFormat.format(user.getCalling().getResourceDisplayList().getTotalCost()) + "MB");
        return;
    }

    private void button2ActionPerformed(ActionEvent e) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        int index = list2.getSelectedIndex();
        if(index == -1 || user.getCalling() == null || user.getCalling().getResourceDisplayList().getNumberOfItems() == 0){
            return;
        }
        user.getCalling().getResourceDisplayList().getDisplay(index).setQuantity(user.getCalling().getResourceDisplayList().getDisplay(index).getQuantity() - 1);
       if(user.getCalling().getResourceDisplayList().getDisplay(index).getQuantity() == 0){
           user.getCalling().getResourceDisplayList().removeDisplay(user.getCalling().getResourceDisplayList().getDisplay(index));
           model2.removeElementAt(index);
           textField1.setText("Total: " + decimalFormat.format(user.getCalling().getResourceDisplayList().getTotalCost()) + "MB");
           list2.setModel(model2);
//           if(index != 0){
//               list2.setSelectedIndex(index - 1);
//           }
       }
       else{
           model2.setElementAt(user.getCalling().getResourceDisplayList().getDisplay(index).getResource().getCode() + " "
                   + user.getCalling().getResourceDisplayList().getDisplay(index).getResource().getType() + " "
                   + user.getCalling().getResourceDisplayList().getDisplay(index).getResource().getSize() + "MB "
                   + user.getCalling().getResourceDisplayList().getDisplay(index).getQuantity(), index);
           textField1.setText("Total: " + decimalFormat.format(user.getCalling().getResourceDisplayList().getTotalCost()) + "MB");
           list2.setModel(model2);
           list2.setSelectedIndex(index);
       }
    }

    private void button3ActionPerformed(ActionEvent e) {
        if(user.getCalling() != null && user.getCalling().getResourceDisplayList().getNumberOfItems() != 0){
            int i;
            String info = "";
            resourceDisplayList = new ResourceDisplayList();
            for(i = 0; i < user.getCalling().getResourceDisplayList().getNumberOfItems(); i++){
                resourceDisplayList.addDisplay(user.getCalling().getResourceDisplayList().getDisplay(i));
            }
            calling = new Calling(resourceDisplayList, 1);
            administrator.addCalling(calling);
            for(i = 0; i < calling.getResourceDisplayList().getNumberOfItems(); i++){
                info += calling.getResourceDisplayList().getDisplay(i).getResource().getCode()
                        + "(" + calling.getResourceDisplayList().getDisplay(i).getQuantity() + ")" + " ";
            }
            user.setCalling(null);
            model2.clear();
            list2.setModel(model2);
            textField1.setText("Total: 0MB" );
            model3.addElement(info + calling.getResourceDisplayList().getTotalCost());
            list3.setModel(model3);

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label6 = new JLabel();
        textField2 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();
        scrollPane3 = new JScrollPane();
        list2 = new JList();
        scrollPane4 = new JScrollPane();
        list3 = new JList();
        textField1 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {60, 58, 69, 58, 58, 59, 71, 80, 81, 61, 104, 62, 77, 23, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {52, 48, 47, 41, 46, 53, 99, 46, 46, 40, 44, 46, 47, 55, 56, 47, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("Resource Calling System");
        label1.setFont(new Font("Consolas", Font.PLAIN, 24));
        contentPane.add(label1, new GridBagConstraints(1, 0, 5, 2, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- label6 ----
        label6.setText("UserName:");
        label6.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(label6, new GridBagConstraints(8, 0, 1, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- textField2 ----
        textField2.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(textField2, new GridBagConstraints(9, 0, 2, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- label2 ----
        label2.setText("Resources");
        label2.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(label2, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- label3 ----
        label3.setText("Current Resource");
        label3.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(label3, new GridBagConstraints(8, 2, 2, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 7, 7), 0, 0));

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setFont(new Font("Consolas", Font.PLAIN, 20));
            list1.addListSelectionListener(e -> list1ValueChanged(e));
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1, new GridBagConstraints(1, 3, 6, 4, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 7, 7), 0, 0));

        //======== scrollPane2 ========
        {

            //---- textArea1 ----
            textArea1.setFont(new Font("Consolas", Font.PLAIN, 20));
            scrollPane2.setViewportView(textArea1);
        }
        contentPane.add(scrollPane2, new GridBagConstraints(8, 3, 5, 4, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- button1 ----
        button1.setText("Add to Order");
        button1.setFont(new Font("Consolas", Font.PLAIN, 16));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, new GridBagConstraints(6, 7, 3, 1, 0.0, 0.0,
            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- button2 ----
        button2.setText("Remove product");
        button2.setFont(new Font("Consolas", Font.PLAIN, 16));
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, new GridBagConstraints(6, 8, 3, 1, 0.0, 0.0,
            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- button3 ----
        button3.setText("Submit order");
        button3.setFont(new Font("Consolas", Font.PLAIN, 16));
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3, new GridBagConstraints(6, 9, 3, 1, 0.0, 0.0,
            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- label4 ----
        label4.setText("Current Calling");
        label4.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(label4, new GridBagConstraints(1, 10, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- label5 ----
        label5.setText("History Calling");
        label5.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(label5, new GridBagConstraints(8, 10, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 7, 7), 0, 0));

        //======== scrollPane3 ========
        {

            //---- list2 ----
            list2.setFont(new Font("Consolas", Font.PLAIN, 20));
            scrollPane3.setViewportView(list2);
        }
        contentPane.add(scrollPane3, new GridBagConstraints(1, 11, 6, 5, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 7, 7), 0, 0));

        //======== scrollPane4 ========
        {

            //---- list3 ----
            list3.setFont(new Font("Consolas", Font.PLAIN, 20));
            scrollPane4.setViewportView(list3);
        }
        contentPane.add(scrollPane4, new GridBagConstraints(8, 11, 5, 5, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- textField1 ----
        textField1.setText("Total: 0MB");
        textField1.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(textField1, new GridBagConstraints(1, 16, 4, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 7), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label6;
    private JTextField textField2;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JList list1;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label4;
    private JLabel label5;
    private JScrollPane scrollPane3;
    private JList list2;
    private JScrollPane scrollPane4;
    private JList list3;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
