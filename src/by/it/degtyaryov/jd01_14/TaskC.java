package by.it.degtyaryov.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class TaskC {

    public static void main(String[] args) {
        String rootPath = Helper.getPath(TaskC.class, "") + "..";
        String outFile = Helper.getPath(TaskC.class, "resultTaskC.txt");

        try (PrintWriter writer = new PrintWriter(new FileWriter(outFile))) {
            writer.print(getFiles(rootPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(getFiles(rootPath));
    }

    private static String getFiles(String path) {
        StringBuilder sb = new StringBuilder();
        File[] files = new File(path).listFiles();
        if (files == null) {
            return "";
        }
        for (File file : files) {
            if (file.isDirectory()) {
                sb.append("dir:").append(file.getName()).append("\n");
                sb.append(getFiles(file.getAbsolutePath()));
            } else {
                sb.append("\tfile:").append(file.getName()).append("\n");
            }
        }
        return sb.toString();
    }
}
