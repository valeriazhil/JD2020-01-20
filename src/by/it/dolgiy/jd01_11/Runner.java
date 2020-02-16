package by.it.dolgiy.jd01_11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
//        System.out.println(list);
//        list.remove(2);
//        System.out.println(list);
//        list.add(2,"fff");
//        System.out.println(list);
//        System.out.println(list.size());
//        System.out.println(list.get(2));
//        System.out.println(list.set(2,"jjj"));
//        list.set(2,"jjj");
//        System.out.println(list);
        System.out.println(list.addAll(list));
        System.out.println(list);
        System.out.println();


        list = new ListB<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
//        System.out.println(list);
//        list.remove(2);
//        System.out.println(list);
//        list.add(2,"fff");
//        System.out.println(list);
//        System.out.println(list.size());
//        System.out.println(list.get(2));
//        System.out.println(list.set(2,"jjj"));
//        list.set(2,"jjj");
//        System.out.println(list);
        System.out.println(list.addAll(list));
        System.out.println(list);
        System.out.println();


    }
}
