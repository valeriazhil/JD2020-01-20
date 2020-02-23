package by.it.demchik.jd01_14;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src/by/it/demchik/jd01_14/";


        String filename = path + "text.txt";
        File f = new File(filename);
        int b, count = 0;
        FileReader is = null;
        try {
            is = new FileReader(f);
            while ((b = is.read()) != -1) {
                count++;
            }
            System.out.println("число слов= " + count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}