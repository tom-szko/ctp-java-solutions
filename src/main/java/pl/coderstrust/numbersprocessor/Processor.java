package pl.coderstrust.numbersprocessor;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private NumbersProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(String fileName, String resultFileName) {
        List<String> linesFromFile = fileProcessor.readLinesFromFile(fileName);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile) {
            String processedLine = numbersProcessor.processLine(line);
            if (processedLine.length() != 0) {
                resultLines.add(processedLine);
            }
        }
        fileProcessor.writeLinesToFile(resultLines, resultFileName);
    }
}
