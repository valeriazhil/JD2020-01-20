package by.it.kondratev.jd01_05;

import static java.lang.Math.*;
import static java.lang.Math.cbrt;

public class TaskC {

    public static void main(String[] args) {
        int sizeB=0;
        int sizeA = (int)(random()*21+20);
        double[] A = new double[sizeA];
        double step = (9-5.33)/(sizeA);          // Для x=9 нужно, чтобы в знаменателе стояло (size-1)
        for (int i = 0; i < sizeA ; i++) {
            double x = 5.33 + step*i;
            double z = cbrt(x*x+4.5);
            A[i] = z;
            if (z>3.5) sizeB++;

        }
        System.out.println("Massiv A");
        int cols=5;                                          // число колонок
        begin_end(cols,1);
        values(A,cols,'A');
        begin_end(cols,2);

        System.out.println("Massiv B");
        double sr_geom = 1;
        double [] B = new double[sizeB];
        int j = 0;
        for (int i = 0; i < sizeA; i++) {
                if (A[i] > 3.5) {
                    B[j] = A[i];
                    sr_geom*=B[j];
                    j++;
                }
        }

        begin_end(cols,1);
        values(B,cols, 'B');
        begin_end(cols,2);
        System.out.println(sr_geom);
    }

    public static void values(double[] mas, int columns,char name) {
        int i = 0;
        for (i = 0; i < mas.length; i++) {
            System.out.printf("║%1c[%2d]=%6.5f",name, i + 1, mas[i]);
            if ((i + 1) % columns == 0) {
                System.out.println("║");
                if (i != mas.length - 1) border(columns);
            } else if (i == mas.length - 1) {
                int k = columns - mas.length % columns;
                for (int j = 1; j <= k; j++) System.out.print("║             ");
                System.out.println("║");
            }
        }

    }

    public static void border(int columns) {
        System.out.print("╠");
        for (int i = 1; i <= columns - 1; i++) {
            System.out.print("═════════════╬");
        }
        System.out.println("═════════════╣");
    }

    public static void begin_end(int columns, int z) {
        if (z == 1) {
            System.out.print("╔");
            for (int i = 1; i <= columns - 1; i++) {
                System.out.print("═════════════╦");
            }
            System.out.println("═════════════╗");

        } else {
            System.out.print("╚");
            for (int i = 1; i <= columns - 1; i++) {
                System.out.print("═════════════╩");
            }
            System.out.println("═════════════╝");
        }
    }
}
