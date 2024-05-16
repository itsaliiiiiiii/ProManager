package com.promanager.promanager.Presentation.View.ProjetView.Documents;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.bson.types.ObjectId;
import java.io.File;
import java.io.IOException;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Persistance.DAOprojet;
import com.promanager.promanager.Presentation.Controller.ProjetController.Documents.AffichageDocumentsController;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageDocuments extends AnchorPane {
    private Stage stage;
    private Text textT;
    private Button PrecedentButton;
    private AffichageDocumentsController controller;
    private ScrollPane scrollPane;
    private VBox documentListe;
    private Button AjouterButton;
    private Text description;
    private Text dateFin;
    private TextField rechercheInput;
    private Button rechercheButton;
    private Text dateDepart;
    private Label textDocuments;

    public AffichageDocuments(ObjectId idProjet, Stage stage) {
        this.stage = stage;
        textT = new Text("Documents :");
        PrecedentButton = new Button("Precedent");
        AjouterButton = new Button("Ajouter");
        dateDepart = new Text("Date Depart");
        dateFin = new Text("Date Depart");
        documentListe = new VBox(10);
        textDocuments = new Label("~ Liste Documents :");
        description = new Text();
        rechercheInput = new TextField();
        rechercheButton = new Button("Rechercher");
        this.controller = new AffichageDocumentsController(this, stage, idProjet);

        design();
    }

    public Button getPrecedentButton() {
        return PrecedentButton;
    }

    public Button getAjouterButton() {
        return AjouterButton;
    }
    public TextField getRechercheInput() {
        return rechercheInput;
    }
    public Button getRechercheButton() {
        return rechercheButton;
    }

    public Text getDescription() {
        return description;
    }

    public VBox getDocumentListe() {
        return documentListe;
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


        rechercheInput.setPrefWidth(100);
        rechercheInput.setPrefWidth(150.0);
        rechercheInput.setLayoutY(350.0);
        rechercheInput.setLayoutX(780);
        rechercheInput.setStyle("-fx-border-color: #6a82ab; -fx-border-radius: 5; -fx-background-radius: 5;");
        
        rechercheButton.setLayoutX(944);
        rechercheButton.setLayoutY(350.0);
        rechercheButton.setStyle("-fx-background-color: #6a82ab;");
        rechercheButton.setTextFill(javafx.scene.paint.Color.WHITE);

        scrollPane = new ScrollPane();
        scrollPane.setLayoutX(50.0);
        scrollPane.setLayoutY(420.0);
        scrollPane.setPrefWidth(1230);
        scrollPane.setPrefHeight(350);
        scrollPane.setStyle(" -fx-selection-bar: #6a82ab;fx-border-color: transparent;-fx-background-color: inherit;");

        scrollPane.setContent(documentListe);
        getChildren().addAll(textT, PrecedentButton, dateDepart, dateFin, scrollPane, textDocuments,
                rechercheInput, rechercheButton,AjouterButton, description);
    }
}