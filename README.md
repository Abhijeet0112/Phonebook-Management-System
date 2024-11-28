### **Project Title**  
**Phonebook Management System**  

---

### **Project Description**  
The **Phonebook Management System** is a Java-based CRUD application that allows users to manage contact information effectively. This project integrates with a MySQL database to store and retrieve data, ensuring persistent storage. It is designed to be user-friendly with a menu-driven console interface, making it ideal for beginner-level database and Java development practice.

---

### **Key Features**  
1. **Add Contact**: Save new contact details including name, phone number, and email.  
2. **View All Contacts**: Retrieve and display all stored contacts from the database.  
3. **Update Contact**: Modify existing contact details using their unique ID.  
4. **Delete Contact**: Remove a contact from the database by their ID.  
5. **Search Contact**: Search for contacts by name or phone number for quick access.  

---

### **Technologies Used**  
1. **Programming Language**: Java  
2. **Database**: MySQL  
3. **JDBC (Java Database Connectivity)**: For database interaction  
4. **Development Environment**: Works with IDEs like IntelliJ IDEA, Eclipse, or any text editor  

---

### **Setup Instructions**  
1. **Clone Repository**:  
   ```bash
   git clone https://github.com/username/phonebook-management-system.git
   cd phonebook-management-system
   ```

2. **Database Setup**:  
   - Import the SQL script provided in the repository (`phonebook.sql`) into your MySQL database.  
   - Ensure the database name is `phonebook_db` and the table is correctly created.  

3. **Add MySQL Connector**:  
   - Download the MySQL Connector/J `.jar` file.  
   - Add it to your project's classpath.  

4. **Run the Application**:  
   - Compile and execute the `PhonebookApp` class to interact with the system.  

---

### **How It Works**  
1. Launch the application.  
2. Use the menu options to perform CRUD operations.  
3. All data is stored in a MySQL database, ensuring persistence across sessions.  

---

### **Future Enhancements**  
1. Add a graphical user interface (GUI) using JavaFX or Swing.  
2. Implement additional features like importing/exporting contacts to/from files.  
3. Enhance search functionality with filters (e.g., by email or partial name match).  

---

### **Contributions**  
Contributions are welcome! Please fork the repository and submit a pull request.  

---

Feel free to customize this description with your GitHub username and any additional details!

---

-- Create the database
CREATE DATABASE phonebook_db;

-- Use the database
USE phonebook_db;

-- Create the contacts table
CREATE TABLE contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL UNIQUE,
    email VARCHAR(100) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
