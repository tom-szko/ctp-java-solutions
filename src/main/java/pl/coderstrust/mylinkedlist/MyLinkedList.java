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
        if (element == null) {
            throw new IllegalArgumentException("Null is not a valid element.");
        }
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
        Node<E> nodeToFind = firstNode;
        for (int i = 0; i < size; i++, nodeToFind = nodeToFind.nextNode) {
            if (nodeToFind.element == element) {
                Node<E> previous = nodeToFind.previousNode;
                Node<E> next = nodeToFind.nextNode;
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
        }
        return false;
    }

    public boolean contains(E element) {
        Node<E> nodeToFind = firstNode;
        for (int i = 0; i < size; i++, nodeToFind = nodeToFind.nextNode) {
            if (nodeToFind.element == element) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        Node<E> currentNode = firstNode;
        Object[] elements = new Object[size];
        for (int i = 0; i < size; i++) {
            elements[i] = currentNode.element;
            if (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
        }
        return elements;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        private Node<E> currentNode;
        private int index;

        MyIterator() {
            index = 0;
            currentNode = firstNode;
        }

        public boolean hasNext() {
            return (index < size - 1);
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No such element!");
            }
            currentNode = currentNode.nextNode;
            index++;
            return currentNode.element;
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
}
