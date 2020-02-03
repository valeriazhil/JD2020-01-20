package by.it.lomazki.Example.jd01_04;

import java.util.Scanner;

public class TaskBB {
    public static void main(String[] args) {

        System.out.println("Число людей: ");
        Scanner scN = new Scanner(System.in);
        int nPeople = scN.nextInt();
        String [] names = new String[nPeople];
        for (int i = 0; i <= names.length-1; i++) {
            System.out.println("Фамилия " + (i+1));
            names[i] = scN.next();
        }
        int [][] salary = new int[nPeople][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + names[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scN.nextInt();
            }
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        int allMoney = 0;
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%7s:", names[i]);
            int sumRow = 0;
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-8d", salary[i][j]);
                sumRow = sumRow + salary[i][j];
            }
            System.out.printf("%-8d\n", sumRow);
            allMoney = allMoney + sumRow;
        }
        System.out.println("Итого     " + allMoney);
        System.out.println("Итого     " + allMoney/4.0/salary.length);
    }
}
