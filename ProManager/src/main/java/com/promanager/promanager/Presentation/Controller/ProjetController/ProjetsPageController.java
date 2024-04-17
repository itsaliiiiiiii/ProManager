package com.promanager.promanager.Presentation.Controller.ProjetController;

import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageHistorique;
import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.AjouterProjetPage;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProjetsPageController {

    public AnchorPane background;
    private Button buttonAjouter;
    private Button buttonHistorique;
    
    private Stage stage;

    public ProjetsPageController(ProjetsPage view, Stage stage) {
        this.background = view.getBack();
        this.buttonAjouter = view.getButtonAjouter();
    
        this.buttonHistorique = view.getHistoriques();
        this.stage = stage;

        this.buttonAjouter.setOnAction(event -> {
            this.openAjouterProjet();
        });

        this.buttonHistorique.setOnAction(event -> {
            this.openHistoriquePage();
        });

    };

    private void openAjouterProjet() {
        stage.setWidth(1300);
        stage.setHeight(800);
        AjouterProjetPage AjouterPage = new AjouterProjetPage(stage);
        Parent root = AjouterPage;
        Scene projectsScene = new Scene(root, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }


    public void afficherProjet(ObjectId id) {
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
    }

    private void openHistoriquePage() {
        AffichageHistorique historiquePage = new AffichageHistorique(stage, "tout", "tout");
        Parent historiqueRoot = historiquePage;
        Scene projectsScene = new Scene(historiqueRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}