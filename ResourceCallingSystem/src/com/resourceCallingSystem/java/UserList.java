package com.resourceCallingSystem.java;

import java.util.ArrayList;
import java.util.Iterator;

public class UserList implements Iterable<User>{

    private ArrayList<User>users;

    public UserList(){
        users = new ArrayList<User>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }


    public User getUser(int index){
        return users.get(index);
    }

    public int getNumberOfUsers(){
        return users.size();
    }

    @Override
    public Iterator<User> iterator() {
        return users.iterator();
    }
}
