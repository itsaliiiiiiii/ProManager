package com.promanager.promanager.Presentation.View.ProjetView.Taches;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Persistance.DAOtache;
import com.promanager.promanager.Presentation.Controller.ProjetController.Taches.TachesProjetController;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class TachesProjet extends AnchorPane {
    private ObjectId idProjet;
    private Text nomProjet;
    private Text categorie;
    private Text type;
    private Text dateDepart;
    private Text dateFin;
    private Button PrecedentButton;
    private Button AjouterButton;
    private TachesProjetController controller;
    private gestionProjet gProjet;
    private Projet Projet;
    private DAOtache gTaches;
    private Stage stage;
    private Label textTaches;
    private ScrollPane scrollPane;
    private VBox tacheListe;
    private ArrayList<ObjectId> idsTaches;
    private String elemTache;
    private Tache tache;

    public TachesProjet(ObjectId id, Stage stage) {
        this.idProjet = id;
        nomProjet = new Text("Nom Projet");
        categorie = new Text("Categorie");
        type = new Text("Type");
        dateDepart = new Text("Date Depart");
        dateFin = new Text("Date Fin");
        PrecedentButton = new Button("Precedent");
        AjouterButton = new Button("Ajouter");
        gProjet = new gestionProjet();
        gTaches = new DAOtache();
        tache = new Tache();
        Projet = new Projet();
        textTaches = new Label("~ Liste Taches :");
        idsTaches = new ArrayList<>();
        elemTache = new String();
        this.stage = stage;
        this.controller = new TachesProjetController(this, stage, idProjet);
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

    public Text getDateDepart() {
        return dateDepart;
    }

    public Text getDateFin() {
        return dateFin;
    }

    public Button getPrecedentButton() {
        return PrecedentButton;
    }

    public Button getAjouterButton() {
        return AjouterButton;
    }

    private void design() {
        nomProjet.setFill(javafx.scene.paint.Color.valueOf("#6a82ab"));
        nomProjet.setLayoutX(50.0);
        nomProjet.setLayoutY(90.0);
        nomProjet.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

        textTaches.setStyle(" -fx-text-fill: #6a82ab;");
        textTaches.setLayoutX(50.0);
        textTaches.setLayoutY(350.0);
        textTaches.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

        categorie.setLayoutX(50.0);
        categorie.setLayoutY(140.0);
        categorie.setFont(new Font(20.0));

        type.setLayoutX(50.0);
        type.setLayoutY(190.0);
        type.setFont(new Font(20.0));

        dateDepart.setLayoutX(50.0);
        dateDepart.setLayoutY(240.0);
        dateDepart.setFont(new Font(20.0));

        dateFin.setLayoutX(50.0);
        dateFin.setLayoutY(290.0);
        dateFin.setFont(new Font(20.0));

        scrollPane = new ScrollPane();
        scrollPane.setLayoutX(50.0);
        scrollPane.setLayoutY(420.0);
        scrollPane.setPrefWidth(1230);
        scrollPane.setPrefHeight(350);
        scrollPane.setStyle(" -fx-selection-bar: #6a82ab;fx-border-color: transparent;-fx-background-color: inherit;");
        tacheListe = new VBox(10);

        PrecedentButton.setLayoutX(1100.0);
        PrecedentButton.setLayoutY(50.0);
        PrecedentButton.setPrefWidth(150.0);
        PrecedentButton.setPrefHeight(40.0);
        PrecedentButton.setFont(new Font(18.0));
        PrecedentButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        PrecedentButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        AjouterButton.setLayoutX(1100.0);
        AjouterButton.setLayoutY(340.0);
        AjouterButton.setPrefWidth(150.0);
        AjouterButton.setPrefHeight(40.0);
        AjouterButton.setFont(new Font(18.0));
        AjouterButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        AjouterButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        Projet = gProjet.get(idProjet);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        nomProjet.setText("Nom Projet : " + Projet.getNomProjet());
        categorie.setText("Categorie : " + Projet.getCategorieProjet());
        type.setText("Type : " + Projet.getTypeProjet());
        dateDepart.setText("Date Depart : " + sdf.format(Projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(Projet.getDateFinProjet()));

        idsTaches = Projet.getListeTaches();

        for (ObjectId idTache : idsTaches) {
            tache = gTaches.get(idTache);
            elemTache = "Categorie : " + tache.getCategorieTache() + " - Date Depart : "
                    + sdf.format(tache.getDateDepartTache()) + " - Date Fin : " + sdf.format(tache.getDateFinTache());

            Label LabelTache = new Label(elemTache);
            HBox hbox = new HBox();
            Button supprimerTache = new Button("Supprimer");

            LabelTache.setFont(Font.font(25));
            LabelTache.setPrefHeight(60);
            LabelTache.setPrefWidth(900);
            LabelTache.setStyle(
                    "-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: #6a82ab;-fx-opacity:0.5;-fx-text-fill: #FFF;-fx-padding: 20px;-fx-background-radius:20px;-fx-border-radius:20px;");

            supprimerTache.setPrefHeight(60);
            supprimerTache.setPrefWidth(200);
            supprimerTache.setStyle(
                    "-fx-background-color: #6a82ab; -fx-text-fill: white;-fx-background-radius:20px;-fx-border-radius:20px;-fx-border-color: black; -fx-border-width: 1px;-fx-padding: 20px;-fx-opacity:0.5;");
            supprimerTache.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

            hbox.setSpacing(20);

            LabelTache.setOnMouseClicked(event -> {
                controller.openTache(idTache, idProjet);
            });

            supprimerTache.setOnMouseClicked(event -> {
                controller.supprimerTacheProjet(idProjet, idTache);
            });

            hbox.getChildren().addAll(LabelTache, supprimerTache);
            tacheListe.getChildren().add(hbox);
        }
        AjouterButton.setOnMouseClicked(event -> {
            controller.AjouterTache(idProjet);
        });

        scrollPane.setContent(tacheListe);

        getChildren().addAll(nomProjet, categorie, type, dateDepart, dateFin, PrecedentButton, scrollPane, textTaches,
                AjouterButton);
    }
}
