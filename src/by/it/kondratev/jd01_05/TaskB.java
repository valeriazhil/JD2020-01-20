package by.it.kondratev.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {

        task4();
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


}
