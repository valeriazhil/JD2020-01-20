package by.it._tasks_.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern patternWords = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = patternWords.matcher(Poem.text);
        while(matcher.find()){
            int start = matcher.start();
            text.setCharAt(start+3,'#');
            if(matcher.end()-start>=7)
                text.setCharAt(start +6, '#');
        }
        System.out.println(text);
    }
}
