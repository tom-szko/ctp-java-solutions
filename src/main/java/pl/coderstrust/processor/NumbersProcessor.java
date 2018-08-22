package pl.coderstrust.processor;

import java.util.Scanner;

public class NumbersProcessor {

    public String processLine(String line) {
        if (!checkLineValidity(line)) {
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
        return lineBuilder.append("=").append(result).append("\n").toString();
    }

    private boolean checkLineValidity(String line) {
        if (line.trim().isEmpty()) {
            return false;
        }
        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);
            if ((character < 48 || character > 57) && character != 32) {
                return false;
            }
        }
        return true;
    }
}
