package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import com.promanager.promanager.Presentation.View.ProjetView.Taches.ModifierTache;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Persistance.DAOprojet;
import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AffichageTaches;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AjouterTacheProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;

public class TachesProjetController {
    private Button PrecedentButton;
    private DAOprojet gProj;
    private Stage stage;

    public TachesProjetController(TachesProjet view, Stage stage, ObjectId id) {
        this.PrecedentButton = view.getPrecedentButton();
        gProj = new DAOprojet();
        this.stage = stage;
        PrecedentButton.setOnAction(event -> {
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

    public void openTache(ObjectId id, ObjectId idProjet) {
        AffichageTaches AjouterPage = new AffichageTaches(id, idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void supprimerTacheProjet(ObjectId idProjet, ObjectId idTache) {
        ArrayList<ObjectId> listTaches = gProj.get(idProjet).getListeTaches();
        listTaches.remove(idTache);
        gProj.update(idProjet, "Taches", listTaches);

        TachesProjet AjouterPage = new TachesProjet(idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void modifierTache(ObjectId idProjet, ObjectId idTache) {
        ModifierTache AjouterPage = new ModifierTache(idProjet, idTache, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void AjouterTache(ObjectId idProjet) {
        AjouterTacheProjet AjouterPage = new AjouterTacheProjet(idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }
}