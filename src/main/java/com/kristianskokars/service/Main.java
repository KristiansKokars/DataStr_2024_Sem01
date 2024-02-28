package com.kristianskokars.service;

import com.kristianskokars.datastructures.MyList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        list2.print();
    }
}