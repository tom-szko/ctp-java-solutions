package pl.coderstrust.mylist;

import java.util.*;

public class MyArrayList<T> implements List<T> {

    private Object[] elementContainer;
    private int listSize;

    MyArrayList(int numberOfItems) {
        if (numberOfItems >= 0) {
            elementContainer = new Object[numberOfItems];
            listSize = 0;
        } else {
            throw new IllegalArgumentException("Illegal numberOfItems: " + numberOfItems + ".");
        }
    }

    MyArrayList() {
        this(10);
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        return (listSize == 0);
    }

    @Override
    public boolean contains(Object object) {
        for (int i = 0; i < listSize; i++) {
            if (elementContainer[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementContainer, listSize);
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < listSize) {
            return (T[]) Arrays.copyOf(elementContainer, listSize, array.getClass());
        }
        System.arraycopy(elementContainer, 0, array, 0, listSize);
        if (array.length > listSize) {
            array[listSize] = null;
        }
        return array;
    }

    @Override
    public boolean add(T t) {
        if (listSize + 1 <= elementContainer.length) {
            elementContainer[listSize] = t;
            listSize++;
            return true;
        } else if (listSize + 1 >= elementContainer.length) {
            elementContainer = grow();
            elementContainer[listSize] = t;
            listSize++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < listSize; i++) {
            if (elementContainer[i].equals(o)) {
                System.arraycopy(elementContainer, i + 1, elementContainer, i, listSize - i);
                listSize--;
                if (listSize < elementContainer.length / 4) {
                    elementContainer = shrink();
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        elementContainer = new Object[]{};
        listSize = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        return (T) elementContainer[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        T oldElement = (T) elementContainer[index];
        elementContainer[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        if (listSize + 1 > elementContainer.length) {
            elementContainer = grow();
        }
        System.arraycopy(elementContainer, index, elementContainer, index + 1, listSize - index);
        listSize++;
        elementContainer[index] = element;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        T oldElement = (T) elementContainer[index];
        System.arraycopy(elementContainer, index + 1, elementContainer, index, listSize - index);
        listSize--;
        if (listSize < elementContainer.length / 4) {
            elementContainer = shrink();
        }
        return oldElement;
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < listSize; i++) {
            if (elementContainer[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int lastIndexOfElement = -1;
        for (int i = 0; i < listSize; i++) {
            if (elementContainer[i].equals(object)) {
                lastIndexOfElement = i;
            }
        }
        return lastIndexOfElement;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex is out of bounds!");
        }
        if (toIndex > listSize) {
            throw new IndexOutOfBoundsException("toIndex is out of bounds!");
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex cannot be greater than toIndex.");
        }
        int size = toIndex - fromIndex;
        List<T> resultList = new MyArrayList<>(size);
        for (int i = 0; i < size; i++) {
            resultList.add(i, (T) this.elementContainer[fromIndex + i]);
        }
        return resultList;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean isModified = false;
        for (T t : collection) {
            if (this.add(t)) {
                isModified = true;
            }
        }
        return isModified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        boolean isModified = false;
        if (listSize + collection.size() > elementContainer.length) {
            elementContainer = Arrays.copyOf(elementContainer, elementContainer.length + collection.size());
        }
        for (int i = listSize - 1; i > index + collection.size(); i--) {
            elementContainer[i] = elementContainer[listSize - (index + collection.size())];
        }
        for (T t : collection) {
            this.add(index, t);
            index++;
            isModified = true;
        }
        return isModified;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isModified = false;
        for (Object object : collection) {
            if (this.remove(object)) {
                isModified = true;
            }
        }
        return isModified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        Object[] tempElementArray = Arrays.copyOf(elementContainer, size());
        boolean isModified = false;
        for (Object aTempElementArray : tempElementArray) {
            boolean contains = false;
            for (Object object : collection) {
                if (aTempElementArray.equals(object)) {
                    contains = true;
                }
            }
            if (!contains) {
                if (remove(aTempElementArray)) {
                    isModified = true;
                }
            }
        }
        return isModified;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyListIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new MyListIterator(index);
    }

    private T[] grow() {
        return (T[]) Arrays.copyOf(elementContainer, elementContainer.length * 2);
    }

    private T[] shrink() {
        return (T[]) Arrays.copyOf(elementContainer, elementContainer.length / 4);
    }

    private class MyIterator implements Iterator<T> {

        int elementIndex;

        MyIterator() {
            elementIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return elementIndex != listSize;
        }

        @Override
        public T next() {
            try {
                T element = get(elementIndex);
                elementIndex++;
                return element;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }
    }

    private class MyListIterator extends MyIterator implements ListIterator<T> {

        MyListIterator(int index) {
            super();
            if (elementIndex < 0 || elementIndex > size()) {
                throw new IndexOutOfBoundsException("Index out of bounds!");
            }
            elementIndex = index;
        }

        @Override
        public boolean hasPrevious() {
            return elementIndex != 0;
        }

        @Override
        public T previous() {
            try {
                elementIndex--;
                return get(elementIndex);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        @Override
        public int nextIndex() {
            return elementIndex;
        }

        @Override
        public int previousIndex() {
            return elementIndex - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override
        public void set(T t) {
            throw new UnsupportedOperationException("set");
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException("add");
        }
    }
}
