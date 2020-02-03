package by.it.anackij.jd01_02;

import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
        step2(step1(n));

    }

    private static int[][] step1(int n) {
        boolean lowBorder, upBorder, border;
        lowBorder = upBorder = border = false;
        Random random = new Random();
        int mas[][] = new int[n][n];
        do {
            for (int i = 0; i < mas.length; i++) {
                for (int i1 = 0; i1 < mas.length; i1++) {
                    mas[i][i1] = random.nextInt(2 * n + 1) - n; // [-6;6] - от 6+6 =12 и еще 0 - 12+1=13, тогда [0;13] - 6
                    System.out.print(mas[i][i1] + " ");
                    if (mas[i][i1] == -n) {
                        lowBorder = true;
                    }
                    if (mas[i][i1] == n) {
                        upBorder = true;
                    }
                }
                if (lowBorder && upBorder)
                    border = true;
                System.out.println();
            }
            System.out.println();
            System.out.println();
        } while (!border);
        return mas;
    }

    private static int step2(int[][] mas) {
        int sum = 0;
        int intIn = 0;
        int intOut = 0;
        boolean in = false;
        boolean out = false;
        for (int i = 0; i < mas.length; i++) {
            for (int i1 = 0; i1 < mas.length; i1++) {
                if (mas[i][i1] > 0) {
                    sum += mas[i][i1];
                    for (int i2 = i1; i2 < mas.length; i2++) {
                        if (mas[i][i2] > 0) {
                            out = true;
                        }
                    }
                }
            }
            if (!out) {
                sum = 0;
            }
            System.out.println("sum of raw " + i + " =" + sum);
        }

        return sum;

    }

    public int[][] step3(int[][] array) {
        int max = Integer.MAX_VALUE;
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
        int cols = 0;
        for (boolean element : delRows) {
            if (!element) rows++;
        }
        for (boolean element : delCols) {
            if (!element) cols++;
        }

        int[][] res = new int[rows][cols];

        int ir = 0;
        for (int i = 0; i < array.length; i++) {
            if (!delRows[i]) {
                int jr = 0;
                for (int j = 0; j < array[i].length; j++) {

                }
            }
        }
        return res;
    }


}
