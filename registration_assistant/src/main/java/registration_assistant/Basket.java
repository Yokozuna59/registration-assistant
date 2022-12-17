package registration_assistant;

import java.io.Serializable;
import java.util.ArrayList;

public class Basket implements Serializable {
    private ArrayList<Section> sectionsBasket;

    public Basket(ArrayList<Section> sectionsInBasket) {
        this.sectionsBasket = sectionsInBasket;
    }

    public void addSection(Section section) {
        boolean found = false;
        for (Section section2 : sectionsBasket) {
            if (section.getCrn().equals(section2.getCrn())
                    && section.getActivity().equals(section2.getActivity())) {
                found = true;
            }
        }
        if (!found) {
            sectionsBasket.add(section);
        }
    }

    public void removeSection(Section section) {
        sectionsBasket.remove(section);
    }

    public ArrayList<Section> getSectionsBasket() {
        return sectionsBasket;
    }
}
