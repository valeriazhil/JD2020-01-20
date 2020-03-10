package by.it.kondratev.calc;

import java.util.*;

public class Printer {

    void print(Var result){
        if (result!=null)
        System.out.println(result);
    }

    void printVar(Map<String, Var> map) {
        Set<Map.Entry<String, Var>> entries = map.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            System.out.println(entry);
        }
    }

    void sortvar(Map<String, Var> hashMap) {
        TreeMap<String, Var> treeMap = new TreeMap<>(hashMap);
        printVar(treeMap);
    }





}
