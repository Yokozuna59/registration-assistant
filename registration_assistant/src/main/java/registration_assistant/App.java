package registration_assistant;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
    private static ArrayList<Section> sections;
    private static Student student;
    private static Scene scene;

    public static void setPane(Object pane) {
        if (pane instanceof Pane)
            App.scene.setRoot((Pane) pane);
        else if (pane instanceof ScrollPane)
            App.scene.setRoot((ScrollPane) pane);
    }

    public static Scene getScene() {
        return scene;
    }

    public static Student getStudent() {
        return student;
    }

    public static ArrayList<Section> getSections() {
        return sections;
    }

    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        ArrayList<Course> courses = ReadCSV.readDegreePlan(
                getClass().getResource("/data/DegreePlan.csv").getFile());
        ArrayList<FinishedCourse> finishedCourses = ReadCSV.readFinishedCourse(
                getClass().getResource("/data/FinishedCourses.csv").getFile());
        sections = ReadCSV.readCourseOffering(
                getClass().getResource("/data/CourseOffering.csv").getFile());

        File studentFolder = Paths.get("src", "main", "resources", "student").toFile();
        studentFolder.mkdir();
        Schedule schedule = new Schedule("202220", new ArrayList<Section>());

        student = new Student(finishedCourses, schedule, new Basket(new ArrayList<>()));
        for (int i = 0; i < sections.size(); i++) {
            sections.get(i).setBasket(student.getBasket());
            sections.get(i).setSchedule(student.getSchedules());
        }
        student.remainCourses(courses, finishedCourses, sections);

        AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("views/basket.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setMinWidth(1563.05);
        stage.setMaxWidth(1563.05);
        stage.setTitle("Registration Assistant");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
