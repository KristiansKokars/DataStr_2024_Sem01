package com.kristianskokars.datastructures;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Array;
import java.util.Arrays;


public class MyGenericList<T> {
    private final int LIST_DEFAULT_SIZE = 10;
    private final Class<T> clazz;
    private T[] array;
    private int size = LIST_DEFAULT_SIZE;
    private int count;

    public MyGenericList(Class<T> clazz) {
        this.clazz = clazz;
        array = createNewArray(size);
        count = 0;
    }

    public MyGenericList(Class<T> clazz, int size) {
        if (size <= 0) throw new IllegalArgumentException("Invalid array size");

        this.clazz = clazz;
        this.size = size;
        array = createNewArray(size);
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
        T[] newArray = createNewArray(size);
        size = size * 2;

        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void push(T number) {
        if (count == size) return;

        array[count] = number;
        count++;
    }

    // TODO: I do not remember if you could do direct [] overloading in Java
    public void addAtIndex(int index, T number) {
        if (isInvalidIndex(index)) return;

        array[index] = number;
    }

    public void deleteAtIndex(int index, T element) {
        // TODO: not sure what behaviour to do here for the task: throw or just do nothing?
        if (isInvalidIndex(index)) return;

        array[index] = null; // NullPointerExceptions here I come
    }

    public T getAtIndex(int index) {
        if (isInvalidIndex(index)) throw new ArrayIndexOutOfBoundsException();

        return array[index];
    }

    public int findElement(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return i;
            }
        }

        return -1;
    }

    @Nullable
    public T returnNextElement(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element && i != size - 1) {
                return array[i + 1];
            }
        }

        return null;
    }

    public void sort() {
        array = (T[]) Arrays.stream(array).sorted().toArray();
    }

    public void print() {
        System.out.println(array[2]);
        for (T element : array) {
            System.out.print(String.format("%d ", element));
        }
    }

    public void empty() {
        array = createNewArray(size);
    }

    private boolean isInvalidIndex(int index) {
        return index > size - 1 || index < 0;
    }

    @SuppressWarnings("unchecked")
    private T[] createNewArray(int size) {
        return (T[]) Array.newInstance(clazz, size);
    }
}
