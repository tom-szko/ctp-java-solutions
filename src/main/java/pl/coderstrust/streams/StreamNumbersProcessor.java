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
        Consumer<Integer> appendSumAtEndOfFile = sum -> outputContents.deleteCharAt(outputContents.length() - 1)
                .append(String.format("=%d\n", sum));

        Files.lines(Paths.get(fileName))
                .filter(line -> line.matches("^[0-9 ]+$"))
                .map(unparsedNumbers -> Arrays.stream(unparsedNumbers.trim().split("\\s+"))
                        .peek(stringNumber -> outputContents.append(stringNumber).append("+"))
                        .mapToInt(Integer::parseInt)
                        .sum())
                .forEach(appendSumAtEndOfFile);
        printToFile(outputContents, resultFileName);
    }

    private void printToFile(StringBuilder outputContents, String outputFileName) throws IOException {
        PrintWriter outputWriter = new PrintWriter(outputFileName);
        outputWriter.print(outputContents);
        outputWriter.flush();
        outputWriter.close();
    }
}
