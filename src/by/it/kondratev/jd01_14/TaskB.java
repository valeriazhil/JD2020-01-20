package by.it.kondratev.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {

        try {
            String file_name = Helper.getPath(TaskB.class, "TaskB.txt");
            StringBuilder text = read(file_name);
            String result = find(text);
            System.out.println(result);
            write_in_txt(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        private static void write_in_txt (String result) throws IOException {
            String file_name2 = Helper.getPath(TaskB.class, "resultTaskB.txt");
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter(file_name2))
            ) {
                bw.write(result);
            }
        }

        private static String find (StringBuilder text)  {
            Pattern p1 = Pattern.compile("[,.!:-]");
            Pattern p2 = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher m = p1.matcher(text);
            int z = 0;
            while (m.find()) z++;

            int w = 0;
            m = p2.matcher(text);
            while (m.find()) w++;

            return "words=" + w + ", punctuation marks=" + z;
        }

        private static StringBuilder read (String file_name) throws IOException {
            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new FileReader(file_name))
            ) {
                while (br.ready()) {
                    String str = br.readLine().replace("...", ".");
                    sb.append(str).append(' ');
                }
            }
            return sb;
        }
}



