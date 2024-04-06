package com.promanager.promanager;

import java.util.ArrayList;
import java.util.Date;

import com.promanager.promanager.Persistance.Connexion;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Persistance.DAOdocument;
import com.promanager.promanager.Presentation.View.LoginPage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// public class App extends Application {
@SuppressWarnings("unused")
public class App {
    // @Override
    // public void start(Stage primaryStage) throws Exception {
    // LoginPage loginPageView = new LoginPage();

    // Scene scene = new Scene(loginPageView, 1300, 800);

    // primaryStage.setScene(scene);
    // primaryStage.setTitle("Login Page");
    // primaryStage.show();
    // }

    public static void main(String[] args) {
        // launch();
        Date currentDate = new Date();
        System.out.println(currentDate);
    }
}
