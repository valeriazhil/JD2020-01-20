package by.it.degtyaryov.jd01_04;

import java.util.Scanner;

/**
 * Класс для вывода таблицы со значениями зарплат по сотрудникам поквартально
 *
 * @author DEA
 */
class TaskB {

    private static final int QUARTERS = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countEmployee = scanner.nextInt();
        String[] lastNames = new String[countEmployee];
        // Заполнение массива фамилий фамилиями
        for (int i = 0; i < lastNames.length; i++) {
            lastNames[i] = scanner.next();
        }
        // Создание массива зарплат для каждого сотрудника по квартально
        int[][] salaries = new int[countEmployee][QUARTERS];
        for (int i = 0; i < countEmployee; i++) {
            System.out.printf("Введите зарплату для %s%n", lastNames[i]);
            for (int j = 0; j < QUARTERS; j++) {
                salaries[i][j] = scanner.nextInt();
            }
        }

        // Вывод в консоль шапки таблицы
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-9s %-10s %-10s %-10s %-10s %-6s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3",
                "Квартал4", "Итого");
        System.out.println("------------------------------------------------------------");

        int totalSum = 0;
        // Вывод в консоль строк таблицы по сотрудникам
        for (int i = 0; i < countEmployee; i++) {
            int quartersSum = salaries[i][0] + salaries[i][1] + salaries[i][2] + salaries[i][3];
            totalSum += quartersSum;
            System.out.printf("%9s %-10d %-10d %-10d %-10d %-5d%n", lastNames[i] + ":", salaries[i][0],
                    salaries[i][1], salaries[i][2], salaries[i][3], quartersSum);
        }
        System.out.println("------------------------------------------------------------");
        // Вывод в консоль итоговой суммы и средней суммы
        double averageSum = (double) totalSum / countEmployee / QUARTERS;
        System.out.printf("%-9s %-1d%n", "Итого", totalSum);
        System.out.printf("%-9s %-1.4f%n", "Средняя", averageSum);
    }
}