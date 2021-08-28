package com.elbicon.coderscampus;

import java.util.*;

public class Main {
    static CustomList<List<Users>> custUserList = new CustomArrayList<List<Users>>();
    static ArrayList<Users> randomUserList = new ArrayList<>();
    static PopulateUserList userList = new PopulateUserList();

    public static void main(String[] args) {
        startTest();
    }

    public static void startTest() {
        // TEST STATEMENTS
        try {
            randomUserList = userList.createUserList(12);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");

            randomUserList = userList.createUserList(9);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");

            randomUserList = userList.createUserList(5);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");
            //custUserList.add(randomUserList);

            randomUserList = userList.createUserList(22);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");
            //custUserList.add(randomUserList);

            List userInfo = custUserList.get(48);
            System.out.println("Processing Get Method for Index");

            System.out.println("Total Length of the Array=" + custUserList.getSize());

            if (userInfo.size() == 0) {
                System.out.println("Search by Index returned 'NULL'");
            } else {
                userInfo.stream()
                        .forEach(user -> {
                            if (user.toString().contains("Index")) {
                                System.out.println("\n" + user.toString());
                            } else if (user.getClass().getSimpleName().equals("Users")) {
                                System.out.println("First Name=" + ((Users) user).getLastName() + " Last Name=" + ((Users) user).getLastName());
                            }
                        });
            }
        } catch (Exception e) {
            System.out.println("Exception Caught:" + e.getMessage());
        }
    }
}
