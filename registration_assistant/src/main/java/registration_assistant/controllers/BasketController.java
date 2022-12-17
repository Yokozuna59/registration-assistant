package registration_assistant.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import registration_assistant.App;
import registration_assistant.Basket;
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
    private TableColumn<Section, Button> add;
    @FXML
    private TableColumn<Section, Button> remove;

    public void switchToSchedule(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/index.fxml"));
        App.setPane(root);
        try {
            App.getStudent().getSchedules().reRenderSchedule();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void goToSavedSchedule(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/index.fxml"));
        App.setPane(root);
        try {
            App.getStudent().getSchedules().reRenderSchedule();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: check if user has added sections
        // nextButton.setDisable(true);

        File studentSchedule = Paths.get("src", "main", "resources", "student",
                "schedule.ser").toFile();
        if (studentSchedule.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(
                        getClass().getResource("/student/schedule.ser").getFile());
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Schedule schedule = (Schedule) objectInputStream.readObject();

                ArrayList<Section> sections = schedule.getSections();
                Basket basket = new Basket(sections);

                for (int i = 0; i < sections.size(); i++) {
                    sections.get(i).setBasket(basket);
                    // sections.get(i).setSchedule(schedule);
                }

                // App.getStudent().setBasket(basket);
                App.getStudent().setSchedules(schedule);
            } catch (Exception e) {
                e.printStackTrace();
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
        add.setCellValueFactory(new PropertyValueFactory<Section, Button>("addToBasket"));
        remove.setCellValueFactory(new PropertyValueFactory<Section, Button>("removeFromBasket"));
        table.setItems(list);
    }
}
