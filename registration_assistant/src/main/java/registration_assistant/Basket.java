package registration_assistant;

import java.util.ArrayList;

public class Basket {
    private static ArrayList<Section> SectionsInBasket;
    
    public Basket(ArrayList<Section> SectionsInBasket){
        this.SectionsInBasket=SectionsInBasket;
    }
    public static ArrayList<Section> getSectionsInBasket() {
        return SectionsInBasket; 
    }
    
}
