package by.it.demchik.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

    }

    Scanner iv = new Scanner(System.in);
    int n = iv.nextInt();

    int[][] array = step1(n);

    //step2(array);
    //step3(array);


    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        boolean min = false;
        boolean max = false;
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = (int) (Math.random() * (3 * n + 1)) - n;
                    if (arr[i][j] == n) {
                        max = true;
                    }
                    if (arr[i][j] == -n) {
                        min = true;
                    }

                }
            }
        }
        while (!max || !min);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(arr[i][j] + " ");

            }
            System.out.println();

        }
        return arr;
    }
}