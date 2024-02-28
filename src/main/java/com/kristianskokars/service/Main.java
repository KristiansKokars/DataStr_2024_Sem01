package com.kristianskokars.service;

import com.kristianskokars.datastructures.MyList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        var list2 = new MyList(2);
        try {
            var file = new File("numbers.txt");
            var reader = new Scanner(file);
            while (reader.hasNextLine()) {
                var number = Integer.parseInt(reader.nextLine());
                list2.push(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Testing file reading, should be: 1 2 3 4 5 6\nResult: ");
        list2.print();
        printDivider();

        // isFull
        System.out.println("Testing isFull, should be: false\nResult: ");
        System.out.println(list2.isFull());
        list2.print();
        printDivider();

        list2.push(9);
        list2.push(9);

        System.out.println("Testing isFull, should be: true\nResult: ");
        System.out.println(list2.isFull());
        printDivider();

        // isEmpty
        System.out.println("Testing isEmpty, should be: false\nResult: ");
        System.out.println(list2.isEmpty());
        list2.print();
        printDivider();

        list2.clear();

        // isClear
        System.out.println("Testing isEmpty and if isClear worked, should be: true\nResult: ");
        System.out.println(list2.isEmpty());
        list2.print();
        printDivider();

        // getCount
        System.out.println("Testing getCount, should be: 0\nResult: ");
        System.out.println(list2.getCount());

        list2.push(1);
        list2.push(2);

        System.out.println("Testing getCount, should be: 2\nResult: ");
        System.out.println(list2.getCount());
        list2.print();
        printDivider();

        // addAtIndex
        System.out.println("Testing addAtIndex, should be: 1 9 2\nResult: ");
        list2.addAtIndex(1, 9);
        list2.print();
        printDivider();

        // deleteAtIndex
        System.out.println("Testing deleteAtIndex, should be: 1 2\nResult: ");
        list2.deleteAtIndex(1);
        list2.print();
        printDivider();

        // getAtIndex
        System.out.println("Testing getAtIndex, should be: 2\nResult: ");
        System.out.println(list2.getAtIndex(1));
        list2.print();
        printDivider();

        // findNumber
        list2.push(4);
        list2.push(6);
        list2.push(7);
        list2.push(3);
        list2.push(3);
        list2.push(5);
        list2.print();
        System.out.println("Testing findNumber, should be: 5 6\nResult: ");
        list2.findNumber(3).print();
        list2.print();
        printDivider();

        // returnNextElement
        System.out.println("Testing returnNextElement, should be: 7\nResult: ");
        System.out.println(list2.returnNextElement(6));
        list2.print();
        printDivider();

        System.out.println("Testing returnNextElement, should be: -1\nResult: ");
        list2.returnNextElement(2);
        list2.print();
        printDivider();

        // sort
        System.out.println("Testing sort");
        list2.sort();
        list2.print();
    }

    private static void printDivider() {
        System.out.println("===============================================");
    }
}