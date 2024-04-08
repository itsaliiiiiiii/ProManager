package com.promanager.promanager;

import java.util.Arrays;

import org.bson.types.ObjectId;

import com.promanager.promanager.Persistance.Connexion;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.View.LoginPage;
import com.promanager.promanager.Presentation.View.ProjetsPage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// @SuppressWarnings("unused")
// public class App {
@SuppressWarnings("unused")
public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        DAOconfiguration config = new DAOconfiguration();
        if (config.getMail().equals("empty")) {
            LoginPage loginPageView = new LoginPage(stage);
            Scene scene = new Scene(loginPageView, 1300, 800);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("ProManager");
            stage.show();
        } else {
            ProjetsPage projetsPage = new ProjetsPage(stage);
            Scene projectsScene = new Scene(projetsPage, 1000, 600);
            stage.setScene(projectsScene);
            stage.setMinWidth(1000);
            stage.setMinHeight(600);
            stage.setTitle("ProManager - Projects");
            stage.show();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}
