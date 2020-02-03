package by.it.anackij.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] counters = new int[0];

    public static void main(String[] args) {
        Pattern patternWords = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = patternWords.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            process(word);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s%S\n", words[i], counters[i]);
        }
    }

    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                counters[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        counters = Arrays.copyOf(counters, counters.length + 1);
        words[words.length - 1] = word;
        counters[counters.length - 1] = 1;
    }
}
