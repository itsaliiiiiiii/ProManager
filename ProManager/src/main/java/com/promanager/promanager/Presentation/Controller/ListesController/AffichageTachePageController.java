package com.promanager.promanager.Presentation.Controller.ListesController;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Presentation.View.ListesVIiew.AffichageTachePage;
import com.promanager.promanager.Presentation.View.ListesVIiew.AjouterDocumentTachePage;
import com.promanager.promanager.Presentation.View.ListesVIiew.ListesPage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AffichageTachePageController {
    private Button PrecedentButton;
    private Button AjouterButton;
    private Stage stage;
    private gestionTache gTache;

    public AffichageTachePageController(AffichageTachePage view, Stage stage, ObjectId idTache) {
        this.PrecedentButton = view.getPrecedentButton();
        this.AjouterButton = view.getAjouterButton();
        gTache = new gestionTache();

        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            stage.setWidth(1300);
            stage.setHeight(800);
            ListesPage AjouterPage = new ListesPage(stage);
            Scene projectsScene = new Scene(AjouterPage, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });

        AjouterButton.setOnAction(event -> {
            stage.setWidth(1300);
            stage.setHeight(800);
            AjouterDocumentTachePage AjouterPage = new AjouterDocumentTachePage(stage, idTache);
            Scene projectsScene = new Scene(AjouterPage, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });

    }

    public void supprimerDocProjet(ObjectId idoc, ObjectId idTache, ObjectId idProj) {
        ArrayList<ObjectId> listTaches = gTache.get_Tache(idTache).getListeDocument();
        System.out.println(listTaches);
        listTaches.remove(idoc);
        System.out.println(listTaches);
        gTache.update(idTache, "Documents", listTaches);

        AffichageTachePage tache = new AffichageTachePage(idTache, stage);
        Scene projectsScene = new Scene(tache, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }
}