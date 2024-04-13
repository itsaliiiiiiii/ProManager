package com.promanager.promanager.Presentation.View.ProjetView.Seances;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionListe;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Liste;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.Controller.ProjetController.Seances.AjouterSeancesProjetController;
import com.promanager.promanager.Presentation.Controller.ProjetController.Taches.AjouterTacheProjetController;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AjouterSeancesProjet extends AnchorPane {
    private Text AjouterTache;
    private Text NomProjet;
    private Text Description;
    private Text DateDepart;
    private Text NoteText;
    private Text DateFin;
    private TextArea InputDescription;
    private TextField Note;
    private Button buttonAnnuler;
    private Button buttonAjouter;
    private DatePicker PickerDateDepart;
    private DatePicker PickerDateFin;
    private Stage stage;
    private String Proj;
    private gestionProjet gProj;
    private AjouterSeancesProjetController controller;
    private DAOconfiguration config;
    private gestionSeance gSeance;

    public Button getButtonAnnuler() {
        return buttonAnnuler;
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

    public TextField getNote() {
        return Note;
    }

    public AjouterSeancesProjet(ObjectId idProj, Stage stage) {
        this.stage = stage;
        AjouterTache = new Text("Ajouter Seance");
        NomProjet = new Text("Nom Projet");
        Note = new TextField();
        NoteText = new Text();
        InputDescription = new TextArea();
        Description = new Text("Description");
        PickerDateFin = new DatePicker();
        DateFin = new Text("Date Fin");
        DateDepart = new Text("Date Depart");
        buttonAjouter = new Button("Ajouter");
        PickerDateDepart = new DatePicker();
        buttonAnnuler = new Button("Annulé");
        gProj = new gestionProjet();
        gSeance = new gestionSeance();
        this.Proj = gProj.get(idProj).getNomProjet();
        config = new DAOconfiguration();
        controller = new AjouterSeancesProjetController(this, stage, idProj);
        design();
    }

    private void design() {
        AjouterTache.setLayoutX(470.0);
        AjouterTache.setLayoutY(70.0);
        AjouterTache.setFont(Font.font("Arial", FontWeight.BOLD, 48.0));
        AjouterTache.setFill(Color.web("#6a82ab"));
        AjouterTache.setText("Ajouter une Seance");

        NomProjet.setLayoutX(300.0);
        NomProjet.setLayoutY(140.0);
        NomProjet.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));
        NomProjet.setFill(Color.web("#6a82ab"));
        NomProjet.setText("Projet : " + Proj);

        Description.setLayoutX(300.0);
        Description.setLayoutY(290.0);
        Description.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Description.setFill(Color.web("#6a82ab"));
        Description.setText("Description");

        NoteText.setLayoutX(300.0);
        NoteText.setLayoutY(190.0);
        NoteText.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        NoteText.setFill(Color.web("#6a82ab"));
        NoteText.setText("Note");

        Note.setLayoutX(300.0);
        Note.setLayoutY(210.0);
        Note.setPrefWidth(400.0);
        Note.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");
        Note.setFont(Font.font("Arial", 18.0));

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

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(150.0);
        scrollPane.setLayoutY(450.0);
        scrollPane.setPrefWidth(1150);
        scrollPane.setPrefHeight(320);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        scrollPane.setStyle(
                "-fx-selection-bar: #6a82ab; -fx-background-color: transparent; -fx-border-color: transparent;");

        VBox mainVBox = new VBox();
        mainVBox.setSpacing(30);

        VBox tachesVBox = new VBox();
        tachesVBox.setSpacing(5);
        tachesVBox.setStyle("-fx-padding: 0 0 0 50px;");


        scrollPane.setContent(mainVBox);

        getChildren().addAll(AjouterTache, NomProjet, Description, InputDescription, DateDepart,
                PickerDateDepart, DateFin,
                PickerDateFin, buttonAjouter, buttonAnnuler, scrollPane,Note,NoteText);
    }
}