package by.it.dolgiy.jd01_12;

import java.util.*;

class TaskB3 {

    private static List<String> list1 = new ArrayList<>();
    private static List<String> list2 = new LinkedList<>();

    static String process(ArrayList<String> peoples){
        ArrayList<String> list1 = new ArrayList<>(peoples);
        System.out.println(list1);
        while (list1.size()!=1){
            Iterator<String> iterator = list1.iterator();
            int count = 0;
            while (iterator.hasNext()) {
                iterator.next();
                if (count==1){
                    iterator.remove();
                    count--;
                }
                else {
                    count++;
                }
            }
            System.out.println(list1);
        }
        return list1.get(0);
    }

    static String process(LinkedList<String> peoples){
        LinkedList<String> list2 = new LinkedList<>(peoples);
        System.out.println(list2);
        while (list2.size()>1){
            Iterator<String> iterator = list2.iterator();
            int count = 0;
            while (iterator.hasNext()) {
                iterator.next();
                if (count==1){
                    iterator.remove();
                    count--;
                }
                else {
                    count++;
                }
            }
            System.out.println(list2);
        }
        return list2.get(0);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 4096 ; i++) {
            list1.add("A"+i);
        }
        for (int i = 1; i <= 4096 ; i++) {
            list2.add("A"+i);
        }
        Long t= System.nanoTime();
        process((ArrayList<String>) list1);
        Long tA= System.nanoTime()-t;

        Long t1= System.nanoTime();
        process((LinkedList<String>) list2);
        Long tA1= System.nanoTime()-t;

        System.out.println(tA);
        System.out.println(tA1);
    }
}
