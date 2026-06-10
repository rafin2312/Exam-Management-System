package com.exam.examprep.controller;

import com.exam.examprep.DatabaseConnection;
import com.exam.examprep.HelloApplication;
import com.exam.examprep.model.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestionController {

    @FXML
    public TextField correctAnswerField;
    @FXML
    public TextField opt1Field;
    @FXML
    public TextField opt2Field;
    @FXML
    public TextField opt3Field;
    @FXML
    public TextField opt4Field;
    @FXML
    public TextArea questionField;
    @FXML
    public TextField questionIDField;



    public void saveQuestion(ActionEvent event) throws SQLException {
        String id = questionIDField.getText();
        String ques = questionField.getText();
        String opt1 = opt1Field.getText();
        String opt2 = opt2Field.getText();
        String opt3 = opt3Field.getText();
        String opt4 = opt4Field.getText();
        String corrAns = correctAnswerField.getText();

        Question question = new Question(id,ques,opt1,opt2,opt3,opt4,corrAns);
        insertQuestionIntoDB(question);
        System.out.println(question.getQuestion()+" "+question.getCorrAns());

        questionIDField.setText("");
        questionField.setText("");
        opt1Field.setText("");
        opt2Field.setText("");
        opt3Field.setText("");
        opt4Field.setText("");
        correctAnswerField.setText("");

    }
    @FXML
    public void goToLogin(javafx.scene.input.MouseEvent mouseEvent) {
        HelloApplication.sceneChange("login");
    }
    @FXML
    public void goToEdit(javafx.scene.input.MouseEvent mouseEvent) {
    }
    public void insertQuestionIntoDB(Question question){
        Connection connection = DatabaseConnection.getConnection();
        try{
            String query =
                    "INSERT INTO question_set VALUES("
                            + question.getId() + ", '"
                            + question.getQuestion() + "', '"
                            + question.getOpt1() + "', '"
                            + question.getOpt2() + "', '"
                            + question.getOpt3() + "', '"
                            + question.getOpt4() + "', '"
                            + question.getCorrAns()
                            + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("Question added to the database");
        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Failed add data into database");
        }
    }
}
