import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * This program recursively calculates the factorial of
 * each valid number from an input file
 * and writes the result or error message for each line into an output file.
 * Author: Alex Kapajika
 * Version: 1.1
 * Since: 2025-04-23
 */
public final class Factorial {
    /** Constant for the input file. */
    private static final String INPUT_FILE = "input.txt";
    /** Constant for the output file. */
    private static final String OUTPUT_FILE = "output.txt";
    /**
     * This is to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Factorial() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * Main Method.
     * @param args Unused.
     */
    public static void main(final String[] args) {
        // Pass the path to the file as a parameter
        try (Scanner scanner = new Scanner(new File(INPUT_FILE));
                FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            // Reading file line by line
            while (scanner.hasNextLine()) {
                // Read the line from the file
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    writer.write("Empty line.\n");
                } else {
                    // Check if the line is a valid number
                    try {
                        int number = Integer.parseInt(line);
                        if (number < 0) {
                            writer.write("Negative number.\n");
                        } else {
                            // Calculate the factorial
                            int result = factorial(number);
                            writer.write("Factorial of " + number + " is: "
                                    + result + "\n");
                        }
                    } catch (NumberFormatException e) {
                        // Handle invalid number format
                        writer.write("Invalid number : " + line + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method calculates the factorial of a number recursively.
     *
     * @param numberFact The number to calculate the factorial for
     * @return The factorial of the number
     */
    public static int factorial(final int numberFact) {
        if (numberFact == 0 || numberFact == 1) {
            return 1;
        }
        return numberFact * factorial(numberFact - 1);
    }
}
