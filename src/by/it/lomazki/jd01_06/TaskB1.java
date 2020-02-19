package by.it.lomazki.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("\\b[бвгджзклмнпрстфхцчшщБВГДЖЗКЛМНПРСТФХЦЧШЩ]?[а-яё]+[уеэоаыяиюё]\\b");
        Matcher matcher = pattern.matcher(sb);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
