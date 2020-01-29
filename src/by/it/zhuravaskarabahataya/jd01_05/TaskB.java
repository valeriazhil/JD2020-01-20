package by.it.zhuravaskarabahataya.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        task1();
    }

    public static void task1() {
        double deltaA = 0.2;

        for (double a = 0; a <=2 ; a += deltaA) {
            double sum = 0;
            for (int x = 0; x <= 6; x++) {
                sum+= pow(7, a) - cos(x);
            }
            System.out.printf("%-5s = %-4.2f %-8s= %-8.4f\n", "При а", a, "Сумма y ", sum);
        }

    }
}
