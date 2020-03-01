package by.it.dolgiy.jd01_11;



import java.util.*;

class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[0];
    private int size;
/////////////////////////////////////////////////
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i<size-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
//////////////////////////////////////////////////
    @Override
    public boolean add(T t) {
        if (!contains(t)){
            if (size==elements.length){
                elements=Arrays.copyOf(elements,elements.length*3/2+1);
            }
            elements[size++]=t;
            return true;
        }
        return false;
    }
/////////////////////////////////////////////////
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    System.arraycopy(elements, i + 1, elements, i, size - i);
                    size--;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i] != null && elements[i].equals(o)) {
                    System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }
///////////////////////////////////////////////////
    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                    return true;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i] != null && o.equals(elements[i])) {
                    return true;
                }
            }
        }
        return false;
    }
///////////////////////////////////////////////////
    @Override
    public int size() {
        return size;
    }
////////////////////////////////////////////////////
    @Override
    public boolean isEmpty() {
        return size==0;
    }
////////////////////////////////////////////////////
    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return false;
    }
////////////////////////////////////////////////////
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o))
                return false;
        }
        return true;
    }
///////////////////////////////////////////////////
    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }
///////////////////////////////////////////////////
    @Override
    public void clear() {
        elements = null;
        size = 0;
    }
///////////////////////////////////////////////////
    @Override
    public Iterator<T> iterator() {
        return null;
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
