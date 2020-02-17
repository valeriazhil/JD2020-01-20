package by.it.gerasimov.jd01_13;

import java.util.Scanner;

class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (true) {
            try {
                String str = scanner.nextLine();
                if (str.equals("END")) {
                    break;
                }
                double n = Double.parseDouble(str);
                sum += n;
                System.out.println(n);
                if (sum >= 0) {
                    System.out.println(Math.sqrt(sum));
                } else {
                    throw new ArithmeticException();
                }
            } catch (Exception e) {
                printException(e);
            }
        }
    }

    static void printException(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().equals(TaskB.class.getName())) {
                String nameException = e.getClass().getName();
                String className = element.getClassName();
                int lineNumber = element.getLineNumber();
                System.out.printf(" name: %s\nclass: %s\n line: %d\n", nameException, className, lineNumber);
                break;
            }
        }
    }
}
