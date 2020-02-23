package by.it.dolgiy.jd01_02;

import java.util.Scanner;

class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i]=scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    private static void step1(int[] mas) {
            int min = mas[0];
            int max = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (min > mas[i])
                min = mas[i];
            if (max < mas[i])
                max = mas[i];
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] mas) {
        double sr=0;
        for (int element : mas) sr = sr + element;
        sr=sr/mas.length;
        for (int element : mas) {
            if (element < sr)
                System.out.print(element + " ");
        }
    }

    private static void step3(int[] mas) {
        int min = mas[0];
        for (int element : mas) {
            if (min > element) min = element;
        }
        for (int i = mas.length-1; i >=0; i--) {
            if (mas[i]==min)
                System.out.print(i + " ");
        }
    }
}
