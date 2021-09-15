package com.elbicon.coderscampus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomArrayList<T> implements CustomList<T> {
    Object[] items = new Object[10];
    Elements indices = new Elements();
    Integer arrayTotalSize;
    Integer size = 0;
    Long currentUserCount;
    Integer newUserCount;
    Long lastElement;

    /*
        Revised add method based on feedback from Roche
    */
    @Override
    public boolean add(T item){
        if (size == items.length){
            //resize the object double in size
            items = Arrays.copyOf(items, items.length * 2);
            }

            items[size] = item;
            size++;

            return true;
        }

    @Override
    public boolean add(int index, T item) throws IndexOutOfBoundsException {
        size = 0;
        Object[] newObject = null;
        if (size == items.length){
            //resize the object double in size
            items = Arrays.copyOf(items, items.length * 2);
        }

        if (items[index] == null) {
            items[index] = item;
            size++;
        }else {
            newObject = new Object[items.length + 1];
            Integer totalElements = getIndexElementsSize();
            for ( int i=0; i < totalElements + 1; i++) {
                if(i < index - 1 && (!(items[i] == null))){
                    newObject[i] = items[i];
                    size++;
                } else if (i == index - 1 && (!(items[i] == null))) {
                    newObject[i] = item;
                    size++;
                }else {
                        newObject[i] = items[i - 1];
                        size++;
                }
            }

        }
        items = Arrays.copyOf(newObject, newObject.length);
        return true;
    }


    /*
     *  Revised getSize method based on feedback from Roche
     */
    @Override
    public int getSize() {
        return size;
    }

    /*
     *  Revised get method based on feedback from Roche
     */
    @Override
    public T get(int index) {
        try {
            if (index >= size) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return (T) items[index];
        } catch (Exception e) {
            System.out.println("Exception Caught " + e.getMessage());
        }
        return null;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        size=0;
        Integer totalElements = getIndexElementsSize();
        Object[] newObject = new Object[items.length -1];
        for ( int i=0; i < totalElements - 1; i++) {
            if(i < index - 1) {
                newObject[i] = items[i];
                size++;
            } else if (i == index - 1) {
                newObject[i] = items[i + 1];
                size++;
                //i++;
            }else {
                newObject[i] = items[i + 1];
                size++;
            }
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

    private Integer getIndexElementsSize(){
        ArrayList itemsCount = new ArrayList(Arrays.asList(items));
        itemsCount.removeAll(Collections.singleton(null));
        return itemsCount.size();
    }
}
