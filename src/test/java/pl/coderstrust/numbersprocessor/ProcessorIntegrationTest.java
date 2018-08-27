package pl.coderstrust.numbersprocessor;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class ProcessorIntegrationTest {

    @Test
    public void testProcessor() throws IOException {
        //given
        Processor processor = new Processor(new NumbersProcessor(), new FileProcessor());
        String input = "src/test/resources/pl.coderstrust.numbersprocessor/task19-sampleTextFile.txt";
        String actualOutput = "src/test/resources/pl.coderstrust.numbersprocessor/task19-resultTextFile.txt";
        String expectedOutput = "src/test/resources/pl.coderstrust.numbersprocessor/task19-expectedOutputFile.txt";
        byte[] expectedOutputBytes = Files.readAllBytes(Paths.get(expectedOutput));
        String expectedOutputContents = new String(expectedOutputBytes, StandardCharsets.UTF_8);

        //when
        processor.process(input, actualOutput);

        //then
        byte[] actualOutputBytes = Files.readAllBytes(Paths.get(actualOutput));
        String actualOutputContents = new String(actualOutputBytes, StandardCharsets.UTF_8);
        assertEquals(expectedOutputContents, actualOutputContents);
    }
}
