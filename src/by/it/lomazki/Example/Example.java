package by.it.lomazki.Example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Random rnd = new Random();
        int[] mas = new int[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] =n - rnd.nextInt(n+n+1);
        }
        System.out.println(Arrays.toString(mas));
        int posOne = 0;
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i]>=0) {
                posOne = i;
            }
        }
        for (int i = posOne; i < mas.length; i++) {
            do{
                sum += mas[i];
            }while (mas[i]<0);
        }
        System.out.println(sum);




    }
}
