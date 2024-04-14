package com.promanager.promanager.Presentation.Controller.ProjetController.Seances;

import java.util.ArrayList;

import com.promanager.promanager.Presentation.View.ProjetView.Seances.AffichageSeances;
import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.AjouterDocumentSeancesProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AffichageSeancesController {
    private Button PrecedentButton;
    private Button AjouterButton;
    private Stage stage;
    private gestionSeance gSeance;

    public AffichageSeancesController(AffichageSeances view, Stage stage, ObjectId idSeance, ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();
        this.AjouterButton = view.getAjouterButton();
        gSeance = new gestionSeance();

        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            stage.setWidth(1300);
            stage.setHeight(800);
            SeancesProjet AjouterPage = new SeancesProjet(idProjet, stage);
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
            AjouterDocumentSeancesProjet AjouterPage = new AjouterDocumentSeancesProjet(stage, idSeance, idProjet);
            Scene projectsScene = new Scene(AjouterPage, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });

    }

    public void supprimerDocProjet(ObjectId idoc , ObjectId idSeance,ObjectId idProj) {
        ArrayList<ObjectId> listTaches = gSeance.get(idSeance).getListeDocument();
        listTaches.remove(idoc);
        gSeance.update(idSeance, "Documents", listTaches);

        AffichageSeances tache = new AffichageSeances(idSeance,idProj, stage);
        Scene projectsScene = new Scene(tache, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }
}
