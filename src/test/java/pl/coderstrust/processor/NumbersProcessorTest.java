package pl.coderstrust.processor;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class NumbersProcessorTest {

    @Test
    @Parameters(method = "sampleStringLines")
    public void testSampleStringLines(String line, String expected) {
        //given
        NumbersProcessor testNumbersProcessor = new NumbersProcessor();

        //when
        String actual = testNumbersProcessor.processLine(line);

        //then
        assertThat(actual, is(expected));
    }

    private Object[] sampleStringLines() {
        return new Object[]{
                new Object[]{"1 2 3", "1+2+3=6\n"},
                new Object[]{"     1 2 3   ", "1+2+3=6\n"},
                new Object[]{"        ", ""},
                new Object[]{"number 1 number 2 number3", ""},
                new Object[]{"0", "0=0\n"}
        };
    }
}