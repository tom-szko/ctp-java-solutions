package pl.coderstrust.whats_new_in_java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Random;

interface Watchable {
    void watch();

    default void look() {
        System.out.println("I'll be looking for " + getTime() + " s.");
    }

    private int getTime() {
        return new Random().nextInt(100);
    }
}

public class IntroducedInJava9 {
    public static void main(String[] args) throws FileNotFoundException {

        //Improvement in try-with-resources: in Java 9 resources can be declared outside resource block.
        BufferedReader bufferedReader = new BufferedReader(new FileReader("pom.xml"));
        try (bufferedReader) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Factory methods for Collections
        List<String> namesList = List.of("Anna", "Mark", "Joe", "Tim");
        Map sampleMap = Map.of(1, "one", 2, "two", 3, "three");

        // Private interface methods
        Watchable eagleEye = () -> System.out.println("I'm watching.");
        eagleEye.watch();
        eagleEye.look();
    }
}
