package by.it.anackij.jd01_11;

import java.util.*;

public class ListA<T> implements List<T> {
    private T[] elements = (T[]) new Object[0];
    private int size;

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements= Arrays.copyOf(elements,elements.length*3/2+1);
        }
        elements[size++]=t;
        return true;
    }

    @Override
    public void add(int i, T t) {
    }

    @Override
    public T remove(int index) {
        // 1 2 3 4
        T element = elements[index];
        System.arraycopy(elements,index+1,element,index,size-index-1);

        return element;
    }

    @Override
    public T get(int i) {
        return elements[i];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            out.append(elements[i]);
            if (i<size-1) out.append(", ");
        }
        out.append(']');
        return out.toString();
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T set(int i, T t) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }
}
