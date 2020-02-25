package by.it.dolgiy.jd01_13;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum =0.0;
        while (true){
            try {
                String text = scanner.nextLine();
                if (text.equals("END")){
                    break;
                }
                double value = Double.parseDouble(text);
                sum= sum + value;
                if (sum<0){
                    throw new ArithmeticException();
                }
                double sqrt = Math.sqrt(sum);
                System.out.println(value);
                System.out.println(sqrt);
            }
            catch (Exception e){
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())){
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int line = element.getLineNumber();
                        System.out.printf(" name: %s\n"+"class: %s\n"+" line: %d\n",name,className,line);
                    }
                }
            }
        }
    }
}
