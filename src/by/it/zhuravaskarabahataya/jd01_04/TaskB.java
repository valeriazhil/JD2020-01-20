package by.it.zhuravaskarabahataya.jd01_04;

import java.util.Scanner;

//вопросы: вставлять текст как комменты
public class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); //иначе никак???
        String [] workers = new String[n];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = sc.nextLine();
        }

        int[][] salary = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Enter salary for " + workers[i] + ", please.");
            for (int j = 0; j < salary[0].length; j++) {
                salary[i][j] = sc.nextInt();
            }
        }

        int[] sumOfTheYear = new int[n];
        int sumOfSalaries = 0;
        for (int i = 0; i < sumOfTheYear.length; i++) {
            for (int j = 0; j < salary[0].length; j++) {
                sumOfTheYear[i] += salary[i][j];

            }
            sumOfSalaries += sumOfTheYear[i];
        }

        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-10s%-12s%-12s%-12s%-12s%-6s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < workers.length; i++) {
            System.out.printf("%8s:  %-12d%-12d%-12d%-12d%-6d\n", workers[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], sumOfTheYear[i]);
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-12s%d\n", "Итого", sumOfSalaries);
        System.out.printf("%-12s%-11.5f", "Средняя", (double)sumOfSalaries/(4*n));
    }
}
