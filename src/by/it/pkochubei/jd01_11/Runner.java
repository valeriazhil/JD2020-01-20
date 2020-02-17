package by.it.pkochubei.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());

        list = new ListA<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());
    }
}
