package pl.coderstrust.mylinkedlist;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class MyLinkedListTest {

    @Test
    public void testEmptyList() {
        // when
        MyLinkedList<String> myList = new MyLinkedList<>();

        // then
        assertEquals(0, myList.size());
    }

    @Test
    @Parameters(method = "testSizeParameters")
    public void testSize(String[] elements, int expectedSize) {
        // given
        MyLinkedList<String> myList = new MyLinkedList<>();
        for (int i = 0; i < elements.length; i++) {
            myList.add(elements[i]);
        }

        // then
        assertEquals(expectedSize, myList.size());
    }

    private Object[] testSizeParameters() {
        return new Object[]{
                new Object[]{new String[]{"One"}, 1},
                new Object[]{new String[]{"One", "Two", "Three"}, 3},
                new Object[]{new String[]{"One", "Two", "Three", "Four", "Five", "Six"}, 6}
        };
    }

    @Test
    @Parameters(method = "testAddParameters")
    public void testAdd(Integer[] elements, int expectedSize, Integer[] expectedContents) {
        // given
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        // when
        for (int i = 0; i < elements.length; i++) {
            myList.add(elements[i]);
        }
        int actualSize = myList.size();
        Object[] actualContents = myList.toArray();

        // then
        assertEquals(expectedSize, actualSize);
        assertArrayEquals(expectedContents, actualContents);
    }

    private Object[] testAddParameters() {
        return new Object[]{
                new Object[]{new Integer[]{1}, 1, new Integer[]{1}},
                new Object[]{new Integer[]{1, 2, 3}, 3, new Integer[]{1, 2, 3}},
                new Object[]{new Integer[]{1, 2, 3, 4, 5, 6}, 6, new Integer[]{1, 2, 3, 4, 5, 6}}
        };
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddWithIllegalArgument() {
        // given
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        // when
        myList.add(null);
    }

    @Test
    @Parameters(method = "testRemoveParameters")
    public void testRemove(String element, boolean expectedResult, int expectedSize, String[] expectedContents) {
        // given
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("One");
        myList.add("Two");
        myList.add("Two");
        myList.add("Three");

        // when
        boolean actualResult = myList.remove(element);
        int actualSize = myList.size();
        Object[] actualContents = myList.toArray();

        // then
        assertEquals(expectedSize, actualSize);
        assertEquals(expectedResult, actualResult);
        assertArrayEquals(expectedContents, actualContents);
    }

    private Object[] testRemoveParameters() {
        return new Object[]{
                new Object[]{"Seven", false, 4, new String[]{"One", "Two", "Two", "Three"}},
                new Object[]{"One", true, 3, new String[]{"Two", "Two", "Three"}},
                new Object[]{"Two", true, 3, new String[]{"One", "Two", "Three"}},
                new Object[]{"Three", true, 3, new String[]{"One", "Two", "Two"}}
        };
    }

    @Test
    @Parameters(method = "testContainsParameters")
    public void testContains(String element, boolean expectedResult) {
        // given
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("One");
        myList.add("Two");
        myList.add("Three");

        // when
        boolean actualResult = myList.contains(element);

        // then
        assertEquals(expectedResult, actualResult);
    }

    private Object[] testContainsParameters() {
        return new Object[]{
                new Object[]{"Seven", false},
                new Object[]{"One", true},
                new Object[]{"Two", true},
                new Object[]{"Three", true}
        };
    }

    @Test
    public void testHasNext() {
        // given
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        Iterator iterator = myList.iterator();

        // when
        boolean actualResult = iterator.hasNext();

        // then
        assertTrue(actualResult);
    }

    @Test
    public void testHasNextOnLastElement() {
        // given
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("One");
        myList.add("Two");
        Iterator iterator = myList.iterator();
        iterator.next();

        // when
        boolean actualResult = iterator.hasNext();

        // then
        assertFalse(actualResult);
    }

    @Test
    public void testNext() {
        // given
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("One");
        myList.add("Two");
        Iterator iterator = myList.iterator();

        // when
        String actualNextElement = (String) iterator.next();

        // then
        assertEquals("Two", actualNextElement);
    }

    @Test(expected = NoSuchElementException.class)
    public void testNextWithException() {
        // given
        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("One");
        Iterator iterator = myList.iterator();

        // when
        iterator.next();
    }
}
