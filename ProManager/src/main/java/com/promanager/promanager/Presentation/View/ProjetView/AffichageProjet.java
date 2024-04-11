package com.promanager.promanager.Presentation.View.ProjetView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Presentation.Controller.ProjetController.AffichageProjetController;
import com.promanager.promanager.Presentation.Controller.ProjetController.AjouterProjetController;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageProjet extends AnchorPane {
    private ObjectId idProjet;
    private Text nomProjet;
    private Text categorie;
    private Text type;
    private Text dateDepart;
    private TextFlow description;
    private Text dateFin;
    private Button modifierButton;
    private Button clonerButton;
    private Button cloturerButton;
    private Button PrecedentButton;
    private AffichageProjetController controller;
    private gestionProjet gProjet;
    private Button documentsButton;
    private Button seancesButton;
    private Button tachesButton;

    public AffichageProjet(ObjectId id, Stage stage) {
        nomProjet = new Text("Nom Projet");
        categorie = new Text("Categorie");
        type = new Text("type");
        dateDepart = new Text("Date Depart");
        description = new TextFlow();
        dateFin = new Text("Date Fin");
        modifierButton = new Button("Modifier");
        clonerButton = new Button("cloner");
        cloturerButton = new Button("Cloturer");
        PrecedentButton = new Button("Precedent");
        documentsButton = new Button("Documents");
        seancesButton = new Button("Seances");
        tachesButton = new Button("Taches");
        gProjet = new gestionProjet();
        idProjet = id;
        this.controller = new AffichageProjetController(this, stage, idProjet);
        design();
    }

    public ObjectId getIdProjet() {
        return idProjet;
    }

    public Text getNomProjet() {
        return nomProjet;
    }

    public Text getCategorie() {
        return categorie;
    }

    public Text getType() {
        return type;
    }

    public Button getDocumentsButton() {
        return documentsButton;
    }

    public Button getSeancesButton() {
        return seancesButton;
    }

    public Button getTachesButton() {
        return tachesButton;
    }

    public Text getDateDepart() {
        return dateDepart;
    }

    public TextFlow getTextFlow() {
        return description;
    }

    public Text getDateFin() {
        return dateFin;
    }

    public Button getModifierButton() {
        return modifierButton;
    }

    public Button getClonerButton() {
        return clonerButton;
    }

    public Button getCloturerButton() {
        return cloturerButton;
    }

    public Button getPrecedentButton() {
        return PrecedentButton;
    }

    private void design() {
        nomProjet.setFill(javafx.scene.paint.Color.valueOf("#6a82ab"));
        nomProjet.setLayoutX(50.0);
        nomProjet.setLayoutY(90.0);
        nomProjet.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

        categorie.setLayoutX(50.0);
        categorie.setLayoutY(140.0);
        categorie.setFont(new Font(20.0));

        type.setLayoutX(50.0);
        type.setLayoutY(190.0);
        type.setFont(new Font(20.0));

        dateDepart.setLayoutX(50.0);
        dateDepart.setLayoutY(240.0);
        dateDepart.setFont(new Font(20.0));

        description.setLayoutX(50.0);
        description.setLayoutY(310.0);
        description.setPrefHeight(400.0);
        description.setPrefWidth(500.0);
        description.setMaxWidth(500);

        dateFin.setLayoutX(50.0);
        dateFin.setLayoutY(290.0);
        dateFin.setFont(new Font(20.0));

        modifierButton.setLayoutX(1100.0);
        modifierButton.setLayoutY(50.0);
        modifierButton.setPrefHeight(40.0);
        modifierButton.setPrefWidth(150.0);
        modifierButton.setFont(new Font(18.0));
        modifierButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        modifierButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        clonerButton.setLayoutX(1100.0);
        clonerButton.setLayoutY(100.0);
        clonerButton.setPrefHeight(40.0);
        clonerButton.setPrefWidth(150.0);
        clonerButton.setFont(new Font(18.0));
        clonerButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        clonerButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        cloturerButton.setLayoutX(1100.0);
        cloturerButton.setLayoutY(150.0);
        cloturerButton.setPrefHeight(40.0);
        cloturerButton.setPrefWidth(150.0);
        cloturerButton.setFont(new Font(18.0));
        cloturerButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        cloturerButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        PrecedentButton.setLayoutX(50.0);
        PrecedentButton.setLayoutY(700.0);
        PrecedentButton.setPrefWidth(150.0);
        PrecedentButton.setPrefHeight(40.0);
        PrecedentButton.setFont(new Font(18.0));
        PrecedentButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        PrecedentButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        documentsButton.setLayoutX(1100.0);
        documentsButton.setLayoutY(700.0);
        documentsButton.setPrefWidth(150.0);
        documentsButton.setPrefHeight(40.0);
        documentsButton.setFont(new Font(18.0));
        documentsButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        documentsButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        seancesButton.setLayoutX(940.0);
        seancesButton.setLayoutY(700.0);
        seancesButton.setPrefWidth(150.0);
        seancesButton.setPrefHeight(40.0);
        seancesButton.setFont(new Font(18.0));
        seancesButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        seancesButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        tachesButton.setLayoutX(780.0);
        tachesButton.setLayoutY(700.0);
        tachesButton.setPrefWidth(150.0);
        tachesButton.setPrefHeight(40.0);
        tachesButton.setFont(new Font(18.0));
        tachesButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        tachesButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        Projet Projet = gProjet.get(idProjet);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        nomProjet.setText("Nom Projet : " + Projet.getNomProjet());
        categorie.setText("Categorie : " + Projet.getCategorieProjet());
        type.setText("Type : " + Projet.getTypeProjet());
        Label desc = new Label(Projet.getDescriptionProjet());
        desc.setFont(new Font(15.0));
        description.getChildren().add(desc);
        dateDepart.setText("Date Depart : " + sdf.format(Projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(Projet.getDateFinProjet()));

        getChildren().addAll(
                nomProjet, categorie, type, dateDepart,
                description, dateFin, modifierButton,
                clonerButton, cloturerButton, PrecedentButton, documentsButton, seancesButton, tachesButton);
    }
}