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
        String[] arrayFam = {famil, famil1, famil2};
        for (int i = 0; i < arrayFam.length; i++) {
            System.out.println(arrayFam[i]);
        }
        System.out.println("Введите зарплату для " + famil);
        int zarPlat = sc.nextInt();
//      int[] arrFamil = new int[zarPlat];
//      for (int i = 0; i < arrayFam.length; i++) {
//          arrFamil[i]=arrFamil[i];
//      }

        System.out.println("Введите зарплату для " + famil1);
        int zarPlat1 = sc.nextInt();
//        int[] arrFamil1 = new int[zarPlat1];
//        for (int i = 0; i < arrFamil1.length; i++) {
//        arrFamil1[i]=arrFamil1[i];
//        }
        System.out.println("Введите зарплату для " + famil2);
        int zarPlat2 = sc.nextInt();
//        int[] arrFamil2 = new int[zarPlat2];
//        for (int i = 0; i < arrFamil2.length; i++) {
//        arrFamil2[i]=arrFamil2[i];
//        }
    }
}