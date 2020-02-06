package by.it.demchik.jd01_01;

import java.util.Scanner;

import static java.lang.Integer.toBinaryString;

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
        Scanner bn=new Scanner(System.in);
        int a=bn.nextInt();
        int b=bn.nextInt();
        int x=a+b;
        System.out.println("DEC:"+a+"+"+b+"="+x);
        System.out.println("BIN:"+ toBinaryString(a)+"+"+ toBinaryString(b)+"="+ toBinaryString(x));
        System.out.println("HEX:"+Integer.toHexString(a)+"+"+Integer.toHexString(b)+"="+Integer.toHexString(x));
        System.out.println("OCT:"+Integer.toOctalString(a)+"+"+Integer.toOctalString(b)+"="+Integer.toOctalString(x));



    }

}
