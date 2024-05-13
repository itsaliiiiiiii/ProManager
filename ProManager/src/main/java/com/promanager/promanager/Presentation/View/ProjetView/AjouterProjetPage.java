package com.promanager.promanager.Presentation.View.ProjetView;

import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.Controller.ProjetController.AjouterProjetController;

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
@SuppressWarnings("unused")
public class AjouterProjetPage extends AnchorPane {
    private Text AjouterProjet;
    private Text NomProjet;
    private Text Type;
    private Text Categorie;
    private Text Description;
    private Text DateDepart;
    private Text DateFin;
    private TextField InputNomProjet;
    private TextArea InputDescription;
    private ComboBox<String> comboBoxType;
    private ComboBox<String> comboBoxCategorie;
    private Button buttonAnnuler;
    private Button buttonAjouter;
    private DatePicker PickerDateDepart;
    private DatePicker PickerDateFin;
    private Stage stage;
    private AjouterProjetController controller;

    private DAOconfiguration config;

    public Text getAjouterProjet() {
        return AjouterProjet;
    }

    public Text getNomProjet() {
        return NomProjet;
    }

    public Text getType() {
        return Type;
    }

    public Text getCategorie() {
        return Categorie;
    }

    public Text getDescription() {
        return Description;
    }

    public Text getDateDepart() {
        return DateDepart;
    }

    public Text getDateFin() {
        return DateFin;
    }

    public TextField getInputNomProjet() {
        return InputNomProjet;
    }

    public TextArea getInputDescription() {
        return InputDescription;
    }

    public ComboBox<String> getComboBoxType() {
        return comboBoxType;
    }

    public ComboBox<String> getComboBoxCategorie() {
        return comboBoxCategorie;
    }

    public Button getButtonAnnuler() {
        return buttonAnnuler;
    }

    public Button getButtonAjouter() {
        return buttonAjouter;
    }

    public DatePicker getPickerDateDepart() {
        return PickerDateDepart;
    }

    public DatePicker getPickerDateFin() {
        return PickerDateFin;
    }

    public AjouterProjetPage(Stage stage) {
        AjouterProjet = new Text("Ajouter Projet");
        NomProjet = new Text("Nom Projet");
        InputNomProjet = new TextField();
        Type = new Text("Type");
        Categorie = new Text("Categorie");
        comboBoxCategorie = new ComboBox<>();
        InputDescription = new TextArea();
        Description = new Text("Description");
        PickerDateFin = new DatePicker();
        DateFin = new Text("Date Fin");
        DateDepart = new Text("Date Depart");
        comboBoxType = new ComboBox<>();
        buttonAjouter = new Button("Ajouter");
        PickerDateDepart = new DatePicker();
        buttonAnnuler = new Button("Annulé");
        this.stage = stage;
        this.controller = new AjouterProjetController(this, stage);
        this.design();
    }

    private void design() {
        AjouterProjet.setLayoutX(470.0);
        AjouterProjet.setLayoutY(100.0);
        AjouterProjet.setFont(Font.font("Arial", FontWeight.BOLD, 48.0));
        AjouterProjet.setFill(Color.web("#6a82ab"));
        AjouterProjet.setText("Ajouter un Projet");

        NomProjet.setLayoutX(300.0);
        NomProjet.setLayoutY(190.0);
        NomProjet.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        NomProjet.setFill(Color.web("#6a82ab"));
        NomProjet.setText("Nom du Projet");

        InputNomProjet.setLayoutX(300.0);
        InputNomProjet.setLayoutY(200.0);
        InputNomProjet.setPrefWidth(400.0);
        InputNomProjet.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");
        InputNomProjet.setFont(Font.font("Arial", 18.0));

        Type.setLayoutX(300.0);
        Type.setLayoutY(280.0);
        Type.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Type.setFill(Color.web("#6a82ab"));
        Type.setText("Type");

        comboBoxType.setLayoutX(300.0);
        comboBoxType.setLayoutY(290.0);
        comboBoxType.setPrefWidth(400.0);
        comboBoxType.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");

        Categorie.setLayoutX(300.0);
        Categorie.setLayoutY(370.0);
        Categorie.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Categorie.setFill(Color.web("#6a82ab"));
        Categorie.setText("Catégorie");

        comboBoxCategorie.setLayoutX(300.0);
        comboBoxCategorie.setLayoutY(380.0);
        comboBoxCategorie.setPrefWidth(400.0);
        comboBoxCategorie.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");

        Description.setLayoutX(300.0);
        Description.setLayoutY(460.0);
        Description.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Description.setFill(Color.web("#6a82ab"));
        Description.setText("Description");

        InputDescription.setLayoutX(300.0);
        InputDescription.setLayoutY(470.0);
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
        DateFin.setLayoutY(270.0);
        DateFin.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        DateFin.setFill(Color.web("#6a82ab"));
        DateFin.setText("Date de Fin");

        PickerDateFin.setLayoutX(800.0);
        PickerDateFin.setLayoutY(280.0);
        PickerDateFin.setPrefWidth(200.0);

        buttonAjouter.setLayoutX(800.0);
        buttonAjouter.setLayoutY(480.0);
        buttonAjouter.setPrefWidth(150.0);
        buttonAjouter.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        buttonAjouter.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        buttonAjouter.setText("Ajouter");

        buttonAnnuler.setLayoutX(800.0);
        buttonAnnuler.setLayoutY(530.0);
        buttonAnnuler.setPrefWidth(150.0);
        buttonAnnuler.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        buttonAnnuler.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        buttonAnnuler.setText("Annuler");

        this.config = new DAOconfiguration();
        config.getCategorie();
        comboBoxCategorie.getItems().addAll(config.getCategorie());
        comboBoxType.getItems().addAll(config.getType());

        getChildren().addAll(AjouterProjet, NomProjet, InputNomProjet, Type,
                comboBoxType, Categorie,
                comboBoxCategorie, Description, InputDescription, DateDepart,
                PickerDateDepart, DateFin,
                PickerDateFin, buttonAjouter, buttonAnnuler);
    }

}
