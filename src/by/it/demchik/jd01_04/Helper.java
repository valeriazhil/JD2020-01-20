package by.it.demchik.jd01_04;


import java.util.Scanner;

public class Helper {
    public static void main(String[] args) {
    }


    static double findMax(double[] arr) {
        Scanner scanner = new Scanner(System.in);
        if (0 == arr.length) {
            return Integer.MAX_VALUE;

        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    static double findMin(double[] arr) {
        Scanner scanner = new Scanner(System.in);
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr)
                if (min > m) min = m;

            return min;

        }
    }









        static void sort ( double[] a) {
            for (int i = a.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (a[j] > a[j + 1]) {
                        double tmp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = tmp;
                    }
                }
            }
        }
}










