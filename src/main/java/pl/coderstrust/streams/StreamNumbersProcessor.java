package pl.coderstrust.streams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class StreamNumbersProcessor {

    public void process(String fileName, String resultFileName) {
        StringBuilder outputContents = new StringBuilder();
        try {
            Files.lines(Paths.get(fileName))
                    .filter(s -> s.matches("^[0-9 ]+$"))
                    .map(s -> Arrays.stream(s.split("\\s"))
                            .filter(s1 -> s1.matches("[0-9]+"))
                            .peek(s1 -> outputContents.append(s1).append("+"))
                            .mapToInt(Integer::parseInt)
                            .sum())
                    .forEach(d -> outputContents.deleteCharAt(outputContents.length() - 1)
                            .append(String.format("=%d\n", d)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter outputWriter = new PrintWriter(resultFileName)) {
            outputWriter.print(outputContents);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
