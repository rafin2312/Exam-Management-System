module com.exam.examprep {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.exam.examprep to javafx.fxml;
    opens com.exam.examprep.controller to javafx.fxml;

    exports com.exam.examprep;
    exports com.exam.examprep.controller;
}
