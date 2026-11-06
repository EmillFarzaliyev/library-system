import java.util.Scanner;
 
public class LibrarySystem {
 
    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println(" Welcome to the Campus Library System");
        System.out.println("==================================");
 
        String[] catalog = { "Clean Code", "Effective Java", "The Pragmatic Programmer" };
        printCatalog(catalog);
 
        System.out.println(catalog[0] + " starts with a capital letter: " + startsWithCapital(catalog[0]));
 
        String searchTitle = "Effective Java";
        boolean found = searchCatalog(catalog, searchTitle);
        System.out.println(found ? searchTitle + " is in the catalog." : searchTitle + " was not found.");
 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String memberName = scanner.nextLine();
        System.out.println("Welcome, " + formatName(memberName) + "!");
 
        runMenu(scanner);
 
        System.out.println("Goodbye, " + formatName(memberName) + "!");
 
        double fine = calculateFine(4);
        System.out.println("Fine due: £" + fine);
    }
 
    public static void printCatalog(String[] catalog) {
        System.out.println("Books currently in the catalog:");
        for (int i = 0; i < catalog.length; i++) {
            System.out.println((i + 1) + ". " + catalog[i]);
        }
    }
 
    public static boolean startsWithCapital(String title) {
        char firstLetter = title.charAt(0);
        return Character.isUpperCase(firstLetter);
    }
 
    public static boolean searchCatalog(String[] catalog, String title) {
        int index = 0;
        boolean found = false;
        while (index < catalog.length && !found) {
            if (catalog[index].equals(title)) {
                found = true;
            }
            index++;
        }
        return found;
    }
 
    public static String formatName(String name) {
        String trimmed = name.trim();
        return trimmed.substring(0, 1).toUpperCase() + trimmed.substring(1).toLowerCase();
    }
 
    public static void runMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("1. Search for a book");
            System.out.println("2. Add a book");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
 
            if (choice == 1) {
                System.out.println("Searching catalog...");
            } else if (choice == 2) {
                System.out.println("Adding a new book...");
            } else if (choice != 3) {
                System.out.println("Invalid option, please try again.");
            }
        } while (choice != 3);
    }
 
    public static double calculateFine(int daysLate) {
        double finePerDay = 0.50;
        double fine = Math.min(daysLate * finePerDay, 5.00);
        return Math.round(fine * 100.0) / 100.0;
    }
}
