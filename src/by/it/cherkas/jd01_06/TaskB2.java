package by.it.cherkas.jd01_06;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static void resolveDotsProblem(StringBuilder str) {
        Pattern dots = Pattern.compile("[.]+[ ]*[а-яё]");
        Matcher m = dots.matcher(Poem.text);
        while (m.find()) {
            str.replace(m.start(), m.end(), " ");
        }
    }

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        resolveDotsProblem(text);
        Pattern sentenсe = Pattern.compile("[^.!?]+[.!?]+");
        Matcher m = sentenсe.matcher(text);
        int countSentences = 0;
        while (m.find()) {
            countSentences++;
        }
        m.reset();
        String[] sentences = new String[countSentences];
        Pattern symbols = Pattern.compile("[^а-яА-ЯёЁ]{2,}");
        for (int i = 0; m.find(); i++) {
            sentences[i] = m.group().replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        }
        bubbleSort(sentences);
        for (String s : sentences) {
            System.out.println(s);
        }
    }

    private static void bubbleSort(String[] str) {
        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].length() > str[j].length()) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
    }
}
