package com.promanager.promanager.Presentation.Controller.HistoriqueController.Projets;

import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageProjetHistorique;
import com.promanager.promanager.Presentation.View.ListesVIiew.ListesPage;
import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;
import com.promanager.promanager.Presentation.View.StatistiqueView.StatistiquePage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AffichageHistoriqueController {

    public AnchorPane background;
    private Button buttonProjets;
    private Button buttonListe;
    private Button buttonStat;
    private Stage stage;

    public AffichageHistoriqueController(AffichageHistorique view, Stage stage) {
        this.background = view.getBack();
        view.getCategorieFilter();
        view.getTypeFilter();
        this.stage = stage;
        this.buttonProjets = view.getProjets();
        this.buttonListe = view.getListes();
        buttonStat = view.getStatistiques();

        this.buttonProjets.setOnAction(event -> {
            this.openProjetsPage();
        });

        this.buttonListe.setOnAction(event -> {
            this.openListesPage();
        });

        this.buttonStat.setOnAction(event -> {
            this.openStatisticPage();
        });
    };

    private void openStatisticPage() {
        StatistiquePage Listespage = new StatistiquePage(stage);
        Scene projectsScene = new Scene(Listespage, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    public void afficherProjet(ObjectId id) {
        stage.setWidth(1300);
        stage.setHeight(800);
        AffichageProjetHistorique historiquePage = new AffichageProjetHistorique(id, stage);
        Parent root = historiquePage;
        Scene projectsScene = new Scene(root, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    private void openProjetsPage() {
        ProjetsPage projetsPage = new ProjetsPage(stage);
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
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
}