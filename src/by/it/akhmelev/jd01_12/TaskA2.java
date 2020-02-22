package by.it.akhmelev.jd01_12;

import java.util.*;

public class TaskA2 {

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        HashSet<Integer> hashSet = new HashSet<>(a);
        hashSet.retainAll(b);
        return hashSet;
    }

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        HashSet<Integer> hashSet = new HashSet<>(a);
        hashSet.addAll(b);
        return hashSet;
    }

    public static void main(String[] args) {
        Set<Integer> a=new HashSet<>(Arrays.asList(1,2,3,4,5,5,6,6,7,97));
        Set<Integer> b=new TreeSet<>(Arrays.asList(9,9,8,8,7,5,6,6,7,7));
        System.out.println(a);
        System.out.println(b);
        Set<Integer> union = getUnion(a, b);
        Set<Integer> cross = getCross(a, b);
        System.out.println(union);
        System.out.println(cross);
    }
}
