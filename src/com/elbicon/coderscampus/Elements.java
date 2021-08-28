package com.elbicon.coderscampus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Elements {
    Long lastElement;
    Integer arrayLength;
    Integer newUserCount = 0;
    Long currentUserCount;

    public Long getCurrentUserCount() {
        return currentUserCount;
    }

    public void setCurrentUserCount(Object[] currentUsers) {
        this.currentUserCount = Arrays.stream(currentUsers)
                .filter(f -> f != null)
                .count();
    }


    public Integer getNewUserCount() {
        return this.newUserCount;
    }

    public void setNewUserCount(ArrayList<Users> newUserCount) {
        Long newUsers = newUserCount.stream()
                .count();
        this.newUserCount = newUsers.intValue();
    }

    public Long getLastElement() {
        return lastElement;
    }

    public void setLastElement(Object[] users) {
        this.lastElement = Arrays.stream(users)
                .filter(f -> f != null)
                .count();
    }

    public Integer getTotalLength() {
        return arrayLength;
    }

    public void setTotalLength(Integer totalLength) {
        this.arrayLength = totalLength;
    }
}
