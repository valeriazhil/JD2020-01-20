package by.it.gerasimov.jd01_02;

import java.util.Scanner;

class TaskA {
    static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            else if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(min + " " + max);
    }
    static void step2(int[] array) {
        double sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
        }
        double avg = sum / array.length;
        for (int value : array) {
            if (value < avg) {
                System.out.print(value + " ");
            }
        }
    }
    static void step3(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            array[i] = scanner.nextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }
}
