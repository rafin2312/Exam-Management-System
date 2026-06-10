package com.exam.examprep.controller;

import com.exam.examprep.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class editQuestionController {
    @FXML
    public void goToSetQuestion(javafx.scene.input.MouseEvent mouseEvent) {
        HelloApplication.sceneChange("setQuestion");
    }
}
