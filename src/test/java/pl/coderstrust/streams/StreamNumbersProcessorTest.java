package pl.coderstrust.streams;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class StreamNumbersProcessorTest {

    @Test
    public void testProcessor() throws IOException {
        //given
        StreamNumbersProcessor processor = new StreamNumbersProcessor();
        String input = "src/test/resources/pl.coderstrust.streams/task19-sampleTextFile.txt";
        String actualOutput = "src/test/resources/pl.coderstrust.streams/task19-resultTextFile.txt";

        //when
        processor.process(input, actualOutput);

        //then
        String expectedOutput = "src/test/resources/pl.coderstrust.streams/task19-expectedOutputFile.txt";
        byte[] expectedOutputBytes = Files.readAllBytes(Paths.get(expectedOutput));
        String expectedOutputContents = new String(expectedOutputBytes, StandardCharsets.UTF_8);
        byte[] actualOutputBytes = Files.readAllBytes(Paths.get(actualOutput));
        String actualOutputContents = new String(actualOutputBytes, StandardCharsets.UTF_8);
        assertEquals(expectedOutputContents, actualOutputContents);
    }
}
