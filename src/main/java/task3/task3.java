import java.util.InputMismatchException;
import java.util.Scanner;

public class task3 {

    /**
     * Recursively calculates the sum of the digits of a natural number x.
     * Example: 1342 -> 1 + 3 + 4 + 2 = 10
     */
    public static int sumOfDigits(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("x must be a non-negative integer.");
        }
        // Base case: when no digits remain
        if (x == 0) {
            return 0;
        }
        // Recursive case: last digit (x % 10) + sum of remaining digits (x / 10)
        return (x % 10) + sumOfDigits(x / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Sample calls
        int sample = 1342;
        System.out.println("Sample (" + sample + "): " + sumOfDigits(sample)); // 10
        System.out.println("Sample (0): " + sumOfDigits(0));                 // 0
        System.out.println();

        // 2. Interactive user input
        try {
            System.out.print("Enter a natural number: ");
            int userNumber = scanner.nextInt();

            int result = sumOfDigits(userNumber);
            System.out.println("Sum of digits of " + userNumber + " is: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}