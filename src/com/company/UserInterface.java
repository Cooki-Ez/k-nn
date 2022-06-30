package com.company;


import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);

    public UserInterface(String trainingExample, String testExample){
        System.out.println("Enter info");
        String line = sc.nextLine();
        new Reader(trainingExample, testExample, line);
    }
}
