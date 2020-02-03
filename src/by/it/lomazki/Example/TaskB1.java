package by.it.lomazki.Example;

import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        System.out.println("input number pls");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println("Квадрат числа равен: ");
        System.out.println(a * a);
    }
}
