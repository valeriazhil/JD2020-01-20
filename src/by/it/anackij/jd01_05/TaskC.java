package by.it.anackij.jd01_05;

import java.util.Scanner;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        Scanner scanner = new Scanner(System.in);
        double delta = scanner.nextDouble();
        double array[] = new double[20];
        double z;
        for (int i = 0; i < array.length; i++) {
            for (double x = 5.33; x < 9; x += delta) {
                z = cbrt(pow(x, 2) + 4.5);
                array[i] = z;
            }
        }
    }
}
