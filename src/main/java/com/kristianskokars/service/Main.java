package com.kristianskokars.service;

import com.kristianskokars.datastructures.MyList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList(5);
        list.push(11);
        list.push(9);
        list.push(2);
        list.push(4);
        list.push(6);

        list.sort();
        System.out.println(list.returnNextElement(11));
        list.print();


        ArrayList<Integer> newList = new ArrayList<>();
    }
}