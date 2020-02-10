package by.it.zhilenkova.jd01.jd01_01;

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
        Scanner scanner = new Scanner(System.in);
        int num1;
        int num2;
        int sum;

        System.out.println("Insert array first element:");
        num1 = scanner.nextInt();
        System.out.println("Insert array second element:");
        num2 = scanner.nextInt();
        sum=num1+num2;

        System.out.println("DEC:" + num1 + "+" + num2 + "=" + sum);

        // Бинарный формат числа
        System.out.println("BIN:" + Integer.toBinaryString(num1) + "+" + Integer.toBinaryString(num2) + "=" + Integer.toBinaryString(sum));


        //  Шеснадцатиричная форма

        System.out.println("HEX:" + Integer.toHexString(num1).toLowerCase() + "+" + Integer.toHexString(num2).toLowerCase() + "=" + Integer.toHexString(sum).toLowerCase());

        //  Восьмиричная форма

        System.out.println("OCT:" + Integer.toOctalString(num1) + "+" + Integer.toOctalString(num2) + "=" + Integer.toOctalString(sum));


}}


