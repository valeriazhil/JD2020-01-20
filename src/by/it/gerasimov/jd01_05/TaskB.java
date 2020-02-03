package by.it.gerasimov.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("a = %3.1f y = %g\n", a, y);
        }

        double b = 0;
        double a = 0;
        for (double x = -5.5; x < 2; x += 0.5) {
            if (x > -4 && x <= -2) {
                b = sin(x * x);
            } else if (x > -2 && x < 0.4) {
                b = cos(x * x);
            } else if (x == 0.4) {
                b = 1 / tan(x * x);
            } else {
                System.out.printf("x = %4.1f %s\n", x, "вычисления не определены");
                continue;
            }
            a = log10(abs(b + 2.74));
            System.out.printf("x = %4.1f a = %e\n", x, a);
        }
    }
}
