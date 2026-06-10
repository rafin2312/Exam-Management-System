package com.exam.examprep.controller;

import com.exam.examprep.DatabaseConnection;
import com.exam.examprep.HelloApplication;
import com.exam.examprep.model.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ExamPageController implements Initializable {

    @FXML
    public Button opt1Clicked;

    @FXML
    public Button opt2Clicked;
    @FXML
    public Button opt3Clicked;
    @FXML
    public Button opt4Clicked;

    @FXML
    public Button nextBtn;
    @FXML
    public Label commentField;
    @FXML
    public Button resultBtn;

    public static int correct = 0;
    public static int wrong = 0;
    public static int attempt = 0;
    @FXML
    public TextArea questionField;
    private int questionStage = 0;
    String ans = "";

    @FXML
    public void nextScene(ActionEvent event) {
        questionStage++;
        List<Question> qList = this.readQuestion();
        if(questionStage >= qList.size() || questionStage >= 10){
            commentField.setText("Well Done. You complete the test");
            questionField.setVisible(false);
            opt1Clicked.setVisible(false);
            opt2Clicked.setVisible(false);
            opt3Clicked.setVisible(false);
            opt4Clicked.setVisible(false);
            nextBtn.setVisible(false);
            resultBtn.setVisible(true);
        }

        System.out.println("Successfully scene change");


        System.out.println("Correct answer is "+ ans);
        System.out.println("Total correct Answer is "+ correct);
        System.out.println("Total wrong answer is "+ wrong);
        System.out.println("Question stage is "+ questionStage);

        Question question = qList.get(questionStage);
        questionField.setText(question.getQuestion());
        opt1Clicked.setText(question.getOpt1());
        opt2Clicked.setText(question.getOpt2());
        opt3Clicked.setText(question.getOpt3());
        opt4Clicked.setText(question.getOpt4());
        ans = question.getCorrAns(); // matching answer


    }

    // reading question from my database
    public List<Question> readQuestion(){
        List<Question> questionList = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        try{
            String query = "SELECT * FROM question_set;";
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery(query);

            while (resultSet.next()){
                String id = resultSet.getString("id");
                String question = resultSet.getString("question");
                String opt1 = resultSet.getString("opt1");
                String opt2 = resultSet.getString("opt2");
                String opt3 = resultSet.getString("opt3");
                String opt4 = resultSet.getString("opt4");
                String corrAns = resultSet.getString("corrAns");

                Question ques = new Question(id,question,opt1,opt2,opt3,opt4,corrAns);
                questionList.add(ques);

            }

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Failed to get question data from database");
        }

        return questionList;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        resultBtn.setVisible(false);
        List<Question> q = this.readQuestion();
        for (Question question: q){
            questionField.setText(question.getQuestion());
            opt1Clicked.setText(question.getOpt1());
            opt2Clicked.setText(question.getOpt2());
            opt3Clicked.setText(question.getOpt3());
            opt4Clicked.setText(question.getOpt4());
            ans = question.getCorrAns();
            break;

        }
    }

    @FXML
    public void option1Clicked(javafx.scene.input.MouseEvent mouseEvent) {
        attempt++;
        String result = opt1Clicked.getText();
        System.out.println("Option 1 clicked. result is "+ result);

        if (Objects.equals(result,ans)){
            correct++;
        }else{
            wrong++;
        }

    }
    @FXML
    public void option3Clicked(javafx.scene.input.MouseEvent mouseEvent) {
        attempt++;
        String result = opt3Clicked.getText();
        System.out.println("Option 3 clicked. result is "+ result);
        if (Objects.equals(result,ans)){
            correct++;
        }else{
            wrong++;
        }
    }
    @FXML
    public void option2Clicked(javafx.scene.input.MouseEvent mouseEvent) {
        attempt++;
        String result = opt2Clicked.getText();
        System.out.println("Option 2 clicked. result is "+ result);
        if (Objects.equals(result,ans)){
            correct++;
        }else{
            wrong++;
        }
    }
    @FXML
    public void option4Clicked(javafx.scene.input.MouseEvent mouseEvent) {
        attempt++;
        String result = opt4Clicked.getText();
        System.out.println("Option 4 clicked. result is "+ result);
        if (Objects.equals(result,ans)){
            correct++;
        }else{
            wrong++;
        }
    }


    @FXML
    public void goToResult(ActionEvent event) {
        HelloApplication.sceneChange("result");
    }
}
