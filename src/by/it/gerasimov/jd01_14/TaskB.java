package by.it.gerasimov.jd01_14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB {

    public static void main(String[] args) {
        String count = countWordsAndMarks();
        System.out.println(count);
        printToFile(count);
    }

    private static void printToFile(String count) {
        try (final BufferedWriter bw = new BufferedWriter(
            new FileWriter(Helper.getPath(TaskB.class) + "resultTaskB.txt"))) {
            bw.write(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String countWordsAndMarks() {
        try (BufferedReader br = new BufferedReader(
            new FileReader(Helper.getPath(TaskB.class) + "TaskB.txt"))) {
            int words = 0;
            int marks = 0;
            String wordRegex = "[а-яА-ЯёЁ]+";
            String markRegex = "(- )|\\.{3}|[.,?!:;()\"]{1}";
            Pattern any = Pattern.compile(wordRegex + "|" + markRegex);
            Matcher m;
            String line;
            while ((line = br.readLine()) != null) {
                m = any.matcher(line);
                while (m.find()) {
                    if (m.group().matches(wordRegex)) {
                        words++;
                    } else {
                        marks++;
                    }
                }
            }
            return "words=" + words + ", punctuation marks=" + marks;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
