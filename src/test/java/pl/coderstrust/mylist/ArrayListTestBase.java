package pl.coderstrust.mylist;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public abstract class ArrayListTestBase {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    public abstract List<Long> getEmptyList();

    public abstract List<Long> getEmptyList(int elements);

    List<Long> list;

    @Test
    public void testEmptyList() {
        // when
        list = getEmptyList();

        // then
        assertEquals(0, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-3", "101"})
    public void testConstructorWithIllegalParameters(int numberOfElements) {
        new MyArrayList<>(numberOfElements);
    }

    @Test
    public void testSizeWhenSomeNumbersAdded() {
        // given
        list = getEmptyList();
        list.add(2L);
        list.add(4L);
        list.add(6L);

        // when
        int actualSize = list.size();

        // then
        assertEquals(3, actualSize);
    }

    @Test
    public void testIsEmptyWhenListSizeIsZero() {
        // given
        list = getEmptyList();

        // then
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyWhenListSizeGreaterThanZero() {
        // given
        list = getEmptyList();
        list.add(3L);

        // then
        assertFalse(list.isEmpty());
    }

    @Test
    @Parameters({"5, true", "6, true", "-9, true", "1, false"})
    public void testContains(long element, boolean expectedContains) {
        // given
        list = getEmptyList();
        list.add(5L);
        list.add(6L);
        list.add(-9L);

        // when
        boolean actualContains = list.contains(element);

        // then
        assertEquals(expectedContains, actualContains);
    }

    @Test
    public void testToArrayWithObject() {
        // given
        list = getEmptyList();
        list.add(5L);
        list.add(6L);
        list.add(-9L);
        list.add(-12332L);

        // when
        Object[] actualResult = list.toArray();

        // then
        assertArrayEquals(new Object[]{5L, 6L, -9L, -12332L}, actualResult);
    }

    @Test
    @Parameters(method = "testToArrayWithGenericParameters")
    public void testToArrayWithGeneric(int destinationLength, Long[] expectedResult) {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        Long[] destination = new Long[destinationLength];

        // when
        Object[] actualResult = list.toArray(destination);

        // then
        assertArrayEquals(expectedResult, actualResult);
    }

    private Object[] testToArrayWithGenericParameters() {
        return new Object[]{
                new Object[]{5, new Long[]{1L, 2L, 3L, null, null}},
                new Object[]{0, new Long[]{1L, 2L, 3L}},
                new Object[]{3, new Long[]{1L, 2L, 3L}},
        };
    }

    @Test
    @Parameters(method = "testToArrayWithGenericException")
    public void testToArrayWithGenericException(Object[] destinationArray, Class exceptionType) {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        Object[] destination = destinationArray;

        // when
        exception.expect(exceptionType);
        list.toArray(destination);
    }

    private Object[] testToArrayWithGenericException() {
        return new Object[]{
                new Object[]{null, NullPointerException.class},
                new Object[]{new String[5], ArrayStoreException.class},
        };
    }

    @Test
    @Parameters(method = "testAddParameters")
    public void testAdd(Long[] elementsToAdd, int expectedListSize) {
        // given
        list = getEmptyList();

        // when
        boolean actualResult = false;
        for(int i = 0; i < elementsToAdd.length; i++) {
            actualResult = list.add(elementsToAdd[i]);
        }
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        // then
        assertTrue(actualResult);
        assertArrayEquals(elementsToAdd, actualResultArray);
        assertEquals(expectedListSize, actualListSize);
    }

    private Object[] testAddParameters() {
        return new Object[] {
                new Object[]{new Long[]{1L}, 1},
                new Object[]{new Long[]{1L, 2L, 3L, 4L, 5L}, 5},
                new Object[]{new Long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L}, 11},
        };
    }

    @Test(expected = OutOfMemoryError.class)
    public void testAddException() {
        // given
        list = new MyArrayList<>();
        for(long i = 0; i < 101; i++) {
            list.add(i);
        }

        // when
        list.add(101L);
    }

    @Test
    public void testRemoveExistentElement() {
        // given
        list = getEmptyList();
        list.add(13L);
        list.add(45L);
        list.add(123L);
        list.add(1L);

        // when
        boolean actualRemoveResult = list.remove(45L);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        // then
        assertTrue(actualRemoveResult);
        assertArrayEquals(new Object[]{13L, 123L, 1L}, actualResultArray);
        assertEquals(3, actualListSize);
    }

    @Test
    public void testRemoveElementWhenDoubled() {
        // given
        list = getEmptyList();
        list.add(13L);
        list.add(45L);
        list.add(45L);
        list.add(45L);
        list.add(1L);

        // when
        boolean actualRemoveResult = list.remove(45L);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        // then
        assertTrue(actualRemoveResult);
        assertArrayEquals(new Object[]{13L, 45L, 45L, 1L}, actualResultArray);
        assertEquals(4, actualListSize);
    }

    @Test
    public void testRemoveNonExistentElement() {
        // given
        list = getEmptyList();
        list.add(13L);
        list.add(45L);
        list.add(123L);
        list.add(1L);

        // when
        boolean actualRemoveResult = list.remove(44L);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        // then
        assertFalse(actualRemoveResult);
        assertArrayEquals(new Object[]{13L, 45L, 123L, 1L}, actualResultArray);
        assertEquals(4, actualListSize);
    }

    @Test
    public void testClearWithEmptyList() {
        // given
        list = getEmptyList();

        // when
        list.clear();
        int actualSize = list.size();
        Object[] actualListContents = list.toArray();

        // then
        assertEquals(0, actualSize);
        assertArrayEquals(new Object[]{}, actualListContents);
    }

    @Test
    public void testClearWithNonEmptyList() {
        // given
        list = getEmptyList();
        list.add(13L);
        list.add(45L);
        list.add(123L);

        // when
        list.clear();
        int actualSize = list.size();
        Object[] actualListContents = list.toArray();

        // then
        assertEquals(0, actualSize);
        assertArrayEquals(new Object[]{}, actualListContents);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @Parameters({"-1", "4", "6"})
    public void testGetWithIllegalIndex(int index) {
        // given
        list = getEmptyList();
        list.add(4L);
        list.add(3L);
        list.add(5L);

        // when
        list.get(index);
    }

    @Test
    @Parameters(method = "testGetParameters")
    public void testGet(int index, Long expectedElement) {
        // given
        list = getEmptyList();
        list.add(4L);
        list.add(3L);
        list.add(5L);

        // when
        Long actualElement = list.get(index);

        // then
        assertEquals(expectedElement, actualElement);
    }

    private Object[] testGetParameters() {
        return new Object[]{
                new Object[]{0, 4L},
                new Object[]{1, 3L},
                new Object[]{2, 5L}
        };
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @Parameters({"-1", "3", "6"})
    public void testSetWithIllegalIndex(int index) {
        // given
        list = getEmptyList();
        list.add(4L);
        list.add(3L);
        list.add(5L);

        // when
        list.set(index, 4L);
    }

    @Test
    @Parameters(method = "testSetParameters")
    public void testSet(int index, Long newElement, Long expectedOldElement, Object[] expectedContents, int expectedSize) {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        list.add(3L);

        // when
        Long actualOldElement = list.set(index, newElement);
        int actualSize = list.size();
        Object[] actualContents = list.toArray();

        // then
        assertEquals(expectedOldElement, actualOldElement);
        assertEquals(expectedSize, actualSize);
        assertArrayEquals(expectedContents, actualContents);
    }

    private Object[] testSetParameters() {
        return new Object[]{
                new Object[]{0, 10L, 1L, new Object[]{10L, 2L, 3L}, 3},
                new Object[]{1, 11L, 2L, new Object[]{1L, 11L, 3L}, 3},
                new Object[]{2, 12L, 3L, new Object[]{1L, 2L, 12L}, 3},
        };
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @Parameters({"-1", "4", "6"})
    public void testAddAtIndexWithIllegalArgument(int index) {
        // given
        list = getEmptyList();
        list.add(4L);
        list.add(3L);
        list.add(5L);

        // when
        list.add(index, 4L);
    }

    @Test
    @Parameters(method = "testAddAtIndexParameters")
    public void testAddAtIndex(int index, Long element, Object[] expectedResultArray, int expectedSize) {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        list.add(3L);

        // when
        list.add(index, element);
        Object[] actualResultArray = list.toArray();
        int actualSize = list.size();

        // then
        assertArrayEquals(expectedResultArray, actualResultArray);
        assertEquals(expectedSize, actualSize);
    }

    private Object[] testAddAtIndexParameters() {
        return new Object[]{
                new Object[]{0, 10L, new Object[]{10L, 1L, 2L, 3L}, 4},
                new Object[]{1, 10L, new Object[]{1L, 10L, 2L, 3L}, 4},
                new Object[]{2, 10L, new Object[]{1L, 2L, 10L, 3L}, 4},
                new Object[]{3, 10L, new Object[]{1L, 2L, 3L, 10L}, 4},
        };
    }

    @Test
    public void testRemoveAtIndex() {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);

        // when
        Object actualRemovedElement = list.remove(2);
        int actualSize = list.size();

        // then
        assertEquals(3L, actualRemovedElement);
        assertEquals(3, actualSize);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @Parameters({"-1", "4", "6"})
    public void testRemoveAtIndexWithIllegalArgument(int index) {
        // given
        list = getEmptyList();
        list.add(4L);
        list.add(3L);
        list.add(5L);

        // when
        list.remove(index);
    }

    @Test
    @Parameters(method = "testIndexOfParameters")
    public void testIndexOf(Object object, int expectedIndex) {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        list.add(3L);

        // when
        int actualIndex = list.indexOf(object);

        // then
        assertEquals(expectedIndex, actualIndex);
    }

    private Object[] testIndexOfParameters() {
        return new Object[]{
                new Object[]{1L, 0},
                new Object[]{2L, 1},
                new Object[]{3L, 2},
                new Object[]{4L, -1},
        };
    }

    @Test
    @Parameters(method = "testLastIndexOfParameters")
    public void testLastIndexOf(Object object, int expectedLastIndex) {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(4L);
        list.add(3L);
        list.add(3L);
        list.add(4L);

        // when
        int actualLastIndex = list.lastIndexOf(object);

        // then
        assertEquals(expectedLastIndex, actualLastIndex);
    }

    private Object[] testLastIndexOfParameters() {
        return new Object[]{
                new Object[]{1L, 0},
                new Object[]{4L, 4},
                new Object[]{3L, 3},
        };
    }

    @Test
    @Parameters(method = "subListIllegalParameters")
    public void testSubListIllegalParameters(int fromIndex, int toIndex, Class exceptionType) throws IndexOutOfBoundsException, IllegalArgumentException {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(4L);
        list.add(3L);
        list.add(5L);

        // when
        exception.expect(exceptionType);
        list.subList(fromIndex, toIndex);
    }

    private Object[] subListIllegalParameters() {
        return new Object[]{
                new Object[]{-1, 0, IndexOutOfBoundsException.class},
                new Object[]{1, 12, IndexOutOfBoundsException.class},
                new Object[]{3, 1, IllegalArgumentException.class},
        };
    }

    @Test
    @Parameters(method = "subListParameters")
    public void testSubListParameters(int fromIndex, int toIndex, Long[] expectedArray) {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        list.add(5L);

        // when
        List<Long> actualSubList = list.subList(fromIndex, toIndex);

        // then
        assertArrayEquals(actualSubList.toArray(), expectedArray);
    }

    private Object[] subListParameters() {
        return new Object[]{
                new Object[]{0, 1, new Long[]{1L}},
                new Object[]{1, 3, new Long[]{2L, 3L}},
                new Object[]{4, 5, new Long[]{5L}},
        };
    }

    @Test
    @Parameters(method = "containsAllParameters")
    public void testContainsAll(List<Long> anotherList, boolean expectedResult) {
        // given
        list = getEmptyList();
        list.add(2L);
        list.add(3L);
        list.add(4L);

        // when
        boolean actualResult = list.containsAll(anotherList);

        // then
        assertThat(actualResult, is(expectedResult));
    }

    private Object[] containsAllParameters() {
        return new Object[]{
                new Object[]{Arrays.asList(3L, 2L), true},
                new Object[]{Arrays.asList(1L, 5L), false},
                new Object[]{Arrays.asList(3L, 6L), false},
                new Object[]{Arrays.asList(), true}
        };
    }

    @Test
    public void testAddAll() {
        // given
        list = getEmptyList();
        list.add(1L);
        Object[] expectedArrayFromList = {1L, 2L, 3L, 4L};

        // when
        boolean actualResult = list.addAll(Arrays.asList(2L, 3L, 4L));
        int actualListSize = list.size();
        Object[] actualArrayFromList = list.toArray();

        // then
        assertTrue(actualResult);
        assertArrayEquals(expectedArrayFromList, actualArrayFromList);
        assertEquals(4, actualListSize);
    }

    @Test
    public void testAddAllWithEmptyCollection() {
        // given
        list = getEmptyList();
        list.add(1L);
        Object[] expectedArrayFromList = {1L};

        // when
        boolean actualResult = list.addAll(Arrays.asList());
        int actualListSize = list.size();
        Object[] actualArrayFromList = list.toArray();

        // then
        assertFalse(actualResult);
        assertArrayEquals(expectedArrayFromList, actualArrayFromList);
        assertEquals(1, actualListSize);
    }

    @Test
    @Parameters(method = "testAddAllAtIndexParameters")
    public void testAddAllAtIndex(int index, List<Long> collection, Object[] expectedResultArray, int expectedListSize, boolean expectedResult) {
        // given
        list = getEmptyList();
        list.add(10L);
        list.add(20L);
        list.add(30L);

        // when
        boolean actualResult = list.addAll(index, collection);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        // then
        assertEquals(expectedResult, actualResult);
        assertArrayEquals(expectedResultArray, actualResultArray);
        assertEquals(expectedListSize, actualListSize);
    }

    private Object[] testAddAllAtIndexParameters() {
        return new Object[]{
                new Object[]{3, Arrays.asList(1L, 2L), new Object[]{10L, 20L, 30L, 1L, 2L}, 5, true},
                new Object[]{0, Arrays.asList(2L), new Object[]{2L, 10L, 20L, 30L}, 4, true},
                new Object[]{1, Arrays.asList(5L, 15L, 150L), new Object[]{10L, 5L, 15L, 150L, 20L, 30L}, 6, true},
                new Object[]{1, Arrays.asList(), new Object[]{10L, 20L, 30L}, 3, false},
        };
    }

    @Test
    @Parameters(method = "testRemoveAllParameters")
    public void testRemoveAll(List<Long> collection, Object[] expectedResultArray, int expectedListSize, boolean expectedResult) {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);

        // when
        boolean actualResult = list.removeAll(collection);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        // then
        assertEquals(expectedResult, actualResult);
        assertArrayEquals(expectedResultArray, actualResultArray);
        assertEquals(expectedListSize, actualListSize);
    }

    private Object[] testRemoveAllParameters() {
        return new Object[]{
                new Object[]{Arrays.asList(1L), new Object[]{2L, 3L, 4L}, 3, true},
                new Object[]{Arrays.asList(2L, 3L), new Object[]{1L, 4L}, 2, true},
                new Object[]{Arrays.asList(4L), new Object[]{1L, 2L, 3L}, 3, true},
                new Object[]{Arrays.asList(1L, 2L, 3L, 4L), new Object[]{}, 0, true},
                new Object[]{Arrays.asList(2L, 3L, 7L), new Object[]{1L, 4L}, 2, true},
                new Object[]{Arrays.asList(10L, 7L), new Object[]{1L, 2L, 3L, 4L}, 4, false},
                new Object[]{Arrays.asList(), new Object[]{1L, 2L, 3L, 4L}, 4, false},
        };
    }

    @Test
    @Parameters(method = "testRetainAllParameters")
    public void testRetainAll(List<Long> collection, Object[] expectedResultArray, int expectedListSize, boolean expectedResult) {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);

        // when
        boolean actualResult = list.retainAll(collection);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        // then
        assertEquals(expectedResult, actualResult);
        assertArrayEquals(expectedResultArray, actualResultArray);
        assertEquals(expectedListSize, actualListSize);
    }

    private Object[] testRetainAllParameters() {
        return new Object[]{
                new Object[]{Arrays.asList(1L), new Object[]{1L}, 1, true},
                new Object[]{Arrays.asList(2L, 3L), new Object[]{2L, 3L}, 2, true},
                new Object[]{Arrays.asList(4L), new Object[]{4L}, 1, true},
                new Object[]{Arrays.asList(1L, 2L, 3L, 4L), new Object[]{1L, 2L, 3L, 4L}, 4, false},
                new Object[]{Arrays.asList(2L, 3L, 7L), new Object[]{2L, 3L}, 2, true},
                new Object[]{Arrays.asList(10L, 7L), new Object[]{}, 0, true},
                new Object[]{Arrays.asList(), new Object[]{}, 0, true},
        };
    }

    @Test
    @Parameters(method = "testIteratorHasNextParameters")
    public void testIteratorHasNext(List<Long> testList, boolean expectedResult) {
        // given
        list = testList;
        Iterator<Long> iterator = list.iterator();

        // when
        boolean actualResult = iterator.hasNext();

        // then
        assertEquals(expectedResult, actualResult);
    }

    private Object[] testIteratorHasNextParameters() {
        return new Object[]{
                new Object[]{Arrays.asList(), false},
                new Object[]{Arrays.asList(1L), true}
        };
    }

    @Test
    public void testIteratorNext() {
        // given
        list = getEmptyList();
        list.add(1L);
        Iterator<Long> iterator = list.iterator();

        // when
        Object actualNext = iterator.next();

        // then
        assertEquals(1L, actualNext);
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextOutOfBounds() {
        // given
        list = getEmptyList();
        list.add(1L);
        Iterator<Long> iterator = list.iterator();
        iterator.next();

        // when
        iterator.next();
    }

    @Test
    public void testListIteratorHasNextWithoutNext() {
        // given
        list = getEmptyList();
        ListIterator<Long> listIterator = list.listIterator();

        // when
        boolean actualHasNext = listIterator.hasNext();

        // then
        assertFalse(actualHasNext);
    }

    @Test
    public void testListIteratorHasNextWithNext() {
        // given
        list = getEmptyList();
        list.add(1L);
        ListIterator<Long> listIterator = list.listIterator();

        // when
        boolean actualHasNext = listIterator.hasNext();

        // then
        assertTrue(actualHasNext);
    }

    @Test
    public void testListIteratorNext() {
        // given
        list = getEmptyList();
        list.add(1L);
        ListIterator<Long> listIterator = list.listIterator();

        // when
        Object actualNext = listIterator.next();

        // then
        assertEquals(1L, actualNext);
    }

    @Test(expected = NoSuchElementException.class)
    public void testListIteratorNextOutOfBounds() {
        // given
        list = getEmptyList();
        list.add(1L);
        ListIterator<Long> listIterator = list.listIterator();
        listIterator.next();

        // when
        listIterator.next();
    }

    @Test
    public void testListIteratorHasPrevious() {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        ListIterator<Long> listIterator = list.listIterator(1);

        // when
        boolean actualResult = listIterator.hasPrevious();

        // then
        assertTrue(actualResult);
    }

    @Test
    public void testListIteratorHasNoPrevious() {
        // given
        list = getEmptyList();
        list.add(1L);
        ListIterator<Long> listIterator = list.listIterator(0);

        // when
        boolean actualResult = listIterator.hasPrevious();

        // then
        assertFalse(actualResult);
    }

    @Test
    public void testListIteratorPrevious() {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        ListIterator<Long> listIterator = list.listIterator(1);

        // when
        Object actualPrevious = listIterator.previous();

        // then
        assertEquals(1L, actualPrevious);
    }

    @Test(expected = NoSuchElementException.class)
    public void testListIteratorPreviousException() {
        // given
        list = getEmptyList();
        list.add(1L);
        ListIterator<Long> listIterator = list.listIterator(0);

        // when
        listIterator.previous();
    }

    @Test
    public void testListIteratorNextIndex() {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        ListIterator<Long> listIterator = list.listIterator(2);

        // when
        int actualNextIndex = listIterator.nextIndex();

        // then
        assertEquals(2, actualNextIndex);
    }

    @Test
    public void testListIteratorPreviousIndex() {
        // given
        list = getEmptyList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        ListIterator<Long> listIterator = list.listIterator(1);

        // when
        int actualPreviousIndex = listIterator.nextIndex();

        // then
        assertEquals(1, actualPreviousIndex);
    }
}
