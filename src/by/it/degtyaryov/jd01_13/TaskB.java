package by.it.degtyaryov.jd01_13;

import java.util.Scanner;

class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            try {
                double number = Double.parseDouble(line);
                sum += number;
                if (sum >= 0) {
                    System.out.printf("Число: %f, корень из суммы: %f%n", number, Math.sqrt(sum));
                } else {
                    throw new ArithmeticException();
                }
            } catch (NumberFormatException | ArithmeticException e) {
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    if (stackTraceElement.getClassName().equals(TaskB.class.getName())) {
                        String name = e.getClass().getName();
                        String className = stackTraceElement.getClassName();
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf(" name: %s%n" +
                                "class: %s%n" +
                                " line: %d%n", name, className, lineNumber);
                        break;
                    }
                }
            }
        }
    }
}
