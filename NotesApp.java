import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String file = "notes.txt";

    // Write note to file 
    public static void writeNote(String note) {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(note + System.lineSeparator());
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    // Read all notes from file
    public static void readNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n--- Saved Notes ---");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
            System.out.println("-------------------\n");
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Start by adding some!");
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Notes App ===");
            System.out.println("1. Write a Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    writeNote(note);
                }
                case 2 -> readNotes();
                case 3 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice, try again!");
            }
        } while (choice != 3);

        sc.close();
    }
}
