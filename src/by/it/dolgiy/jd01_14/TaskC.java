package by.it.dolgiy.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;


public class TaskC {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String name = TaskC.class.getName().replace(TaskC.class.getSimpleName(),"")
                .replace('.',File.separatorChar).replace("jd01_14\\","");
        String path = property + name;
        File file = new File(path);
        for (String s : Objects.requireNonNull(file.list())) {
            String stringPath = path + s;
            System.out.println("dir:"+s);
            File file1 = new File(stringPath);
            for (String s1 : Objects.requireNonNull(file1.list())) {
                System.out.println("file:"+s1);
            }
        }
        try (PrintWriter writer = new PrintWriter(
                TaskH.getPath(TaskC.class, "resultTaskC.txt")
        )){
            for (String s : Objects.requireNonNull(file.list())) {
                String stringPath = path + s;
                writer.println("dir:"+s);
                File file1 = new File(stringPath);
                for (String s1 : Objects.requireNonNull(file1.list())) {
                    writer.println("file:"+s1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
        }
    }
}
