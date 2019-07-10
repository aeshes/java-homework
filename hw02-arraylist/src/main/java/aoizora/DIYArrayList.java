package aoizora;

import java.util.AbstractList;
import java.util.List;

public class DIYArrayList<E> extends AbstractList<E> implements List<E> {

    private Object[] elementData;
    private int size;

    public DIYArrayList() {
        this(5);
    }

    public DIYArrayList(int size) {
        super();
        if (size < 0)
            throw new IllegalArgumentException("Negative initial capacity");
        this.elementData = new Object[size];
    }

    public boolean add(E element) {
        ensureCapacityInternal(size + 1);
        this.elementData[size++] = element;
        return true;
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

    private void rangeCheck(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return this.size;
    }
}
