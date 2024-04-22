package com.promanager.promanager.Presentation.View.ListesVIiew;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionListe;
import com.promanager.promanager.Metier.POJO.Liste;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.Controller.ListesController.AjouterTachepageController;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AjouterTachePage extends AnchorPane {
    private Text AjouterTache;
    private Text Categorie;
    private Text Nomliste;
    private Text Description;
    private Text DateDepart;
    private Text DateFin;
    private TextArea InputDescription;
    private ComboBox<String> comboBoxCategorie;
    private Button buttonAnnuler;
    private Button buttonAjouter;
    private DatePicker PickerDateDepart;
    private DatePicker PickerDateFin;
    private ToggleGroup toggleGroup;
    private RadioButton oldList;
    private RadioButton newList;
    private gestionListe gListe;
    private TextField InputNomListe;
    private TextArea InputDescriptionListe;
    private ObjectId idListe;
    private Stage stage;
    private AjouterTachepageController controller;

    private DAOconfiguration config;

    public Text getAjouterTache() {
        return AjouterTache;
    }

    public RadioButton getOldList() {
        return oldList;
    }

    public RadioButton getNewList() {
        return newList;
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

    public ToggleGroup getToggleGroup() {
        return toggleGroup;
    }

    public Text getDateFin() {
        return DateFin;
    }

    public ObjectId getIdListe() {
        return idListe;
    }

    public TextArea getInputDescription() {
        return InputDescription;
    }

    public ComboBox<String> getComboBoxCategorie() {
        return comboBoxCategorie;
    }

    public Button getButtonAnnuler() {
        return buttonAnnuler;
    }

    public void setIdListe(ObjectId idListe) {
        this.idListe = idListe;
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

    public TextField getInputNomListe() {
        return InputNomListe;
    }

    public TextArea getInputDescriptionListe() {
        return InputDescriptionListe;
    }

    public AjouterTachePage(Stage stage) {
        AjouterTache = new Text("Ajouter Tache");
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
        toggleGroup = new ToggleGroup();
        oldList = new RadioButton("Liste Existante");
        newList = new RadioButton("Nouvelle Liste");
        gListe = new gestionListe();
        Nomliste = new Text("Nom Liste");
        idListe = new ObjectId();
        InputNomListe = new TextField();
        InputDescriptionListe = new TextArea();
        this.stage = stage;
        this.controller = new AjouterTachepageController(this, stage);
        this.design();
    }

    private void design() {
        AjouterTache.setLayoutX(470.0);
        AjouterTache.setLayoutY(100.0);
        AjouterTache.setFont(Font.font("Arial", FontWeight.BOLD, 48.0));
        AjouterTache.setFill(Color.web("#6a82ab"));
        AjouterTache.setText("Ajouter un Tache");

        Categorie.setLayoutX(300.0);
        Categorie.setLayoutY(190.0);
        Categorie.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Categorie.setFill(Color.web("#6a82ab"));
        Categorie.setText("Catégorie");

        comboBoxCategorie.setLayoutX(300.0);
        comboBoxCategorie.setLayoutY(200.0);
        comboBoxCategorie.setPrefWidth(400.0);
        comboBoxCategorie.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");

        Description.setLayoutX(300.0);
        Description.setLayoutY(270.0);
        Description.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Description.setFill(Color.web("#6a82ab"));
        Description.setText("Description");

        InputDescription.setLayoutX(300.0);
        InputDescription.setLayoutY(280.0);
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
        buttonAjouter.setLayoutY(580.0);
        buttonAjouter.setPrefWidth(150.0);
        buttonAjouter.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        buttonAjouter.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        buttonAjouter.setText("Ajouter");

        buttonAnnuler.setLayoutX(800.0);
        buttonAnnuler.setLayoutY(630.0);
        buttonAnnuler.setPrefWidth(150.0);
        buttonAnnuler.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        buttonAnnuler.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        buttonAnnuler.setText("Annuler");

        Nomliste.setLayoutX(300.0);
        Nomliste.setLayoutY(430.0);
        Nomliste.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Nomliste.setFill(Color.web("#6a82ab"));
        Nomliste.setText("Liste");

        oldList.setLayoutX(300);
        oldList.setLayoutY(440);
        oldList.setFont(Font.font("Arial", 14.0));

        newList.setLayoutX(440);
        newList.setLayoutY(440);
        newList.setFont(Font.font("Arial", 14.0));

        oldList.setToggleGroup(toggleGroup);
        newList.setToggleGroup(toggleGroup);
        toggleGroup.selectToggle(oldList);

        ScrollPane scrollPane = new ScrollPane();
        Label listeSelectione = new Label();

        scrollPane.setLayoutX(300.0);
        scrollPane.setLayoutY(480.0);
        scrollPane.setPrefWidth(400.0);
        scrollPane.setPrefHeight(180.0);

        listeSelectione.setLayoutX(300.0);
        listeSelectione.setLayoutY(660.0);

        VBox documentListe = new VBox(10);
        for (Liste list : gListe.getAll()) {

            Label labelListe = new Label("Nom : " + list.getNomListe());
            labelListe.setFont(Font.font(18));
            labelListe.setPrefHeight(20);
            labelListe.setPrefWidth(380);
            labelListe.setStyle(
                    "-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: #6a82ab;-fx-opacity:0.5;-fx-text-fill: #FFF;-fx-padding: 20px;-fx-background-radius:20px;-fx-border-radius:20px;");

            labelListe.setOnMouseClicked(event -> {
                setIdListe(list.getIdListe());
                listeSelectione.setText(list.getNomListe() + " selectionné");
            });
            
            documentListe.getChildren().add(labelListe);
        }
        this.buttonAjouter.setOnAction(event -> {
            try {
                controller.AjouterTache(idListe);
                controller.openTachePage();
            } catch (ProjetExeption e) {
                e.MessageErreurAjouterProjet();
            }
        });

        scrollPane.setContent(documentListe);

        InputNomListe.setLayoutX(300.0);
        InputNomListe.setLayoutY(480.0);
        InputNomListe.setPrefWidth(400.0);
        InputNomListe.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");

        InputDescriptionListe.setLayoutX(300.0);
        InputDescriptionListe.setLayoutY(520.0);
        InputDescriptionListe.setPrefWidth(400.0);
        InputDescriptionListe.setPrefHeight(150.0);
        InputDescriptionListe
                .setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");

        this.config = new DAOconfiguration();
        config.getCategorie();
        comboBoxCategorie.getItems().addAll(config.getCategorie());

        InputNomListe.setVisible(false);
        InputDescriptionListe.setVisible(false);

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == oldList) {
                scrollPane.setVisible(true);
                listeSelectione.setVisible(true);
                InputNomListe.setVisible(false);
                InputDescriptionListe.setVisible(false);
            } else if (newValue == newList) {
                scrollPane.setVisible(false);
                listeSelectione.setVisible(false);
                InputNomListe.setVisible(true);
                InputDescriptionListe.setVisible(true);
            }
        });

        getChildren().addAll(AjouterTache, Categorie, comboBoxCategorie, Description, InputDescription, DateDepart,
                PickerDateDepart, DateFin, PickerDateFin, buttonAjouter, buttonAnnuler, oldList, newList,
                Nomliste,
                InputNomListe, InputDescriptionListe, scrollPane, listeSelectione);
    }

}
