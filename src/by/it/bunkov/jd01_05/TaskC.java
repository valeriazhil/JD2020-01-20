package by.it.bunkov.jd01_05;

import static java.lang.StrictMath.random;

import static java.lang.Math.*;

public class TaskC {

    public static void main(String[] args) {

        step6();


    }

    private static void step6() {
        double[] array = createArrayFrom20To40();
        fillArray(array);
        double mean = geometricMean(array);
        System.out.println("Mean = " + mean);
    }

    private static double[] createArrayFrom20To40() {
        int n = (int) (random() * 21) + 20;
        return new double[n];
    }

    private static void fillArray(double[] array) {
        double deltaX = (9 - 5.33) / (array.length);
        System.out.println("array length = " + array.length);
        System.out.println("delta x = " + deltaX);
        double x = 5.33;
        for (int i = 0; i < array.length; i++) {
            array[i] = cbrt(x * x + 4.5);
            x += deltaX;
        }
        printArray(array, "V", 4);
    }

    private static double geometricMean(double[] array) {
        int countOfMoreThen3point5 = 0;
        for (double a : array) {
            if (a > 3.5) {
                countOfMoreThen3point5++;
            }
        }
        double[] arrayMoreThen3point5 = new double[countOfMoreThen3point5];
        int count = 0;
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                arrayMoreThen3point5[count] = array[i];
                sum += arrayMoreThen3point5[count++];
            }
        }
        double mean = sum / countOfMoreThen3point5;
        printArray(arrayMoreThen3point5, "V", 4);

        return mean;
    }

    private static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[ %-2d] = %-8.6f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }


}
