package by.it.kondratev.jd01_11;

import java.util.*;

class SetC<T>  implements Set<T> {

    private T[] elements = (T[]) new Object[0];
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size==0) return true;
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (o!=null) {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) return true;
            }
        } else
            for (int i = 0; i < size; i++) {
            if (elements[i]==null) return true;
        }
            return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        T[] col2 = (T[]) c.toArray();
        boolean b =true;
        for (T t : col2) {
            if (!this.contains(t)) { b=false; break;}
        }
        return b;
    }

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length*3/2+1);
        }
        if (contains(t)) return false;
        else { elements[size] = t; size++; return true; }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] col2 = (T[]) c.toArray();
        boolean b = false;
        for (T t : col2) {
            if (add(t)) b = true;
        }
        return b;
    }

    @Override
    public boolean remove(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(o)) {
                    System.arraycopy(elements, i + 1, elements, i, --size - i);
                    return true;
                }
            }
        } else for (int i = 0; i < size; i++) {
            if (elements[i]==null) {
                System.arraycopy(elements, i + 1, elements, i, --size - i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        T[] col2 = (T[]) c.toArray();
        boolean b = false;
        for (T t : col2) {
            if (this.remove(t)) b=true;
        }
        return b;
    }

    @Override
    public void clear() {
        for (int i = size-1; i >=0 ; i--) {
            remove(elements[i]);
        }

    }

        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size ; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return  null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
