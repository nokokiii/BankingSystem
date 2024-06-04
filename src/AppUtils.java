import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppUtils {
    public static Integer getIntInput(Scanner scanner, String prompt) {
        System.out.print(prompt);

        try {
            int result = scanner.nextInt();
            scanner.nextLine();
            return result;
        } catch (NoSuchElementException e) {
            System.out.println("No option selected. Please try again");
            scanner.nextLine();
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
            scanner.nextLine();
            return null;
        }
    }

    public static Double getDoubleInput(Scanner scanner, String prompt) {
        System.out.print(prompt);

        try {
            double result = scanner.nextDouble();
            scanner.nextLine();
            return result;
        } catch (NoSuchElementException e) {
            System.out.println("No option selected. Please try again");
            scanner.nextLine();
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
            scanner.nextLine();
            return null;
        }
    }

    public static String getStringInput(Scanner scanner, String prompt) {
        System.out.print(prompt);

        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("No option selected. Please try again");
            scanner.nextLine();
            return null;
        }
    }
}
