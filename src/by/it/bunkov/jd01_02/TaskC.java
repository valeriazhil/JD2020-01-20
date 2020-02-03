package by.it.bunkov.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    }


    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];

        int min = -n;

        int max = n;

        int m = n + 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                arr[i][j] = (int) Math.round((Math.random() * 2 * n) - n); //(int) ((Math.random() * (2 * n + 1) - (n + 1))); //(int) Math.round((Math.random() * 2*n) - n);

                while (arr[i][j] > min && arr[i][j] < max) {

                    arr[i][j] = (int) Math.round((Math.random() * (2 * m) - m)); //(int) ((Math.random() * (2 * n + 1) - (n + 1))); //(int) Math.round((Math.random() * 2*n) - n);

                    if (arr[i][j] >= min && arr[i][j] <= max) {

                        break;

// return arr;

                    }

                }

            }

        }

        for (int[] anArr : arr) {

            for (int anAnArr : anArr) {

                System.out.print(anAnArr + " ");

            }

            System.out.println();

        }

        return arr;

    }


    private static int step2(int[][] mas) {


        int sum = 0;
        for (int[] row : mas) {
            boolean start = false;
            boolean stop = false;
            int sumRow = 0;
            for (int value : row) {
                if (value > 0) {
                    if (start) {
                        stop = true;
                        break;
                    }
                    start = true;
                }
                if (start)
                    sumRow += value;
            }
            if (stop) sum += sumRow;
        }

        for (int i = 0; i < mas.length; i++) {
            boolean betweenPositive = false;
            int localSum = 0;
            for (int j = 0; j < mas[i].length; j++) {
                if (betweenPositive) {
                    if (mas[i][j] > 0) {
                        sum += localSum;
                        break;
                    }
                    localSum += mas[i][j];
                } else {
                    if (mas[i][j] > 0) {
                        betweenPositive = true;
                    }
                }
            }
        }
        System.out.println(sum);
        return sum;
    }


    private static int[][] step3(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int element : row) {
                if (element > max)
                    max = element;
            }
        }
        boolean[] delRows = new boolean[array.length];
        boolean[] delCols = new boolean[array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max == array[i][j]) {
                    delRows[i] = true;
                    delCols[j] = true;

                }
            }
        }
        int rows = 0;
        for (boolean element : delRows) if (!element) rows++;
        int cols = 0;
        for (boolean element : delCols) if (!element) cols++;
        int[][] res = new int[rows][cols];

        int ir = 0;
        for (int i = 0; i < array.length; i++) {
            if (!delRows[i]) {
                int jr = 0;
                for (int j = 0; j < array[i].length; j++) {
                    if (!delCols[j]) {
                        res[ir][jr++] = array[i][j];

                    }
                }
                ir++;
            }

        }
        return res;


    }
}











