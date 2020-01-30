package by.it.dolgiy.jd01_01;

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
        System.out.println("введите чила");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = i+j;
        String a = Integer.toBinaryString(i);
        String b = Integer.toBinaryString(j);
        String c = Integer.toBinaryString(k);
        String a1 = Integer.toHexString(i);
        String b1 = Integer.toHexString(j);
        String c1 = Integer.toHexString(k);
        String a2 = Integer.toOctalString(i);
        String b2 = Integer.toOctalString(j);
        String c2 = Integer.toOctalString(k);
        System.out.println("DEC:"+i+"+"+j+"="+k);
        System.out.println("BIN:"+a+"+"+b+"="+c);
        System.out.println("HEX:"+a1+"+"+b1+"="+c1);
        System.out.println("OCT:"+a2+"+"+b2+"="+c2);
    }

}
