package com.kristianskokars.datastructures;

import java.util.Arrays;


public class MyList {
    private int[] array;
    private int size;
    private int count;

    public MyList(int size) {
        this.size = size;
        array = new int[size];
        count = 0;
    }

    public boolean isFull() {
        return array.length == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getCount() {
        return count;
    }

    public void doubleArray() {
        int[] newArray = new int[size * 2];
        size = size * 2;

//        for (int i = 0; i < array.length; i++) {
//            newArray[i] = array[i];
//        }
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void push(int number) {
        if (count == size) return;

        array[count] = number;
        count++;
    }

    // TODO: I do not remember if you could do direct [] overloading in Java
    public void addAtIndex(int index, int number) {
        if (isInvalidIndex(index)) return;

        array[index] = number;
    }

    public void deleteAtIndex(int index, int number) {
        // TODO: not sure what behaviour to do here for the task: throw or just do nothing?
        if (isInvalidIndex(index)) return;

        array[index] = 0; // 0 is by default the empty value
    }

    public int getAtIndex(int index, int number) {
        if (isInvalidIndex(index)) throw new ArrayIndexOutOfBoundsException();

        return array[index];
    }

    public int findNumber(int number) {
        for (int i = 0; i < size; i++) {
            if (array[i] == number) {
                return i;
            }
        }

        return -1;
    }

    public int returnNextElement(int number) {
        for (int i = 0; i < size; i++) {
            if (array[i] == number && i != size - 1) {
                return array[i + 1];
            }
        }

        return -1;
    }

    public void sort() {
        array = Arrays.stream(array).sorted().toArray();
    }

    public void print() {
        System.out.println(array[2]);
        for (int number : array) {
            System.out.print(String.format("%d ", number));
        }
    }

    public void empty() {
        array = new int[size];
    }

    private boolean isInvalidIndex(int index) {
        return index > size - 1 || index < 0;
    }
}
