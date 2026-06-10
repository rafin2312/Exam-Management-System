package com.exam.examprep.controller;

import com.exam.examprep.DatabaseConnection;
import com.exam.examprep.HelloApplication;
import com.exam.examprep.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.w3c.dom.events.MouseEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationController {
    @FXML
    public TextField emailField;

    @FXML
    public TextField nameField;
    @FXML
    public PasswordField passwordField;


    @FXML
    public void registrationButton(ActionEvent event){
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        Student student = new Student(name, email,password);
        System.out.println(student.getName()+" "+student.getEmail()+" "+student.getPassword());
        insertStudentIntoDatabase(student);
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");

    }

    public void insertStudentIntoDatabase(Student student){
        String query =
                "INSERT INTO student(name,email,password) VALUES('"
                        + student.getName() + "','"
                        + student.getEmail() + "','"
                        + student.getPassword() + "')";
        System.out.println(query);
        try{
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(query);

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Failed to add student into database");
        }
    }

    @FXML
    public void goToLogin(javafx.scene.input.MouseEvent mouseEvent) {
        HelloApplication.sceneChange("login");
    }
}
