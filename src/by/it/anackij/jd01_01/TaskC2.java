package by.it.anackij.jd01_01;

import java.math.BigInteger;
import java.sql.Struct;
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
        Scanner sc = new Scanner(System.in);
        int i1 = sc.nextInt();
        int i2 = sc.nextInt();
        int sum = i1 + i2;
        System.out.println("DEC:" + i1 + "+" + i2 + "=" + sum);

        String convertBinaryArg1 = Integer.toBinaryString(i1);
        String convertBinaryArg2 = Integer.toBinaryString(i2);
        String convertBinarySum = Integer.toBinaryString(sum);
        System.out.println("BIN:" + convertBinaryArg1 + "+" + convertBinaryArg2 + "=" + convertBinarySum);

        String convertHexArg1 = Integer.toHexString(i1);
        String convertHexArg2 = Integer.toHexString(i2);
        String convertHexSum = Integer.toHexString(sum);
        System.out.println("HEX:" + convertHexArg1 + "+" + convertHexArg2 + "=" + convertHexSum);

        String convertOctalArg1 = Integer.toOctalString(i1);
        String convertOctalArg2 = Integer.toOctalString(i2);
        String convertOctalSum = Integer.toOctalString(sum);
        System.out.println("OCT:" + convertOctalArg1 + "+" + convertOctalArg2 + "=" + convertOctalSum);

    }
}
