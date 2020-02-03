package by.it.zhuravaskarabahataya.jd01_01;

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
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        System.out.println("DEC:" + a + "+" + b + "=" + (a + b));
        System.out.println(sumBinary(a, b));
        System.out.println(sumHex(a, b));
        System.out.println(sumOct(a, b));

    }

    public static String sumBinary(int a, int b) {
        String binaryA = Integer.toBinaryString(a);
        String binaryB = Integer.toBinaryString(b);
        StringBuilder sum = new StringBuilder();
        int x = binaryA.length() - 1;
        int y = binaryB.length() - 1;
        int ostatok = 0;
       /* if (binaryA.equals("0")) {
            sum.append(binaryB);
            return "BIN:" + binaryA + "+" + binaryB + "=" + sum;
        }
        if (binaryB.equals("0")) {
            sum.append(binaryA);
            return "BIN:" + binaryA + "+" + binaryB + "=" + sum;
        } */
        while (x >= 0 || y >= 0) {
            int summ = ostatok;
            if (x >= 0) {
                if (binaryA.charAt(x) == '1')
                    summ += 1;
                x--;
            }
            if (y >= 0) {
                if (binaryB.charAt(y) == '1')
                    summ += 1;
                y--;
            }
            sum.insert(0, summ % 2);
            ostatok = summ / 2;
        }

        if (ostatok > 0)
            sum.insert(0, 1);


        return "BIN:" + binaryA + "+" + binaryB + "=" + sum;
    }

    public static String sumHex(int a, int b) {
        String hexA = Integer.toHexString(a);
        String hexB = Integer.toHexString(b);
        StringBuilder result = new StringBuilder();
        int x = hexA.length() - 1;
        int y = hexB.length() - 1;
        int ostatok = 0;
        while (x >= 0 || y >= 0) {
            int sum = ostatok;
            if (x >= 0) {
                // System.out.println("Char from A at x is " + hexA.charAt(x));
                switch (hexA.charAt(x)) {
                    case 'a':
                        sum += 10;
                        break;
                    case 'b':
                        sum += 11;
                        break;
                    case 'c':
                        sum += 12;
                        break;
                    case 'd':
                        sum += 13;
                        break;
                    case 'e':
                        sum += 14;
                        break;
                    case 'f':
                        sum += 15;
                        break;
                    default:
                        sum += hexA.charAt(x) - '0';
                        break;
                }
                x--;
                // System.out.println("sum after a is " + sum);
            }
            if (y >= 0) {
                // System.out.println("Char from B at y is " + hexB.charAt(y));

                switch (hexB.charAt(y)) {
                    case 'a':
                        sum += 10;
                        break;
                    case 'b':
                        sum += 11;
                        break;
                    case 'c':
                        sum += 12;
                        break;
                    case 'd':
                        sum += 13;
                        break;
                    case 'e':
                        sum += 14;
                        break;
                    case 'f':
                        sum += 15;
                        break;
                    default:
                        sum += hexB.charAt(y) - '0'; //how else turn into int?...
                        break;
                }
                y--;
            }
            //System.out.println("sum is " + sum);
            if (sum < 10) {
                result.insert(0, sum);
            } else if (sum < 16) {
                switch (sum) {
                    case 10:
                        result.insert(0, 'a');
                        break;
                    case 11:
                        result.insert(0, 'b');
                        break;
                    case 12:
                        result.insert(0, 'c');
                        break;
                    case 13:
                        result.insert(0, 'd');
                        break;
                    case 14:
                        result.insert(0, 'e');
                        break;
                    case 15:
                        result.insert(0, 'f');
                        break;
                }
            } else {
                int dev = sum % 16;
                switch (ostatok) {
                    case 10:
                        result.insert(0, 'a');
                        break;
                    case 11:
                        result.insert(0, 'b');
                        break;
                    case 12:
                        result.insert(0, 'c');
                        break;
                    case 13:
                        result.insert(0, 'd');
                        break;
                    case 14:
                        result.insert(0, 'e');
                        break;
                    case 15:
                        result.insert(0, 'f');
                        break;
                    default:
                        result.insert(0, dev);
                        break;
                }
                ostatok = sum / 16;
            }
        }

        return "HEX:" + hexA + "+" + hexB + "=" + result;

    }

    public static String sumOct(int a, int b) {
        String octA = Integer.toOctalString(a);
        String octB = Integer.toOctalString(b);
        StringBuilder result = new StringBuilder();
        int x = octA.length() - 1;
        int y = octB.length() - 1;
        int ostatok = 0;
        while (x >= 0 || y >= 0) {
            int summ = ostatok;
            if (x >= 0) {
                summ += octA.charAt(x) - '0';
                x--;
            }
            if (y >= 0) {
                summ += octB.charAt(y) - '0';
                y--;
            }
            result.insert(0, summ % 8);
            ostatok = summ / 8;
        }
        return "OCT:" + octA + "+" + octB + "=" + result;
    }

}
