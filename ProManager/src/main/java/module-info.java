module com.promanager.promanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires java.naming;

    opens com.promanager.promanager.Presentation.Controller to javafx.fxml;
    opens com.promanager.promanager to javafx.graphics;
}