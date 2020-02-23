package by.it.kondratev.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)  {

        String pathname = Helper.getPath(TaskC.class, "TaskC");
        pathname = pathname.replace("\\jd01_14\\TaskC", "");
        StringBuilder stringBuilder = print_to_console(pathname);
        System.out.println(stringBuilder);
        write_in_txt(stringBuilder);
        }

    private static StringBuilder print_to_console(String pathname) {
        File file = new File(pathname);
        File[] elements = file.listFiles();
        for (File elem : elements) {
            if (elem.isFile()) {
                sb.append("file:").append(elem.getName()).append("\n");
                System.out.println("file:" + elem.getName());
            }
            else {
                sb.append("dir:").append(elem.getName()).append("\n");
                System.out.println("dir:" + elem.getName());
                print_to_console(pathname + File.separator + elem.getName());
            }
        }
        return sb;
    }

    static void write_in_txt(StringBuilder sb) {
        String resultTaskC = Helper.getPath(TaskC.class, "resultTaskC.txt");
                    try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter(resultTaskC))
            ) {

                        bw.write(sb.toString());
                } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
}



