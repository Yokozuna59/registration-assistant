package registration_assistant.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import registration_assistant.App;
import registration_assistant.Section;

public class SectionsTableController implements Initializable {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Section> list = FXCollections
                .observableArrayList(App.getStudent().getBasket().getSectionsBasket());
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
        add.setCellValueFactory(new PropertyValueFactory<Section, Button>("addToSchedule"));
        remove.setCellValueFactory(new PropertyValueFactory<Section, Button>("removeFromSchedule"));
        table.setItems(list);
    }
}
