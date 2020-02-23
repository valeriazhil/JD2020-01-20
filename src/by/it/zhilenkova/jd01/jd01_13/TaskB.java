package by.it.zhilenkova.jd01.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        for (int i = 0; true ; i++) {
            String str = scan.nextLine();
            if (!(str.equalsIgnoreCase("end"))){
                try {
                    double out=Double.parseDouble(str);
                    System.out.println("Вы ввели: " + out);
                    sum+=out;
                    if (out<0){
                        throw new ArithmeticException();
                    }
                    double sqrt = Math.sqrt(sum);
                    System.out.println("корень из суммы всех ранее введенных чисел: " + sqrt);
                }catch (NumberFormatException | ArithmeticException e){
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement element: stackTrace){
                        if (TaskB.class.getName().equals(element.getClassName())){
                            System.out.println(element);
                            String name1 = e.getClass().getName();
                            String clName = element.getClassName();
                            int number = element.getLineNumber();
                            System.out.printf(
                                    "name: %s\n" +
                                            "class: %s\n"+
                                            "line: %d\n", name1,clName,number);
                            break;
                        }
                    }
                }
            }else {
                break;
            }
        }
    }
}
