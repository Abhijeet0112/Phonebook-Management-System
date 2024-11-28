package com.phonebook.app;
import java.util.Scanner;

import com.phonebook.database.PhonebookManager;

public class PhonebookApp {
    public static void main(String[] args) {
        PhonebookManager manager = new PhonebookManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Phonebook Management System ====");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Search Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.next();
                    System.out.print("Enter email: ");
                    String email = scanner.next();
                    manager.addContact(name, phoneNumber, email);
                    break;

                case 2:
                    manager.viewAllContacts();
                    break;

                case 3:
                    System.out.print("Enter ID of the contact to update: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    scanner.nextLine(); // Consume newline
                    String newName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.next();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.next();
                    manager.updateContact(idToUpdate, newName, newPhoneNumber, newEmail);
                    break;

                case 4:
                    System.out.print("Enter ID of the contact to delete: ");
                    int idToDelete = scanner.nextInt();
                    manager.deleteContact(idToDelete);
                    break;

                case 5:
                    System.out.print("Enter name or phone number to search: ");
                    scanner.nextLine(); // Consume newline
                    String query = scanner.nextLine();
                    manager.searchContact(query);
                    break;

                case 6:
                    System.out.println("Exiting Phonebook Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
