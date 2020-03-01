package by.it.kondratev.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> namesA = new ArrayList<>(Arrays.asList("val1", "val2", "val3", "val4"));
        LinkedList<String> namesB = new LinkedList<>(Arrays.asList("val1", "val2", "val3", "val4"));
        System.out.println(process(namesA));
        System.out.println(process(namesB));
    }

    private static String process(ArrayList<String> peoples) {
        boolean needDelete = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (needDelete) {
                    iterator.remove();
                }
                needDelete = !needDelete;
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        boolean needDelete = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (needDelete) {
                    iterator.remove();
                }
                needDelete = !needDelete;
            }
        }
        return peoples.get(0);
    }
}
