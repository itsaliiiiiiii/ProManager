module com.promanager.promanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.promanager.promanager to javafx.fxml;
    exports com.promanager.promanager;
}