/*
 * Created by JFormDesigner on Thu Oct 01 13:49:35 CST 2020
 */

package com.resourceCallingSystem.java;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * @author 沈佳军
 * @description It's a Frame to show the log
 * @date 2020/11/14
 */
public class LogFrame extends JFrame {
    private UserList userList;
    private ResourceCatalog resourceCatalog;
    public LogFrame(UserList initialUserList, ResourceCatalog initialResourceCatalog) {
        initComponents();
        userList = initialUserList;
        resourceCatalog = initialResourceCatalog;
    }

//-----------------------------------------------------------------------------------------------------------------------------
    private void button2MouseClicked(MouseEvent e) {
    }

    private void button1MouseClicked(MouseEvent e) {
    }

    private void textArea1KeyTyped(KeyEvent e) {
    }

    private void passwordField1KeyTyped(KeyEvent e) {
    }

    private void textField1KeyTyped(KeyEvent e) {
    }

    private void passwordField2KeyTyped(KeyEvent e) {
    }
//--------------------------------------------------------------------------------------------------------------------------------

    private void button1ActionPerformed(ActionEvent e) {
        int i, j;
        String inputUserName = textField1.getText();
        String inputPassword = String.valueOf(passwordField2.getPassword());
        for(i = 0; i < userList.getNumberOfUsers(); i++) {
            if(userList.getUser(i).getUsrName().equals(inputUserName)){
                break;
            }
        }
        if(i == userList.getNumberOfUsers()){
            for(j = 0; j < userList.getNumberOfUsers(); j++) {
                if(userList.getUser(j).getPassword().equals(inputPassword)){
                    break;
                }
            }
            if(j == userList.getNumberOfUsers()){
                JOptionPane.showMessageDialog(this,"Invalid UserName and Password","warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            else{
                JOptionPane.showMessageDialog(this,"Invalid UserName","warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        else {
            for(j = 0; j < userList.getNumberOfUsers(); j++) {
                if(userList.getUser(j).getPassword().equals(inputPassword)){
                    break;
                }
            }
            if(j == userList.getNumberOfUsers()){
                JOptionPane.showMessageDialog(this,"Invalid Password","warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            else{
                JOptionPane.showMessageDialog(this, "Log in Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                ResourceCallingSystem resourceCallingSystem = new ResourceCallingSystem(userList,userList.getUser(i), resourceCatalog);
                resourceCallingSystem.setVisible(true);
                resourceCallingSystem.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                return;
            }
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        dispose();
        LogUpFrame logUpFrame = new LogUpFrame(userList, resourceCatalog);
        logUpFrame.setVisible(true);
        logUpFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField2 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {104, 108, 240, 122, 99, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {64, 105, 66, 69, 103, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label3 ----
        label3.setText("Resource Calling System");
        label3.setFont(new Font("Consolas", Font.PLAIN, 24));
        contentPane.add(label3, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- label4 ----
        label4.setText("UserName:");
        label4.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(label4, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- textField1 ----
        textField1.setFont(new Font("Consolas", Font.PLAIN, 20));
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textField1KeyTyped(e);
            }
        });
        contentPane.add(textField1, new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- label2 ----
        label2.setText("Password:");
        label2.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(label2, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- passwordField2 ----
        passwordField2.setFont(new Font("Consolas", Font.PLAIN, 20));
        passwordField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                passwordField2KeyTyped(e);
            }
        });
        contentPane.add(passwordField2, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- button1 ----
        button1.setText("Log in");
        button1.setFont(new Font("Consolas", Font.PLAIN, 16));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            new Insets(0, 0, 7, 7), 0, 0));

        //---- button2 ----
        button2.setText("Log up");
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
            new Insets(0, 0, 7, 7), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
