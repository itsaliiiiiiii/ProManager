package com.promanager.promanager.Presentation.Controller.ProjetController.Documents;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Documents.AffichageDocuments;
import com.promanager.promanager.Presentation.View.ProjetView.Documents.AjouterDocumentProjet;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AffichageDocumentsController {
    private Button PrecedentButton;
    private Button AjouterButton;
    private Stage stage;
    private gestionProjet gProj;

    public AffichageDocumentsController(AffichageDocuments view, Stage stage, ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();
        this.AjouterButton = view.getAjouterButton();
        gProj = new gestionProjet();

        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            stage.setWidth(1300);
            stage.setHeight(800);
            AffichageProjet AjouterPage = new AffichageProjet(idProjet, stage);
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
            AjouterDocumentProjet AjouterPage = new AjouterDocumentProjet(stage, idProjet);
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
