package com.elbicon.coderscampus;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PopulateUserList {
    public List<List<Users>> createUserList(int userCount) {
        List<List<Users>> siteUsers = new ArrayList<List<Users>>();
        Random random = new Random();
        String alphaNumerics = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        try {
            StringBuilder firstName = new StringBuilder();
            StringBuilder lastName = new StringBuilder();
            for (int i = 0; i < userCount; i++) {
                Users user = new Users();
                for(int randChar = 0; randChar< 7;randChar++){
                    firstName.append(alphaNumerics.charAt(random.nextInt(alphaNumerics.length())));
                    lastName.append(alphaNumerics.charAt(random.nextInt(alphaNumerics.length())));
                }
                user.setFirstName(firstName.toString());
                user.setLastName(lastName.toString());
                List a = new ArrayList();
                a.add(user);
                siteUsers.add(a);
                firstName.setLength(0);
                lastName.setLength(0);
            }
            return siteUsers;
        } catch (Exception e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }
        return null;
    }
}
