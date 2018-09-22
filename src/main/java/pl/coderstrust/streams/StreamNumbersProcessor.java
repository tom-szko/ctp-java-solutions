package pl.coderstrust.streams;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Consumer;

public class StreamNumbersProcessor {

    public void process(String fileName, String resultFileName) throws IOException {
        StringBuilder outputContents = new StringBuilder();
        Consumer<Integer> appendSumAtEndOfFile = d -> outputContents.deleteCharAt(outputContents.length() - 1)
                .append(String.format("=%d\n", d));
        Files.lines(Paths.get(fileName))
                .filter(line -> line.matches("^[0-9 ]+$"))
                .map(unparsedNumbers -> Arrays.stream(unparsedNumbers.split("\\s"))
                        .filter(parsedStringNumber -> parsedStringNumber.matches("[0-9]+"))
                        .peek(parsedNumber -> outputContents.append(parsedNumber).append("+"))
                        .mapToInt(Integer::parseInt)
                        .sum())
                .forEach(appendSumAtEndOfFile);
        PrintWriter outputWriter = new PrintWriter(resultFileName);
        outputWriter.print(outputContents);
        outputWriter.flush();
        outputWriter.close();
    }
}
