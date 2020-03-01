package by.it.lomazki.Example.jd01_00_02;

import java.util.Scanner;

public class TaskC2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("input number 1");
        int num1 = scanner.nextInt();
        System.out.println("input number 2");
        int num2 = scanner.nextInt();
        int sum = num1 + num2;

        System.out.println("DEC: " + num1 + "+" + num2 + "=" + sum);


    }
}
