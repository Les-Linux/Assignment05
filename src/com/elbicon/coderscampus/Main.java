package com.elbicon.coderscampus;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    //static CustomList<List<Users>> custUserList = new CustomArrayList<List<Users>>();
    static CustomList<List<List<Users>>> custUserList = new CustomArrayList<>();
    static List<List<Users>> randomUserList = new ArrayList<List<Users>>();
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

            randomUserList = userList.createUserList(3);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");


            randomUserList = userList.createUserList(22);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");


            //0 based index search
            List<List<Users>> userInfo = custUserList.get(43);


            System.out.println("## Processing Get Method for Index ##");

            System.out.println("Total Elements in the Array=" + custUserList.getSize());

            if (userInfo.size() == 0) {
                System.out.println("Search by Index returned 'NULL'");
            } else {
                if(userInfo.stream().findFirst().toString().contains("Index")){
                    System.out.println(userInfo.toString());
                    System.exit(0);
                }else{
                    userInfo.stream()
                            .flatMap(u -> u.stream())
                            .forEach(f -> {
                                if (f.toString().contains("Index")) {
                                    System.out.println("\n" + f.toString());
                                } else if (f.getClass().getSimpleName().equals("Users")) {
                                    System.out.println("First Name=" + f.getFirstName() + " Last Name=" + f.getLastName());
                                }
                            });
                }
            }
        } catch (Exception e) {
            System.out.println("Exception Caught:" + e.getMessage());
        }
    }
}
