package by.it.bunkov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(a);
        res.retainAll(b);
        return res;

    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }


    public static void main(String[] args) {
        TreeSet<Integer>  treeSet= new TreeSet<>(Arrays.asList(1, 2, 3, 5, 6, 7, 96));
        HashSet<Integer>  hashSet= new HashSet<>(Arrays.asList(234, 111, 5, 5, 6, 7, 96));

        System.out.println(getUnion(treeSet,hashSet));
        System.out.println(getCross(treeSet,hashSet));
        //  Set<Integer> u

    }
}
