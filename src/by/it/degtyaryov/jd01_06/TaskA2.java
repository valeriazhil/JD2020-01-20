package by.it.degtyaryov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Подсчет сколько раз встречается каждое слово в тексте
 *
 * @author DEA
 */
public class TaskA2 {

    private static String[] words = {};
    private static int[] count = {};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            process(matcher.group());
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%s%n", words[i], count[i]);
        }
    }

    /**
     * Если переданное слово уже встречалось ранее, то увеличиваем счетчик для этого слова,
     * иначе добавляем слово в массив слов и устанавливаем для него счетчик = 1
     *
     * @param word слово для подсчета
     * @author DEA
     */
    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                count[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
        count = Arrays.copyOf(count, count.length + 1);
        count[count.length - 1] = 1;
    }
}