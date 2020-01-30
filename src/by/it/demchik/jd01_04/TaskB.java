package by.it.demchik.jd01_04;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//запускаем сканер,имя сканера scanner.
        int n = scanner.nextInt();//ищем интовое значение  сканером,значение для поиска к-ва сотрудников
        String[] lastName = new String[n];//ищем строку стринг с фамилиями при помощу сканера

        //узнаем массив с фамилиями
        for (int i = 0; i < lastName.length; i++) {//перебираем значение зарплат
            lastName[i] = scanner.next();//ищем для каждого значения из массива ЗП, в соотвветсвии с нахождением в массиве
        }
        //узнаем массов зп, квартал
        int[][] selary = new int[n][4];//создаем интовый массив со значением п-колв строк(сотр) и [4]кол-во месяцв
        for (int i = 0; i < selary.length; i++) {//перебираем массив
            System.out.println("Введите зарплату для " + lastName[i]);
            for (int j = 0; j < 4; j++) {
                selary[i][j] = scanner.nextInt();
            }
        }

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Фамилия   Квартал1      Квартал2      Квартал3     Квартал4        Итого");
        System.out.println("-------------------------------------------------------------------------");

        int allMoney = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("" + lastName[i] + ":      ");

            int sumRow = 0;
            for (int j = 0; j < 4; j++) {
                int a=j;
                System.out.printf("%-14d", selary[i][j]);
                sumRow = sumRow + selary[i][j];

            }
            System.out.printf("%-18d\n", sumRow);
            allMoney = allMoney + sumRow;


        }

        System.out.println("Итого:       " + allMoney);

        System.out.println("Итого:       " + allMoney / 4.0 / n);
    }
}