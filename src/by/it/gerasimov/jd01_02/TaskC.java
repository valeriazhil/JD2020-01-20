package by.it.gerasimov.jd01_02;

import java.util.Scanner;

class TaskC {

    static int[][] step1(int n) {
        int[][] array = new int[n][n];
        boolean condition = false;
        while (!condition) {
            boolean isN = false;
            boolean isMinusN = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = (int) (Math.random() * (2*n + 1)) - n;
                    if (array[i][j] == n) {
                        isN = true;
                    }
                    else if (array[i][j] == -n) {
                        isMinusN = true;
                    }
                }
            }
            condition = isN && isMinusN;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    static int step2 (int[][] array) {
        int n = array[0].length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            boolean toCount = false;
            for (int j = 0; j < n; j++) {
                if (toCount) {
                    if (array[i][j] > 0) {
                        break;
                    }
                    else {
                        sum += array[i][j];
                    }
                }
                else if (array[i][j] > 0) {
                    toCount = true;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    static int[][] step3 (int[][] array) {

        int n = array[0].length;
        int max = array[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }

        boolean[] rowMin = new boolean[n];
        boolean[] colMin = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == max) {
                    rowMin[i] = true;
                    colMin[j] = true;
                }
            }
        }

        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < n; i++) {
            if (!rowMin[i]) {
                rowCount++;
            }
            if (!colMin[i]) {
                colCount++;
            }
        }

        int[][] arrayNew = new int[rowCount][colCount];

        int i1 = 0;
        for (int i = 0; i < n; i++) {
            int j1 = 0;
            if (!rowMin[i]) {
                for (int j = 0; j < n; j++) {
                    if (!colMin[j]) {
                        arrayNew[i1][j1] = array[i][j];
                        System.out.print(arrayNew[i1][j1] + " ");
                        j1++;
                    }
                }
                System.out.println();
                i1++;
            }
        }

        return arrayNew;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = step1(n);
        step2(array);
        step3(array);
    }
}
