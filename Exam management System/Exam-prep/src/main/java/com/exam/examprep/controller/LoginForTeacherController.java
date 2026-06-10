package com.exam.examprep.controller;

import com.exam.examprep.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginForTeacherController {

    @FXML
    public TextField teacherLogin;
    @FXML
    public PasswordField teacherPassword;


    @FXML
    public void enter(ActionEvent event) {
        String validEmail = "rafin";
        String validPassword = "1234";

        String email = "rafin";
        String password = "1234";
        if(validEmail.equals(email) && validPassword.equals(password)){
            HelloApplication.sceneChange("setQuestion");
        }

    }
    @FXML
    public void goToLogin(javafx.scene.input.MouseEvent mouseEvent) {
        HelloApplication.sceneChange("login");
    }
}
