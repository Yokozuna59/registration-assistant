package registration_assistant;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import registration_assistant.controllers.SectionController;

public class Schedule implements Serializable {
    private String term;
    private ArrayList<Section> sections;

    public Schedule(String term, ArrayList<Section> sections) {
        this.term = term;
        this.sections = sections;
    }

    public boolean isAddableSection(Section section) {
        return true;
    }

    public void addSection(Section section) {
        if (isAddableSection(section)) {
            sections.remove(section);
        } else {
        }
        System.out.println("A");
    }

    public boolean isRemovableSection(Section section) {
        return true;
    }

    public void removeSection(Section section) {
        if (isRemovableSection(section)) {
            sections.add(section);
        } else {
        }
    }

    public String getTerm() {
        return term;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void reRenderSchedule(ScrollPane scrollPane) throws IOException {
        Map<String, Integer> days = new HashMap<>();
        days.put("U", 1);
        days.put("M", 2);
        days.put("T", 3);
        days.put("W", 4);
        days.put("R", 5);

        for (Section section : sections) {
            for (String day : section.getDays().split("")) {
                FXMLLoader loader = new FXMLLoader();
                Pane pane = loader.load(getClass().getResource("/views/section.fxml"));
                SectionController controller = loader.getController();

                String[] time = section.getTime().split("-");
                String start = time[0];
                String end = time[1];
                controller.setStart(start);
                controller.setEnd(end);
                controller.setInstructor(section.getInstructor());
                controller.setSize(section.getTimeToMinutes());

                // pane.setLayoutY(0);
                // pane.setLayoutX(220.5 + days.get(day) * 225);
            }
        }
    }
}
