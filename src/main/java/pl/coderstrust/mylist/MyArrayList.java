package pl.coderstrust.mylist;

import java.util.*;

public class MyArrayList implements List<Long> {

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
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(elementContainer, a.length);
    }

    @Override
    public boolean add(Long aLong) {
        if (listSize + 1 <= elementContainer.length) {
            elementContainer[listSize] = aLong;
            listSize++;
            return true;
        } else if (listSize + 1 >= elementContainer.length) {
            elementContainer = Arrays.copyOf(elementContainer, elementContainer.length + 10);
            elementContainer[listSize] = aLong;
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
    public Long get(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        return (Long) elementContainer[index];
    }

    @Override
    public Long set(int index, Long element) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        Long oldElement = (Long) elementContainer[index];
        elementContainer[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, Long element) {
        if (index < 0 || index > listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        if (listSize + 1 > elementContainer.length) {
            elementContainer = Arrays.copyOf(elementContainer, elementContainer.length + 10);
        }
        System.arraycopy(elementContainer, index, elementContainer, index + 1, listSize - index);
        listSize++;
        elementContainer[index] = element;
    }

    @Override
    public Long remove(int index) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        Long oldElement = (Long) elementContainer[index];
        System.arraycopy(elementContainer, index + 1, elementContainer, index, listSize - index);
        listSize--;
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
    public List<Long> subList(int fromIndex, int toIndex) {
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
        List<Long> resultList = new MyArrayList(size);
        for (int i = 0; i < size; i++) {
            resultList.add(i, (Long) this.elementContainer[fromIndex + i]);
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
    public boolean addAll(Collection<? extends Long> c) {
        boolean isModified = false;
        for (Long l : c) {
            if (this.add(l)) {
                isModified = true;
            }
        }
        return isModified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Long> collection) {
        boolean isModified = false;
        if (listSize + collection.size() > elementContainer.length) {
            elementContainer = Arrays.copyOf(elementContainer, elementContainer.length + collection.size());
        }
        for (int i = listSize - 1; i > index + collection.size(); i--) {
            elementContainer[i] = elementContainer[listSize - (index + collection.size())];
        }
        for (Long l : collection) {
            this.add(index, l);
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
    public Iterator<Long> iterator() {
        return new MyIterator();
    }

    @Override
    public ListIterator<Long> listIterator() {
        return new MyListIterator(0);
    }

    @Override
    public ListIterator<Long> listIterator(int index) {
        return new MyListIterator(index);
    }

    private class MyIterator implements Iterator<Long> {

        int elementIndex;

        MyIterator() {
            elementIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return elementIndex != listSize;
        }

        @Override
        public Long next() {
            try {
                Long element = get(elementIndex);
                elementIndex++;
                return element;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }
    }

    private class MyListIterator extends MyIterator implements ListIterator<Long> {

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
        public Long previous() {
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
        public void set(Long t) {
            throw new UnsupportedOperationException("set");
        }

        @Override
        public void add(Long t) {
            throw new UnsupportedOperationException("add");
        }
    }
}
