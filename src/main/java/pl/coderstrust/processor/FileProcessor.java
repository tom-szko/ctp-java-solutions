package pl.coderstrust.processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FileProcessor {
    List<String> readLinesFromFile(String fileName) {
        List<String> fileContents = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                fileContents.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContents;
    }

    void writeLinesToFile(List<String> resultLines, String resultFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFileName))) {
            for (String line : resultLines) {
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
