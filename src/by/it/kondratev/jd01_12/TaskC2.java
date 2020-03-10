package by.it.kondratev.jd01_12;

import java.util.*;

class TaskC2 {

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 7, 5));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 7, 8, 8, 9, 7, 5, 9, 10, 11));
        Set<Integer> c = new HashSet<>(Arrays.asList(7, 8, 9, 11, 13, 15, 12));

        Set<Short> d = new HashSet<>(Arrays.asList((short) 1, (short) 2, (short) 3));
        Set<Short> e = new TreeSet<>(Arrays.asList((short) 3, (short) 2, (short) 4));

        System.out.println("Множество А: " + a);
        System.out.println("Множество B: " + b);
        System.out.println("Множество C: " + c);
        System.out.println("Множество D: " + d);
        System.out.println("Множество E: " + e);

        System.out.println("getCross(a, b, c): " + getCross(a, b, c));
        System.out.println("getUnion(a, b, c): " + getUnion(a, b, c));
        System.out.println("getCross(d, e): " + getCross(d, e));
        System.out.println("getUnion(d, e): " + getUnion(d, e));
    }

    private static <T extends Number> Set<T> getUnion(Set<T>... sets) {
        Set<T> resultSet = new HashSet<>();
        for (Set<T> set : sets) {
            resultSet.addAll(set);
        }
        return resultSet;
    }

    private static <T extends Number> Set<T> getCross(Set<T>... sets) {
        if (sets.length <= 0) {
            return Collections.EMPTY_SET;
        }
        Set<T> resultSet = new HashSet<>(sets[0]);
        for (int i = 1; i < sets.length; i++) {
            resultSet.retainAll(sets[i]);
        }
        return resultSet;
    }
}
