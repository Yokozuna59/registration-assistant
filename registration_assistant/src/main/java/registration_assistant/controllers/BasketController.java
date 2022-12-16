package registration_assistant.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import registration_assistant.App;
import registration_assistant.BasketButton;
import registration_assistant.Schedule;
import registration_assistant.Section;

public class BasketController implements Initializable {
    @FXML
    private AnchorPane pane;
    @FXML
    private Text title;
    @FXML
    private Button savedScheduleButton;
    @FXML
    private Button nextButton;

    @FXML
    private TableView<Section> table;
    @FXML
    private TableColumn<Section, String> courseName;
    @FXML
    private TableColumn<Section, String> activity;
    @FXML
    private TableColumn<Section, String> crn;
    @FXML
    private TableColumn<Section, String> description;
    @FXML
    private TableColumn<Section, String> instructor;
    @FXML
    private TableColumn<Section, String> days;
    @FXML
    private TableColumn<Section, String> time;
    @FXML
    private TableColumn<Section, String> place;
    @FXML
    private TableColumn<Section, String> status;
    @FXML
    private TableColumn<Section, String> waitlist;
    @FXML
    private TableColumn<Section, BasketButton> add;
    @FXML
    private TableColumn<Section, BasketButton> remove;

    public void switchToSchedule(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/index.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void goToSavedSchedule(ActionEvent e) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(
                    getClass().getResource("/student/schedule.ser").getFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Schedule schedule = (Schedule) objectInputStream.readObject();
            App.getStudent().setSchedules(schedule);
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/index.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: check if user has added sections
        // nextButton.setDisable(true);

        File studentFolder = Paths.get("src", "main", "resources", "student").toFile();
        if (studentFolder.exists()) {
            boolean finished = false;
            while (!finished) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(
                            getClass().getResource("/student/schedule.ser").getFile());
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Schedule schedule = (Schedule) objectInputStream.readObject();
                    finished = true;
                } catch (Exception e) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        } else {
            savedScheduleButton.setDisable(true);
        }

        ObservableList<Section> list = FXCollections.observableArrayList(App.getSections());
        courseName.setCellValueFactory(new PropertyValueFactory<Section, String>("fullName"));
        activity.setCellValueFactory(new PropertyValueFactory<Section, String>("activity"));
        crn.setCellValueFactory(new PropertyValueFactory<Section, String>("crn"));
        description.setCellValueFactory(new PropertyValueFactory<Section, String>("description"));
        instructor.setCellValueFactory(new PropertyValueFactory<Section, String>("instructor"));
        days.setCellValueFactory(new PropertyValueFactory<Section, String>("days"));
        time.setCellValueFactory(new PropertyValueFactory<Section, String>("time"));
        place.setCellValueFactory(new PropertyValueFactory<Section, String>("location"));
        status.setCellValueFactory(new PropertyValueFactory<Section, String>("status"));
        waitlist.setCellValueFactory(new PropertyValueFactory<Section, String>("waitlist"));
        add.setCellValueFactory(new PropertyValueFactory<Section, BasketButton>("addToBasket"));
        remove.setCellValueFactory(new PropertyValueFactory<Section, BasketButton>("removeFromBasket"));
        table.setItems(list);
    }
}
