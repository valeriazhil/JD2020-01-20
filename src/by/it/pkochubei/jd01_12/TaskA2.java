package by.it.pkochubei.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 4, 6, 7, 3, 45, 5, 4, 6, 8, 0, 4, 2, 4, 6, 7, 4));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(3, 0, 7, 7, 1, 45, 5, 4, 6, 8, 2, 3, 2, 4, 6, 7, 4));
        System.out.println(getUnion(hashSet, treeSet));
        System.out.println(getCross(hashSet, treeSet));
    }
}
