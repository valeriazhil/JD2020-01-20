package by.it.degtyaryov.jd01_11;

import java.util.*;

class ListA<T> implements List<T> {

    private T[] values = (T[]) new Object[0];
    private int size;

    @Override
    public boolean add(T t) {
        if (size >= values.length) {
            values = Arrays.copyOf(values, values.length * 3 / 2 + 1);
        }
        values[size++] = t;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            return;
        }
        if (size >= values.length) {
            values = Arrays.copyOf(values, values.length * 3 / 2 + 1);
        }
        System.arraycopy(values, index, values, index + 1, size++ - index);
        values[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T elemToDelete = values[index];
        System.arraycopy(values, index + 1, values, index, --size - index);
        return elemToDelete;
    }

    @Override
    public boolean remove(Object o) {
        boolean wasDeleted = false;
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            wasDeleted = true;
        }
        return wasDeleted;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean wasRemoved = false;
        for (Object element : c) {
            if (remove(element)) {
                wasRemoved = true;
            }
        }
        return wasRemoved;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (values[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(values[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        values = (T[]) new Object[0];
        size = 0;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            return null;
        }
        T oldValue = values[index];
        values[index] = element;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (values[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(values[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i > 0; i--) {
                if (values[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i > 0; i--) {
                if (o.equals(values[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(values, size);
    }

    @Override
    public String toString() {
        StringBuilder strValue = new StringBuilder();
        strValue.append('[');
        for (int i = 0; i < size; i++) {
            strValue.append(values[i]);
            if (i != size - 1) {
                strValue.append(", ");
            }
        }
        strValue.append(']');
        return strValue.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListA<?> listA = (ListA<?>) o;
        return size == listA.size &&
                Arrays.equals(values, listA.values);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        T[] array = Arrays.copyOfRange(values, fromIndex, toIndex);
        return Arrays.asList(array);
    }

    @Override
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        if (index >= size) {
            return null;
        }
        return new ListIterator<T>() {

            int cursor = index;

            @Override
            public boolean hasNext() {
                return size - cursor > 1;
            }

            @Override
            public T next() {
                return values[++cursor];
            }

            @Override
            public boolean hasPrevious() {
                return cursor > 0;
            }

            @Override
            public T previous() {
                return values[--cursor];
            }

            @Override
            public int nextIndex() {
                return cursor + 1;
            }

            @Override
            public int previousIndex() {
                return cursor - 1;
            }

            @Override
            public void remove() {
                ListA.this.remove(cursor);
            }

            @Override
            public void set(T t) {
                ListA.this.set(cursor, t);
            }

            @Override
            public void add(T t) {
                ListA.this.add(cursor, t);
            }
        };
    }

    // not implemented

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean wasRemoved = false;
        for (int i = 0; i < size; i++) {
            if(!c.contains(values[i])){
                remove(i);
                wasRemoved = true;
            }
        }
        return wasRemoved;
    }
}
