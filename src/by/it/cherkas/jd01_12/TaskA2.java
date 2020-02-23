package by.it.cherkas.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TaskA2 {
    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        result.retainAll(two);
        return result;
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 7, 5));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(5, 6, 7, 7, 8, 8, 9, 7, 5, 9, 10, 11));

        System.out.println("Set one: " + treeSet);
        System.out.println("Set two: " + hashSet);

        System.out.println("getCross(a, b): " + getCross(treeSet, hashSet));
        System.out.println("getUnion(a, b): " + getUnion(treeSet, hashSet));
    }
}
