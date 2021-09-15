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

    /*
     *  Revised the main method based on feedback from Roche
     */
    public static void startTest() {
        // TEST STATEMENTS
        try {
            randomUserList = userList.createUserList(12);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");

            randomUserList = userList.createUserList(9);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");

            randomUserList = userList.createUserList(8);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");


            randomUserList = userList.createUserList(13);
            System.out.println("Update Succeeded? - " + custUserList.add(randomUserList) + "\n");

            System.out.println("Total Size=" + custUserList.getSize());

            // Add @param index
            randomUserList = userList.createUserList(1);
            System.out.println("Update Succeeded? - " + custUserList.add(2,randomUserList));
            System.out.println("Updated Total Size=" + custUserList.getSize());

            //Remove @param index
            System.out.println("Update Succeeded? - " + custUserList.remove(5));
            System.out.println("Updated Total Size=" + custUserList.getSize());

/*            for (int i=0; i <10;i++){
                randomUserList = userList.createUserList((new Random()).nextInt(10));
                System.out.println("Update Succeeded? = " + custUserList.add(randomUserList) + "\n");
            }*/
        } catch (Exception e) {
            System.out.println("Exception Caught:" + e.getMessage());
        }
    }
}
