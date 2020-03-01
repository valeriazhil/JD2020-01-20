package by.it.kondratev.jd01_15;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        read_from_java();

    }

    private static StringBuilder read_from_java() {
        String java_name = getPath() + TaskB.class.getSimpleName() + ".java";
        StringBuilder result = new StringBuilder();


        try (BufferedReader br = new BufferedReader(
                new FileReader(java_name)
        )) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

        static String getPath () {
            String root = System.getProperty("user.dir");
            String name = TaskB.class.getName();
            name = name.replace('.', File.separatorChar).
                    replace(TaskB.class.getSimpleName(), "");
            return root + File.separatorChar + "src" + File.separatorChar + name; // + "matrix.txt";
        }

}