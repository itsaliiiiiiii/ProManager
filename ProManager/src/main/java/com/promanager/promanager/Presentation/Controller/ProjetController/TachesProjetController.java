package com.promanager.promanager.Presentation.Controller.ProjetController;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.TachesProjet;
import com.promanager.promanager.Presentation.View.TacheView.AffichageTaches;

public class TachesProjetController {
    private Button AjouterButton;
    private Button PrecedentButton;
    private Stage stage;

    public TachesProjetController(TachesProjet view, Stage stage, ObjectId id) {
        this.AjouterButton = view.getAjouterButton();
        this.PrecedentButton = view.getPrecedentButton();
        this.stage = stage;
        PrecedentButton.setOnAction(event -> {
            stage.setWidth(1300);
            stage.setHeight(800);
            AffichageProjet AjouterPage = new AffichageProjet(id, stage);
            Scene projectsScene = new Scene(AjouterPage, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });
    }
    public void openTache(ObjectId id,ObjectId idProjet){
        stage.setWidth(1300);
        stage.setHeight(800);
        AffichageTaches AjouterPage = new AffichageTaches(id, idProjet,stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }
}
