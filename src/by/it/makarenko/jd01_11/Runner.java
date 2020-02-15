package by.it.makarenko.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("2");
        list.add("6");
        list.add("lol");
        list.add("one2");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());

        list = new ListA<>();
        list.add("one");
        list.add("2");
        list.add("6");
        list.add("lol");
        list.add("one2");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(3));

        list = new ListB<>();
    }
}
