module com.promanager.promanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.promanager.promanager.Controller to javafx.fxml;
    opens com.promanager.promanager to javafx.graphics;
}