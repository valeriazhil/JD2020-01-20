package by.it.zhilenkova.jd01.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должна появится в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = new int[2];
        System.out.println("Insert array elements:");
        for (int i = 0; i < 2; i++) {
            array[i] = scanner.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.print ("Inserted array elements:");
        for (int i = 0; i < 2; i++) {
            System.out.print (" " + array[i]);
        }
        System.out.println();
        int sum=0;
        for(int i=0; i<array.length; i++) {
            sum=sum+array[i];
        }
        System.out.println("Sum" + " " + "=" +  " " + sum);


    }


}
