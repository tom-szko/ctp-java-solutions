package pl.coderstrust.mylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(E element) {
        isValidElement(element);
        Node<E> previous = lastNode;
        Node<E> newNode = new Node(element, previous, null);
        if (previous == null) {
            firstNode = newNode;
            lastNode = firstNode;
        } else {
            lastNode = newNode;
            previous.nextNode = lastNode;
        }
        size++;
    }

    public boolean remove(E element) {
        isValidElement(element);
        Node<E> found = find(element);
        if (found != null) {
            Node<E> previous = found.previousNode;
            Node<E> next = found.nextNode;
            if (previous == null) {
                firstNode = next;
            } else {
                previous.nextNode = next;
            }
            if (next == null) {
                lastNode = previous;
            } else {
                next.previousNode = previous;
            }
            size--;
            return true;
        }
        return false;
    }

    private Node<E> find(E element) {
        Node<E> nodeToFind = firstNode;
        for (int i = 0; i < size; i++, nodeToFind = nodeToFind.nextNode) {
            if (nodeToFind.element.equals(element)) {
                return nodeToFind;
            }
        }
        return null;
    }

    public boolean contains(E element) {
        isValidElement(element);
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        Object[] elements = new Object[size];
        int elementIndex = 0;
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            elements[elementIndex] = iterator.next();
            elementIndex++;
        }
        return elements;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private void isValidElement(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Null as element is not allowed.");
        }
    }

    private class Node<T> {
        private T element;
        private Node<T> nextNode;
        private Node<T> previousNode;

        Node(T element, Node<T> previousNode, Node<T> nextNode) {
            this.element = element;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }
    }

    private class LinkedListIterator implements Iterator {
        private Node<E> following;
        private Node<E> returned;
        private int nextIndex;

        LinkedListIterator() {
            following = firstNode;
            nextIndex = 0;
        }

        public boolean hasNext() {
            return (nextIndex < size);
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No such element!");
            }
            returned = following;
            following = following.nextNode;
            nextIndex++;
            return returned.element;
        }
    }
}
