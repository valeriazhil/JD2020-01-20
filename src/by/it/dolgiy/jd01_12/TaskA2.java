package by.it.dolgiy.jd01_12;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TaskA2 {

    static Set<Integer> getCross(Set<Integer> a,Set<Integer> b){
        HashSet<Integer> cr = new HashSet<>(a);
        cr.retainAll(b);
        return cr;
    }

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        TreeSet<Integer> un = new TreeSet<>(a);
        un.addAll(b);
        return un;
    }

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(0,1,2,3,4,5,6));
        Set<Integer> b = new TreeSet<>(Arrays.asList(3,4,5,6,7,8,9));
        System.out.println(a);
        System.out.println(b);
        Set<Integer> cross = getCross(a,b);
        Set<Integer> union = getUnion(a,b);
        System.out.println(cross);
        System.out.println(union);
    }
}
