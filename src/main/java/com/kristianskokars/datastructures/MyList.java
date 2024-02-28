package com.kristianskokars.datastructures;

public class MyList {
    private final int LIST_DEFAULT_SIZE = 10;
    private int[] array;
    private int size = LIST_DEFAULT_SIZE;
    private int count;

    public MyList() {
        array = new int[size];
        count = 0;
    }

    public MyList(int size) throws IllegalArgumentException {
        if (size <= 0) throw new IllegalArgumentException("Invalid array size");

        this.size = size;
        array = new int[size];
        count = 0;
    }

    public boolean isFull() {
        return array.length == count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getCount() {
        return count;
    }

    public void push(int number) {
        if (count == size) {
            resize();
        };

        array[count] = number;
        count++;
    }

    // TODO: I do not remember if you could do direct [] overloading in Java
    public void addAtIndex(int index, int number) {
        if (isInvalidIndex(index) || index > count) return;

        if (isFull()) resize();

        if (index == count) {
            push(number);
        } else {
            for (int i = count; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = number;
        }

        array[index] = number;
        count++;
    }

    public void deleteAtIndex(int index) throws Exception {
        if (isInvalidIndex(index)) throw new IllegalArgumentException("Invalid index");
        if (isEmpty()) throw new Exception("Can't delete from empty array");

        array[index] = 0; // 0 is by default the empty value
        if (index != count) {
            for (int i = index; i < count - 1; i++) {
                array[i] = array[i + 1];
            }
        }
        count--;
        array[count] = 0; // null out the end from the shift
    }

    public int getAtIndex(int index) throws ArrayIndexOutOfBoundsException {
        if (isInvalidIndex(index)) throw new ArrayIndexOutOfBoundsException();

        return array[index];
    }

    public MyList findNumber(int number) throws Exception {
        var indexes = new MyList();

        for (int i = 0; i < size; i++) {
            if (array[i] == number) {
                indexes.push(i);
            }
        }

        if (indexes.getCount() == 0) throw new Exception("Element not found");

        return indexes;
    }

    public int[] returnNextElement(int number) throws Exception {
        var indexes = findNumber(number);
        var neighboursSize = indexes.getCount();

        if (indexes.getAtIndex(indexes.getCount() - 1) == (count - 1)) {
            neighboursSize--;
        }

        int[] neighbours = new int[neighboursSize];

        for (int i = 0; i < neighboursSize; i++) {
            int indexFromSearch = indexes.getAtIndex(i);
            int indexNeighbour = indexFromSearch + 1;
            neighbours[i] = array[indexNeighbour];
        }

        return neighbours;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(String.format("%d ", array[i]));
        }
        System.out.println();
    }

    public void clear() {
        count = 0;
        size = LIST_DEFAULT_SIZE;
        array = new int[size];
        System.gc();
    }

    public void sort() throws Exception {
        if (isEmpty()) throw new Exception("Can't sort empty array");

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (array[i] > array[j]) {
                    swap(i, j);
                }
            }
        }
    }

    private void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private void resize() {
        int[] newArray = new int[size * 2];
        size = size * 2;

        // Alternative implementation
//        for (int i = 0; i < array.length; i++) {
//            newArray[i] = array[i];
//        }
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
        System.gc(); // teacher wanted it
    }


    private boolean isInvalidIndex(int index) {
        return index > size - 1 || index < 0;
    }
}
