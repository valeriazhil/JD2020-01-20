package by.it.kondratev.jd01_13;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) {

        double n = 0;
        double sum = 0;

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        try {
            while (!str.equals("END")) {
                n = Double.parseDouble(str);
                sum += n;
                if (sum < 0) throw new ArithmeticException("Корень из  отрицательного числа");
                System.out.print("n = "+ n + "  корень из суммы = " + Math.sqrt(sum));
                str = sc.nextLine();
            }
        } catch (ArithmeticException | NumberFormatException e) {
            System.out.println(" name: " + e.getClass().getName() );
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                String elem = element.toString();
                Pattern p = Pattern.compile("TaskB");
                Matcher m = p.matcher(elem);
                if (m.find()) {
                    System.out.println("class: " + element.getClassName());
                    System.out.println(" line: " + element.getLineNumber());
                    break;
                }
            }
            }

        }

    }

