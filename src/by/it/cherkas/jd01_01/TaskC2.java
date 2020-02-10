package by.it.cherkas.jd01_01;

import java.util.Scanner;

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
        int a =sc.nextInt();
        int b =sc.nextInt();
        int sum = a + b;

        System.out.print("DEC:");
        System.out.println(a + "+" + b + "=" + sum);

        String a_tobin = Integer.toBinaryString(a);
        String b_tobin = Integer.toBinaryString(b);
        String sum_tobin = Integer.toBinaryString(sum);

        System.out.print("BIN:");
        System.out.println(a_tobin + "+" + b_tobin + "=" + sum_tobin);

        String a_tohex = Integer.toHexString(a);
        String b_tohex = Integer.toHexString(b);
        String sum_tohex = Integer.toHexString(sum);

        System.out.print("HEX:");
        System.out.println(a_tohex + "+" + b_tohex + "=" + sum_tohex);

        String a_tooct = Integer.toOctalString(a);
        String b_tooct = Integer.toOctalString(b);
        String sum_tooct = Integer.toOctalString(sum);

        System.out.print("OCT:");
        System.out.println(a_tooct + "+" + b_tooct + "=" + sum_tooct);
    }
}