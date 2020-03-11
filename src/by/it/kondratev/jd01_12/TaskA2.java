package by.it.kondratev.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TaskA2 {

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new TreeSet<>();
        for (int i = 0; i < (int)(Math.random()*100+32); i++) {
            a.add((int)(Math.random()*30+32));
            b.add((int)(Math.random()*30+32));
        }
        System.out.println("HashSet a: " + a);
        System.out.println("TreeSet b: " + b);

        System.out.println("getCross(a, b): " + getCross(a, b));
        System.out.println("getUnion(a, b): " + getUnion(a, b));
    }

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> resultSet = new HashSet<>(a);
        resultSet.addAll(b);
        return resultSet;
    }

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> resultSet = new HashSet<>(a);
        resultSet.retainAll(b);
        return resultSet;
    }
}
