package by.it.degtyaryov.jd01_12;

import java.util.*;

class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> namesA = new ArrayList<>(Arrays.asList("val1", "val2", "val3", "val4"));
        LinkedList<String> namesB = new LinkedList<>(Arrays.asList("val1", "val2", "val3", "val4"));
        System.out.println(process(namesA));
        System.out.println(process(namesB));
    }

    private static String process(ArrayList<String> peoples) {
        List<String> list = new ArrayList<>(peoples);
        boolean needDelete = false;
        while (list.size() > 1) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (needDelete) {
                    iterator.remove();
                }
                needDelete = !needDelete;
            }
        }
        return list.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        List<String> list = new LinkedList<>(peoples);
        boolean needDelete = false;
        while (list.size() > 1) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (needDelete) {
                    iterator.remove();
                }
                needDelete = !needDelete;
            }
        }
        return list.get(0);
    }
}
