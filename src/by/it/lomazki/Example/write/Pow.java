package by.it.lomazki.Example.write;

import java.util.Scanner;

public class Pow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int N = scanner.nextInt();
        int sum = 1;

        for (int i = 0; i <= N; i++) {
            sum = sum * a;
        }

        System.out.println(sum);
    }
}
