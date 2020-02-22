package by.it.kondratev.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {

    public static void main(String[] args) {

        String pathname = Helper.getPath(TaskC.class, "TaskC");
        pathname = pathname.replace("\\jd01_14\\TaskC", "");
        File file = new File(pathname);
        File[] elements = file.listFiles();
        for (File elem : elements) {
            if (elem.isFile())
                System.out.println("file:" + elem.getName());
            else System.out.println("dir:" + elem.getName());
        }
        write_in_txt(elements);
    }

        static void write_in_txt(File[] files) {
            String file_name = Helper.getPath(TaskC.class, "resultTaskC.txt");
            String str;
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter(file_name))
            ) {
                for (File elem : files) {
                    if (elem.isFile())
                        str = "file:" + elem.getName();
                    else str = "dir:" + elem.getName();
                    bw.write(str+"\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}

