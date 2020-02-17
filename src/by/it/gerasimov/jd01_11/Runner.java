package by.it.gerasimov.jd01_11;

import java.util.*;

class Runner {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");   //0
        list.add("Two");   //1
        list.add("Three"); //2
        list.add("Four");  //3
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());

        Set<String> list2 = new SetC<>();
        list.add("One");   //0
        list.add("Two");   //1
        list.add("Three"); //2
        list.set(2, "Four");  //3
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());
    }

}
