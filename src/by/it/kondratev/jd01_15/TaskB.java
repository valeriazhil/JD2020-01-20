package by.it.kondratev.jd01_15;

import java.io.*;

public class TaskB {

    private static String java_name = getPath() + TaskB.class.getSimpleName() + ".java";
    private static String txt_name = getPath() + TaskB.class.getSimpleName() + ".txt";


    public static void main(String[] args) {
        StringBuilder sb = read_from_java();
        System.out.println(sb);
        write_to_txt(sb);

    }

    private static void write_to_txt(StringBuilder sb) {
        try (FileWriter fw = new FileWriter(txt_name)) {
            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder read_from_java() {
        StringBuilder result = new StringBuilder();
        int x, y;

        try (BufferedReader br = new BufferedReader(new FileReader(java_name)))
        { while ((x= br.read()) != -1) {
            if ((char)x == '"') {
                do {
                result.append((char) x); }
                while ((char)(x= br.read()) != '"');
                 }

            if ((char)x != '/')
                    result.append((char) x);
                else {
                    y = br.read();
                    if ((char)y != '*' && (char)y != '/')
                        result.append((char)x).append((char)y);
                    else {
                        if ((char)y == '/') { br.readLine(); result.append('\n'); }
                        else
                            while (true) {
                                x = br.read();
                                if ((char)x == '*') {
                                    y = br.read();
                                    if ((char)y == '/') break;
                                }
                            }
                    }

        }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    static String getPath () {
            String root = System.getProperty("user.dir");
            String name = TaskB.class.getName();
            name = name.replace('.', File.separatorChar).
                    replace(TaskB.class.getSimpleName(), "");
            return root + File.separatorChar + "src" + File.separatorChar + name;
        }

}