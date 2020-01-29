package by.it.gerasimov.jd01_02;

import java.util.Scanner;

public class TaskC {

    static int[][] step3(int[][] array1) {
        int n = array1.length;
        int[] row = new int[n];
        int[] col = new int[n];
        int rowCount = 0;
        int colCount = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array1[i][j] > max) {
                    max = array1[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array1[i][j] == max) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (row[i] == 1) {
                rowCount += 1;
            }
            if (col[i] == 1) {
                colCount += 1;
            }
        }
        int i1 = 0;
        int[][] array2 = new int[n-rowCount][n-colCount];
        for (int i = 0; i < n; i++) {
            if (row[i] == 0) {
                int j1 = 0;
                for (int j = 0; j < n; j++) {
                    if (col[j] == 0) {
                        array2[i1][j1] = array1[i][j];
                        j1++;
                    }
                }
                i1++;
            }
        }
        return array2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) (Math.random() * 100);
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        int[][] array2 = step3(array);
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
