package by.it.degtyaryov.jd01_11;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetC<T> implements Set<T> {

    private List<T> array = new ListA<>();

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
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return array.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if ((contains(t))) return false;
        array.add(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return array.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return array.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean isAllAdded = false;
        for (T element : c) {
            isAllAdded = isAllAdded || add(element);
        }
        return isAllAdded;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return array.removeAll(c);
    }

    @Override
    public void clear() {
        array.clear();
    }

    // not implemented

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
