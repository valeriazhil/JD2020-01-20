package by.it.gerasimov.jd01_12;

import java.util.*;

class TaskC2 {

    @SafeVarargs
    static Set<Number> getCross(Set<? extends Number>... args) {
        Set<Number> hashSet = new NumberSet<>(args[0]);
        for (Set<? extends Number> arg : args) {
            hashSet.retainAll(new NumberSet<>(arg));
        }
        return hashSet;
    }

    @SafeVarargs
    static Set<Number> getUnion(Set<? extends Number>... args) {
        Set<Number> hashSet = new NumberSet<>();
        for (Set<? extends Number> arg : args) {
            hashSet.addAll(new NumberSet<>(arg));
        }
        return hashSet;
    }

    public static void main(String[] args) {
        Set<Double> a = new HashSet<>(Arrays.asList(1.1, 2.0, 3.0));
        Set<Integer> b = new TreeSet<>(Arrays.asList(9, 9, 2, 3, 8, 7, 5, 6, 6, 7, 7));
        System.out.println(a);
        System.out.println(b);
        Set<Number> union = getCross(a, b);
        System.out.println(union);
        Set<Number> cross = getUnion(a, b);
        System.out.println(cross);
    }

    static class NumberSet<T extends Number> extends HashSet<T> {

        public NumberSet() {
            super();
        }

        public NumberSet(Collection<? extends T> c) {
            this.addAll(c);
        }

        @Override
        public boolean contains(Object o) {
            for (Number number : this) {
                if (number.doubleValue() == ((Number) o).doubleValue()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            boolean modified = false;
            for (T e : c) {
                if (!this.contains(e)) {
                    if (add(e)) {
                        modified = true;
                    }
                }
            }
            return modified;
        }
    }
}
