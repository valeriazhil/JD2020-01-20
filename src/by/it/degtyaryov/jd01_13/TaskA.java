package by.it.degtyaryov.jd01_13;

import java.util.HashMap;

class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals(TaskA.class.getName())) {
                    String name = e.getClass().getName();
                    String className = stackTraceElement.getClassName();
                    int line = stackTraceElement.getLineNumber();
                    System.out.printf(" name: %s%n" +
                            "class: %s%n" +
                            " line: %d%n", name, className, line);
                    break;
                }
            }
        }
    }
}
