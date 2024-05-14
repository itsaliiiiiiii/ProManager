package com.promanager.promanager.Presentation.View.HistoriqueView.Documents;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.promanager.promanager.Presentation.Controller.HistoriqueController.Documents.AffichageDocumentsHistoriqueController;
import org.bson.types.ObjectId;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Persistance.DAOprojet;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageDocumentsHistorique extends AnchorPane {
    private ObjectId idProjet;
    private Stage stage;
    private Text textT;
    private Text description;
    private Button PrecedentButton;
    private AffichageDocumentsHistoriqueController controller;
    private ScrollPane scrollPane;
    private VBox documentListe;

    private Document_ document;
    private Projet projet;
    private Text dateFin;
    private Text dateDepart;
    private Label textDocuments;

    private String elemDocument;
    private ArrayList<ObjectId> idsDocuments;

    public AffichageDocumentsHistorique(ObjectId idProjet, Stage stage) {
        this.idProjet = idProjet;
        this.stage = stage;
        textT = new Text("Documents :");
        PrecedentButton = new Button("Precedent");
        dateDepart = new Text("Date Depart");
        dateFin = new Text("Date Depart");
        idsDocuments = new ArrayList<>();
        textDocuments = new Label("~ Liste Documents :");
        description = new Text();
        documentListe = new VBox();
        this.controller = new AffichageDocumentsHistoriqueController(this, stage, idProjet);
        design();
    }

    public Button getPrecedentButton() {
        return PrecedentButton;
    }

    public VBox getDocumentListe() {
        return documentListe;
    }
    public Text getDescription() {
        return description;
    }

    public Text getDateFin() {
        return dateFin;
    }

    public Text getDateDepart() {
        return dateDepart;
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

        
        scrollPane.setContent(documentListe);
        getChildren().addAll(textT, PrecedentButton, dateDepart, dateFin, scrollPane, textDocuments,
                description);
    }

    
}