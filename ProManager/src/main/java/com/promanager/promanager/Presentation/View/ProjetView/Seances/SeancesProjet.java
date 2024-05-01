package com.promanager.promanager.Presentation.View.ProjetView.Seances;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.promanager.promanager.Presentation.Controller.ProjetController.Seances.ImporterSeanceController;
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
public class SeancesProjet extends AnchorPane {
    private ObjectId idProjet;
    private Text nomProjet;
    private Text dateDepart;
    private Text dateFin;
    private Button PrecedentButton;
    private Button AjouterButton;
    private SeancesProjetController controller;
    private gestionProjet gProjet;
    private Projet Projet;
    private DAOseance gSeance;
    private Stage stage;
    private Label textSeances;
    private ScrollPane scrollPane;
    private VBox seanceListe;
    private Button ImporterButton;
    private ArrayList<ObjectId> idSeances;
    private String elemTache;
    private Seance Seance;

    public SeancesProjet(ObjectId id, Stage stage) {
        this.idProjet = id;
        nomProjet = new Text("Nom Projet");

        dateDepart = new Text("Date Depart");
        dateFin = new Text("Date Fin");
        PrecedentButton = new Button("Precedent");
        AjouterButton = new Button("Ajouter");
        gProjet = new gestionProjet();
        gSeance = new DAOseance();
        Seance = new Seance();
        Projet = new Projet();
        textSeances = new Label("~ Liste Seances :");
        idSeances = new ArrayList<>();
        elemTache = new String();
        ImporterButton=new Button("Importer");
        this.stage = stage;
        this.controller = new SeancesProjetController(this, stage, idProjet);
        design();
    }

    public Button getImporterButton() {
        return ImporterButton;
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

    public Button getAjouterButton() {
        return AjouterButton;
    }



    
    @SuppressWarnings("deprecation")
    private void design() {
        nomProjet.setFill(javafx.scene.paint.Color.valueOf("#6a82ab"));
        nomProjet.setLayoutX(50.0);
        nomProjet.setLayoutY(90.0);
        nomProjet.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

        textSeances.setStyle(" -fx-text-fill: #6a82ab;");
        textSeances.setLayoutX(50.0);
        textSeances.setLayoutY(350.0);
        textSeances.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

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
        seanceListe = new VBox(10);

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

        ImporterButton.setLayoutX(930);
        ImporterButton.setLayoutY(340.0);
        ImporterButton.setPrefWidth(150.0);
        ImporterButton.setPrefHeight(40.0);
        ImporterButton.setFont(new Font(18.0));
        ImporterButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        ImporterButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        Projet = gProjet.get(idProjet);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        nomProjet.setText("Nom Projet : " + Projet.getNomProjet());
    
        dateDepart.setText("Date Depart : " + sdf.format(Projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(Projet.getDateFinProjet()));

        idSeances = Projet.getListeSeances();

        for (ObjectId idSeance : idSeances) {
            Seance = gSeance.get(idSeance);
            elemTache = "Date Seance "
                    + sdf.format(Seance.getDateDepartSeance()) + " - Heur Debut : " + Seance.getDateDepartSeance().getHours() + ":00 - Heur Fin : " + Seance.getDateFinSeance()
                            .getHours() + ":00";

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
                controller.openSeance(idSeance, idProjet);
            });

            supprimerTache.setOnMouseClicked(event -> {
                controller.supprimerSeanceProjet(idProjet, idSeance);
            });

            hbox.getChildren().addAll(LabelTache, supprimerTache);
            seanceListe.getChildren().add(hbox);
        }
        AjouterButton.setOnMouseClicked(event -> {
            controller.AjouterTache(idProjet);
        });
        ImporterButton.setOnMouseClicked(event->{
            controller.Importer(idProjet);
        });

        scrollPane.setContent(seanceListe);

        getChildren().addAll(nomProjet, dateDepart, dateFin, PrecedentButton, scrollPane, textSeances,
                AjouterButton,ImporterButton);
    }
}
