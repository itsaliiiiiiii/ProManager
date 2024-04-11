package com.promanager.promanager.Presentation.View.ProjetView.Taches;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Persistance.DAOtache;
import com.promanager.promanager.Presentation.Controller.ProjetController.Taches.AffichageTacheController;
import com.promanager.promanager.Presentation.Controller.ProjetController.Taches.TachesProjetController;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageTaches extends AnchorPane {
    private ObjectId idTache;
    private Stage stage;
    private Text textT;
    private Text description;
    private Button PrecedentButton;
    private AffichageTacheController controller;
    private Text categorie;
    private Text dateFin;
    private Text dateDepart;
    private ScrollPane scrollPane;
    private VBox documentListe;
    private Tache Tache;
    private Button AjouterButton;
    private Document_ document_;
    private DAOtache gTache;
    private gestionDocument gDocument;
    Label textDocuments;

    private String elemDocument;
    private ArrayList<ObjectId> idsDocuments;

    public AffichageTaches(ObjectId idTache, ObjectId idProjet, Stage stage) {
        this.idTache = idTache;
        this.stage = stage;
        textT = new Text("Tache :");
        PrecedentButton = new Button("Precedent");
        this.controller = new AffichageTacheController(this, stage, idTache, idProjet);
        gDocument = new gestionDocument();
        categorie = new Text("Categorie");
        dateDepart = new Text("Date Depart");
        dateFin = new Text("Date Depart");
        AjouterButton = new Button("Ajouter");
        idsDocuments = new ArrayList<>();
        textDocuments = new Label("~ Liste Documents :");
        gTache = new DAOtache();
        description = new Text();
        design();
    }

    public Button getPrecedentButton() {
        return PrecedentButton;
    }

    private void design() {
        textT.setFill(javafx.scene.paint.Color.valueOf("#6a82ab"));
        textT.setLayoutX(50.0);
        textT.setLayoutY(90.0);
        textT.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

        categorie.setLayoutX(50.0);
        categorie.setLayoutY(140.0);
        categorie.setFont(new Font(20.0));

        description.setLayoutX(50.0);
        description.setLayoutY(300.0);
        description.setFont(new Font(20.0));

        dateDepart.setLayoutX(50.0);
        dateDepart.setLayoutY(190.0);
        dateDepart.setFont(new Font(20.0));

        dateFin.setLayoutX(50.0);
        dateFin.setLayoutY(250.0);
        dateFin.setFont(new Font(20.0));

        textDocuments.setStyle(" -fx-text-fill: #6a82ab;");
        textDocuments.setLayoutX(50.0);
        textDocuments.setLayoutY(340.0);
        textDocuments.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

        AjouterButton.setLayoutX(1100.0);
        AjouterButton.setLayoutY(340.0);
        AjouterButton.setPrefWidth(150.0);
        AjouterButton.setPrefHeight(40.0);
        AjouterButton.setFont(new Font(18.0));
        AjouterButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        AjouterButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        PrecedentButton.setLayoutX(1100.0);
        PrecedentButton.setLayoutY(50.0);
        PrecedentButton.setPrefWidth(150.0);
        PrecedentButton.setPrefHeight(40.0);
        PrecedentButton.setFont(new Font(18.0));
        PrecedentButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        PrecedentButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        scrollPane = new ScrollPane();
        scrollPane.setLayoutX(50.0);
        scrollPane.setLayoutY(420.0);
        scrollPane.setPrefWidth(1230);
        scrollPane.setPrefHeight(350);
        scrollPane.setStyle(" -fx-selection-bar: #6a82ab;fx-border-color: transparent;-fx-background-color: inherit;");
        documentListe = new VBox(10);

        Tache = gTache.get(idTache);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        categorie.setText("Categorie : " + Tache.getCategorieTache());
        dateDepart.setText("Date Depart : " + sdf.format(Tache.getDateDepartTache()));
        dateFin.setText("Date Fin : " + sdf.format(Tache.getDateFinTache()));
        description.setText(Tache.getDescriptionTache());

        idsDocuments = Tache.getListeDocument();
        if (idsDocuments != null) {
            for (ObjectId idDoc : idsDocuments) {
                document_ = gDocument.get(idDoc);

                String[] pathDoc = (document_.getPathDocument()).split("/");
                elemDocument = "Description : " + document_.getDescriptionDocument() + " - Nom : "
                        + pathDoc[pathDoc.length - 1];

                Label LabelDocument_ = new Label(elemDocument);
                LabelDocument_.setFont(Font.font(25));
                LabelDocument_.setPrefHeight(60);
                LabelDocument_.setPrefWidth(1200);
                LabelDocument_.setStyle(
                        "-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: #6a82ab;-fx-opacity:0.5;-fx-text-fill: #FFF;-fx-padding: 20px;-fx-background-radius:20px;-fx-border-radius:20px;");

                LabelDocument_.setOnMouseClicked(event -> {
                    // controller.openDocument_(idDoc, idProjet);
                });
                documentListe.getChildren().add(LabelDocument_);
            }
        }
        scrollPane.setContent(documentListe);
        getChildren().addAll(textT, PrecedentButton, categorie, dateDepart, dateFin, scrollPane, textDocuments,
                AjouterButton, description);
    }
}