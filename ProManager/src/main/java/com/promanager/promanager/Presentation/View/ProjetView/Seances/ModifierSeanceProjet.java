package com.promanager.promanager.Presentation.View.ProjetView.Seances;

import org.bson.types.ObjectId;


import com.promanager.promanager.Presentation.Controller.ProjetController.Seances.ModifierSeanceProjetController;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ModifierSeanceProjet extends AnchorPane{
    private Text Description;
    private Text Note;

    private TextArea InputNote;
    private TextArea InputDescription;
    private Button buttonAnnuler;
    private Button buttonModifier;
    
    private Stage stage;
    private ModifierSeanceProjetController controller;


    public ModifierSeanceProjet(ObjectId id,ObjectId idSeance, Stage stage) {
        InputDescription = new TextArea();
        Note = new Text("Note");
        InputNote = new TextArea();
        Description = new Text("Description");
        buttonModifier = new Button("Modifier");
        buttonAnnuler = new Button("Annulé");
        this.stage = stage;
        this.controller = new ModifierSeanceProjetController(this, id , idSeance ,stage);
        this.design();
    }
    public Text getDescription() {
        return Description;
    }

    public TextArea getInputDescription() {
        return InputDescription;
    }


    public Button getButtonAnnuler() {
        return buttonAnnuler;
    }

    public Button getButtonModifier() {
        return buttonModifier;
    }
    
    public TextArea getInputNote() {
        return InputNote;
    }
    private void design() {

        Description.setLayoutX(675.0);
        Description.setLayoutY(270.0);
        Description.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Description.setFill(Color.web("#6a82ab"));
        Description.setText("Description");

        Note.setLayoutX(165);
        Note.setLayoutY(270.0);
        Note.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Note.setFill(Color.web("#6a82ab"));
        Note.setText("Note");

        InputNote.setLayoutX(150.0);
        InputNote.setLayoutY(300.0);
        InputNote.setPrefWidth(400.0);
        InputNote.setPrefHeight(100.0);
        InputNote.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");
        InputNote.setFont(Font.font("Arial", 18.0));

        InputDescription.setLayoutX(650.0);
        InputDescription.setLayoutY(300.0);
        InputDescription.setPrefWidth(400.0);
        InputDescription.setPrefHeight(100.0);
        InputDescription.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");
        InputDescription.setFont(Font.font("Arial", 18.0));


        buttonModifier.setLayoutX(800.0);
        buttonModifier.setLayoutY(480.0);
        buttonModifier.setPrefWidth(150.0);
        buttonModifier.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        buttonModifier.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        buttonModifier.setText("Modifier");

        buttonAnnuler.setLayoutX(800.0);
        buttonAnnuler.setLayoutY(530.0);
        buttonAnnuler.setPrefWidth(150.0);
        buttonAnnuler.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        buttonAnnuler.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));
        buttonAnnuler.setText("Annuler");


        this.getChildren().addAll(Description,InputNote,Note, InputDescription, buttonModifier, buttonAnnuler);
    }
}
