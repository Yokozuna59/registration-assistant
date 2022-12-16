package registration_assistant.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;

public class SectionController {
    @FXML
    private Pane pane;

    @FXML
    private Rectangle rectangle;

    @FXML
    private GridPane gridPane;

    @FXML
    private RowConstraints bottomRow;

    @FXML
    private RowConstraints topRow;

    @FXML
    private Label courseInfo;

    @FXML
    private Label instructor;

    @FXML
    private Label start;

    @FXML
    private Label end;

    public void setStart(String startTime) {
        start.setText(startTime);
    }

    public void setEnd(String endTime) {
        end.setText(endTime);
    }

    public void setInstructor(String instructorName) {
        instructor.setText(instructorName);
    }

    public void setCourseInfo(String courseName, String place) {
        this.courseInfo.setText(String.format("%s@%s", courseName, place));
    }

    public void setSize(int size) {
        pane.setPrefSize(225, size);
        rectangle.setHeight(size);
        gridPane.setPrefHeight(size);
        topRow.setPrefHeight(size / 2);
        bottomRow.setPrefHeight(size / 2);
    }

    @FXML
    void initialize() {
    }
}
