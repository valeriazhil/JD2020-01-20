package by.it.zhuravaskarabahataya.jd01_02;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        step1();
        step2(sc.nextInt());
        step3(sc.nextInt(), sc.nextInt(), sc.nextInt());
    }

    private static void step1() {
        int x = 1;
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                System.out.print(x + " ");
                x++;
            }
            System.out.println();
        }

    }

    private static void step2(int month) {
        switch (month) {
            case 1: {
                System.out.println("январь");
                break;
            }
            case 2: {
                System.out.println("февраль");
                break;
            }
            case 3: {
                System.out.println("март");
                break;
            }
            case 4: {
                System.out.println("апрель");
                break;
            }
            case 5: {
                System.out.println("май");
                break;
            }
            case 6: {
                System.out.println("июнь");
                break;
            }
            case 7: {
                System.out.println("июль");
                break;
            }
            case 8: {
                System.out.println("август");
                break;
            }
            case 9: {
                System.out.println("сентябрь");
                break;
            }
            case 10: {
                System.out.println("октябрь");
                break;
            }
            case 11: {
                System.out.println("ноябрь");
                break;
            }
            case 12: {
                System.out.println("декабрь");
                break;
            }
            default: {
                System.out.println("нет такого месяца");
            }
        }
    }

    private static void step3(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            System.out.println("корней нет");
        } else if (discriminant == 0) {
            double result = -(b / (2 * a));
            System.out.println(result);
        } else if (discriminant > 0) {
            double result1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double result2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(result1 + " " + result2);
        }
    }
}
