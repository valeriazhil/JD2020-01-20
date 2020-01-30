package by.it.anackij.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (double x = 1; x < 7; x++) {
                y += pow(7, a)-cos(x);
            }
            System.out.printf("При a=%6.4f Сумма y=%6.4f\n", a, y);
            y=0;
        }
    }

    private static void step2() {
        double a;
        double b=0;
        for (double x = -5.5; x <2 ; x+=0.5) {
            boolean flag=true;
            if (((x / 2) > -2) && ((x / 2) <= -1)) {
                b=sin(pow(x,2));
            }else if (((x / 2) > -1) && ((x / 2) < 0.2)) {
                b=cos(pow(x,2));
            }else if ((x / 2) == 0.2) {
                b = 1 / tan(pow(x, 2));
            }else flag = false;
            if (flag){
                a= log(abs(b+2.74));
                System.out.printf("При x/2=%4.2f b=%4.2f a=%6.4f\n",x/2,b,a);
            } else System.out.printf("При x/2=%4.2f вычисления не определены\n",x);
        }
    }
}