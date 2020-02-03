package by.it.dolgiy.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        step1();

        int month=scanner.nextInt();
        step2(month);

        double a=scanner.nextInt();
        double b=scanner.nextInt();
        double c=scanner.nextInt();
        step3(a, b, c);


    }

    private static void step1() {
        for (int i = 1; i <= 25 ; i++) {
            System.out.print(i+" ");
            if (i%5==0)
                System.out.println();
        }
    }

    private static void step2(int month) {
        String[] a = {"январь","февраль","март","апрель","май","июнь","июль","август","сентябрь","октябрь","ноябрь","декабрь"};
        switch (month) {
            case 1: System.out.println(a[0]); break;
            case 2: System.out.println(a[1]); break;
            case 3: System.out.println(a[2]); break;
            case 4: System.out.println(a[3]); break;
            case 5: System.out.println(a[4]); break;
            case 6: System.out.println(a[5]); break;
            case 7: System.out.println(a[6]); break;
            case 8: System.out.println(a[7]); break;
            case 9: System.out.println(a[8]); break;
            case 10: System.out.println(a[9]); break;
            case 11: System.out.println(a[10]); break;
            case 12: System.out.println(a[11]); break;
            default: System.out.println("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c) {
        double dis = b * b - 4 * a * c;
        if (dis < 0) System.out.println("кортей нет");
        else if (dis == 0) {
            double x = -b / (2 * a);
            System.out.println(x);
        }
        else {
            double x1 = (-b + Math.sqrt(dis)) / (2 * a);
            double x2 = (-b - Math.sqrt(dis)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }
    }
}
