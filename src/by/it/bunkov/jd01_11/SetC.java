package by.it.bunkov.jd01_11;

import java.util.*;

class SetC<T> implements Set<T> {

    private List<T> array = new ListA<>();

    @Override
    public boolean add(T t) {
        if ((contains(t))) return false;
        array.add(t);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean isAllAdded = true;
        for (T element : c) {
            if (!add(element)) {
                isAllAdded = false;
            }
        }
        return isAllAdded;
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return array.contains(o);
    }

    @Override
    public Object[] toArray() {
        return array.toArray();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return array.containsAll(c);
    }

    @Override
    public boolean remove(Object o) {
        return array.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return array.removeAll(c);
    }

    @Override
    public void clear() {
        array.clear();
    }

    @Override
    public String toString() {
        return array.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetC<?> setC = (SetC<?>) o;
        return Objects.equals(array, setC.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(array);
    }

    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }

    // not implemented

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
