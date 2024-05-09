package com.promanager.promanager.Presentation.Controller.ProjetController;

import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageHistorique;
import com.promanager.promanager.Presentation.View.ListesView.ListesPage;

import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.AjouterProjetPage;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;
import com.promanager.promanager.Presentation.View.StatistiqueView.StatistiquePage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProjetsPageController {

    private Button buttonAjouter;
    private Button buttonHistorique;
    private Button buttonListes;
    private Button buttonStatistics;


    private Stage stage;

    public ProjetsPageController(ProjetsPage view, Stage stage) {
        // this.background = view.getBack();
        this.buttonAjouter = view.getButtonAjouter();
        buttonListes = view.getListes();
        buttonStatistics = view.getStatistiques();

        this.buttonHistorique = view.getHistoriques();
        this.stage = stage;

        this.buttonAjouter.setOnAction(event -> {
            this.openAjouterProjet();
        });

        this.buttonHistorique.setOnAction(event -> {
            this.openHistoriquePage();
        });

        this.buttonListes.setOnAction(event -> {
            this.openListesPage();
        });
        
        this.buttonStatistics.setOnAction(event -> {
            this.openStatisticPage();
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
        AffichageHistorique historiquePage = new AffichageHistorique(stage);
        Parent historiqueRoot = historiquePage;
        Scene projectsScene = new Scene(historiqueRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
    private void openListesPage() {
        ListesPage Listespage = new ListesPage(stage);
        Scene projectsScene = new Scene(Listespage, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
    private void openStatisticPage() {
        StatistiquePage Listespage = new StatistiquePage(stage);
        Scene projectsScene = new Scene(Listespage, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

}