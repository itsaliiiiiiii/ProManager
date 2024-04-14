package com.promanager.promanager.Presentation.View.HistoriqueView.Projets;

import java.text.SimpleDateFormat;

import com.promanager.promanager.Presentation.Controller.HistoriqueController.Projets.AffichageProjetHistoriqueController;
import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageProjetHistorique extends AnchorPane {
    private ObjectId idProjet;
    private Text nomProjet;
    private Text categorie;
    private Text type;
    private Text dateDepart;
    private TextFlow description;
    private Text dateFin;

    private Button PrecedentButton;
    private AffichageProjetHistoriqueController controller;
    private gestionProjet gProjet;
    private Button documentsButton;
    private Button seancesButton;
    private Button tachesButton;

    public AffichageProjetHistorique(ObjectId id, Stage stage) {
        nomProjet = new Text("Nom Projet");
        categorie = new Text("Categorie");
        type = new Text("type");
        dateDepart = new Text("Date Depart");
        description = new TextFlow();
        dateFin = new Text("Date Fin");

        PrecedentButton = new Button("Precedent");
        documentsButton = new Button("Documents");
        seancesButton = new Button("Seances");
        tachesButton = new Button("Taches");
        gProjet = new gestionProjet();
        idProjet = id;
        this.controller = new AffichageProjetHistoriqueController(this, stage, idProjet);
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
                description, dateFin, PrecedentButton, documentsButton, seancesButton, tachesButton );
    }
}