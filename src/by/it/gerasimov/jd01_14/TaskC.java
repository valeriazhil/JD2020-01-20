package by.it.gerasimov.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class TaskC {

    public static void main(String[] args) {
        String list = listFiles(Helper.getPath(TaskC.class) + "..");
        System.out.println(list);
        printToFile(list);
    }

    private static void printToFile(String str) {
        try (final BufferedWriter bw = new BufferedWriter(
            new FileWriter(Helper.getPath(TaskC.class) + "resultTaskC.txt"))) {
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String listFiles(String path) {
        File[] files = new File(path).listFiles();
        StringBuilder result = new StringBuilder();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    result.append("dir:").append(f.getName()).append('\n')
                        .append(listFiles(path + File.separator + f.getName()));
                } else {
                    result.append("file:").append(f.getName()).append('\n');
                }
            }
        }
        return result.toString();
    }
}
