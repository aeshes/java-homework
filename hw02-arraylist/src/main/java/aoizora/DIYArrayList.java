package aoizora;

import java.util.*;

public class DIYArrayList<E> implements List<E> {

    private Object[] elementData;
    private int size;
    private final static int DEFAULT_CAPACITY = 5;

    public DIYArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public DIYArrayList(int size) {
        super();
        if (size < 0)
            throw new IllegalArgumentException("Negative initial capacity");
        this.elementData = new Object[size];
    }

    @Override
    public boolean add(E element) {
        ensureCapacityInternal(size + 1);
        this.elementData[size++] = element;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private void ensureCapacityInternal(int capacity) {
        if (capacity >= size) {
            realloc(capacity);
        }
    }

    private void realloc(int minCapacity) {
        if (minCapacity < elementData.length) {
            return;
        }

        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 2);
        Object[] newData = new Object[newCapacity];
        System.arraycopy(elementData, 0, newData, 0, size);
        this.elementData = newData;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = (E) elementData[index];
        elementData[index] = element;
        return old;
    }

    @Override
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public E remove(int i) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public List<E> subList(int i, int i1) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private class Itr implements Iterator<E> {
        int cursor;
        int lastRet = -1; // index of last element returned; -1 if no such

        public boolean hasNext() {
            return cursor != size;
        }


        @SuppressWarnings("unchecked")
        public E next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();

            Object[] elementData = DIYArrayList.this.elementData;

            cursor = i + 1;

            return (E) elementData[lastRet = i];
        }


        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            try {
                DIYArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

        private class ListItr extends Itr implements ListIterator<E> {
            ListItr(int index) {
                super();
                cursor = index;
            }

          public boolean hasPrevious() {
                return cursor != 0;
            }

          public int nextIndex() {
                return cursor;
            }

          public int previousIndex() {
                return cursor - 1;
           }

          @SuppressWarnings("unchecked")
          public E previous() {
                int i = cursor - 1;
                if (i < 0)
                    throw new NoSuchElementException();

                Object[] elementData = DIYArrayList.this.elementData;

                cursor = i;
                return (E) elementData[lastRet = i];
        }

          public void set(E e) {
                if (lastRet < 0)
                    throw new IllegalStateException();
                try {
                    DIYArrayList.this.set(lastRet, e);
                } catch (IndexOutOfBoundsException ex) {
                    throw new ConcurrentModificationException();
                }
            }

          public void add(E e) {
                try {
                    int i = cursor;
                    DIYArrayList.this.add(i, e);
                    cursor = i + 1;
                    lastRet = -1;
                } catch (IndexOutOfBoundsException ex) {
                    throw new ConcurrentModificationException();
                }
              }
        }
}
