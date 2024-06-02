package com.promanager.promanager.Presentation.View.ProjetView.Seances;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Presentation.Controller.ProjetController.Seances.AjouterSeancesProjetController;
import org.bson.types.ObjectId;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
    private ComboBox<Integer> heurdebut;
    private ComboBox<Integer> heurfin;
    private Text NoteText;
    private Text debutSeance;
    private TextArea InputDescription;
    private TextField Note;
    private Button buttonAnnuler;
    private Button buttonAjouter;
    private DatePicker PickerDate;
    private Stage stage;
    private String Proj;
    private AjouterSeancesProjetController controller;

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
        return PickerDate;
    }

    public TextField getNote() {
        return Note;
    }

    public ComboBox<Integer> getHeurdebut() {
        return heurdebut;
    }

    public ComboBox<Integer> getHeurfin() {
        return heurfin;
    }

    public AjouterSeancesProjet(ObjectId idProj, Stage stage) {
        this.stage = stage;
        AjouterTache = new Text("Ajouter Seance");
        NomProjet = new Text("Nom Projet");
        Note = new TextField();
        NoteText = new Text();
        InputDescription = new TextArea();
        Description = new Text("Description");
        PickerDate = new DatePicker();
        debutSeance = new Text();
        DateDepart = new Text("Date Depart");
        buttonAjouter = new Button("Ajouter");
        buttonAnnuler = new Button("Annulé");
        heurdebut = new ComboBox<>();
        heurfin = new ComboBox<>();
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
        DateDepart.setText("Date de Seance");

        PickerDate.setLayoutX(800.0);
        PickerDate.setLayoutY(200.0);
        PickerDate.setPrefWidth(200.0);

        debutSeance.setLayoutX(800.0);
        debutSeance.setLayoutY(250.0);
        debutSeance.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        debutSeance.setFill(Color.web("#6a82ab"));
        debutSeance.setText("Heure :");

        heurdebut.setLayoutX(800.0);
        heurdebut.setLayoutY(260.0);
        heurdebut.setPrefWidth(80.0);
        heurdebut.setStyle("-fx-background-color:#fff");

        heurfin.setLayoutX(890.0);
        heurfin.setLayoutY(260.0);
        heurfin.setPrefWidth(80.0);
        heurfin.setStyle("-fx-background-color:#fff");

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

        for (int h = 8; h <= 18; h++) {
            heurdebut.getItems().add(h);
            heurfin.getItems().add(h);
        }

        scrollPane.setContent(mainVBox);

        getChildren().addAll(AjouterTache, NomProjet, Description, InputDescription, DateDepart,
                PickerDate, debutSeance, heurdebut, heurfin, buttonAjouter, buttonAnnuler, scrollPane, Note, NoteText);
    }
}