package by.it.makarenko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    static Set<Integer>getCross(Set<Integer> a, Set<Integer> b){
        return null;
    }
    static Set<Integer>getUnion(Set<Integer> a, Set<Integer> b){
        HashSet<Integer> hashSet = new HashSet<>(a);
//        HashSet.addAll(b);
//        return HashSet;
        return null;
    }

    public static void main(String[] args) {
        Set<Integer> a=new HashSet<>(Arrays.asList(1,2,3,4,5,4,3,2,1));
        Set<Integer> b=new TreeSet<>(Arrays.asList(11,22,33,4,5,4,32,25,12));
        System.out.println(a);
        System.out.println(b);
    }
}
