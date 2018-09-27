package pl.coderstrust.whats_new_in_java;

import java.util.ArrayList;
import java.util.List;

public class IntroducedInJava7 {
    public static void main(String[] args) {

        // Underscores in numeric literals
        int number = 1_000_500;
        System.out.println(number);

        // Type inference in generics
        List<String> list = new ArrayList<>();
        list.add("Item1");
        System.out.println("list2 contents: " + list.toString());

        // Strings in Switch statements
        String option = "Render";
        System.out.println(optionDescription(option));
    }

    private static String optionDescription (String option) {
        String message;
        switch(option) {
            case "Render":
                message = "Generates an image";
                break;
            case "Dimensions":
                message = "Provides height and width of the image (in pixels)";
                break;
            case "Desaturate":
                message = "Lowers image saturation";
                break;
            default:
                throw new UnsupportedOperationException("An unsupported option has been invoked");
        }
        return message;
    }
}
