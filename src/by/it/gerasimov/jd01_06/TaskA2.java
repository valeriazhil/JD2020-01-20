package by.it.gerasimov.jd01_06;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] words = new String[0];
    private static int[] counts = new int[0];

    public static void main(String[] args) {
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(Poem.text);
        while (m.find()) {
            enrollWord(m.group());
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], counts[i]);
        }
    }

    private static void enrollWord(String s) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(s)) {
                counts[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        counts = Arrays.copyOf(counts, counts.length + 1);
        words[words.length - 1] = s;
        counts[counts.length - 1] = 1;
    }
}
