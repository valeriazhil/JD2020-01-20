package by.it.cherkas.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] surname = new String[n];
        for (int i = 0; i < surname.length; i++) {
            surname[i] = scanner.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + surname[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();

            }
        }
        System.out.println("_____________________________________________________________");
        System.out.println("Фамиоия Квартал 1  Квартал 2  Квартал 3  Квартал  4");
        System.out.println("_____________________________________________________________");
        for (int i = 0; i < n; i++) {
            System.out.printf("%7s:\n", surname[i]);

        int sumRow=0;
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-8d", salary[i][j]);
            }
            System.out.printf("%7s", surname[i]);
        }
    }

}

