package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ProjetView.Taches.AffichageTaches;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AffichageTacheController {
    private Button PrecedentButton;

    public AffichageTacheController(AffichageTaches view, Stage stage, ObjectId idTache,ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();

        PrecedentButton.setOnAction(event -> {
            stage.setWidth(1300);
            stage.setHeight(800);
            TachesProjet AjouterPage = new TachesProjet(idProjet, stage);
            Scene projectsScene = new Scene(AjouterPage, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });

    }
}
