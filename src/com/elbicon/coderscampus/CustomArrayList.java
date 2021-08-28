package com.elbicon.coderscampus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomArrayList<T> implements CustomList<T> {
    Object[] items = new Object[10];
    Elements indices = new Elements();
    Integer arrayTotalSize;
    Long currentUserCount;
    Integer newUserCount;
    Long lastElement;


    @Override
    public boolean add(T item) {
        try {
            updateNewUserCount(item);
            updateCountStats();
            updateArraySize(items.length);

            for (int i = 0; i <= newUserCount - 1; i++) { //insert from index 0
                if (lastElement == 0 && i <= arrayTotalSize - 1) {
                    this.items[i] = ((ArrayList<?>) item).get(i);
                    //break;
                } else if (lastElement != 0 && i <= arrayTotalSize - 1 && indexFree()) {
                    this.items[lastElement.intValue()] = ((ArrayList<?>) item).get(i);
                    lastElement++;
                } else {
                    updateArraySize(this.items.length * 2);
                    updateCountStats();
                    this.items = Arrays.copyOf(this.items, arrayTotalSize);

                    updateCountStats();
                    this.items[lastElement.intValue()] = ((ArrayList<?>) item).get(i);

                    updateCountStats();

                }
            }
            updateCountStats();
            updateNewUserCount(item);

            //For Informational Purpose Only
            System.out.println("ArrayTotalSize=" + arrayTotalSize);
            System.out.println("UserCount=" + currentUserCount);
            System.out.println("NewUserAdded=" + newUserCount);

            return true;
        } catch (Exception e) {
            System.out.println("Exception Caught - " + e.getMessage());
        }
        return false;
    }

    @Override
    public int getSize() {
        return this.items.length;
        //return 0;
    }

    @Override
    public T get(int index) {
        try {
            if (index <= this.items.length -1) {
                List userIndex = IntStream.range(0, items.length)
                        .mapToObj(m -> this.items[index])
                        .distinct()
                        .filter(f -> f != null)
                        .collect(Collectors.toList());
                return (T) userIndex;
            } else {
                List<String> indexOutOfBounds = new ArrayList<>();
                indexOutOfBounds.add("*** User Index out of Bounds ***");
                return (T) indexOutOfBounds;
            }
        } catch (Exception e) {
            System.out.println("Exception Caught " + e.getMessage());
        }
        return null;
    }

    private void updateCountStats() {
        indices.setCurrentUserCount(items);
        currentUserCount = indices.getCurrentUserCount();

        indices.setLastElement(items);
        lastElement = indices.getLastElement();
    }

    private void updateNewUserCount(T item) {
        indices.setNewUserCount((ArrayList<Users>) item);
        newUserCount = indices.getNewUserCount();

    }

    private void updateArraySize(int elementCount) {
        //indices.setTotalLength(this.items.length);
        indices.setTotalLength(elementCount);
        arrayTotalSize = indices.getTotalLength();
    }

    private boolean indexFree() {
        if (!(arrayTotalSize > lastElement)) {
            return false;
        }
        return true;
    }
}
