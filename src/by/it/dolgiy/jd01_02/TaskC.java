package by.it.dolgiy.jd01_02;

import java.util.Scanner;

class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas= new int[n][n];
        System.out.println(step1(n));


    }
    private static int[ ][ ] step1 (int n) {
        int[][] mas = new int[n][n];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = (int) ((Math.random() * (2 * n + 2)) - n - 1);
                if (mas[i][j] == n && mas[i][j] == -n)
                    return mas;
                    System.out.printf("% -3d",mas[i][j]);
            }
            System.out.println();
        }
        return mas;
    }


}
