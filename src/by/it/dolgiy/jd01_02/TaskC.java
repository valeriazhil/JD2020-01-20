package by.it.dolgiy.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class TaskC {

    private static Random rnd = new Random();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas= step1(n);
        System.out.println(Arrays.deepToString(mas));

    }

    private static int[][] step1(int n) {
        int[][] res = new int[n][n];
        boolean maxOk;
        boolean minOk;
        do {
            maxOk = false;
            minOk = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j]=rnd.nextInt(2*n+1)-n;
                    if (res[i][j] == n) maxOk = true;
                    if (res[i][j] ==-n) minOk = true;
                }
            }
        } while (!maxOk || !minOk);
        return res;
    }


}
