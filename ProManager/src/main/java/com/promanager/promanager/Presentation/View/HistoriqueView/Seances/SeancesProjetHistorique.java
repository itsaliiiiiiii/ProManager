package com.promanager.promanager.Presentation.View.HistoriqueView.Seances;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.promanager.promanager.Presentation.Controller.HistoriqueController.Seances.SeancesProjetHistoriqueController;
import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Persistance.DAOseance;
import com.promanager.promanager.Persistance.DAOtache;
import com.promanager.promanager.Presentation.Controller.ProjetController.Seances.SeancesProjetController;
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
public class SeancesProjetHistorique extends AnchorPane {
    private ObjectId idProjet;
    private Text nomProjet;
    private Text dateDepart;
    private Text dateFin;
    private Text typeProjet;
    private Text categorieProjet;
    private Button PrecedentButton;

    private SeancesProjetHistoriqueController controller;
    private Projet Projet;
    private Stage stage;
    private Label textSeances;
    private ScrollPane scrollPane;
    private VBox seanceListe;
    private ArrayList<ObjectId> idSeances;
    private String elemTache;
    private Seance Seance;

    public SeancesProjetHistorique(ObjectId id, Stage stage) {
        this.idProjet = id;
        nomProjet = new Text("Nom Projet");
        typeProjet = new Text("Type : ");
        categorieProjet = new Text("Categorie : ");
        dateDepart = new Text("Date Depart");
        dateFin = new Text("Date Fin");

        PrecedentButton = new Button("Precedent");
        Seance = new Seance();
        Projet = new Projet();
        textSeances = new Label("~ Liste Seances :");
        idSeances = new ArrayList<>();
        elemTache = new String();
        seanceListe = new VBox(10);
        this.stage = stage;
        this.controller = new SeancesProjetHistoriqueController(this, stage, idProjet);
        design();
    }

    public ObjectId getIdProjet() {
        return idProjet;
    }

    public Text getNomProjet() {
        return nomProjet;
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

    public VBox getSeanceListe() {
        return seanceListe;
    }
    public Text getTypeProjet() {
        return typeProjet;
    }

    public Text getCategorieProjet() {
        return categorieProjet;
    }

    private void design() {
        nomProjet.setFill(javafx.scene.paint.Color.valueOf("#6a82ab"));
        nomProjet.setLayoutX(50.0);
        nomProjet.setLayoutY(90.0);
        nomProjet.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

        textSeances.setStyle(" -fx-text-fill: #6a82ab;");
        textSeances.setLayoutX(50.0);
        textSeances.setLayoutY(350.0);
        textSeances.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

        typeProjet.setLayoutX(50.0);
        typeProjet.setLayoutY(190.0);
        typeProjet.setFont(new Font(20.0));

        categorieProjet.setLayoutX(50.0);
        categorieProjet.setLayoutY(140.0);
        categorieProjet.setFont(new Font(20.0));

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
        
        PrecedentButton.setLayoutX(1100.0);
        PrecedentButton.setLayoutY(50.0);
        PrecedentButton.setPrefWidth(150.0);
        PrecedentButton.setPrefHeight(40.0);
        PrecedentButton.setFont(new Font(18.0));
        PrecedentButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        PrecedentButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        scrollPane.setContent(seanceListe);

        getChildren().addAll(nomProjet,typeProjet,categorieProjet,dateDepart, dateFin, PrecedentButton, scrollPane, textSeances);
    }

   
}
