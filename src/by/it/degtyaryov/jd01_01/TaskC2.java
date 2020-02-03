package by.it.degtyaryov.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74
*/

class TaskC2 {

    public static void main(String[] args) {

        int one, two, result;
        Scanner scanner = new Scanner(System.in);
        one = scanner.nextInt();
        two = scanner.nextInt();
        scanner.close();
        result = one + two;


        System.out.println("DEC:" + one + "+" + two + "=" + result + "\n" +
                "BIN:" + Integer.toString(one, 2) + "+" + Integer.toString(two, 2) + "=" + Integer.toString(result, 2) + "\n" +
                "HEX:" + Integer.toString(one, 16) + "+" + Integer.toString(two, 16) + "=" + Integer.toString(result, 16) + "\n" +
                "OCT:" + Integer.toString(one, 8) + "+" + Integer.toString(two, 8) + "=" + Integer.toString(result, 8));
    }

}
