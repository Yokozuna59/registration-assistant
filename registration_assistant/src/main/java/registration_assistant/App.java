package registration_assistant;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<Course> courses=ReadFiles.readDegreePlan("src\\main\\resources\\data\\DegreePlan.csv");
        ArrayList<FinishedCourse> finishCourses=ReadFiles.readFinshedCourses("src\\main\\resources\\data\\FinishedCourses.csv");
        ArrayList<Section> Sections=ReadFiles.readCourseOffering("src\\main\\resources\\data\\CourseOffering.csv");


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
