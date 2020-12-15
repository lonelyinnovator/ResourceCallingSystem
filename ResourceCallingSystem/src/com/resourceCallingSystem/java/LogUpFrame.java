/*
 * Created by JFormDesigner on Thu Oct 01 14:23:14 CST 2020
 */

package com.resourceCallingSystem.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Brainrain
 */
public class LogUpFrame extends JFrame {
    private UserList userList;
    private User user;
    private ResourceCatalog resourceCatalog;
    public LogUpFrame(UserList initialUserList, ResourceCatalog initialResourceCatalog) {
        initComponents();
        userList = initialUserList;
        resourceCatalog = initialResourceCatalog;
    }

//-------------------------------------------------------------------------------------------
    private void button1MouseClicked(MouseEvent e) {
    }

    private void button2MouseClicked(MouseEvent e) {
    }
//-------------------------------------------------------------------------------------------

    private void button2ActionPerformed(ActionEvent e) {
        String msg = "NULL";
        if(textField1.getText().equals("")){
            msg += " UserName";
        }
        if(textField2.getText().equals("")){
            msg += " Email";
        }
        if(String.valueOf(passwordField1.getPassword()).equals("")){
            msg += " Password";
        }
        if(!msg.equals("NULL")){
            JOptionPane.showMessageDialog(this, msg,"warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Log up Success! You will return to Log in.", "Success", JOptionPane.INFORMATION_MESSAGE);
        user = new User(textField1.getText(), String.valueOf(passwordField1.getPassword()), textField2.getText(),null);
        userList.addUser(user);
        dispose();
        LogFrame logFrame = new LogFrame(userList, resourceCatalog);
        logFrame.setVisible(true);
        logFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void button1ActionPerformed(ActionEvent e) {
        dispose();
        LogFrame logFrame = new LogFrame(userList, resourceCatalog);
        logFrame.setVisible(true);
        logFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {90, 168, 204, 106, 61, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {87, 80, 81, 82, 84, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("UsrName:");
        label1.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(label1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- textField1 ----
        textField1.setFont(new Font("Consolas", Font.PLAIN, 20));
        contentPane.add(textField1, new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- label2 ----
        label2.setText("Email:");
        label2.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(label2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- textField2 ----
        textField2.setFont(new Font("Consolas", Font.PLAIN, 20));
        contentPane.add(textField2, new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- label3 ----
        label3.setText("Password:");
        label3.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(label3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- passwordField1 ----
        passwordField1.setFont(new Font("Consolas", Font.PLAIN, 20));
        contentPane.add(passwordField1, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- button1 ----
        button1.setText("return");
        button1.setFont(new Font("Consolas", Font.PLAIN, 16));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 7), 0, 0));

        //---- button2 ----
        button2.setText("log up");
        button2.setFont(new Font("Consolas", Font.PLAIN, 16));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 7), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
