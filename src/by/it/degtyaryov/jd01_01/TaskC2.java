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

        System.out.printf("DEC:%d+%d=%d%n", one, two, result);
        System.out.printf("BIN:%s+%s=%s%n", Integer.toBinaryString(one), Integer.toBinaryString(two), Integer.toBinaryString(result));
        System.out.printf("HEX:%s+%s=%s%n", Integer.toHexString(one), Integer.toHexString(two), Integer.toHexString(result));
        System.out.printf("OCT:%s+%s=%s%n", Integer.toOctalString(one), Integer.toOctalString(two), Integer.toOctalString(result));
    }
}