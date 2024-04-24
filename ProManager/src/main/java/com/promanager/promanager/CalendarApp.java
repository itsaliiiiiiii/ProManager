package com.promanager.promanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;

public class CalendarApp extends Application {
    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws Exception {
        String cheminAbsolu = "C:\\Users\\pc\\Desktop\\ProManager\\ProManager\\ProManager\\src\\main\\java\\com\\promanager\\promanager\\main.fxml";
        FXMLLoader loader = new FXMLLoader(new File(cheminAbsolu).toURI().toURL());
        Scene scene = new Scene(loader.load());
        stage.setTitle("Google Calendar Integration");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
