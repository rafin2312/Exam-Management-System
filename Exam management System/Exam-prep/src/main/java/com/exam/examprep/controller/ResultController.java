package com.exam.examprep.controller;

import com.exam.examprep.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

public class ResultController {

    @FXML
    private ProgressIndicator correct_progress;

    @FXML
    private ProgressIndicator wrong_progress;

    @FXML
    private Label correcttext;

    @FXML
    private Label wrongtext;

    @FXML
    private Label marks;

    @FXML
    private Label markstext;

    @FXML
    private Label remark;

    @FXML
    public void initialize() {

        int correct = ExamPageController.correct;
        int wrong = ExamPageController.wrong;

        int total = correct + wrong;

        if (total == 0) {
            total = 1; // Prevent division by zero
        }

        // Score display
        marks.setText(correct + "/" + total);
        markstext.setText(correct + " Marks Scored out of " + total);

        // Correct and wrong answer labels
        correcttext.setText("Correct Answers : " + correct);
        wrongtext.setText("Incorrect Answers : " + wrong);

        // Progress indicators
        correct_progress.setProgress((double) correct / total);
        wrong_progress.setProgress((double) wrong / total);

        // Percentage
        double percentage = ((double) correct / total) * 100;

        // Remarks
        if (percentage < 20) {
            remark.setText(
                    "You need more practice. Review the topics carefully and try again."
            );
        }
        else if (percentage < 50) {
            remark.setText(
                    "Fair attempt. Keep practicing and you can improve your score."
            );
        }
        else if (percentage < 80) {
            remark.setText(
                    "Good job! You have a decent understanding of the material."
            );
        }
        else if (percentage < 100) {
            remark.setText(
                    "Excellent work! Your preparation and effort are clearly visible."
            );
        }
        else {
            remark.setText(
                    "Outstanding! Perfect score. Keep up the great work."
            );
        }
    }

    @FXML
    public void goToLogin(javafx.scene.input.MouseEvent mouseEvent) {

        // Reset values for next exam
        ExamPageController.correct = 0;
        ExamPageController.wrong = 0;
        ExamPageController.attempt = 0;

        HelloApplication.sceneChange("login");
    }
}