package by.it.demchik.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        System.out.println("------------------------------------");
        System.out.println("    List     "+list);
        list.remove(1);
        System.out.println("    List     "+list);
        System.out.println("    List     "+list.size());
        System.out.println("");


        list = new ListA<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        System.out.println("My  List     "+list);
        list.remove(1);
        System.out.println("My  List     "+list);
        System.out.println("My  List     "+list.size());
        System.out.println("------------------------------------");



        list = new ListB<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        System.out.println("My  List     "+list);
        list.remove(1);
        System.out.println("My  List     "+list);
        System.out.println("My  List     "+list.size());
        System.out.println("------------------------------------");


    }

}



