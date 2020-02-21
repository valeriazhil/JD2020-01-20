package by.it.lomazki.Example.april_day;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sc  = scanner.nextLine();
        String scMonth = sc.trim().toUpperCase();
        MyClass.operation (scMonth);

    }
}

