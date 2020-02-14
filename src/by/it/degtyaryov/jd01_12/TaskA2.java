package by.it.degtyaryov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TaskA2 {

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 7, 5));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 7, 8, 8, 9, 7, 5, 9, 10, 11));
        System.out.println("Множество А: " + a);
        System.out.println("Множество B: " + b);
        getCross(a, b);
        getUnion(a, b);
        System.out.println("Множество А: " + a);
        System.out.println("Множество B: " + b);
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> resultSet = new HashSet<>(a);
        resultSet.addAll(b);
        return resultSet;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> resultSet = new HashSet<>(a);
        resultSet.retainAll(b);
        return resultSet;
    }
}
