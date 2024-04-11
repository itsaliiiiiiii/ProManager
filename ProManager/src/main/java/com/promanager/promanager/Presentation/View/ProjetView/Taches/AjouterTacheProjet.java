package com.promanager.promanager.Presentation.View.ProjetView.Taches;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.Controller.ProjetController.Taches.AjouterTacheProjetController;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AjouterTacheProjet extends AnchorPane {
    private Text AjouterTache;
    private Text NomProjet;
    private Text Categorie;
    private Text Description;
    private Text DateDepart;
    private Text DateFin;
    private TextArea InputDescription;
    private ComboBox<String> comboBoxCategorie;
    private Button buttonAnnuler;
    private Button buttonAjouter;
    private DatePicker PickerDateDepart;
    private DatePicker PickerDateFin;
    private Stage stage;
    private String Proj;
    private gestionProjet gProj;
    AjouterTacheProjetController controller;
    private DAOconfiguration config;

    public AjouterTacheProjet(ObjectId idProj) {
        AjouterTache = new Text("Ajouter Tache");
        NomProjet = new Text("Nom Projet");
        Categorie = new Text("Categorie");
        comboBoxCategorie = new ComboBox<>();
        InputDescription = new TextArea();
        Description = new Text("Description");
        PickerDateFin = new DatePicker();
        DateFin = new Text("Date Fin");
        DateDepart = new Text("Date Depart");
        buttonAjouter = new Button("Ajouter");
        PickerDateDepart = new DatePicker();
        buttonAnnuler = new Button("Annulé");
        gProj = new gestionProjet();
        this.Proj = gProj.get(idProj).getNomProjet();
        config = new DAOconfiguration();
        controller = new AjouterTacheProjetController(this);
        design();
    }

    private void design() {
        AjouterTache.setLayoutX(470.0);
        AjouterTache.setLayoutY(100.0);
        AjouterTache.setFont(Font.font("Arial", FontWeight.BOLD, 48.0));
        AjouterTache.setFill(Color.web("#6a82ab"));
        AjouterTache.setText("Ajouter une Tache");

        NomProjet.setLayoutX(300.0);
        NomProjet.setLayoutY(190.0);
        NomProjet.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));
        NomProjet.setFill(Color.web("#6a82ab"));
        NomProjet.setText("Projet : " + Proj);

        Categorie.setLayoutX(300.0);
        Categorie.setLayoutY(250.0);
        Categorie.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Categorie.setFill(Color.web("#6a82ab"));
        Categorie.setText("Catégorie");

        comboBoxCategorie.setLayoutX(300.0);
        comboBoxCategorie.setLayoutY(270.0);
        comboBoxCategorie.setPrefWidth(400.0);
        comboBoxCategorie.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");

        Description.setLayoutX(300.0);
        Description.setLayoutY(340.0);
        Description.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Description.setFill(Color.web("#6a82ab"));
        Description.setText("Description");

        InputDescription.setLayoutX(300.0);
        InputDescription.setLayoutY(360.0);
        InputDescription.setPrefWidth(400.0);
        InputDescription.setPrefHeight(100.0);
        InputDescription.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");
        InputDescription.setFont(Font.font("Arial", 18.0));

        DateDepart.setLayoutX(800.0);
        DateDepart.setLayoutY(240.0);
        DateDepart.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        DateDepart.setFill(Color.web("#6a82ab"));
        DateDepart.setText("Date de Début");

        PickerDateDepart.setLayoutX(800.0);
        PickerDateDepart.setLayoutY(250.0);
        PickerDateDepart.setPrefWidth(200.0);

        DateFin.setLayoutX(800.0);
        DateFin.setLayoutY(300.0);
        DateFin.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        DateFin.setFill(Color.web("#6a82ab"));
        DateFin.setText("Date de Fin");

        PickerDateFin.setLayoutX(800.0);
        PickerDateFin.setLayoutY(310.0);
        PickerDateFin.setPrefWidth(200.0);

        buttonAjouter.setLayoutX(800.0);
        buttonAjouter.setLayoutY(370.0);
        buttonAjouter.setPrefWidth(150.0);
        buttonAjouter.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        buttonAjouter.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        buttonAjouter.setText("Ajouter");

        buttonAnnuler.setLayoutX(800.0);
        buttonAnnuler.setLayoutY(420.0);
        buttonAnnuler.setPrefWidth(150.0);
        buttonAnnuler.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        buttonAnnuler.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        buttonAnnuler.setText("Annuler");

        this.config = new DAOconfiguration();
        config.getCategorie();
        comboBoxCategorie.getItems().addAll(config.getCategorie());

        getChildren().addAll(AjouterTache, NomProjet, Categorie,
                comboBoxCategorie, Description, InputDescription, DateDepart,
                PickerDateDepart, DateFin,
                PickerDateFin, buttonAjouter, buttonAnnuler);
    }
}