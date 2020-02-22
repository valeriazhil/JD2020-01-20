package by.it.degtyaryov.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class TaskC {

    public static void main(String[] args) {
        String path = Helper.getPath(TaskC.class, "") + "..";
        try (PrintWriter writer = new PrintWriter(new FileWriter(Helper.getPath(TaskC.class, "resultTaskC.txt")))) {
            writer.print(getFiles(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(getFiles(path));
    }

    private static String getFiles(String path) {
        StringBuilder sb = new StringBuilder();
        File root = new File(path);
        File[] files = root.listFiles();
        if (files == null) {
            return "";
        }
        for (File file : files) {
            if (file.isDirectory()) {
                sb.append("dir:").append(file.getName()).append("\n");
                sb.append(getFiles(file.getAbsolutePath()));
            } else {
                sb.append("    file:").append(file.getName()).append("\n");
            }
        }
        return sb.toString();
    }
}
