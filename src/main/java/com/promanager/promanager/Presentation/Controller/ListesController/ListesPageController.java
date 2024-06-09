package com.promanager.promanager.Presentation.Controller.ListesController;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Presentation.DB.ListesModel.ListesPageModel;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageHistorique;
import com.promanager.promanager.Presentation.View.ListesView.AffichageTachePage;
import com.promanager.promanager.Presentation.View.ListesView.AjouterTachePage;
import com.promanager.promanager.Presentation.View.ListesView.ListesPage;
import com.promanager.promanager.Presentation.View.ListesView.ModifierTacheListe;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;
import com.promanager.promanager.Presentation.View.StatistiqueView.StatistiquePage;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import org.bson.types.ObjectId;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ListesPageController {
    private Button buttonProjets;
    private Button buttonHistorique;
    private Button buttonStatistic;
    private Button buttonAjouterTache;
    private Stage stage;
    private ListesPageModel model;

    public ListesPageController(ListesPage view, Stage stage) {
        this.stage = stage;
        this.buttonProjets = view.getProjets();
        this.buttonHistorique = view.getHistoriques();
        this.buttonAjouterTache = view.getButtonAjouter();
        buttonStatistic = view.getStatistiques();
        model = new ListesPageModel();

        buttonProjets.setOnAction(event -> {
            openProjetsPage();
        });
        buttonHistorique.setOnAction(event -> {
            openHistoriquePage();
        });
        buttonStatistic.setOnAction(event -> {
            openStatisticPage();
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

    private void openStatisticPage() {
        StatistiquePage Listespage = new StatistiquePage(stage);
        Scene projectsScene = new Scene(Listespage, 1300, 800);
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

    public void modifierTache(ObjectId idTache) {
        ModifierTacheListe AjouterPage = new ModifierTacheListe(idTache, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void supprimerTache(ObjectId idTache, ObjectId idListe) {
        ArrayList<ObjectId> listTaches = model.getTachesListe(idListe);
        listTaches.remove(idTache);
        model.updateListe(idListe, listTaches);

        ListesPage page = new ListesPage(stage);
        Scene projectsScene = new Scene(page, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void supprimerListe(ObjectId idListe) {
        boolean sup = true;
        for (ObjectId tache : model.getTachesListe(idListe)) {
            boolean tacheUtiliseeDansProjet = false;
            for (Projet projet : model.getAllProjets()) {
                if (projet.getListeTaches().contains(tache)) {
                    tacheUtiliseeDansProjet = true;
                    break;
                }
            }
            if (!tacheUtiliseeDansProjet) {
                sup = false;
            }
        }

        if (sup) {
            model.deleteListe(idListe);
            listepage();

        } else {
            Stage stage = new Stage();
            Label erreurMessage = new Label("Impossible de supprimer liste");
            Button closeButton = new Button("OK");
            closeButton.setOnAction(event -> stage.close());

            VBox root = new VBox(20);
            root.setPadding(new Insets(10));
            root.getChildren().addAll(erreurMessage, closeButton);
            Scene error = new Scene(root, 400, 200);

            erreurMessage.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-text-fill: red;");
            root.setStyle("-fx-background-color: #f0f0f0; -fx-alignment: center;");

            stage.setScene(error);
            stage.setResizable(false);
            stage.setTitle("Erreur");
            stage.show();
        }

    }

    private void listepage() {
        ListesPage Listespage = new ListesPage(stage);
        Scene projectsScene = new Scene(Listespage, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    public void clonerTache(ObjectId idTache, ObjectId list) throws ProjetExeption {
        Tache tache = model.getTache(idTache);
        tache.setIdTache(new ObjectId());
        ObjectId idnewTache = model.addTache(tache);
        ArrayList<ObjectId> listTaches = model.getTachesListe(list);
        listTaches.add(idnewTache);
        model.updateListe(list, listTaches);
        listepage();
    }
}