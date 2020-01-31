package by.it.kondratev.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        //step1(n);
        int [][] mas=new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mas[i][j] = (int)(Math.random()*21-10);
        //step2(mas);
        //step3(mas)
    }


    static int[][] step1(int n) {
        int [][] mas=new int[n][n];
        boolean h1=true, h2=true;
        while (h1 && h2){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double d=Math.random()*2*n;
                    mas[i][j] = (int)Math.round(d)-n;
                    if (mas[i][j] == n) h1 = false;
                    if (mas[i][j] == -n) h2 = false;
                }
             }
            if(h1==h2 && h1==false) break;
            else {h1=true; h2=true;}
        }   ;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j] + " ");}
                System.out.println();

        }
     return mas;
    }

    static int step2(int[ ][ ] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            int s = 0;
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > 0) s++;
                if (s == 2)
                    for (int k = j - 1; k >= 0; k--) {
                        if (mas[i][k] <= 0) sum += mas[i][k];
                        else break;
                    }
            }
        }
        System.out.println("Сумма = "+sum);
        return sum;
    }


}
