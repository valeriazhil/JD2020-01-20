package by.it.degtyaryov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static final String VOWELS = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            if (isFirstConsonantLastVowels(matcher.group())) {
                System.out.println(matcher.group());
            }
        }
    }

    /**
     * @param word слово для определения
     * @return возвращает true если word начинается с согласной буквы и заканчивается гласной
     * @author DEA
     */
    private static boolean isFirstConsonantLastVowels(String word) {
        return (!VOWELS.contains(String.valueOf(word.charAt(0)))
                && VOWELS.contains(String.valueOf(word.charAt(word.length() - 1))));
    }
}
