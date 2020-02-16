package by.it.zhuravaskarabahataya.jd01_12;


// TaskC2. Попробуйте решить заново задачу TaskA2 для любого количества множеств на входе метода,
// а также для различных типов чисел в каждом из множеств (generics).
//  В main покажите работоспособность решения.

import java.util.*;

class TaskC2 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 4));
        Set<Integer> b = new TreeSet<>(Arrays.asList(3, 1, 1, 5, 9, 2, 6, 20, 21, 22));
        Set<Integer> c = new HashSet<>(Arrays.asList(3, 5, 9, 2, 6, 20, 21, 22));
        Set<Integer> d = new HashSet<>(Arrays.asList(3, 5, 2, 6, 20, 21, 22, 24));
        Set<String> q = new HashSet<>(Arrays.asList("Биба", "Боба"));
        Set<String> w = new HashSet<>(Arrays.asList("Биба", "Боба", "Друзья"));
        Set<String> e = new HashSet<>(Arrays.asList("Биба"));
        Set<String> r = new HashSet<>(Arrays.asList("Биба", "Боба", "Шальные", "Ребята"));

        System.out.println(getCross(a, b));
        System.out.println(getCross(a, b, c,d));
        System.out.println(getUnion(a, b));
        System.out.println(getUnion(a, b, c, d));
        System.out.println(getCross(q, w, e, r));
        System.out.println(getUnion(q, w, e, r));
    }

    private static Set<?> getCross(Set<?>... set) {
        Set<Object> result = new HashSet<>(set[0]);
        for (int i = 1; i < set.length; i++) {
            result = (Set<Object>) getCross(result, set[i]);
        }
        return result;
    }

    private static Set<?> getCross(Set<?> set1, Set<?> set2) {
        Set<Object> result = new HashSet<>();
        Iterator<?> iterator = set1.iterator();
        while (iterator.hasNext()){
            Object set1Member = iterator.next();
            if (set2.contains(set1Member)){
                result.add(set1Member);
            }
        }
        return result;
    }

    private static Set<?> getUnion(Set<?>... set) {
        Set<?> result = new HashSet<>(set[0]);
        for (int i = 1; i < set.length; i++) {
            result = getUnion(result, set[i]);
        }
        return result;
    }

    private static Set<?> getUnion(Set<?> set1, Set<?> set2) {
        Set<Object> result = new HashSet<>(set1);
        Iterator<?> iterator = set2.iterator();
        while (iterator.hasNext()){
            Object set2Member = iterator.next();
            if (!result.contains(set2Member)){
                result.add(set2Member);
            }
        }
        return result;
    }

}
