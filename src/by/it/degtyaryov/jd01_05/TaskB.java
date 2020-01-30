package by.it.degtyaryov.jd01_05;

import static java.lang.Math.*;

class TaskB {

    public static void main(String[] args) {
        exerciseFour();
        exerciseFive();
    }

    private static void exerciseFour() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При a=%4.2f Сумма y = %e%n", a, y);
        }
    }

    private static void exerciseFive() {
        for (double x = -5.5; x < 2; x += 0.5) {
            double b;
            // TODO: уточнить можно ли было как-нибудь вынести определение b в отдельный метод.
            //  Как определить тогда что для некоторых значений вычисление не определено
            if (-2 < x / 2 && x / 2 <= -1) {
                b = sin(pow(x, 2));
            } else if (-1 < x / 2 && x / 2 <= 0.2) {
                b = cos(pow(x, 2));
            } else if (x / 2 == 0.2) {
                b = 1 / tan(pow(x, 2));
            } else {
                System.out.printf("При x/2=%5.2f вычисления не определены%n", x / 2);
                continue;
            }

            double a = log10(abs(b + 2.74));
            System.out.printf("При x/2=%5.2f a = %e%n", x / 2, a);
        }
    }
}
