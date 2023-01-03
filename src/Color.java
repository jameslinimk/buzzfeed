public class Color {
    // ANSI escape codes for colors
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    /**
     * Prints text in a color and adds a new line
     * @param color Color to print the text in
     * @param text Text to print
     */
    public static void colorPrintln(String color, String text) {
        System.out.println(color + text + RESET);
    }

    /**
     * Prints text in a color
     * @param color Color to print the text in
     * @param text Text to print
     */
    public static void colorPrint(String color, String text) {
        System.out.print(color + text + RESET);
    }
}
