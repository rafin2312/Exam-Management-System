package com.exam.examprep.controller;

import com.exam.examprep.DatabaseConnection;
import com.exam.examprep.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.w3c.dom.events.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML
    public TextField emailField;

    @FXML
    public PasswordField passwordField;
    Connection connect;
    PreparedStatement prepare;
    ResultSet result;

    @FXML
    public void enterButton(ActionEvent event){
        String validEmail = emailField.getText();
        String validPassword = passwordField.getText();
        String checkData = "SELECT EMAIL,PASSWORD FROM STUDENT WHERE EMAIL='"+validEmail+"' AND PASSWORD='"+validPassword+"';";
        System.out.println(checkData);
        connect = DatabaseConnection.getConnection();
        try{
            prepare = connect.prepareStatement(checkData);
            result = prepare.executeQuery();
            if (result.next()){
                HelloApplication.sceneChange("examPage");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Failed to fetch data from database for login");
        }

        String email = emailField.getText();
        String password = passwordField.getText();
        if (email.equals(validEmail) && password.equals(validPassword)){
            HelloApplication.sceneChange("examPage");
        }else{
            System.out.println("Failed to login. Please Try again");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Email or Password is incorrect");
            alert.show();
        }
    }
    @FXML
    public void goToQuestionSet(javafx.scene.input.MouseEvent event){
        HelloApplication.sceneChange("loginForTeacher");
    }
    @FXML
    public void goToRegistration(javafx.scene.input.MouseEvent mouseEvent) {
        HelloApplication.sceneChange("registration");
    }
}
