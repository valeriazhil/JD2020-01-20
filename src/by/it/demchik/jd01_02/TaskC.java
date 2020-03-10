package by.it.demchik.jd01_02;



import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner tv = new Scanner(System.in);
        int n = tv.nextInt();
        int[][] mas = step1(n);
        step2(mas);


    }



    static int[][] step1(int n) {

        int[][] mas = new int[n][n];
        boolean max = false;
        boolean min = false;
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                    if (mas[i][j] == n) {
                        max = true;
                    }
                    if (mas[i][j] == -n) {
                        min = true;
                    }
                }

            }

        }
        while (!max || !min);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(mas[i][j] + " ");

            }

                   }
        return mas;
    }

    static int step2 (int[][] mas) {
        int n = mas [0].length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                sum = -mas[i][j];
            }
        }return sum;
    }


}



