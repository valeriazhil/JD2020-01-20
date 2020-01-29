package by.it.anackij.jd01_04;

import java.io.PrintStream;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfPeople = scanner.nextInt();
//        System.out.println("Enter names:");

        String[] arrayOfNames = new String[amountOfPeople];
        Scanner surname = new Scanner(System.in);
        for (int i = 0; i < arrayOfNames.length; i++) {
            if (surname.hasNextLine()) arrayOfNames[i] = surname.next();
        }

        int[][] salary = new int[amountOfPeople][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%s%s%s", "Введите зарплату для ", arrayOfNames[i], ":");
            Scanner money = new Scanner(System.in);
            for (int j = 0; j < salary[0].length; j++) {
                if (money.hasNextInt())
                salary[i][j] = money.nextInt();
            }
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%10s%-8s%-8s%-8s%-8s%-8s%n", "Фамилия", " Квартал1", " Квартал2", " Квартал3", " Квартал4", " Итого");

        int sum = 0;
        int sumTotal = 0;
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%9s%s", arrayOfNames[i], ": ");
            for (int j = 0; j < salary[0].length; j++) {
                System.out.printf("%-8d ", salary[i][j]);
                sum+=salary[i][j];
            }
            System.out.printf("%-8d%n", sum);
            sumTotal+= sum;
            sum = 0;
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-11s%d%n", "Итого", sumTotal);
        System.out.printf("%-11s%-8.4f%n", "Средняя", ((double)(sumTotal/(salary.length*salary[0].length))));

    }
}
