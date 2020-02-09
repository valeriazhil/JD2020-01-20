package by.it.zhilenkova.jd01.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i <= mas.length - 1; i++) {
            mas[i] = scanner.nextInt();
        }

        step1(mas); // Выводит минимальное и максимальное значения массива через пробел
        step2(mas); // Выводит толлько те значения, которые строго меньше среднего арифметического
        step3(mas); // Выводит индекс минимального значения или индексы минимальных через пробел, если их несколько одинаковых
    }

    private static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int element : mas) {
            if (min > element) min = element;
            if (max < element) max = element;

        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] mas) {
        double sum = 0;
        for (int element : mas) {
            sum = sum + element;
        }
        double avg = sum / mas.length;
        for (int element : mas) {
            if (element < avg)
                System.out.print(element + " ");
        }
    }

    private static void step3(int[] mas) {
        int min = mas[0];
        for (int element : mas) {
            if (min > element) min = element;
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min)
                System.out.print(i + " ");
        }
    }
}
