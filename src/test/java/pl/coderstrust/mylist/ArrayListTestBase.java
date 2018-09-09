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

    public abstract List<Long> getList();

    public abstract List<Long> getList(int elements);

    List<Long> list;

    @Test
    public void testConstructor() {
        // when
        list = getList();

        // then
        assertEquals(0, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithIllegalParameter() {
        // given
        int numberOfElements = -3;

        // when
        getList(numberOfElements);
    }

    @Test
    public void testSize() {
        // given
        list = getList();
        list.add(2L);
        list.add(4L);
        list.add(6L);
        int expectedSize = 3;

        //when
        int actualSize = list.size();

        // then
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        // given
        list = getList();
        boolean expectedIsEmpty = true;

        //when
        boolean actualIsEmpty = list.isEmpty();

        // then
        assertEquals(expectedIsEmpty, actualIsEmpty);
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
        // given
        list = getList();
        list.add(3L);
        boolean expectedIsEmpty = false;

        //when
        boolean actualIsEmpty = list.isEmpty();

        // then
        assertEquals(expectedIsEmpty, actualIsEmpty);
    }

    @Test
    public void testContainsWhenItemOnTheList() {
        // given
        list = getList();
        list.add(5L);
        list.add(6L);
        list.add(-9L);
        boolean expectedContains = true;

        // when
        boolean actualContains = list.contains(6L);

        // then
        assertEquals(expectedContains, actualContains);
    }


    @Test
    public void testContainsWhenItemNotOnTheList() {
        // given
        list = getList();
        list.add(5L);
        list.add(6L);
        list.add(-9L);
        boolean expectedContains = false;

        // when
        boolean actualContains = list.contains(1L);

        // then
        assertEquals(expectedContains, actualContains);
    }

    @Test
    public void testToArrayWithObject() {
        //given
        list = getList();
        list.add(5L);
        list.add(6L);
        list.add(-9L);
        list.add(-12332L);
        Object[] expectedResult = {5L, 6L, -9L, -12332L};

        //when
        Object[] actualResult = list.toArray();

        //then
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    @Parameters(method = "testToArrayWithGenericParameters")
    public void testToArrayWithGeneric(int destinationLength, Long[] expectedResult) {
        //given
        list = getList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        Long[] destination = new Long[destinationLength];

        //when
        Object[] actualResult = list.toArray(destination);

        //then
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
        //given
        list = getList();
        list.add(1L);
        list.add(2L);
        Object[] destination = destinationArray;
        exception.expect(exceptionType);

        //when
        list.toArray(destination);
    }

    private Object[] testToArrayWithGenericException() {
        return new Object[]{
                new Object[]{null, NullPointerException.class},
                new Object[]{new String[5], ArrayStoreException.class},
        };
    }

    @Test
    public void testAdd() {
        // given
        list = getList();
        Object[] expectedResultArray = {4L};
        int expectedListSize = 1;

        //when
        boolean actualResult = list.add(4L);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        //then
        assertTrue(actualResult);
        assertArrayEquals(expectedResultArray, actualResultArray);
        assertEquals(expectedListSize, actualListSize);
    }

    @Test
    public void testRemoveExistentElement() {
        // given
        list = getList();
        list.add(13L);
        list.add(45L);
        list.add(123L);
        list.add(1L);
        Object[] expectedResultArray = {13L, 123L, 1L};
        int expectedListSize = 3;

        // when
        boolean actualRemoveResult = list.remove(45L);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        // then
        assertTrue(actualRemoveResult);
        assertArrayEquals(expectedResultArray, actualResultArray);
        assertEquals(expectedListSize, actualListSize);
    }

    @Test
    public void testRemoveElementWhenDoubled() {
        // given
        list = getList();
        list.add(13L);
        list.add(45L);
        list.add(45L);
        list.add(45L);
        list.add(1L);
        Object[] expectedResultArray = {13L, 45L, 45L, 1L};
        int expectedListSize = 4;

        // when
        boolean actualRemoveResult = list.remove(45L);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        // then
        assertTrue(actualRemoveResult);
        assertArrayEquals(expectedResultArray, actualResultArray);
        assertEquals(expectedListSize, actualListSize);
    }

    @Test
    public void testRemoveNonExistentElement() {
        // given
        list = getList();
        list.add(13L);
        list.add(45L);
        list.add(123L);
        list.add(1L);
        Object[] expectedResultArray = {13L, 45L, 123L, 1L};
        int expectedListSize = 4;

        // when
        boolean actualRemoveResult = list.remove(44L);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        // then
        assertTrue(!actualRemoveResult);
        assertArrayEquals(expectedResultArray, actualResultArray);
        assertEquals(expectedListSize, actualListSize);
    }

    @Test
    public void testClear() {
        // given
        list = getList();
        Object[] expectedListContents = {};
        int expectedSize = 0;

        // when
        list.clear();
        int actualSize = list.size();
        Object[] actualListContents = list.toArray();

        // then
        assertEquals(expectedSize, actualSize);
        assertArrayEquals(expectedListContents, actualListContents);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @Parameters({"-1", "4", "6"})
    public void testGetWithIllegalIndex(int index) {
        // given
        list = getList();
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
        list = getList();
        list.add(4L);
        list.add(3L);
        list.add(5L);

        // when
        Long actualElement = list.get(index);

        //then
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
        list = getList();
        list.add(4L);
        list.add(3L);
        list.add(5L);

        // when
        list.set(index, 4L);
    }

    @Test
    @Parameters(method = "testSetParameters")
    public void testSet(int index, Long newElement, Long expectedOldElement) {
        // given
        list = getList();
        list.add(1L);
        list.add(2L);
        list.add(3L);

        // when
        Long actualOldElement = list.set(index, newElement);

        // then
        assertEquals(expectedOldElement, actualOldElement);
    }

    private Object[] testSetParameters() {
        return new Object[]{
                new Object[]{0, 10L, 1L},
                new Object[]{1, 11L, 2L},
                new Object[]{2, 12L, 3L}
        };
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @Parameters({"-1", "4", "6"})
    public void testAddAtIndexWithIllegalArgument(int index) {
        // given
        list = getList();
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
        list = getList();
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
        list = getList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        Long expectedRemovedElement = 3L;
        int expectedSize = 3;

        // when
        Long actualRemovedElement = list.remove(2);
        int actualSize = list.size();

        // then
        assertEquals(expectedRemovedElement, actualRemovedElement);
        assertEquals(expectedSize, actualSize);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @Parameters({"-1", "4", "6"})
    public void testRemoveAtIndexWithIllegalArgument(int index) {
        // given
        list = getList();
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
        list = getList();
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
        list = getList();
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
        list = getList();
        list.add(1L);
        list.add(4L);
        list.add(3L);
        list.add(5L);
        exception.expect(exceptionType);

        // when
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
        list = getList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        list.add(5L);

        // when
        List<Long> actualSubList = list.subList(fromIndex, toIndex);

        //then
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
        list = getList();
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
        list = getList();
        list.add(1L);
        Object[] expectedArrayFromList = {1L, 2L, 3L, 4L};
        int expectedListSize = 4;

        //when
        boolean actualResult = list.addAll(Arrays.asList(2L, 3L, 4L));
        int actualListSize = list.size();
        Object[] actualArrayFromList = list.toArray();

        //then
        assertTrue(actualResult);
        assertArrayEquals(expectedArrayFromList, actualArrayFromList);
        assertEquals(expectedListSize, actualListSize);
    }

    @Test
    public void testAddAllWithEmptyCollection() {
        // given
        list = getList();
        list.add(1L);
        Object[] expectedArrayFromList = {1L};
        int expectedListSize = 1;

        //when
        boolean actualResult = list.addAll(Arrays.asList());
        int actualListSize = list.size();
        Object[] actualArrayFromList = list.toArray();

        //then
        assertFalse(actualResult);
        assertArrayEquals(expectedArrayFromList, actualArrayFromList);
        assertEquals(expectedListSize, actualListSize);
    }

    @Test
    @Parameters(method = "testAddAllAtIndexParameters")
    public void testAddAllAtIndex(int index, List<Long> collection, Object[] expectedResultArray, int expectedListSize, boolean expectedResult) {
        // given
        list = getList();
        list.add(10L);
        list.add(20L);
        list.add(30L);

        //when
        boolean actualResult = list.addAll(index, collection);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        //then
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
        list = getList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);

        //when
        boolean actualResult = list.removeAll(collection);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        //then
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
        list = getList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);

        //when
        boolean actualResult = list.retainAll(collection);
        Object[] actualResultArray = list.toArray();
        int actualListSize = list.size();

        //then
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

        //when
        boolean actualResult = iterator.hasNext();

        //then
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
        list = getList();
        list.add(1L);
        Iterator<Long> iterator = list.iterator();
        Long expectedNext = 1L;

        //when
        Long actualNext = iterator.next();

        //then
        assertEquals(expectedNext, actualNext);
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextOutOfBounds() {
        // given
        list = getList();
        list.add(1L);
        Iterator<Long> iterator = list.iterator();
        iterator.next();

        //when
        iterator.next();
    }

    @Test
    public void testListIteratorHasNextWithoutNext() {
        // given
        list = getList();
        ListIterator<Long> listIterator = list.listIterator();

        //when
        boolean actualHasNext = listIterator.hasNext();

        //then
        assertFalse(actualHasNext);
    }

    @Test
    public void testListIteratorHasNextWithNext() {
        // given
        list = getList();
        list.add(1L);
        ListIterator<Long> listIterator = list.listIterator();

        //when
        boolean actualHasNext = listIterator.hasNext();

        //then
        assertTrue(actualHasNext);
    }

    @Test
    public void testListIteratorNext() {
        // given
        list = getList();
        list.add(1L);
        ListIterator<Long> listIterator = list.listIterator();
        Long expectedNext = 1L;

        //when
        Long actualNext = listIterator.next();

        //then
        assertEquals(expectedNext, actualNext);
    }

    @Test(expected = NoSuchElementException.class)
    public void testListIteratorNextOutOfBounds() {
        // given
        list = getList();
        list.add(1L);
        ListIterator<Long> listIterator = list.listIterator();
        listIterator.next();

        //when
        listIterator.next();
    }

    @Test
    public void testListIteratorHasPrevious() {
        // given
        list = getList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        ListIterator<Long> listIterator = list.listIterator(1);

        //when
        boolean actualResult = listIterator.hasPrevious();

        //then
        assertTrue(actualResult);
    }

    @Test
    public void testListIteratorHasNoPrevious() {
        // given
        list = getList();
        list.add(1L);
        ListIterator<Long> listIterator = list.listIterator(0);

        //when
        boolean actualResult = listIterator.hasPrevious();

        //then
        assertFalse(actualResult);
    }

    @Test
    public void testListIteratorPrevious() {
        // given
        list = getList();
        list.add(1L);
        list.add(2L);
        ListIterator<Long> listIterator = list.listIterator(1);
        Long expectedPrevious = 1L;

        // when
        Long actualPrevious = listIterator.previous();

        // then
        assertEquals(expectedPrevious, actualPrevious);
    }

    @Test(expected = NoSuchElementException.class)
    public void testListIteratorPreviousException() {
        // given
        list = getList();
        list.add(1L);
        ListIterator<Long> listIterator = list.listIterator(0);

        //when
        listIterator.previous();
    }

    @Test
    public void testListIteratorNextIndex() {
        list = getList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        ListIterator<Long> listIterator = list.listIterator(2);
        int expectedNextIndex = 2;

        // when
        int actualNextIndex = listIterator.nextIndex();

        // then
        assertEquals(expectedNextIndex, actualNextIndex);
    }

    @Test
    public void testListIteratorPreviousIndex() {
        list = getList();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        ListIterator<Long> listIterator = list.listIterator(1);
        int expectedPreviousIndex = 1;

        // when
        int actualPreviousIndex = listIterator.nextIndex();

        // then
        assertEquals(expectedPreviousIndex, actualPreviousIndex);
    }
}
