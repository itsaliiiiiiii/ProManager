package com.promanager.promanager.Presentation.Controller.HistoriqueController.Documents;

import java.util.ArrayList;

import com.promanager.promanager.Presentation.View.HistoriqueView.Documents.AffichageDocumentsHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageProjetHistorique;
import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Documents.AffichageDocuments;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AffichageDocumentsHistoriqueController {
    private Button PrecedentButton;
    private Stage stage;
    private gestionProjet gProj;

    public AffichageDocumentsHistoriqueController(AffichageDocumentsHistorique view, Stage stage, ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();
        gProj = new gestionProjet();

        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            stage.setWidth(1300);
            stage.setHeight(800);
            AffichageProjetHistorique AjouterPage = new AffichageProjetHistorique(idProjet, stage);
            Scene projectsScene = new Scene(AjouterPage, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });



    }

    public void supprimerDocProjet(ObjectId idoc, ObjectId idProj) {
        ArrayList<ObjectId> listDoc = gProj.get(idProj).getListeDocument();
        listDoc.remove(idoc);
        gProj.update(idProj, "Documents", listDoc);

        AffichageDocuments root = new AffichageDocuments(idProj, stage);
        Scene projectsScene = new Scene(root, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }
}
