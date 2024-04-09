package com.promanager.promanager.Presentation.Controller.ProjetController;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;
import com.promanager.promanager.Presentation.View.ProjetView.TachesProjet;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class TachesProjetController {
    private ObjectId idProjet;
    private Text nomProjet;
    private Text categorie;
    private Text type;
    private Text dateDepart;
    private TextFlow description;
    private Text dateFin;
    private Button PrecedentButton;
    private TachesProjetController controller;
    private gestionProjet gProjet;
    private Projet Projet;

    public TachesProjetController(TachesProjet view, Stage stage, ObjectId id) {
        this.PrecedentButton = view.getPrecedentButton();

        PrecedentButton.setOnAction(event -> {
            stage.setWidth(1300);
            stage.setHeight(800);
            AffichageProjet AjouterPage = new AffichageProjet(id, stage);
            Parent root = AjouterPage;
            Scene projectsScene = new Scene(root, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
        });
    }
}
