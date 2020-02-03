package by.it.lomazki.jd01_01;

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

import java.util.Scanner;

class TaskC2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i=sc.nextInt();
        int n=sc.nextInt();
        int sum = i+n;

        String BINi = Integer.toBinaryString(i);
        String BINn = Integer.toBinaryString(n);
        String BINsum = Integer.toBinaryString(sum);

        String HEXi = Integer.toHexString(i);
        String HEXn = Integer.toHexString(n);
        String HEXsum = Integer.toHexString(sum);

        String OCTi = Integer.toOctalString(i);
        String OCTn = Integer.toOctalString(n);
        String OCTsum = Integer.toOctalString(sum);

        System.out.println("DEC:" + i + "+" + n + "=" + sum);
        System.out.println("BIN:" + BINi + "+" + BINn + "=" + BINsum);
        System.out.println("HEX:" + HEXi + "+" + HEXn + "=" + HEXsum);
        System.out.println("OCT:" + OCTi + "+" + OCTn + "=" + OCTsum);
    }

}
