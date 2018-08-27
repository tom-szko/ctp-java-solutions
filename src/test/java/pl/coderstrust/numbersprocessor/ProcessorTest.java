package pl.coderstrust.numbersprocessor;

import org.junit.Test;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class ProcessorTest {

    @Test
    public void testProcessor() {
        // given
        NumbersProcessor mockNumbersProcessor = mock(NumbersProcessor.class);
        FileProcessor mockFileProcessor = mock(FileProcessor.class);
        when(mockFileProcessor.readLinesFromFile("input.txt")).thenReturn(Arrays.asList("1 2 3", "4 5 6"));
        when(mockNumbersProcessor.processLine("1 2 3")).thenReturn("1+2+3=6");
        when(mockNumbersProcessor.processLine("4 5 6")).thenReturn("4+5+6=15");
        Processor testProcessor = new Processor(mockNumbersProcessor, mockFileProcessor);

        // when
        testProcessor.process("input.txt", "output.txt");

        // then
        verify(mockFileProcessor).readLinesFromFile("input.txt");
        verify(mockNumbersProcessor, times(1)).processLine("1 2 3");
        verify(mockFileProcessor).writeLinesToFile(Arrays.asList("1+2+3=6", "4+5+6=15"), "output.txt");
    }
}
