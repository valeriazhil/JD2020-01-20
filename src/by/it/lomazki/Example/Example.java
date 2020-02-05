package by.it.lomazki.Example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]+");
        Matcher matcher = pattern.matcher(Poem.text);

    }
}


