package by.it.kondratev.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число работников: ");
        int n = sc.nextInt();

        System.out.println("Введите фамилии работников");
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Работник №" + (i + 1) + ": ");
            name[i] = sc.next();
            System.out.println();
        }

        int[][] cash = new int[n][4];

        for (int i = 0; i < n; i++) {
            System.out.print("Введите квартальные зарплаты для работника " + name[i] + ":  ");
            for (int k = 0; k < 4; k++) {
                cash[i][k] = sc.nextInt();
            }
            System.out.println();
        }

        double year = 0;

        System.out.println("Фамилия      Квартал_1  Квартал_2  Квартал_3  Квартал_4  Итого");
        System.out.println("_______________________________________________________");
        for (int i = 0; i < n ; i++) {
            int itog=0;
            System.out.printf("%-13s",name[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-11d",cash[i][j]);
                itog+= cash[i][j];
            }
            System.out.printf("%-8d", itog);
            year+= itog;
            System.out.println();
        }
        System.out.println("_______________________________________________________");

        System.out.println("Общая годовая зарплата: "+year);
        double sr = year/(n*4);
        System.out.printf("Средняя квартальная зарплата: %6.4f",sr);
    }
}


