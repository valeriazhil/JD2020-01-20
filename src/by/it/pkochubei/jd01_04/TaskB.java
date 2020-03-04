package by.it.pkochubei.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = scanner.next();
        }
        int z = 4;
        int[][] salary = new int[n][z];
        int[] summSalary = new int[n];
        int summ = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + name[i]);
            for (int j = 0; j < z; j++) {
                salary[i][j] = scanner.nextInt();
                summSalary[i] += salary[i][j];
            }
            summ += summSalary[i];
        }
        double average = (double) summ / (n * z);
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-14s ", "Фамилия");
        for (int j = 0; j < z; j++) {
            System.out.printf("Квартал %-3d ", j + 1);
        }
        System.out.println("Итого");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-13s: ", name[i]);
            for (int j = 0; j < z; j++) {
                System.out.printf("%-11d", salary[i][j]);
            }
            System.out.println(summSalary[i]);
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-13s %d\n", "Итого", summ);
        System.out.printf("%-13s %.4f\n", "Средняя", average);
    }
}
