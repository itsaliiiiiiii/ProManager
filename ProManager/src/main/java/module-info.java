module com.promanager.promanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires java.naming;
    requires java.desktop;
    requires javafx.base;
    requires javafx.swing;
    requires google.api.services.calendar.v3.rev411;
    requires com.google.api.client.auth;
    requires google.api.client;
    requires com.google.api.client.extensions.java6.auth;
    requires com.google.api.client.extensions.jetty.auth;
    requires com.google.api.client;
    requires com.google.api.client.json.jackson2;
    requires java.base;

    requires jdk.httpserver;

    opens com.promanager.promanager to javafx.fxml;

    exports com.promanager.promanager;

    opens com.promanager.promanager.Presentation.Controller to javafx.fxml;
    opens com.promanager.promanager.Metier.Service to javafx.fxml;

}