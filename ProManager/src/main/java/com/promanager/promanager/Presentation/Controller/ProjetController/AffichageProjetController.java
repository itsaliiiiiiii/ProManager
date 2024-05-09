package com.promanager.promanager.Presentation.Controller.ProjetController;

import java.text.SimpleDateFormat;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Presentation.Model.ProjetModel.AffichageProjetModel;
import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.ModifierProjet;
import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;
import com.promanager.promanager.Presentation.View.ProjetView.Documents.AffichageDocuments;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageProjetController {
    private ObjectId idProjet;
    private Text nomProjetText;
    private Text categorieText;
    private Text typeText;
    private Text dateDepartText;
    private TextFlow textFlow;
    private Text dateFinText;
    private Button modifierButton;
    private Button clonerButton;
    private Button cloturerButton;
    private Button PrecedentButton;
    private Button documentsButton;
    private Button seancesButton;
    private Button tachesButton;
    private gestionProjet gProj;

    private Text nomProjet;
    private Text categorie;
    private Text type;
    private Text dateDepart;
    private Label desc;
    private Text dateFin;
    AffichageProjetModel model;

    Stage stage;

    public AffichageProjetController(AffichageProjet view, Stage stage, ObjectId id) {
        this.idProjet = id;
        this.nomProjetText = view.getNomProjet();
        this.categorieText = view.getCategorie();
        this.typeText = view.getType();
        this.textFlow = view.getTextFlow();
        this.dateDepartText = view.getDateDepart();
        this.dateFinText = view.getDateFin();
        this.modifierButton = view.getModifierButton();
        this.clonerButton = view.getClonerButton();
        this.cloturerButton = view.getCloturerButton();
        this.PrecedentButton = view.getPrecedentButton();
        this.documentsButton = view.getDocumentsButton();
        this.seancesButton = view.getSeancesButton();
        this.tachesButton = view.getTachesButton();
        this.gProj = new gestionProjet();

        nomProjet = view.getNomProjet();
        categorie = view.getCategorie();
        type = view.getType();
        dateDepart = view.getDateDepart();
        dateFin = view.getDateFin();
        desc = view.getDesc();

        model = new AffichageProjetModel();

        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            openProjet();
        });

        documentsButton.setOnAction(event -> {
            openDoc();
        });

        tachesButton.setOnAction(event -> {
            openTachesProjet();
        });

        seancesButton.setOnAction(event -> {
            openSeancesProjet();
        });

        clonerButton.setOnAction(event -> {
            ClonerProjet();
        });

        cloturerButton.setOnAction(event -> {
            CloturerProjet();
        });

        modifierButton.setOnAction(event -> {
            openModifierProjet();
        });

        fillData();
    }

    private void fillData() {
        Projet Projet = model.getProjet(idProjet);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        nomProjet.setText("Nom Projet : " + Projet.getNomProjet());
        categorie.setText("Categorie : " + Projet.getCategorieProjet());
        type.setText("Type : " + Projet.getTypeProjet());
        desc = new Label(Projet.getDescriptionProjet());
        dateDepart.setText("Date Depart : " + sdf.format(Projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(Projet.getDateFinProjet()));
    }

    private void openProjet() {
        ProjetsPage projetsPage = new ProjetsPage(stage);
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void openSeancesProjet() {
        SeancesProjet projetsPage = new SeancesProjet(idProjet, stage);
        Scene projectsScene = new Scene(projetsPage, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void openTachesProjet() {
        TachesProjet tachesProjet = new TachesProjet(idProjet, stage);
        Parent projetsRoot = tachesProjet;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void openDoc() {
        AffichageDocuments tachesProjet = new AffichageDocuments(idProjet, stage);
        Parent projetsRoot = tachesProjet;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void openModifierProjet() {
        ModifierProjet modifier = new ModifierProjet(idProjet, stage);
        Parent projetsRoot = modifier;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void ClonerProjet() {
        Stage stage = new Stage();
        Label message = new Label(
                "Cloner Projet ?");
        message.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;-fx-text-fill: #6a82ab;");

        Button ClonerButton = new Button("Cloner");
        Button AnnuleButton = new Button("Annulé");
        ClonerButton.setOnAction(
                event -> {
                    model.Cloner(idProjet);
                    stage.close();
                });
        AnnuleButton.setOnAction(
                event -> {
                    stage.close();
                });
        ClonerButton.setPrefWidth(150.0);
        ClonerButton.setPrefHeight(40.0);
        ClonerButton.setFont(new Font(18.0));
        ClonerButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");

        AnnuleButton.setPrefWidth(150.0);
        AnnuleButton.setPrefHeight(40.0);
        AnnuleButton.setFont(new Font(18.0));
        AnnuleButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");

        VBox root = new VBox(20);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(message, ClonerButton, AnnuleButton);
        Scene error = new Scene(root, 400, 200);
        root.setStyle("-fx-background-color: #f0f0f0; -fx-alignment: center;");
        stage.setScene(error);
        stage.setResizable(false);
        stage.setTitle("Cloner Projet");
        stage.show();
    }

    private void CloturerProjet() {
        Stage stage = new Stage();
        Label message = new Label(
                "Cloturer Projet ?");
                
        message.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;-fx-text-fill: #6a82ab;");

        Button CloturerButton = new Button("Cloturer");
        Button AnnuleButton = new Button("Annulé");
        CloturerButton.setOnAction(
                event -> {
                    model.Cloturer(idProjet);
                    stage.close();
                    openProjet();
                });
        AnnuleButton.setOnAction(
                event -> {
                    stage.close();
                });
        CloturerButton.setPrefWidth(150.0);
        CloturerButton.setPrefHeight(40.0);
        CloturerButton.setFont(new Font(18.0));
        CloturerButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");

        AnnuleButton.setPrefWidth(150.0);
        AnnuleButton.setPrefHeight(40.0);
        AnnuleButton.setFont(new Font(18.0));
        AnnuleButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");

        VBox root = new VBox(20);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(message, CloturerButton, AnnuleButton);
        Scene error = new Scene(root, 400, 200);
        root.setStyle("-fx-background-color: #f0f0f0; -fx-alignment: center;");
        stage.setScene(error);
        stage.setResizable(false);
        stage.setTitle("Cloturer Projet");
        stage.show();
    }
}