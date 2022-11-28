package registration_assistant;

import java.util.ArrayList;

public class Schedule {
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
}
