package by.it.lomazki.jd01_02;

import java.util.Scanner;

public class TaskAA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }

        step1 (mas);
        step2 (mas);
        step3 (mas);
    }

    private static void step1 (int[ ] mas){
        int min = mas[0];
        int max = mas[0];
        for (int element = 0; element < mas.length; element++) {
            if (min>element) element = min;
            if (max<element) element = max;
        }
        System.out.println(min + " " + max);
    }
    private static void step2 (int[ ] mas) {
        int avg = 0;
        for (int element = 0; element < mas.length; element++) {
            avg = avg + element;
        }
        avg = avg / mas.length;
        for (int element = 0; element < mas.length; element++) {
            if (element<avg) System.out.println(element);
        }
    }
    private static void step3 (int[ ] mas) {
        int min = mas[0];
        for (int element = 0; element < mas.length; element++) {
            if (min > element) element = min;
        }
        for (int i = mas.length-1; i >=0 ; i--) {
            if (mas[i] == i) System.out.print(i + " ");
        }
    }
    

    
    
    
    
    
    

}
