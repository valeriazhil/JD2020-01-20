package by.it.dolgiy.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB1 {

    private static List<String> list = new ArrayList<>();
    private static int[] count = {};

    static int pos(String word){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String text = scanner.next();
            if (text.equals("end")){
                break;
            }
            Pattern pattern = Pattern.compile("[(a-zA-z)\\'?]+");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()){
                String word = matcher.group();
                list.add(word);
                int value = pos(word);
                if (value>=0){
                    count = Arrays.copyOf(count, count.length+1);
                    count[value]++;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)+"="+count[i]);
        }

    }
}
