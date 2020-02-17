package by.it.gerasimov.jd01_12;

import java.util.*;

public class TaskB3 {

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

    static <T> T processAsArrayList(LinkedList<T> people) {
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
        while (people.size() > 1) {
            people.addLast(people.pollFirst());
            people.pollFirst();
        }
        return people.peekFirst();
    }

    public static void main(String[] args) {
        String[] strPeople = new String[4096];
        for (int i = 0; i < strPeople.length; i++) {
            strPeople[i] = "Person " + i;
        }
        List<String> people = Arrays.asList(strPeople);
        ArrayList<String> arrayPeople = new ArrayList<>(people);
        LinkedList<String> linkedPeople = new LinkedList<>(people);
        double start = System.nanoTime();
        System.out.println(process(arrayPeople));
        System.out.println((System.nanoTime() - start) / 1000);
        start = System.nanoTime();
        System.out.println(processAsArrayList(linkedPeople));
        System.out.println((System.nanoTime() - start) / 1000);
        start = System.nanoTime();
        System.out.println(process(linkedPeople));
        System.out.println((System.nanoTime() - start) / 1000);
    }
}
