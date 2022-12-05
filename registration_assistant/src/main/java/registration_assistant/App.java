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

        try {
            ArrayList<Course> courses = ReadCSV.readDegreePlan(getClass().getClassLoader().getResource(
                    new File(dataFile, "DegreePlan.csv").toString()).toURI());
            ArrayList<FinishedCourse> finishCourses = ReadCSV
                    .readFinishedCourse(getClass().getClassLoader().getResource(
                            new File(dataFile, "FinishedCourses.csv").toString()).toURI());
            ArrayList<Section> Sections = ReadCSV.readCourseOffering(getClass().getClassLoader().getResource(
                    new File(dataFile, "CourseOffering.csv").toString()).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("views/index.fxml"));
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
