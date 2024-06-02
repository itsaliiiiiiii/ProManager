package com.promanager.promanager.Presentation.View.ProjetView.Seances;

import com.promanager.promanager.Presentation.Controller.ProjetController.Seances.AffichageSeancesController;
import org.bson.types.ObjectId;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageSeances extends AnchorPane {
    private Stage stage;
    private Text textT;
    private Button PrecedentButton;
    private AffichageSeancesController controller;
    private Text description;
    private Text note; 
    private Text dateFin;
    private Text dateDepart;
    private ScrollPane scrollPane;
    private VBox documentListe;
    private Button AjouterButton;
    private Label textDocuments;

    public AffichageSeances(ObjectId idSeance, ObjectId idProjet, Stage stage) {
        this.stage = stage;
        textT = new Text("Seance :");
        PrecedentButton = new Button("Precedent");
        dateDepart = new Text("Date Depart");
        dateFin = new Text("Date Depart");
        AjouterButton = new Button("Ajouter");
        textDocuments = new Label("~ Liste Documents :");
        description = new Text();
        documentListe=new VBox();
        note = new Text();
        this.controller = new AffichageSeancesController(this, stage, idSeance, idProjet);

        design();
    }

    public Button getPrecedentButton() {
        return PrecedentButton;
    }

    public Text getNote() {
        return note;
    }

    public Text getDescription() {
        return description;
    }

    public Text getDateFin() {
        return dateFin;
    }

    public VBox getDocumentListe() {
        return documentListe;
    }

    public Text getDateDepart() {
        return dateDepart;
    }

    public Button getAjouterButton() {
        return AjouterButton;
    }

    private void design() {
        textT.setFill(javafx.scene.paint.Color.valueOf("#6a82ab"));
        textT.setLayoutX(50.0);
        textT.setLayoutY(90.0);
        textT.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

        description.setLayoutX(50.0);
        description.setLayoutY(250.0);
        description.setFont(new Font(20.0));

        note.setLayoutX(50.0);
        note.setLayoutY(300.0);
        note.setFont(new Font(20.0));

        dateDepart.setLayoutX(50.0);
        dateDepart.setLayoutY(140.0);
        dateDepart.setFont(new Font(20.0));

        dateFin.setLayoutX(50.0);
        dateFin.setLayoutY(200.0);
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

        scrollPane = new ScrollPane();
        scrollPane.setLayoutX(50.0);
        scrollPane.setLayoutY(420.0);
        scrollPane.setPrefWidth(1230);
        scrollPane.setPrefHeight(350);
        scrollPane.setStyle(" -fx-selection-bar: #6a82ab;fx-border-color: transparent;-fx-background-color: inherit;");
        documentListe = new VBox(10);

        scrollPane.setContent(documentListe);
        getChildren().addAll(textT, PrecedentButton, dateDepart, dateFin, scrollPane, textDocuments,
                AjouterButton, note,description);
    }
}