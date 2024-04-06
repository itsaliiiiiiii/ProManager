package com.promanager.promanager;

import com.promanager.promanager.Presentation.View.LoginPage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginPage loginPageView = new LoginPage();

        Scene scene = new Scene(loginPageView, 1300, 800);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Page");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}
