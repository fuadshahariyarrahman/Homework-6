import java.io.File;
import java.util.Scanner;

public class task4 {

    // Calculate the total size of files in a directory
    public static long calculateSize(File directory) {

        long totalSize = 0;

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {

                if (file.isFile()) {
                    totalSize += file.length();
                }
                else if (file.isDirectory()) {
                    totalSize += calculateSize(file);
                }
            }
        }

        return totalSize;
    }

    // Display the size of each directory and its subdirectories
    public static void displayDirectorySizes(File directory) {

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {

                if (file.isDirectory()) {

                    long size = calculateSize(file);

                    System.out.println("\nDirectory: " + file.getAbsolutePath());
                    System.out.println("Size in Bytes: " + size);
                    System.out.println("Size in KB: " + size / 1024.0);
                    System.out.println("Size in MB: " + size / (1024.0 * 1024.0));

                    displayDirectorySizes(file);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter directory name: ");
        String directoryName = input.nextLine();

        File directory = new File(directoryName);

        if (!directory.exists() || !directory.isDirectory()) {

            System.out.println("Error: The specified directory does not exist.");

        } else {

            long totalSize = calculateSize(directory);

            System.out.println("\nTotal Directory Size:");
            System.out.println("Size in Bytes: " + totalSize);
            System.out.println("Size in KB: " + totalSize / 1024.0);
            System.out.println("Size in MB: " + totalSize / (1024.0 * 1024.0));

            System.out.println("\nIndividual Directory Sizes:");
            displayDirectorySizes(directory);
        }

        input.close();
    }
}