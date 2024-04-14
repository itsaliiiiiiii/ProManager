package com.promanager.promanager;

import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.View.LoginPage;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Image logo = new Image(getClass().getResourceAsStream("Presentation/View/Logo/ProManager.png"));


        DAOconfiguration config = new DAOconfiguration();
        if (config.getMail().equals("empty")) {
            LoginPage loginPageView = new LoginPage(stage);
            Scene scene = new Scene(loginPageView, 1300, 800);
            stage.setScene(scene);
        } else {
            ProjetsPage projetsPage = new ProjetsPage(stage, "tout", "tout");
            Scene projectsScene = new Scene(projetsPage, 1300, 800);
            stage.setScene(projectsScene);
        }
        stage.setResizable(false);
        stage.setTitle("ProManager");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}