package by.it.bunkov.jd01_12;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {

    static <T> T process(ArrayList<T> people) {
        Iterator<T> it = people.iterator();
        while (people.size() > 1) {
            for (int i = 0; i < 2; i++) {
                if (!it.hasNext()) {
                    it = people.iterator();
                }
                it.next();
            }
            it.remove();
        }
        return people.get(0);
    }

    static <T> T process(LinkedList<T> people) {
        Iterator<T> it = people.iterator();
        while (people.size() > 1) {
            for (int i = 0; i < 2; i++) {
                if (!it.hasNext()) {
                    it = people.iterator();
                }
                it.next();
            }
            it.remove();
        }
        return people.get(0);
    }

    public static void main(String[] args) {
        System.out.println(process(new LinkedList<>(Arrays.asList(1, 2, 3, 4))));
    }
}