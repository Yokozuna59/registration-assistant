package registration_assistant;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        File dataFile = new File("data");
        ArrayList<Course> courses = ReadCSV
                .readDegreePlan(getClass().getResource("/data/DegreePlan.csv").getFile());
        ArrayList<FinishedCourse> finishCourses = ReadCSV
                .readFinishedCourse(getClass().getResource("/data/FinishedCourses.csv").getFile());
        ArrayList<Section> Sections = ReadCSV
                .readCourseOffering(getClass().getResource("/data/CourseOffering.csv").getFile());

        AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("views/Schedule.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("Registration Assistant");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
