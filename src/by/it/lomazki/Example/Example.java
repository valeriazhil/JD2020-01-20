package by.it.lomazki.Example;


import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(numberToWords(number));
    }

    public static String numberToWords(int number) {
        String[] ones = // 0 .. 19
                {
                        "zero", "one", "two", "three", "four",
                        "five", "six", "seven", "eight", "nine",
                        "ten", "eleven", "twelve", "thirteen", "fourteen",
                        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
                };

        String[] tens = // 20 .. 100
                {
                        "twenty", "thirty", "forty", "fifty", "sixty",
                        "seventy", "eighty", "ninety", "hundred"
                };

        int dec = number / 10 - 2;
        int ed = number % 10;

        if (number < 20)
            return ones[number];
        if (number % 10 == 0)
            return tens[dec];
        else
            return tens[dec] + ones[ed];
    }
}


