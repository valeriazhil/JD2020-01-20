package by.it.kondratev.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {

        task4();
        task5();
    }

    private static void task4() {
        for (double a = 0; a <=2 ; a+=0.2) {
            double y=0;
            for (int x = 1; x <=6 ; x++) {
                y+=7*a-cos(x);
            }

            System.out.printf("При а=%2.1f значение у=%7.6e\n",a,y);
        }
    }

    private static void task5() {
        for (double x = -5.5; x <2 ; x+=0.5) {
            if((x/2>-2) && (x/2<=-1))  {
                double b = sin(x*x);
                double a = log10(abs(b+2.74));
                System.out.printf("sin При х/2=%3.2f значение а=%7.6e\n",x/2,a);  //значение в=%7.4f
            }
            else if ((x/2>-1) && (x/2<0.2)) {
                double b = cos(x*x);
                double a = log10(abs(b+2.74));
                System.out.printf("cos При х/2=%3.2f значение а=%-7.4f\n",x/2,a);;
            }    else if (x/2==0.2) {
                double b = 1/tan(x*x);
                double a = log10(abs(b+2.74));
                System.out.printf("тан При х/2=%3.2f значение а=%-7.4f\n",x/2,a);
            }
                      else System.out.printf("При х/2=%3.2f вычисления не определены\n",x/2);



        }
    }



}
