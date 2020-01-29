package by.it.lomazki.Example;

import java.util.Scanner;

public class TaskC3 {
    public static void main(String[] args) {

        double mars = 3.86;
        double earth = 9.81;
        System.out.println("your weight");
        Scanner scanner = new Scanner(System.in);
        int weight = scanner.nextInt();
        double weightMars = weight/mars*earth;

        System.out.println(weightMars);
    }
}
