package com.promanager.promanager.Presentation.View.ProjetView.Taches;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionListe;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Liste;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.Controller.ProjetController.Taches.AjouterTacheProjetController;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("unused")
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
    private AjouterTacheProjetController controller;
    private DAOconfiguration config;
    private VBox mainVBox;

    public AjouterTacheProjet(ObjectId idProj, Stage stage) {
        this.stage = stage;
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
        
        config = new DAOconfiguration();
        mainVBox = new VBox();
        controller = new AjouterTacheProjetController(this, stage, idProj);
        design();
    }

    public Button getButtonAnnuler() {
        return buttonAnnuler;
    }

    public String getProj() {
        return Proj;
    }

    public void setProj(String proj) {
        Proj = proj;
    }

    public Button getButtonAjouter() {
        return buttonAjouter;
    }

    public TextArea getInputDescription() {
        return InputDescription;
    }

    public DatePicker getPickerDateDepart() {
        return PickerDateDepart;
    }

    public DatePicker getPickerDateFin() {
        return PickerDateFin;
    }

    public VBox getMainVBox() {
        return mainVBox;
    }

    public ComboBox<String> getComboBoxCategorie() {
        return comboBoxCategorie;
    }

    private void design() {
        AjouterTache.setLayoutX(470.0);
        AjouterTache.setLayoutY(70.0);
        AjouterTache.setFont(Font.font("Arial", FontWeight.BOLD, 48.0));
        AjouterTache.setFill(Color.web("#6a82ab"));
        AjouterTache.setText("Ajouter une Tache");

        NomProjet.setLayoutX(300.0);
        NomProjet.setLayoutY(140.0);
        NomProjet.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));
        NomProjet.setFill(Color.web("#6a82ab"));
        NomProjet.setText("Projet : " + Proj);

        Categorie.setLayoutX(300.0);
        Categorie.setLayoutY(200.0);
        Categorie.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Categorie.setFill(Color.web("#6a82ab"));
        Categorie.setText("Catégorie");

        comboBoxCategorie.setLayoutX(300.0);
        comboBoxCategorie.setLayoutY(220.0);
        comboBoxCategorie.setPrefWidth(400.0);
        comboBoxCategorie.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");

        Description.setLayoutX(300.0);
        Description.setLayoutY(290.0);
        Description.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Description.setFill(Color.web("#6a82ab"));
        Description.setText("Description");

        InputDescription.setLayoutX(300.0);
        InputDescription.setLayoutY(310.0);
        InputDescription.setPrefWidth(400.0);
        InputDescription.setPrefHeight(100.0);
        InputDescription.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");
        InputDescription.setFont(Font.font("Arial", 18.0));

        DateDepart.setLayoutX(800.0);
        DateDepart.setLayoutY(190.0);
        DateDepart.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        DateDepart.setFill(Color.web("#6a82ab"));
        DateDepart.setText("Date de Début");

        PickerDateDepart.setLayoutX(800.0);
        PickerDateDepart.setLayoutY(200.0);
        PickerDateDepart.setPrefWidth(200.0);

        DateFin.setLayoutX(800.0);
        DateFin.setLayoutY(250.0);
        DateFin.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        DateFin.setFill(Color.web("#6a82ab"));
        DateFin.setText("Date de Fin");

        PickerDateFin.setLayoutX(800.0);
        PickerDateFin.setLayoutY(260.0);
        PickerDateFin.setPrefWidth(200.0);

        buttonAjouter.setLayoutX(800.0);
        buttonAjouter.setLayoutY(320.0);
        buttonAjouter.setPrefWidth(150.0);
        buttonAjouter.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        buttonAjouter.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        buttonAjouter.setText("Ajouter");

        buttonAnnuler.setLayoutX(800.0);
        buttonAnnuler.setLayoutY(370.0);
        buttonAnnuler.setPrefWidth(150.0);
        buttonAnnuler.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        buttonAnnuler.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        buttonAnnuler.setText("Annuler");

        this.config = new DAOconfiguration();
        config.getCategorie();
        comboBoxCategorie.getItems().addAll(config.getCategorie());

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(150.0);
        scrollPane.setLayoutY(450.0);
        scrollPane.setPrefWidth(1150);
        scrollPane.setPrefHeight(320);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        scrollPane.setStyle(
                "-fx-selection-bar: #6a82ab; -fx-background-color: transparent; -fx-border-color: transparent;");

        mainVBox.setSpacing(30);

        scrollPane.setContent(mainVBox);

        getChildren().addAll(AjouterTache, NomProjet, Categorie,
                comboBoxCategorie, Description, InputDescription, DateDepart,
                PickerDateDepart, DateFin,
                PickerDateFin, buttonAjouter, buttonAnnuler, scrollPane);
    }
}