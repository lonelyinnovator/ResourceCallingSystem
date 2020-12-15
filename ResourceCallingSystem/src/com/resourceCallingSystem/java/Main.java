package com.resourceCallingSystem.java;

public class Main {
    /**
     * @param args
     * @return void
     * @description The main of the program.
     */
    public static void main(String[] args) {
        Database database = new Database();
        LogFrame logFrame = new LogFrame(database.getUserList(), database.getResourceCatalog());
        logFrame.setVisible(true);
        logFrame.setDefaultCloseOperation(3);
    }
}
