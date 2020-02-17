package by.it.dolgiy.jd01_12;

import java.util.*;

class TaskB2 {

    private static List<String> list1 = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G","I"));
    private static List<String> list2 = new LinkedList<>(Arrays.asList("A","B","C","D","E","F","G","I"));

    static String process(ArrayList<String> peoples){
        ArrayList<String> list1 = new ArrayList<>(peoples);
        Iterator<String> iterator = list1.iterator();
        System.out.println(list1);
        while (iterator.hasNext()){
            while (list1.size() > (list1.size()/2) && list1.size()!=1){
                int a = list1.size()/2;
                for (int i = 0; i < a; i++) {
                    iterator.next();
                    iterator.remove();
                }
                System.out.println(list1);
            }
            if (list1.size()==1) {
                break;
            }
        }
        return String.valueOf(list1);
    }

    static String process(LinkedList<String> peoples){
        LinkedList<String> list2 = new LinkedList<>(peoples);
        Iterator<String> iterator = list2.iterator();
        System.out.println(list2);
        while (iterator.hasNext()){
            while (list2.size() > (list2.size()/2) && list2.size()!=1){
                int a = list2.size()/2;
                for (int i = 0; i < a; i++) {
                    iterator.next();
                    iterator.remove();
                }
                System.out.println(list2);
            }
            if (list2.size()==1) {
                break;
            }
        }
        return String.valueOf(list2);
    }

    public static void main(String[] args) {
        process((ArrayList<String>) list1);
        process((LinkedList<String>) list2);
    }
}
