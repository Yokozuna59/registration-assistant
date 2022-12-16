package registration_assistant;

import java.util.ArrayList;

public class Basket {
    private static ArrayList<Section> sectionsBasket;

    public Basket(ArrayList<Section> sectionsInBasket) {
        Basket.sectionsBasket = sectionsInBasket;
    }

    public void addSection(ArrayList<Section> sections, Section section) {
        sectionsBasket.add(section);
    }

    public void removeSection(ArrayList<Section> sections, Section section) {
        sectionsBasket.remove(section);
    }

    public static ArrayList<Section> getSectionsBasket() {
        return sectionsBasket;
    }
}
