package com.resourceCallingSystem.java;

public class User {

    private Calling calling;
    private String usrName;
    private String password;
    private String email;



    public User(String initialUsrName, String initialPassword, String initialEmail, Calling initialCalling){
        usrName = initialUsrName;
        password = initialPassword;
        email = initialEmail;
        calling = initialCalling;
    }

    public User(){

    }


    public String getUsrName() {
        return usrName;
    }



    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Calling getCalling() {
        return calling;
    }

    public void setCalling(Calling calling){
        this.calling = calling;
    }

    @Override
    public String toString() {
        return getUsrName() + " " + getPassword() + " " + getEmail();
    }

}
