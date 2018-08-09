package pl.coderstrust.christmas;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static pl.coderstrust.christmas.ChristmasTree.getChristmasTree;

public class ChristmasTreeTest {

    @Test
    public void testForSizeOfSix() {
        //given
        int size = 6;
        List<String> expected = Arrays.asList(
                "     *",
                "    ***",
                "   *****",
                "  *******",
                " *********",
                "***********",
                "    **");

        //when
        List<String> actual = getChristmasTree(size);

        //then
        assertThat(actual, is(expected));
    }

    @Test
    public void testCornerCase() {
        //given
        int size = 1;
        List<String> expected = Arrays.asList(
                "*",
                "**");

        //when
        List<String> actual = getChristmasTree(size);

        //then
        assertThat(actual, is(expected));
    }

    @Test
    public void testNegativeSize() {
        //given
        int size = -1;
        List<String> expected = new ArrayList<String>();

        //when
        List<String> actual = getChristmasTree(size);

        //then
        assertThat(actual, is(expected));
    }
}
