package pl.coderstrust.numbersprocessor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileProcessor {
    List<String> readLinesFromFile(String fileName) {
        List<String> fileContents = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContents.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
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
            System.exit(1);
        }
    }
}
