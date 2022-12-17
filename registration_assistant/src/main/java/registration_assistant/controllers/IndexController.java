package registration_assistant.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import registration_assistant.App;

public class IndexController implements Initializable {
    public void switchToBasket(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/basket.fxml"));
        App.setPane(root);
    }

    public void saveSchedule() {
        File studentSchedule = Paths.get("src", "main", "resources", "student",
                "schedule.ser").toFile();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(studentSchedule);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(App.getStudent().getSchedules());
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
