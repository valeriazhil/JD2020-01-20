package by.it.makarenko.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int men = sc.nextInt();
        System.out.println(men);
        String famil = sc.next();
        String famil1 = sc.next();
        String famil2 = sc.next();
        String [] arrayFam = {famil,famil1,famil2};
        for (int i = 0; i <arrayFam.length ; i++) {
            System.out.println(arrayFam[i]);
        }
        int x=4;
        int y=4;
        int [][] cash = new int[x][4];
        for (int i = 0; i <x ; i++) {
            cash[i]=new int[x];
            for (int j = 0; j <y ; j++) {
                cash[i][j] = sc.nextInt();
            }
        }
        System.out.println(cash[x][y]);
    }
}
