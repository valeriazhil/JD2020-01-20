package by.it.kondratev.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<String> control_list = new ArrayList<>();
        control_list.add("12x");
        control_list.add("11w");
        control_list.add("13e");
        control_list.add(null);
        control_list.add("10h");

        List<String> list = new ListB<>();
        list.add("12x");
        list.add("11w");
        list.add("13e");
        list.add(null);
        list.add("10h");

        System.out.println(list.addAll(control_list));
        System.out.println(list);
        /*System.out.println(control_list);
        System.out.println(list.size());
        System.out.println(control_list.size());
        list.add(2, "16o");
        control_list.add(2, "16o");
        System.out.println(list);
        System.out.println(control_list);
        System.out.println(list.indexOf(null));
        System.out.println(control_list.indexOf(null));
        System.out.println(list.remove("13e"));
        System.out.println(control_list.remove("13e"));
        System.out.println(list);
        System.out.println(control_list);*/

    }
}
