package by.it.zhuravaskarabahataya.jd01_05;

import com.sun.org.apache.bcel.internal.classfile.SourceFile;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        double deltaA = 0.2;

        for (double a = 0; a <= 2; a += deltaA) {
            double sum = 0;
            for (int x = 0; x <= 6; x++) {
                sum += pow(7, a) - cos(x);
            }
            System.out.printf("%-5s = %-4.2f %-8s= %-8.4f\n", "При а", a, "Сумма y ", sum);
        }

    }

    private static void task2() {
        double deltaX = 0.5;
        double b;
        for (double x = -6 + deltaX; x < 2; x += deltaX) {
            if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(x * x);
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                b = cos(x * x);
            } else if (x / 2 == 0.2) {
                b = 1 / (tan(x * x));
            } else {
                System.out.printf("%-7s= %-5.2f %-12s\n", "При х/2", x / 2, " ничего :(");
                continue;
            }
            double a = log10(abs(b + 2.74));
            System.out.printf("%-7s= %-5.2f %-3s= %-8.8f\n", "При х/2", x / 2, " α ", a);
        }
    }
}


