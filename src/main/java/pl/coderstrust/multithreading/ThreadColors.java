package pl.coderstrust.multithreading;

enum ThreadColour {
    RED ("\u001B[31m"),
    GREEN ("\u001B[32m"),
    PURPLE ("\u001B[35m"),
    CYAN ("\u001B[36m");

    private final String colour;

    ThreadColour(String colour) {
        this.colour = colour;
    }

    public String getValue() {
        return colour;
    }
}
