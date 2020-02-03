package by.it.akhmelev.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String[] lastName=new String[n];
        for (int i = 0; i < lastName.length; i++) {
            lastName[i]=scanner.next();
        }

        int[][] salary=new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для "+lastName[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j]=scanner.nextInt();
            }
        }

        System.out.println("---------------------------------------------");
        System.out.println("Фамилия Кв1     Кв2     Кв3     Кв4     Итого ");
        System.out.println("---------------------------------------------");
        int allMoney=0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%7s:",lastName[i]);
            int sumRow=0;
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-8d",salary[i][j]);
                sumRow=sumRow+salary[i][j];
            }
            System.out.printf("%-8d\n",sumRow);
            allMoney=allMoney+sumRow;
        }
        System.out.println("Итого    "+allMoney);
        System.out.println("Итого    "+allMoney/4.0/n);

    }
}
