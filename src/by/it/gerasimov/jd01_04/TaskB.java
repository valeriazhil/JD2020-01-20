package by.it.gerasimov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = scanner.next();
        }
        int m = 4;
        int[][] salary = new int[n][m];
        int[] summarySalary = new int[n];
        int summary = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + name[i]);
            for (int j = 0; j < m; j++) {
                salary[i][j] = scanner.nextInt();
                summarySalary[i] += salary[i][j];
            }
            summary += summarySalary[i];
        }
        double average = (double) summary / (n * m);
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-13s ", "Фамилия");
        for (int j = 0; j < m; j++) {
            System.out.printf("Квартал %-2d ", j + 1);
        }
        System.out.println("Итого");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%12s: ", name[i]);
            for (int j = 0; j < m; j++) {
                System.out.printf("%-11d", salary[i][j]);
            }
            System.out.println(summarySalary[i]);
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-13s %d\n", "Итого", summary);
        System.out.printf("%-13s %.4f\n", "Средняя", average);
    }
}
