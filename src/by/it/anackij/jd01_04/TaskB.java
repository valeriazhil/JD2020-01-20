package by.it.anackij.jd01_04;

import java.util.Scanner;

public class TaskB {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int workers = scanner.nextInt();

        String[] arrayOfNames = new String[workers];
        for (int i = 0; i < arrayOfNames.length; i++) {
            if (scanner.hasNextLine()) arrayOfNames[i] = scanner.next();
        }

        int[][] salary = new int[workers][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%s%s%s", "Введите зарплату для ", arrayOfNames[i], ":");
            System.out.println();
            for (int j = 0; j < salary[0].length; j++) {
                if (scanner.hasNextInt())
                salary[i][j] = scanner.nextInt();
            }
        }
        System.out.println();
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
        System.out.printf("%-11s%-8.4f%n", "Средняя", ((sumTotal/4.0/salary.length)));
    }

}



