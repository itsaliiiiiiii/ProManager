package com.promanager.promanager.Presentation.View.ProjetView.Seances;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.bson.types.ObjectId;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Persistance.DAOseance;
import com.promanager.promanager.Persistance.DAOtache;
import com.promanager.promanager.Presentation.Controller.ProjetController.Seances.AffichageSeancesController;
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
public class AffichageSeances extends AnchorPane {
    private ObjectId idSeance;
    private ObjectId idProjet;
    private Stage stage;
    private Text textT;
    private Text description;
    private Button PrecedentButton;
    private AffichageSeancesController controller;
    private Text dateFin;
    private Text dateDepart;
    private ScrollPane scrollPane;
    private VBox documentListe;
    private Seance Seance;
    private Button AjouterButton;
    private Document_ document_;
    private DAOseance gSeance;
    private gestionDocument gDocument;
    Label textDocuments;

    private String elemDocument;
    private ArrayList<ObjectId> idsDocuments;

    public AffichageSeances(ObjectId idSeance, ObjectId idProjet, Stage stage) {
        this.idSeance = idSeance;
        this.idProjet = idProjet;
        this.stage = stage;
        textT = new Text("Seance :");
        PrecedentButton = new Button("Precedent");
        gDocument = new gestionDocument();
        dateDepart = new Text("Date Depart");
        dateFin = new Text("Date Depart");
        AjouterButton = new Button("Ajouter");
        idsDocuments = new ArrayList<>();
        textDocuments = new Label("~ Liste Documents :");
        gSeance = new DAOseance();
        description = new Text();
        this.controller = new AffichageSeancesController(this, stage, idSeance, idProjet);

        design();
    }

    public Button getPrecedentButton() {
        return PrecedentButton;
    }

    public Button getAjouterButton() {
        return AjouterButton;
    }

    private void design() {
        textT.setFill(javafx.scene.paint.Color.valueOf("#6a82ab"));
        textT.setLayoutX(50.0);
        textT.setLayoutY(90.0);
        textT.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

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

        Seance = gSeance.get(idSeance);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dateDepart.setText("Date Depart : " + sdf.format(Seance.getDateDepartSeance()));
        dateFin.setText("Date Fin : " + sdf.format(Seance.getDateFinSeance()));
        description.setText(Seance.getDescriptionSeance());
        idsDocuments = Seance.getListeDocument();
        
        if (idsDocuments != null) {
            for (ObjectId idDoc : idsDocuments) {
                document_ = gDocument.get(idDoc);

                String[] pathDoc = (document_.getPathDocument()).split("/");
                elemDocument = "Description : " + document_.getDescriptionDocument() + " - Nom : "
                        + pathDoc[pathDoc.length - 1];

                Label LabelDocument_ = new Label(elemDocument);
                LabelDocument_.setFont(Font.font(25));
                LabelDocument_.setPrefHeight(60);
                LabelDocument_.setPrefWidth(900);
                LabelDocument_.setStyle(
                        "-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: #6a82ab;-fx-opacity:0.5;-fx-text-fill: #FFF;-fx-padding: 20px;-fx-background-radius:20px;-fx-border-radius:20px;");

                Button SupprimerDoc = new Button("Supprimer");

                HBox hbox = new HBox();
                SupprimerDoc.setPrefHeight(60);
                SupprimerDoc.setPrefWidth(200);
                SupprimerDoc.setStyle(
                        "-fx-background-color: #6a82ab; -fx-text-fill: white;-fx-background-radius:20px;-fx-border-radius:20px;-fx-border-color: black; -fx-border-width: 1px;-fx-padding: 20px;-fx-opacity:0.5;");
                SupprimerDoc.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

                LabelDocument_.setOnMouseClicked(event -> {
                    File file = new File(document_.getPathDocument());
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                SupprimerDoc.setOnMouseClicked(event -> {
                    controller.supprimerDocProjet(idDoc, idSeance, idProjet);
                });
                
                hbox.setSpacing(30);
                hbox.getChildren().addAll(LabelDocument_, SupprimerDoc);
                documentListe.getChildren().add(hbox);
            }
        }

        scrollPane.setContent(documentListe);
        getChildren().addAll(textT, PrecedentButton, dateDepart, dateFin, scrollPane, textDocuments,
                AjouterButton, description);
    }
}