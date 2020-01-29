package by.it.degtyaryov.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        int[] mas = new int[10];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            mas[i] = scanner.nextInt();
        }

        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];

        for (int i : mas) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        System.out.println(min + " " + max);

    }

    static void step2(int[] mas) {
        double average;
        int sum = 0;

        for (int i : mas) {
            sum += i;
        }

        average = (double) sum / mas.length;

        for (int i : mas) {
            if (i < average) {
                System.out.println(i);
            }
        }
    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int i : mas) {
            min = Math.min(i, min);
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min) {
                System.out.print(i + " ");
            }
        }
    }

}
