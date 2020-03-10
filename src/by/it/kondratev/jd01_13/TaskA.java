package by.it.kondratev.jd01_13;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    public static void main(String[] args) {

        try {
    if (Math.random() > 0.5)
        new HashMap<String, String>(null);
    else
        Integer.parseInt("привет");
        }
        catch (NullPointerException | NumberFormatException e) {
            System.out.println(" name: " + e.getClass().getName() );
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {    //if (element.getClassName().equals(TaskA.class.getName())) {
                String elem = element.toString();
                Pattern p = Pattern.compile("TaskA");
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
