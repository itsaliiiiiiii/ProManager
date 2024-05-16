package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import com.promanager.promanager.Presentation.View.ProjetView.Taches.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Presentation.Model.ProjetModel.Taches.TachesProjetModel;
import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;

public class TachesProjetController {
    private Button PrecedentButton;
    private Button AjouterButton;
    private Button ImporterButton;
    private Stage stage;
    private ObjectId idProj;
    private Text nomProjet;
    private Text categorie;
    private Text type;
    private Text dateDepart;
    private Text dateFin;
    private String elemTache;
    private VBox tacheListe;

    private TachesProjetModel model;

    public TachesProjetController(TachesProjet view, Stage stage, ObjectId id) {
        this.PrecedentButton = view.getPrecedentButton();
        nomProjet = view.getNomProjet();
        categorie = view.getCategorie();
        type = view.getType();
        dateDepart = view.getDateDepart();
        dateFin = view.getDateFin();
        tacheListe = view.getTacheListe();
        AjouterButton = view.getAjouterButton();
        ImporterButton = view.getImporterButton();
        model = new TachesProjetModel();

        this.stage = stage;

        idProj = id;

        PrecedentButton.setOnAction(event -> {
            openAffiche();
        });

        AjouterButton.setOnMouseClicked(event -> {
            AjouterTache(idProj);
        });
        ImporterButton.setOnMouseClicked(event -> {
            Importer(idProj);
        });

        fillData();
    }

    private void openAffiche() {
        AffichageProjet AjouterPage = new AffichageProjet(idProj, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
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
        ArrayList<ObjectId> listTaches = model.getProjet(idProjet).getListeTaches();
        listTaches.remove(idTache);
        model.updateProjet(idProjet, listTaches);

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

    public void Importer(ObjectId idProjet) {
        ImporterTache AjouterPage = new ImporterTache(stage, idProjet);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void fillData() {

        Projet Projet = new Projet();
        Projet = model.getProjet(idProj);

        ArrayList<ObjectId> idsTaches = Projet.getListeTaches();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        nomProjet.setText("Nom Projet : " + Projet.getNomProjet());
        categorie.setText("Categorie : " + Projet.getCategorieProjet());
        type.setText("Type : " + Projet.getTypeProjet());
        dateDepart.setText("Date Depart : " + sdf.format(Projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(Projet.getDateFinProjet()));

        for (ObjectId idTache : idsTaches) {
            Tache tache = model.getTache(idTache);
            elemTache = "Categorie : " + tache.getCategorieTache() + " - Date Depart : "
                    + sdf.format(tache.getDateDepartTache()) + " - Date Fin : " + sdf.format(tache.getDateFinTache());

            Label LabelTache = new Label(elemTache);
            HBox hbox = new HBox();
            Button supprimerTache = new Button("Supprimer");
            Button modifierTache = new Button("Modifier");
            Button ClonerTache = new Button("Cloner");

            LabelTache.setFont(Font.font(18));
            LabelTache.setPrefHeight(40);
            LabelTache.setPrefWidth(800);
            LabelTache.setStyle(
                    "-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: #6a82ab;-fx-opacity:0.5;-fx-text-fill: #FFF;-fx-padding: 15px;-fx-background-radius:13px;-fx-border-radius:13px;");

            supprimerTache.setPrefHeight(40);
            supprimerTache.setPrefWidth(140);
            supprimerTache.setStyle(
                    "-fx-background-color: #6a82ab; -fx-text-fill: white;-fx-background-radius:13px;-fx-border-radius:13px;-fx-border-color: black; -fx-border-width: 1px;-fx-padding: 15px;-fx-opacity:0.5;");
            supprimerTache.setFont(Font.font("Arial", FontWeight.BOLD, 15.0));

            modifierTache.setPrefHeight(40);
            modifierTache.setPrefWidth(140);
            modifierTache.setStyle(
                    "-fx-background-color: #6a82ab; -fx-text-fill: white;-fx-background-radius:13px;-fx-border-radius:13px;-fx-border-color: black; -fx-border-width: 1px;-fx-padding: 15px;-fx-opacity:0.5;");
            modifierTache.setFont(Font.font("Arial", FontWeight.BOLD, 15.0));

            ClonerTache.setPrefHeight(40);
            ClonerTache.setPrefWidth(100);
            ClonerTache.setStyle(
                    "-fx-background-color: #6a82ab; -fx-text-fill: white;-fx-background-radius:13px;-fx-border-radius:13px;-fx-border-color: black; -fx-border-width: 1px;-fx-padding: 15px;-fx-opacity:0.5;");
            ClonerTache.setFont(Font.font("Arial", FontWeight.BOLD, 15.0));

            hbox.setSpacing(15);

            LabelTache.setOnMouseClicked(event -> {
                openTache(idTache, idProj);
            });

            supprimerTache.setOnMouseClicked(event -> {
                supprimerTacheProjet(idProj, idTache);
            });

            modifierTache.setOnMouseClicked(event -> {
                modifierTache(idProj, idTache);
            });

            ClonerTache.setOnMouseClicked(event -> {
                try {
                    model.clonerTache(idTache,idProj);
                    TachesProjet AjouterPage = new TachesProjet(idProj, stage);
                    Scene projectsScene = new Scene(AjouterPage, 1300, 800);
                    stage.setScene(projectsScene);
                    stage.setTitle("ProManager");
                    stage.setResizable(false);
                    stage.setMinWidth(1300);
                    stage.setMinHeight(800);
                    stage.show();
                } catch (ProjetExeption e) {
                    e.printStackTrace();
                }
            });

            hbox.getChildren().addAll(LabelTache, supprimerTache, modifierTache, ClonerTache);
            tacheListe.getChildren().add(hbox);
            
        }
    }
}