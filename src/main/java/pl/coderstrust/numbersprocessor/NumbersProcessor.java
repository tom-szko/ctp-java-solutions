package pl.coderstrust.numbersprocessor;

import java.util.Scanner;

public class NumbersProcessor {

    public String processLine(String line) {
        if (!hasOnlyAlphabetChars(line)) {
            return "";
        }
        int result = 0;
        Scanner scanner = new Scanner(line);
        StringBuilder lineBuilder = new StringBuilder();
        while (scanner.hasNextInt()) {
            int nextNumber = scanner.nextInt();
            result += nextNumber;
            lineBuilder.append(nextNumber);
            if (scanner.hasNextInt()) {
                lineBuilder.append("+");
            }
        }
        lineBuilder.append("=").append(result).append("\n");
        return lineBuilder.toString();
    }

    private boolean hasOnlyAlphabetChars(String line) {
        if (line.trim().isEmpty()) {
            return false;
        }
        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);
            if ((character < '0' || character > '9') && character != ' ') {
                return false;
            }
        }
        return true;
    }
}
