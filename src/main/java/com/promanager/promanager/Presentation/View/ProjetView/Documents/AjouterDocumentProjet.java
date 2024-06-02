package com.promanager.promanager.Presentation.View.ProjetView.Documents;

import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.Controller.ProjetController.Documents.AjouterDocumentProjetController;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AjouterDocumentProjet extends AnchorPane {
    private Button PrecedentButton;
    private Button Ajouter;
    private Button SelectionDocument;
    private Text text;
    private Text Document;
    private TextArea Description;
    @SuppressWarnings("unused")
    private AjouterDocumentProjetController controller;

    public AjouterDocumentProjet(Stage stage, ObjectId idProjet) {
        PrecedentButton = new Button("Precedent");
        Ajouter = new Button("Ajouter");
        Description = new TextArea();
        SelectionDocument = new Button("Selectioner Document");
        text = new Text("Ajouter Document ");
        Document = new Text("");
        controller = new AjouterDocumentProjetController(this, stage, idProjet);
        design();
    }

    public Button getPrecedentButton() {
        return PrecedentButton;
    }

    public Button getAjouter() {
        return Ajouter;
    }

    public Button getSelectionDocument() {
        return SelectionDocument;
    }

    public Text getText() {
        return text;
    }

    public Text getLabel() {
        return Document;
    }

    public TextArea getDescription() {
        return Description;
    }

    private void design() {
        text.setFill(Color.valueOf("#6a82ab"));
        text.setFont(Font.font("Arial", FontWeight.BOLD, 40.0));
        text.setLayoutX(490.0);
        text.setLayoutY(250.0);

        Document.setFont(Font.font("Arial", FontWeight.NORMAL, 16.0));
        Document.setLayoutX(525.0);
        Document.setLayoutY(360.0);

        Description.setLayoutX(525.0);
        Description.setLayoutY(380.0);
        Description.setPrefWidth(250.0);
        Description.setPrefHeight(100.0);

        PrecedentButton.setPrefWidth(150.0);
        PrecedentButton.setPrefHeight(40.0);
        PrecedentButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        PrecedentButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        PrecedentButton.setLayoutX(50.0);
        PrecedentButton.setLayoutY(700.0);

        Ajouter.setPrefWidth(150.0);
        Ajouter.setPrefHeight(40.0);
        Ajouter.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        Ajouter.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        Ajouter.setLayoutX(570.0);
        Ajouter.setLayoutY(500.0);

        SelectionDocument.setPrefWidth(250.0);
        SelectionDocument.setPrefHeight(40.0);
        SelectionDocument.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        SelectionDocument.setStyle("-fx-background-color: #6a82ab33; -fx-text-fill: black;");
        SelectionDocument.setLayoutX(525.0);
        SelectionDocument.setLayoutY(300.0);

        getChildren().addAll(PrecedentButton, SelectionDocument, text, Document, Ajouter, Description);
    }
}
