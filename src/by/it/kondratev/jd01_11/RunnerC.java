package by.it.kondratev.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RunnerC {
    public static void main(String[] args) {

        List<String> control_list = new ArrayList<>();
        /*control_list.add("12x");
        control_list.add("11w");
        control_list.add("13e");*/
        control_list.add(null);
        control_list.add("82x");


        Set<String> set = new SetC<>();
        set.add("82x");
        set.add("81w");
        set.add("83e");
        set.add("81w");
        set.add("80h");
        set.add(null);

        System.out.println(control_list);
        System.out.println(set);
        set.clear();
        System.out.println(set);

    }
}
