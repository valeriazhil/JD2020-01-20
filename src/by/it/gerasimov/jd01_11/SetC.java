package by.it.gerasimov.jd01_11;

//import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class SetC<T> implements Set<T> {

    ListB<T> elements = new ListB<>();

    @Override
    public String toString() {
        return elements.toString();
    }

    @Override
    public boolean add(T t) {
        if (!elements.contains(t)) {
            elements.add(t);
        }
        return true;
    }
    @Override
    public int size() {
        return elements.size();
    }
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean add = false;
        for (T e : c) {
            if (!elements.contains(e)) {
                elements.add(e);
                if (!add) {
                    add = true;
                }
            }
        }
        return add;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!elements.contains(o)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removed = false;
        for (Object o : c) {
            if (elements.remove(o)) {
                removed = true;
            }
        }
        return removed;
    }
    @Override
    public void clear() {
        elements.clear();
    }

    @Override
    public Object[] toArray() {
        return elements.toArray();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }
    @Override
    public boolean remove(Object o) {
        return false;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
