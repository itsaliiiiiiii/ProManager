package com.promanager.promanager.Presentation.View;

import com.promanager.promanager.Presentation.Controller.AjouterProjetController;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    AjouterProjetController controller;

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

        this.controller = new AjouterProjetController(this, stage);

        this.design();
    }

    private void design() {
        AjouterProjet = new Text("Ajouter Projet");
        AjouterProjet.setLayoutX(517.0);
        AjouterProjet.setLayoutY(126.0);
        AjouterProjet.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        AjouterProjet.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        AjouterProjet.setStrokeWidth(0.0);
        AjouterProjet.setFont(Font.font("System Bold", 48.0));

        NomProjet = new Text("Nom Projet");
        NomProjet.setLayoutX(266.0);
        NomProjet.setLayoutY(226.0);
        NomProjet.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        NomProjet.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        NomProjet.setStrokeWidth(0.0);
        NomProjet.setFont(Font.font(32.0));

        InputNomProjet = new TextField();
        InputNomProjet.setLayoutX(264.0);
        InputNomProjet.setLayoutY(243.0);
        InputNomProjet.setPrefHeight(40.0);
        InputNomProjet.setPrefWidth(283.0);
        this.InputNomProjet.setStyle(
                "-fx-background-color:#f4f4f4; -fx-border-radius:9px; -fx-background-radius:9px; -fx-border-color:#546379; -fx-border-width:2px;");

        Type = new Text("Type");
        Type.setLayoutX(264.0);
        Type.setLayoutY(372.0);
        Type.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        Type.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        Type.setStrokeWidth(0.0);
        Type.setFont(Font.font(32.0));

        comboBoxType = new ComboBox<>();
        comboBoxType.setLayoutX(267.0);
        comboBoxType.setLayoutY(391.0);
        comboBoxType.setPrefHeight(41.0);
        comboBoxType.setPrefWidth(277.0);
        comboBoxType.setStyle("-fx-background-color: #fff;");

        Categorie = new Text("Categorie");
        Categorie.setLayoutX(264.0);
        Categorie.setLayoutY(462.0);
        Categorie.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        Categorie.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        Categorie.setStrokeWidth(0.0);
        Categorie.setFont(Font.font(32.0));

        comboBoxCategorie = new ComboBox<>();
        comboBoxCategorie.setLayoutX(267.0);
        comboBoxCategorie.setLayoutY(491.0);
        comboBoxCategorie.setPrefHeight(41.0);
        comboBoxCategorie.setPrefWidth(277.0);

        InputDescription = new TextArea();
        InputDescription.setLayoutX(924.0);
        InputDescription.setLayoutY(464.0);
        InputDescription.setPrefHeight(200.0);
        InputDescription.setPrefWidth(282.0);
        this.InputDescription.setStyle(
                "-fx-background-color:#f4f4f4; -fx-border-radius:9px; -fx-background-radius:9px; -fx-border-color:#546379; -fx-border-width:2px;");

        Description = new Text("Description");
        Description.setLayoutX(924.0);
        Description.setLayoutY(407.0);
        Description.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        Description.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        Description.setStrokeWidth(0.0);
        Description.setFont(Font.font(32.0));

        PickerDateFin = new DatePicker();
        PickerDateFin.setLayoutX(928.0);
        PickerDateFin.setLayoutY(330.0);
        PickerDateFin.setPrefHeight(40.0);
        PickerDateFin.setPrefWidth(245.0);

        DateFin = new Text("Date Fin");
        DateFin.setLayoutX(932.0);
        DateFin.setLayoutY(312.0);
        DateFin.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        DateFin.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        DateFin.setStrokeWidth(0.0);
        DateFin.setFont(Font.font(32.0));

        PickerDateDepart = new DatePicker();
        PickerDateDepart.setLayoutX(925.0);
        PickerDateDepart.setLayoutY(225.0);
        PickerDateDepart.setPrefHeight(40.0);
        PickerDateDepart.setPrefWidth(245.0);

        DateDepart = new Text("Date Depart");
        DateDepart.setLayoutX(929.0);
        DateDepart.setLayoutY(207.0);
        DateDepart.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        DateDepart.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        DateDepart.setStrokeWidth(0.0);
        DateDepart.setFont(Font.font(32.0));

        buttonAjouter = new Button("Ajouter");
        buttonAjouter.setLayoutX(986.0);
        buttonAjouter.setLayoutY(687.0);
        buttonAjouter.setMnemonicParsing(false);
        buttonAjouter.setPrefHeight(56.0);
        buttonAjouter.setPrefWidth(162.0);
        buttonAjouter.setFont(Font.font(25.0));

        buttonAnnuler = new Button("Annulé");
        buttonAnnuler.setLayoutX(293.0);
        buttonAnnuler.setLayoutY(685.0);
        buttonAnnuler.setMnemonicParsing(false);
        buttonAnnuler.setPrefHeight(56.0);
        buttonAnnuler.setPrefWidth(162.0);
        buttonAnnuler.setFont(Font.font(25.0));

        getChildren().addAll(AjouterProjet, NomProjet, InputNomProjet, Type, comboBoxType, Categorie,
                comboBoxCategorie, Description, InputDescription, PickerDateFin, DateFin,
                PickerDateDepart, DateDepart, buttonAjouter, buttonAnnuler);
    }
}
