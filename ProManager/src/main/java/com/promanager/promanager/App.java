package com.promanager.promanager;

// import com.promanager.promanager.Presentation.View.LoginPage;
import com.promanager.promanager.Presentation.View.ProjetsPage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// @SuppressWarnings("unused")
// public class App {
public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ProjetsPage ProjetsPagev = new ProjetsPage();

        Scene scene = new Scene(ProjetsPagev, 1300, 800);

        stage.setScene(scene);
        stage.setTitle("Login Page");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
