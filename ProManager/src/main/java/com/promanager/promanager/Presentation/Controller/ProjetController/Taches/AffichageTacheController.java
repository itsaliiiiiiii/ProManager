package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AffichageTaches;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AjouterDocumentTacheProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AffichageTacheController {
    private Button PrecedentButton;
    private Button AjouterButton;
    private Stage stage;
    private gestionTache gTache;

    public AffichageTacheController(AffichageTaches view, Stage stage, ObjectId idTache, ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();
        this.AjouterButton = view.getAjouterButton();
        gTache = new gestionTache();

        this.stage = stage;

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

        AjouterButton.setOnAction(event -> {
            stage.setWidth(1300);
            stage.setHeight(800);
            AjouterDocumentTacheProjet AjouterPage = new AjouterDocumentTacheProjet(stage, idTache, idProjet);
            Scene projectsScene = new Scene(AjouterPage, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });

    }

    public void supprimerDocProjet(ObjectId idoc , ObjectId idTache,ObjectId idProj) {
        ArrayList<ObjectId> listTaches = gTache.get_Tache(idTache).getListeDocument();
        System.out.println(listTaches);
        listTaches.remove(idoc);
        System.out.println(listTaches);
        gTache.update(idTache, "Documents", listTaches);

        AffichageTaches tache = new AffichageTaches(idTache,idProj, stage);
        Scene projectsScene = new Scene(tache, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }
}