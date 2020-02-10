package by.it.degtyaryov.jd01_05;

import static java.lang.Math.*;

class TaskA {

    public static void main(String[] args) {
        exerciseOneApart();
        exerciseOneTogether();
        exerciseTwo();
        exerciseThree();
    }

    private static void exerciseOneApart() {
        double a = 756.13;
        double x = 0.3;
        double cos = cos(pow((pow(x, 2) + (PI / 6)), 5));
        double root = sqrt(x * pow(a, 3));
        double log = log(abs((a - (1.12 * x)) / 4));
        double z = cos - root - log;
        System.out.println(z);
    }

    private static void exerciseOneTogether() {
        double a = 756.13;
        double x = 0.3;
        double z = cos(pow((pow(x, 2) + (PI / 6)), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - (1.12 * x)) / 4));
        System.out.println(z);
    }

    private static void exerciseTwo() {
        double a = 1.21;
        double b = 0.371;
        double tg = tan(pow((a + b), 2));
        double root = cbrt(a + 1.5);
        double mul = a * pow(b, 5);
        double div = b / log(pow(a, 2));
        double z = tg - root + mul - div;
        System.out.println(z);
    }

    private static void exerciseThree() {
        double x = 12.1;
        for (double a = -5; a <= 12; a += 3.75) {
            double f = pow(E, (a * x)) - 3.45 * a;
            System.out.printf("При a=%6.2f f=%g%n", a, f);
        }
    }
}
