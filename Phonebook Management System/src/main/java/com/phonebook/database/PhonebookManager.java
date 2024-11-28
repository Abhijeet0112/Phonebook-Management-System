package com.phonebook.database;
import java.sql.*;
import java.util.Scanner;

public class PhonebookManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/phonebook_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    // Method to add a new contact
    public void addContact(String name, String phoneNumber, String email) {
        String query = "INSERT INTO contacts (name, phone_number, email) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setString(3, email);
            statement.executeUpdate();
            System.out.println("Contact added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to view all contacts
    public void viewAllContacts() {
        String query = "SELECT * FROM contacts";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Phonebook is empty!");
                return;
            }

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                                   ", Name: " + resultSet.getString("name") +
                                   ", Phone: " + resultSet.getString("phone_number") +
                                   ", Email: " + resultSet.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update a contact
    public void updateContact(int id, String name, String phoneNumber, String email) {
        String query = "UPDATE contacts SET name = ?, phone_number = ?, email = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setString(3, email);
            statement.setInt(4, id);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Contact updated successfully!");
            } else {
                System.out.println("Contact not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a contact
    public void deleteContact(int id) {
        String query = "DELETE FROM contacts WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Contact deleted successfully!");
            } else {
                System.out.println("Contact not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to search for a contact
    public void searchContact(String queryText) {
        String query = "SELECT * FROM contacts WHERE name LIKE ? OR phone_number LIKE ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + queryText + "%");
            statement.setString(2, "%" + queryText + "%");
            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("No contact found with the given query!");
                return;
            }

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                                   ", Name: " + resultSet.getString("name") +
                                   ", Phone: " + resultSet.getString("phone_number") +
                                   ", Email: " + resultSet.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
