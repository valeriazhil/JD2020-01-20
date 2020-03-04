package by.it.zhuravaskarabahataya.jd01_13;

import java.util.Scanner;

//. В классе TaskB напишите цикл, который:
// считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
// переводит каждую строку в вещественное число и выводит в консоль данное число
// и корень из суммы всех
//ранее введенных чисел, включая введенное;
// если перевести ввод в число невозможно, то программа перехватывает полученную ошибку
// и показывает
//сообщение в консоли сообщение, такого же формата, как в предыдущем задании
// если невозможно извлечь корень, то обработка аналогична, но тип ошибки - ArithmeticException

class TaskB {
    static double summ = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String scannedText;
        double sum = 0;
        while (!(scannedText = sc.nextLine()).equals("END")) {
          // parseTextToDouble(scannedText);
            try {
                double num = Double.parseDouble(scannedText);
                System.out.println(num);
                sum += num;
            } catch (NumberFormatException e) {
                System.out.println("Невозможно перевести в вещественное число:(");
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String cl = element.getClassName();
                        int line = element.getLineNumber();
                        System.out.printf(" name: %s\n" + "class: %s\n" + " line: %d", name, cl, line);
                    }
                }
            }
            try {
                double sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt)) {
                    throw new ArithmeticException("Невохможно извлечь корень");
                } else
                    System.out.println(sqrt);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String cl = element.getClassName();
                        int line = element.getLineNumber();
                        System.out.printf(" name: %s\n" + "class: %s\n" + " line: %d", name, cl, line);
                    }
                }
            }


        }

    }
}
