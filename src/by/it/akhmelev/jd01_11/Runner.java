package by.it.akhmelev.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {

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

        list = new ListA<>();
        list.add("One");   //0
        list.add("Two");   //1
        list.add("Three"); //2
        list.add("Four");  //3
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());


    }

}
