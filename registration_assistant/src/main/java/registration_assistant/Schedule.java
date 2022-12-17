package registration_assistant;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
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
        if (sections.size() != 0) {
            boolean CheckConflict = false;
            boolean CheckDuplicate = false;
            for (int i = 0; i < sections.size(); i++) {
                if (section.getName().equals(sections.get(i).getName()))
                    CheckDuplicate = true;
            }
            String[] days = section.getDays().split("");
            int StartTime = Integer.parseInt(section.getTime().split("-")[0]);
            int EndTime = Integer.parseInt(section.getTime().split("-")[1]);
            for (int i = 0; i < sections.size(); i++) {
                String[] days2 = sections.get(i).getDays().split("");
                if (CheckConflictInDays(days, days2)) {
                    String[] Duration = sections.get(i).getTime().split("-");
                    if (CheckConflictInHours(Duration, StartTime, EndTime))
                        CheckConflict = true;
                }
            }
            if (!CheckDuplicate && !CheckConflict)
                return true;
            else
                return false;
        } else
            return true;
    }

    public boolean CheckConflictInDays(String[] Days1, String[] Days2) {
        for (int i = 0; i < Days1.length; i++) {
            for (int j = 0; j < Days2.length; j++) {
                if (Days1[i].equals(Days2[j]))
                    return true;
            }
        }
        return false;
    }

    public boolean CheckConflictInHours(String[] Duration, int StartTime, int EndTime) {
        int StartTime1 = Integer.parseInt(Duration[0]);
        int EndTime1 = Integer.parseInt(Duration[1]);
        if ((StartTime1 <= StartTime && StartTime <= EndTime1) || (StartTime1 <= EndTime && EndTime <= EndTime1))
            return true;
        else
            return false;
    }

    public void addSection(Section section) {
        if (isAddableSection(section)) {
            ArrayList<Section> RecOrLecSections = App.getStudent().getBasket().getSectionsBasket();
            boolean found = false;
            for (int i = 0; i < RecOrLecSections.size(); i++) {
                if (RecOrLecSections.get(i).getCrn().equals(section.getCrn())
                        && !RecOrLecSections.get(i).getActivity().equals(section.getActivity())) {
                    found = true;
                }
                if (found) {
                    if (isAddableSection(RecOrLecSections.get(i))) {
                        sections.add(section);
                        section.setDisabledAddButton(true);
                        section.setDisabledRemoveButton(false);
                        sections.add(RecOrLecSections.get(i));
                        RecOrLecSections.get(i).setDisabledAddButton(true);
                        RecOrLecSections.get(i).setDisabledRemoveButton(false);
                    }
                    break;
                }
            }
            if (!found) {
                sections.add(section);
                section.setDisabledAddButton(true);
                section.setDisabledRemoveButton(false);
            }
        } else {
        }
        try {
            reRenderSchedule();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isRemovableSection(Section section) {
        return true;
    }

    public static void removePane(Section section) {
        ObservableList<Node> nodes = ((AnchorPane) (((ScrollPane) App.getScene().getRoot()).getContent()))
                .getChildren();
        for (int i = nodes.size() - 1; i >= 0; i--) {
            if (nodes.get(i) instanceof AnchorPane) {
                continue;
            } else if (nodes.get(i) instanceof Pane) {
                Pane pane = (Pane) nodes.get(i);
                ((AnchorPane) (((ScrollPane) App.getScene().getRoot()).getContent())).getChildren().remove(pane);
            }
        }
        for (Node node : nodes) {
            if (node instanceof AnchorPane) {
                continue;
            } else if (node instanceof Pane) {
                Pane pane = (Pane) node;
                ((AnchorPane) (((ScrollPane) App.getScene().getRoot()).getContent())).getChildren().remove(pane);
            }
        }
    }

    public void removeSection(Section section) {
        ArrayList<Section> RecOrLecSections = App.getStudent().getBasket().getSectionsBasket();
        sections.remove(section);
        section.setDisabledAddButton(false);
        section.setDisabledRemoveButton(true);
        removePane(section);
        for (int i = 0; i < RecOrLecSections.size(); i++) {
            if (RecOrLecSections.get(i).getCrn().equals(section.getCrn())
                    && !RecOrLecSections.get(i).getActivity().equals(section.getActivity())) {
                sections.remove(RecOrLecSections.get(i));
                RecOrLecSections.get(i).setDisabledAddButton(false);
                RecOrLecSections.get(i).setDisabledRemoveButton(true);
                removePane(RecOrLecSections.get(i));
            }
        }
        try {
            reRenderSchedule();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTerm() {
        return term;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void reRenderSchedule() throws IOException {
        Map<String, Integer> days = new HashMap<>();
        days.put("U", 1);
        days.put("M", 2);
        days.put("T", 3);
        days.put("W", 4);
        days.put("R", 5);

        for (Section section : sections) {
            for (String day : section.getDays().split("")) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/views/section.fxml"));
                Pane pane = loader.load();
                SectionController controller = loader.getController();

                String[] time = section.getTime().split("-");
                String start = time[0];
                String end = time[1];

                controller.setStart(start);
                controller.setEnd(end);
                controller.setInstructor(section.getInstructor());
                controller.setCourseInfo(section.getFullName(), section.getLocation());
                controller.setSize(section.getTimeToMinutes());

                int StartTimeMinutes = Integer.parseInt(start) % 100;
                int StartTimeHours = Integer.parseInt(start) / 100;
                pane.setLayoutY(220.5 + ((StartTimeHours - 7) * 60) + StartTimeMinutes);
                pane.setLayoutX(231.1 + (days.get(day) - 1) * 225);
                ((AnchorPane) (((ScrollPane) App.getScene().getRoot()).getContent())).getChildren().add(pane);
            }
        }
    }
}
