package by.it.demchik.jd01_05;
import static  java.lang.Math.*;
public class TaskA {

    public static void main(String[] args) {
        step1();
        step2();
        step3();


    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double z = cos(pow((x * x + PI / 6), 5));
        double i = sqrt(x * pow(a, 3));
        double r = log(abs((a - 1.12 * x) / 4));
        double t = z - i - r;
        System.out.println(t);
    }


    private static void step2() {


        double a = 1.21;
        double b = 0.371;
        double c = tan(pow(a + b, 2));
        double d = cbrt(a + 1.5);
        double e = a * (pow(b, 5));
        double f = b / (log(a * a));
        double y = c - d + e - f;
        System.out.println(y);

    }


    private static void step3() {
        double x = 12.1;
        for (double a = -5; a <= 12; a = a + 3.75) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("При а=%6.2f f=%g\n", a, f);
        }

    }
}