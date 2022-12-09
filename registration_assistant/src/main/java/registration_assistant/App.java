package registration_assistant;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<Course> courses = ReadCSV.readDegreePlan(
                getClass().getResource("/data/DegreePlan.csv").getFile());
        ArrayList<FinishedCourse> finishedCourses = ReadCSV.readFinishedCourse(
                getClass().getResource("/data/FinishedCourses.csv").getFile());
        ArrayList<Section> sections = ReadCSV.readCourseOffering(
                getClass().getResource("/data/CourseOffering.csv").getFile());

        Student student1 = new Student(finishedCourses, null);
        student1.remainCourses(courses, sections);
        System.out.println(sections.size());
        for(int i=0;i<sections.size();i++)
            System.out.println(sections.get(i).getFullName());
        ScrollPane root = FXMLLoader.load(getClass().getClassLoader().getResource("views/index.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setMinHeight(758);
        stage.setMinWidth(1206);
        stage.setTitle("Registration Assistant");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
