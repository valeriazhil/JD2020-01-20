package by.it.gerasimov.jd01_05;

import static java.lang.Math.*;

class TaskA {

    public static void main(String[] args) {

        double a = 756.13;
        double x = 0.3;
        double z = cos(pow(x * x + PI / 6, 5)) - sqrt(x * a * a * a) - log(abs((a - 1.12 * x) / 4));
        System.out.println(z);

        a = 1.21;
        double b = 0.371;
        double y = tan(pow(a + b, 2)) - pow(a + 1.5, 1.0 / 3) + a * pow(b, 5) - b / log(a * a);
        System.out.println(y);

        x = 12.1;
        for (a = -5; a <= 12; a += 3.75) {
            double f = pow(E, a * x) - 3.45 * a;
            System.out.printf("a = %5.2f f = %g\n", a, f);
        }
    }
}
