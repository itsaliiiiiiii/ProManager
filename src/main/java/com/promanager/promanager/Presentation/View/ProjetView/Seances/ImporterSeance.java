package com.promanager.promanager.Presentation.View.ProjetView.Seances;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Metier.Service.GoogleCalendarAuth;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.Controller.ProjetController.Seances.ImporterSeanceController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
public class ImporterSeance extends AnchorPane {
    private Button addFromGoogleCalendarButton;
    private ListView<String> calendarEventListView;
    private Stage stage;
    private ImporterSeanceController controller;
    private Button AjouterButton;
    private Button AnnulerButton;
    private ObjectId idProjet;
    private ComboBox<String> comboBoxCategorie;
    private Text Categorie;
    private DAOconfiguration config;

    public ImporterSeance(Stage stage, ObjectId id) {
        this.addFromGoogleCalendarButton = new Button("Ajouter Google Calendar");
        this.calendarEventListView = new ListView<>();
        this.stage = stage;
        this.idProjet = id;
        this.AjouterButton = new Button("Ajouter");
        this.AnnulerButton = new Button("Annuler");
        Categorie = new Text("Categorie : ");
        comboBoxCategorie = new ComboBox<>();
        this.controller = new ImporterSeanceController(this, stage,idProjet);
        design();
    }

    public Button getAddFromGoogleCalendarButton() {
        return addFromGoogleCalendarButton;
    }

    public ListView<String> getCalendarEventListView() {
        return calendarEventListView;
    }

    public ImporterSeanceController getController() {
        return controller;
    }

    public Button getAjouterButton() {
        return AjouterButton;
    }

    public Button getAnnulerButton() {
        return AnnulerButton;
    }

    public ComboBox<String> getComboBoxCategorie() {
        return comboBoxCategorie;
    }

    public Text getCategorie() {
        return Categorie;
    }

    void design() {
        addFromGoogleCalendarButton.setLayoutX(200);
        addFromGoogleCalendarButton.setLayoutY(300);
        addFromGoogleCalendarButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        addFromGoogleCalendarButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");

        AjouterButton.setLayoutX(1020);
        AjouterButton.setLayoutY(650);
        AjouterButton.setPrefWidth(150.0);
        AjouterButton.setPrefHeight(40.0);
        AjouterButton.setFont(new Font(18.0));
        AjouterButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        AjouterButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        AnnulerButton.setLayoutX(100);
        AnnulerButton.setLayoutY(650);
        AnnulerButton.setPrefWidth(150.0);
        AnnulerButton.setPrefHeight(40.0);
        AnnulerButton.setFont(new Font(18.0));
        AnnulerButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        AnnulerButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        VBox root = new VBox(10);
        root.setLayoutX(300);
        root.setLayoutY(160);
        root.setPrefWidth(750);
        root.setPrefHeight(400);
        calendarEventListView.setStyle("-fx-font-size: 20px;");

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(this.addFromGoogleCalendarButton, this.calendarEventListView);
        this.getChildren().addAll(root, AjouterButton, AnnulerButton);
    }

}
