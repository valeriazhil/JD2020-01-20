package by.it.degtyaryov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Заменяет у каждого слова 4 и 7 символы (если есть) на символ '#'
 * @author DEA
 */
public class TaskA1 {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            text.setCharAt(matcher.start() + 3, '#');
            if (matcher.end() - matcher.start() >= 7) {
                text.setCharAt(matcher.start() + 6, '#');
            }
        }
        System.out.println(text);
    }
}