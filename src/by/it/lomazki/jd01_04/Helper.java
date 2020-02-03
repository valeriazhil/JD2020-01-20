package by.it.lomazki.jd01_04;

import java.util.Scanner;


public class Helper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  str = scanner.nextLine();
        double[] arr = new double[str.length()];
        System.out.println(findMin(arr));
        System.out.println(findMax(arr));
        sort (arr);
        printArray (arr);
        for (double i:arr) System.out.print(i + " ");
        System.out.println();

    }

     static double findMin(double[] arr) {
        if (0 == arr.length)
            return Integer.MIN_VALUE;
        else {
            double min = arr[0];
            for (int m = 0; m < arr.length; m++) {
                if (min > arr[m])
                    min = arr[m];
            }
            return min;
        }
    }

     static double findMax(double[ ] arr) {
        if (0 == arr.length)
            return Integer.MAX_VALUE;
        else {
            double max = arr[0];
            for (int m = 0; m < arr.length; m++) {
                if (max < arr[m])
                    max = arr[m];
            }
            return max;
        }
    }


    static void sort(double[ ] arr) {
        boolean swap;
        int last = arr.length;
        do {
            swap = false;
            for (int j = 0; j < last-1; j++) {
                if (arr[j] > arr[j+1]) {
                    double buffer = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
    }
    static  void printArray (double [] arr) {
        for (double element : arr) {
            System.out.println(element + " ");
        }
    }
}
