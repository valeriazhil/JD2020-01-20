package by.it.lomazki.Example;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
    public static void main(String[] args) {

        String input = "Hello Java! Hello JavaScript! JavaSE 8.";

        Pattern pattern = Pattern.compile("Java(\\w*)");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find())
            System.out.println(matcher.group());


    }
}


