import java.util.InputMismatchException;
import java.util.Scanner;

public class task1 {

    // Calculates area for two int side lengths and returns an int
    public static int calculateArea(int length, int width) {
        return length * width;
    }

    // Calculates area for two double side lengths and returns a double
    public static double calculateArea(double length, double width) {
        return length * width;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Direct calls demonstrating overloaded behavior
        int areaInt = calculateArea(6, 3);
        double areaDouble = calculateArea(6.5, 3.2);
        System.out.println("Direct int call (6, 3): " + areaInt);
        System.out.println("Direct double call (6.5, 3.2): " + areaDouble);
        System.out.println();

        // 2. Interactive input for integer side lengths
        try {
            System.out.print("Enter integer length: ");
            int intLength = scanner.nextInt();

            System.out.print("Enter integer width: ");
            int intWidth = scanner.nextInt();

            int userIntArea = calculateArea(intLength, intWidth);
            System.out.println("Rectangle area (int): " + userIntArea);
        } catch (InputMismatchException e) {
            System.out.println("Invalid integer input. Skipping int calculation.");
            scanner.nextLine(); // Clear invalid token
        }

        System.out.println();

        // 3. Interactive input for double side lengths
        try {
            System.out.print("Enter double length: ");
            double doubleLength = scanner.nextDouble();

            System.out.print("Enter double width: ");
            double doubleWidth = scanner.nextDouble();

            double userDoubleArea = calculateArea(doubleLength, doubleWidth);
            System.out.println("Rectangle area (double): " + userDoubleArea);
        } catch (InputMismatchException e) {
            System.out.println("Invalid double input. Skipping double calculation.");
        } finally {
            scanner.close();
        }
    }
}