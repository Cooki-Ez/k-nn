package com.company;


import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int k = 3;



    public static void main(String[] args) {
        start();
    }
    public static void start(){
        System.out.println("Enter 1 to change path to TRAIN from.");
        System.out.println("Enter 2 to change path to TEST from.");
        System.out.println("Enter 3 to change k (3 by default)");
        System.out.println("Enter 4 to input manually");
        System.out.println("Enter 5 to start");
        System.out.println("Enter 6 to exit");
        String trainingExample = "iris.data.csv";
        String testExample = "iris.test.data.csv";
        int fromUser = sc.nextInt();
        switch (fromUser) {
            case 1 -> {
                System.out.println("Path to TRAIN file");
                trainingExample = sc.nextLine();
            }
            case 2 -> {
                System.out.println("Path to TEST file");
                testExample = sc.nextLine();
            }
            case 3 -> {
                System.out.println("New k");
                k = sc.nextInt();
            }
            case 4 -> new UserInterface(trainingExample, testExample);
            case 5 -> new Reader(trainingExample, testExample);
            case 6 -> System.exit(1);
        }

        start();
    }

}
