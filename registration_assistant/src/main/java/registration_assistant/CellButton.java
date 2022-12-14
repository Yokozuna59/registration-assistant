package registration_assistant;

import java.io.Serializable;

import javafx.scene.control.Button;

public class CellButton extends Button implements Serializable {
    CellButton(String buttonName, boolean isAddButton) {
        super(buttonName);
        disableProperty().set(!isAddButton);
    }

    public void disable() {
        disableProperty().set(true);
    }

    public void enable() {
        disableProperty().set(false);
    }
}
