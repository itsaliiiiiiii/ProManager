package com.promanager.promanager.Presentation.Controller.ListesController;

import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageHistorique;
import com.promanager.promanager.Presentation.View.ListesVIiew.ModifierTacheListe;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.ModifierTache;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ListesVIiew.AffichageTachePage;
import com.promanager.promanager.Presentation.View.ListesVIiew.AjouterTachePage;
import com.promanager.promanager.Presentation.View.ListesVIiew.ListesPage;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListesPageController {
    private Button buttonProjets;
    private Button buttonHistorique;
    private Button buttonAjouterTache;
    private Stage stage;

    public ListesPageController(ListesPage view, Stage stage) {
        this.stage = stage;
        this.buttonProjets = view.getProjets();
        this.buttonHistorique = view.getHistoriques();
        this.buttonAjouterTache = view.getButtonAjouter();

        buttonProjets.setOnAction(event -> {
            openProjetsPage();
        });
        buttonHistorique.setOnAction(event -> {
            openHistoriquePage();
        });
        buttonAjouterTache.setOnAction(event -> {
            AjouterTache();
        });
    }

    public void afficherTache(ObjectId idtache) {
        AffichageTachePage afficheTache = new AffichageTachePage(idtache, stage);
        Scene projectsScene = new Scene(afficheTache, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    public void AjouterTache() {
        AjouterTachePage afficheTache = new AjouterTachePage(stage);
        Scene projectsScene = new Scene(afficheTache, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
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
    public void  modifierTache(ObjectId idTache){
        ModifierTacheListe AjouterPage = new ModifierTacheListe(idTache, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }
}