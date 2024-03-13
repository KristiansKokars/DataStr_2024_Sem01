package com.kristianskokars.service;

import com.kristianskokars.datastructures.MyList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainService {
    public static void main(String[] args) throws Exception {
        var numbersFromFile = readFromFile(getResourcePath("numbers.txt"));

        System.out.println("Testing file reading, should be: 1 2 3 4 5 6\nResult: ");
        numbersFromFile.print();
        printDivider();

        // isFull
        System.out.println("Testing isFull, should be: false\nResult: ");
        System.out.println(numbersFromFile.isFull());
        numbersFromFile.print();
        printDivider();

        numbersFromFile.push(9);
        numbersFromFile.push(9);

        System.out.println("Testing isFull, should be: true\nResult: ");
        System.out.println(numbersFromFile.isFull());
        printDivider();

        // isEmpty
        System.out.println("Testing isEmpty, should be: false\nResult: ");
        System.out.println(numbersFromFile.isEmpty());
        numbersFromFile.print();
        printDivider();

        numbersFromFile.clear();

        // isClear
        System.out.println("Testing isEmpty and if isClear worked, should be: true\nResult: ");
        System.out.println(numbersFromFile.isEmpty());
        numbersFromFile.print();
        printDivider();

        // getCount
        System.out.println("Testing getCount, should be: 0\nResult: ");
        System.out.println(numbersFromFile.getCount());

        numbersFromFile.push(1);
        numbersFromFile.push(2);

        System.out.println("Testing getCount, should be: 2\nResult: ");
        System.out.println(numbersFromFile.getCount());
        numbersFromFile.print();
        printDivider();

        // addAtIndex
        System.out.println("Testing addAtIndex, should be: 1 9 2\nResult: ");
        numbersFromFile.addAtIndex(1, 9);
        numbersFromFile.print();
        printDivider();

        // deleteAtIndex
        System.out.println("Testing deleteAtIndex, should be: 1 2\nResult: ");
        numbersFromFile.deleteAtIndex(1);
        numbersFromFile.print();
        printDivider();

        // getAtIndex
        System.out.println("Testing getAtIndex, should be: 2\nResult: ");
        System.out.println(numbersFromFile.getAtIndex(1));
        numbersFromFile.print();
        printDivider();

        // findNumber
        numbersFromFile.push(4);
        numbersFromFile.push(6);
        numbersFromFile.push(7);
        numbersFromFile.push(3);
        numbersFromFile.push(3);
        numbersFromFile.push(5);
        numbersFromFile.print();
        System.out.println("Testing findNumber, should be: 5 6\nResult: ");
        numbersFromFile.findNumber(3).print();
        numbersFromFile.print();
        printDivider();

        // returnNextElement
        System.out.println("Testing returnNextElement, should be: 7\nResult: ");
        System.out.println(numbersFromFile.returnNextElement(6));
        numbersFromFile.print();
        printDivider();

        System.out.println("Testing returnNextElement, should be: -1\nResult: ");
        numbersFromFile.returnNextElement(2);
        numbersFromFile.print();
        printDivider();

        // sort
        System.out.println("Testing sort");
        numbersFromFile.sort();
        numbersFromFile.print();
    }

    private static String getResourcePath(String resource) {
        return MainService.class.getClassLoader().getResource(resource).getPath();
    }

    private static MyList readFromFile(String path) throws Exception {
        if (path == null || path.length() < 3) throw new Exception("File path is invalid");
        var fileList = new MyList();

        try {
            var file = new File(path);
            var reader = new Scanner(file);
            while (reader.hasNextLine()) {
                var number = Integer.parseInt(reader.nextLine());
                fileList.push(number);
            }
            reader.close();
            return fileList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private static void printDivider() {
        System.out.println("===============================================");
    }
}