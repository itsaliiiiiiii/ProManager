package com.promanager.promanager.Presentation.Controller.ListesController;

import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ListesVIiew.AffichageTachePage;
import com.promanager.promanager.Presentation.View.ListesVIiew.ListesPage;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListesPageController {
    private Stage stage;
    public ListesPageController(ListesPage view , Stage stage) {
        this.stage = stage;
    }
    public void afficherTache(ObjectId idtache){
        AffichageTachePage afficheTache = new AffichageTachePage(idtache, stage);
        Scene projectsScene = new Scene(afficheTache, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}