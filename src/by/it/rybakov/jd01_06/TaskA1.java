package by.it.rybakov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder(Poem.text);
        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher=pattern.matcher(Poem.text);
        while(matcher.find()){
           int start= matcher.start();
           sb.setCharAt(start,'#');
        }
        System.out.println(sb);
    }
}
