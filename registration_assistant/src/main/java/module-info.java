module registration_assistant {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens registration_assistant to javafx.fxml;

    exports registration_assistant;
}
