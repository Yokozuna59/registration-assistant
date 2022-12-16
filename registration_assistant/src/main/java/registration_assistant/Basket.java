package registration_assistant;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Section> sectionsBasket;

    public Basket(ArrayList<Section> sectionsInBasket) {
        this.sectionsBasket = sectionsInBasket;
    }

    public void addSection(Section section) {
        sectionsBasket.add(section);
    }

    public void removeSection(Section section) {
        sectionsBasket.remove(section);
    }

    public ArrayList<Section> getSectionsBasket() {
        return sectionsBasket;
    }
}
