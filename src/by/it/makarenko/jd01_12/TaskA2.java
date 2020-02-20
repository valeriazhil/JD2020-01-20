package by.it.makarenko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    static Set<Integer>getCross(Set<Integer> a, Set<Integer> b){
        HashSet<Integer> hashSet = new HashSet<>(a);
        hashSet.retainAll(b);
        return hashSet;
    }
    static Set<Integer>getUnion(Set<Integer> a, Set<Integer> b){
        HashSet<Integer> hashSet = new HashSet<>(a);
        hashSet.addAll(b);
        return hashSet;
    }

    public static void main(String[] args) {
        Set<Integer> a=new HashSet<>(Arrays.asList(1,2,3,4,5,4,3,2,1));
        Set<Integer> b=new TreeSet<>(Arrays.asList(11,22,33,4,5,4,32,25,12));
        System.out.println(a);
        System.out.println(b);
        Set<Integer> cross = getCross(a,b);
        Set<Integer> union = getUnion(a,b);
        System.out.println(cross);
        System.out.println(union);

    }
}
