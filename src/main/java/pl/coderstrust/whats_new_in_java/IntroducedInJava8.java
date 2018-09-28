package pl.coderstrust.whats_new_in_java;

import java.util.stream.Stream;

// Default interface methods
interface Flyable {
    void fly();
    default void jump() {
        System.out.println("I'm jumping.");
    }
}

public class IntroducedInJava8 {
    public static void main(String[] args) {

        // Lambda expressions
        Flyable flyingThing = () -> System.out.println("I'm flying.");
        flyingThing.fly();
        flyingThing.jump();

        // Streams
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(number -> (number < 3 || number > 7))
                .map(number -> number + 10)
                .forEach(System.out::println);
    }
}
