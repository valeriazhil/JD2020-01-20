package by.it.bunkov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskA2 {

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        return null;

    }
    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        HashSet<Integer> hashSet = new HashSet<>(a);
        hashSet.addAll(b);

        return hashSet;

    }


    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3,5,6,7,96));
        Set<Integer> b = new HashSet<>(Arrays.asList(9,5,3,5,6,7,8));
        System.out.println(a);
        System.out.println(b);
      //  Set<Integer> u

    }
}
