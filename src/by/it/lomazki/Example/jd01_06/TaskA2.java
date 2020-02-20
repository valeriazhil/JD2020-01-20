package by.it.lomazki.Example.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String [] w = new String[0];
    private static int [] count = new int [0];

    private static int pos (String word) {
        for (int i = 0; i < w.length; i++) {
            if (w[i].equals(word))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            int p = pos(word);
            if (p>=0) {
                count[p]++;
            }
        }
    }
}
