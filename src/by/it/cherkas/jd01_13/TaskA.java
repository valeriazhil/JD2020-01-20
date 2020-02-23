package by.it.cherkas.jd01_13;

import java.util.HashMap;

class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {

            for (StackTraceElement element : e.getStackTrace()) {
                if (element.getClassName().equals(TaskA.class.getName())) {
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    int lineNumber = element.getLineNumber();

                    System.out.printf(" name: %s%n" +
                            "class: %s%n" +
                            " line: %d%n", name, className, lineNumber);
                    break;
                }
            }

        }

    }
}