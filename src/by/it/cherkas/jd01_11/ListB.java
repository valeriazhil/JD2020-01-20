package by.it.cherkas.jd01_11;

import java.util.*;

class ListB<T> implements List<T> {

    private T[] elements = (T[]) new Object[0];
    private int size;

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            out.append(elements[i]);
            if (i < size - 1) out.append(", ");
        }
        out.append(']');
        return out.toString();
    }

    private void ensureCapacityInternal(int min) {
        if (size < min) {
            elements = Arrays.copyOf(elements, size + min);
        }
    }

    @Override
    public boolean add(T t) {
        ensureCapacityInternal(size + 1);
        elements[size++] = t;
        return true;
    }

    @Override
    public T remove(int index) {
        if (index < size && index >= 0) {
            T element = elements[index];
            System.arraycopy(elements, index + 1, elements, index, --size - index);
            return element;
        }
        return null;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public T set(int index, T element) {
        T oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        ensureCapacityInternal(size + 1);
        System.arraycopy(elements, index, elements, index + 1, ++size - index);
        elements[index] = element;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] array = (T[]) c.toArray();
        size += c.size();
        System.arraycopy(array, 0, elements, size - c.size(), c.size());
        return c.size() != 0;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = false;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    this.remove(i--);
                    size--;
                    if (!removed) {
                        removed = true;
                    }
                }
            }
        } else for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                this.remove(i--);
                size--;
                if (!removed) {
                    removed = true;
                }
            }
        }
        return removed;
    }

//stubs

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }


    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
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
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
