package by.it.dolgiy.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class TaskB {

    public static void main(String[] args) {
        String datFileName = TaskH.getPath(TaskB.class,"text.txt");
        List<String> list = readString(datFileName);
        final String string = list.toString();
        System.out.println("words="+patternWords(string)+", "+
                "punctuation marks="+patternPunctuationMarks(string));
        try (PrintWriter writer = new PrintWriter(
                TaskH.getPath(TaskB.class, "resultTaskB.txt")
        )){
            writer.println("words="+patternWords(string)+", "+
                    "punctuation marks="+patternPunctuationMarks(string));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
        }
    }

    private static int patternWords(String string) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(string);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        return count;
    }

    private static int patternPunctuationMarks(String string) {
        Pattern pattern = Pattern.compile("\\p{Punct}{2,3}");
        Matcher matcher = pattern.matcher(string);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        return count;
    }

    private static List<String> readString(String datFileName) {
        List<String> list = new ArrayList<>();
        File file = new File(datFileName);
//        String str = null;
        String str;
        try (final BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((str = reader.readLine())!=null) {
                list.addAll(Arrays.asList(str.split(" ")));
            }
        } catch (IOException e) {
            System.out.println("ERROR:");
        }
        return list;
    }
}
