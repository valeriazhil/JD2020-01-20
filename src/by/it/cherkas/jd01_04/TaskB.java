package by.it.cherkas.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Число человек:");
        int n = scanner.nextInt();

        String[] people = new String[n];
        for (int i = 0; i < people.length; i++) {



            people[i] = scanner.nextLine();
        }
        System.out.println(Arrays.toString(people));
       // int[][] salary = new int[n][4];

        }
    }

