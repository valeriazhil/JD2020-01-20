package by.it.demchik.jd01_05;

import static java.lang.Math.cos;
import static java.lang.Math.pow;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();

    }

    private static void step1() {

        double sum = 0;

        for (double a = 0; a <= 2.0; a = a + 0.2) {

            for (int x = 1; x <= 6; x++) {
                sum = sum + ((pow(7, a)) - cos(x));
                System.out.printf("При а=%6.2f y=%g\n", a, sum);
            }
        }
    }
    private static void step2() {

    }
}
