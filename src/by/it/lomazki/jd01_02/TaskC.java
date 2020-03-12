package by.it.lomazki.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = step1(n);
        System.out.println(Arrays.deepToString(array));
        step2(array);
    }

    static int[][] step1(int n) {
        Random rnd = new Random();
        int[][] mas = new int[n][n];
        boolean masOk = false;
        while (!masOk) {
            boolean min = false;
            boolean max = false;
            for (int row = 0; row < mas.length; row++) {
                for (int coll = 0; coll < mas[row].length; coll++) {
                    mas[row][coll] = n - rnd.nextInt(n + n + 1);
                    if (mas[row][coll] == -n) {
                        min = true;
                    } else if (mas[row][coll] == n) {
                        max = true;
                    }
                }
            }
            masOk = max && min;
            if (!masOk)
                for (int i = 0; i < mas.length; i++) {
                    for (int j = 0; j < mas[i].length; j++) {
                        System.out.print(mas[i][j] + " ");
                    }
                    System.out.println();
                }
        }
        return mas;
    }

    static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] >=0){
                    do {
                        sum = sum+mas[i][j];
                    }while (mas[i][j]<=0);
                    System.out.println(sum);
                }
            }
        }
        return sum;
    }


}



