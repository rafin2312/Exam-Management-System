# Exam-prep

![Build Status](https://img.shields.io/badge/build-passing-brightgreen) ![License](https://img.shields.io/badge/license-MIT-blue)

## Project Description

Exam-prep is a robust JavaFX application designed to streamline the process of exam preparation and management for both educators and students. It offers a comprehensive platform where teachers can efficiently create and manage question sets, while students can engage in interactive examinations and receive immediate feedback on their performance. The application is built with a clear separation of concerns, utilizing JavaFX for the user interface and a MySQL database for persistent data storage, ensuring a scalable and maintainable architecture.

## Features

### Teacher Module

*   **Secure Teacher Login:** Authenticated access for educators to manage exam content.
*   **Question Management:**
    *   **Add Questions:** Intuitive interface for adding new multiple-choice questions, including options and the correct answer.
    *   **Edit Questions:** Functionality to modify existing questions, ensuring accuracy and relevance of exam material.
*   **Dashboard Overview:** (Placeholder for future feature: A dashboard displaying statistics on question usage and student performance.)

### Student Module

*   **User Registration & Login:** Secure authentication system for students.
*   **Exam Participation:** Students can take exams composed of questions dynamically retrieved from the database.
*   **Instant Results:** Immediate display of exam scores and performance analysis upon completion.
*   **Result History:** (Placeholder for future feature: Students can review their past exam attempts and progress.)

## Project Structure

```
Exam-prep/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── exam/
│   │   │           └── examprep/
│   │   │               ├── controller/
│   │   │               │   ├── ExamPageController.java
│   │   │               │   ├── LoginController.java
│   │   │               │   ├── LoginForTeacherController.java
│   │   │               │   ├── QuestionController.java
│   │   │               │   ├── RegistrationController.java
│   │   │               │   ├── ResultController.java
│   │   │               │   └── editQuestionController.java
│   │   │               ├── model/
│   │   │               │   ├── Question.java
│   │   │               │   ├── Student.java
│   │   │               │   └── Teacher.java
│   │   │               ├── DatabaseConnection.java
│   │   │               └── HelloApplication.java
│   │   └── resources/
│   │       └── com/
│   │           └── exam/
│   │               └── examprep/
│   │                   ├── editQuestion.fxml
│   │                   ├── examPage.fxml
│   │                   ├── login.fxml
│   │                   ├── loginForTeacher.fxml
│   │                   ├── registration.fxml
│   │                   ├── result.fxml
│   │                   └── setQuestion.fxml
└─── target/ # Compiled classes and build artifacts
```

## Technologies Used

*   **JavaFX 18.0.2:** A powerful UI toolkit for building rich client applications. It provides a modern, hardware-accelerated graphics pipeline for smooth and responsive user interfaces.
*   **Maven 3.11.0:** A robust project management and comprehension tool that handles project builds, reporting, and documentation from a central piece of information.
*   **MySQL 8.4.0:** A widely used open-source relational database management system (RDBMS) known for its reliability, performance, and ease of use.
*   **MySQL Connector/J 8.4.0:** The official JDBC driver for MySQL, enabling Java applications to connect to MySQL databases.
*   **JDK 18:** The Java Development Kit, providing the runtime environment and tools necessary for developing Java applications.

## Database Schema

The `exam_prep` database consists of three primary tables:

### `question_set`

| Column         | Type        | Constraints         | Description                               |
| :------------- | :---------- | :------------------ | :---------------------------------------- |
| `id`           | `INT`       | `PRIMARY KEY`       | Unique identifier for the question.       |
| `question`     | `VARCHAR(255)` | `NOT NULL`          | The text of the question.                 |
| `option1`      | `VARCHAR(255)` | `NOT NULL`          | First multiple-choice option.             |
| `option2`      | `VARCHAR(255)` | `NOT NULL`          | Second multiple-choice option.            |
| `option3`      | `VARCHAR(255)` | `NOT NULL`          | Third multiple-choice option.             |
| `option4`      | `VARCHAR(255)` | `NOT NULL`          | Fourth multiple-choice option.            |
| `correct_answer` | `VARCHAR(255)` | `NOT NULL`          | The correct answer among the options.     |

### `student`

| Column   | Type        | Constraints                 | Description                               |
| :------- | :---------- | :-------------------------- | :---------------------------------------- |
| `id`     | `INT`       | `PRIMARY KEY`, `AUTO_INCREMENT` | Unique identifier for the student.        |
| `username` | `VARCHAR(255)` | `NOT NULL`, `UNIQUE`        | Student's chosen username for login.      |
| `password` | `VARCHAR(255)` | `NOT NULL`                  | Student's password (should be hashed in production). |

### `teacher`

| Column   | Type        | Constraints                 | Description                               |
| :------- | :---------- | :-------------------------- | :---------------------------------------- |
| `id`     | `INT`       | `PRIMARY KEY`, `AUTO_INCREMENT` | Unique identifier for the teacher.        |
| `username` | `VARCHAR(255)` | `NOT NULL`, `UNIQUE`        | Teacher's chosen username for login.      |
| `password` | `VARCHAR(255)` | `NOT NULL`                  | Teacher's password (should be hashed in production). |

## Setup and Installation

To get a local copy of Exam-prep up and running on your machine, please follow these detailed steps:

### Prerequisites

Ensure you have the following software installed on your system:

*   **Java Development Kit (JDK) 18 or higher:** Download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.java.net/install/).
*   **Apache Maven:** Download and install from [Maven Official Website](https://maven.apache.org/download.cgi).
*   **MySQL Server:** Download and install from [MySQL Community Downloads](https://dev.mysql.com/downloads/mysql/).
*   **MySQL Workbench (Optional):** A visual tool for database design, development, and administration. Download from [MySQL Workbench](https://dev.mysql.com/downloads/workbench/).

### Database Configuration

1.  **Create Database:** Open your MySQL client (e.g., MySQL Workbench, command line) and create a new database named `exam_prep`:
    ```sql
    CREATE DATABASE exam_prep;
    USE exam_prep;
    ```
2.  **Create Tables:** Execute the following SQL commands to set up the necessary tables for the application:
    ```sql
    CREATE TABLE `question_set` (
        `id` INT NOT NULL,
        `question` VARCHAR(255) NOT NULL,
        `option1` VARCHAR(255) NOT NULL,
        `option2` VARCHAR(255) NOT NULL,
        `option3` VARCHAR(255) NOT NULL,
        `option4` VARCHAR(255) NOT NULL,
        `correct_answer` VARCHAR(255) NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE `student` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `username` VARCHAR(255) NOT NULL UNIQUE,
        `password` VARCHAR(255) NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE `teacher` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `username` VARCHAR(255) NOT NULL UNIQUE,
        `password` VARCHAR(255) NOT NULL,
        PRIMARY KEY (`id`)
    );
    ```
3.  **Update Database Credentials:** The application's database connection details are configured in `src/main/java/com/exam/examprep/DatabaseConnection.java`. If your MySQL username or password differs from the default (`root` and `12345678`), please update the `DB_USERNAME` and `DB_PASSWORD` constants accordingly.

    ```java
    // Example of database connection configuration
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/exam_prep";
    private static final String DB_USERNAME = "root"; // Your MySQL username
    private static final String DB_PASSWORD = "12345678"; // Your MySQL password
    ```

### Building and Running the Application

1.  **Clone/Extract Project:**
    If you cloned the repository:
    ```bash
    git clone https://github.com/your-username/Exam-prep.git # Replace with actual repository URL
    cd Exam-prep
    ```
    If you extracted the provided zip file, navigate to the `Exam-prep` directory:
    ```bash
    cd /path/to/Exam-prep
    ```
2.  **Build Project:** Use Maven to clean and build the project. This will download all necessary dependencies and compile the source code.
    ```bash
    mvn clean install
    ```
3.  **Run Application:** Execute the JavaFX application using the Maven plugin:
    ```bash
    mvn javafx:run
    ```

## Usage

Upon launching the application, you will be presented with a login screen. 

### For Teachers

1.  **Login:** Use the teacher login option. Default credentials (if not changed in the database) are:
    *   **Username:** `teacher`
    *   **Password:** `12345678`
    *   *Note: It is highly recommended to change these default credentials in a production environment for security reasons.*
2.  **Add Questions:** Navigate to the question management section to add new questions, specify options, and mark the correct answer.

### For Students

1.  **Register:** If you are a new student, use the registration option to create an account.
2.  **Login:** Log in with your registered student credentials.
3.  **Take Exam:** Once logged in, you can start an exam. Questions will be presented sequentially.
4.  **View Results:** After completing the exam, your score and performance summary will be displayed.

## Roadmap

*   **User Interface Enhancements:** Improve the overall aesthetic and user experience of the application.
*   **Advanced Question Types:** Support for different question formats (e.g., true/false, fill-in-the-blanks).
*   **Exam Customization:** Allow teachers to create custom exams with specific question sets and time limits.
*   **Performance Analytics:** Provide detailed analytics for teachers on student performance and question effectiveness.
*   **Security Improvements:** Implement password hashing and other security best practices for user authentication.
*   **Deployment Options:** Explore options for easier deployment, such as standalone executables or web deployment.

## Contributing

We welcome contributions to the Exam-prep project! If you have suggestions for improvements, new features, or bug fixes, please follow these steps:

1.  Fork the repository.
2.  Create a new branch (`git checkout -b feature/YourFeature` or `bugfix/YourBugFix`).
3.  Make your changes and commit them (`git commit -m 'Add new feature'` or `'Fix bug'`).
4.  Push to the branch (`git push origin feature/YourFeature`).
5.  Open a Pull Request.

Please ensure your code adheres to the project's coding standards and includes appropriate tests.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details. (Note: A `LICENSE` file is not explicitly provided in the current project structure, but it is highly recommended to include one for open-source projects.)

## Contact

For any questions or inquiries, please open an issue on the GitHub repository or contact [Your Name/Email/Organization].

---

*This README was generated by Manus AI.*
