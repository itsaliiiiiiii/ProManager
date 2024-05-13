package com.promanager.promanager.Presentation.Controller.ProjetController.Seances;

import com.promanager.promanager.Presentation.View.ProjetView.Seances.AffichageSeances;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.ImporterSeance;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Presentation.Model.ProjetModel.Seances.SeancesProjetModel;
import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.AjouterSeancesProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;

public class SeancesProjetController {
    private Button PrecedentButton;
    private Stage stage;
    private ObjectId idProjet;

    private Button AjouterButton;
    private Button ImporterButton;

    private Text nomProjet;
    private Text dateDepart;
    private Text dateFin;

    private Seance Seance;

    private Projet Projet;
    private VBox seanceListe;
    private SeancesProjetModel model;

    public SeancesProjetController(SeancesProjet view, Stage stage, ObjectId id) {
        this.PrecedentButton = view.getPrecedentButton();
        this.idProjet = id;
        this.stage = stage;
        AjouterButton = view.getAjouterButton();
        ImporterButton = view.getImporterButton();
        Projet = new Projet();
        nomProjet = view.getNomProjet();
        dateDepart = view.getDateDepart();
        dateFin = view.getDateFin();
        seanceListe = view.getSeanceListe();
        model = new SeancesProjetModel();

        PrecedentButton.setOnAction(event -> {
            Precedent();
        });

        AjouterButton.setOnMouseClicked(event -> {
            AjouterTache(idProjet);
        });
        ImporterButton.setOnMouseClicked(event -> {
            Importer(idProjet);
        });

        fill();
    }

    private void Precedent() {
        AffichageProjet AjouterPage = new AffichageProjet(idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void openSeance(ObjectId id, ObjectId idProjet) {
        AffichageSeances AjouterPage = new AffichageSeances(id, idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void supprimerSeanceProjet(ObjectId idProjet, ObjectId idSeance) {
        ArrayList<ObjectId> listSeances = model.getProjet(idProjet).getListeSeances();
        listSeances.remove(idSeance);
        model.updateprojet(idProjet, listSeances);

        SeancesProjet AjouterPage = new SeancesProjet(idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void AjouterTache(ObjectId idProjet) {
        AjouterSeancesProjet AjouterPage = new AjouterSeancesProjet(idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void Importer(ObjectId idProjet) {
        ImporterSeance AjouterPage = new ImporterSeance(stage, idProjet);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    @SuppressWarnings("deprecation")
    private void fill() {
        Projet = model.getProjet(idProjet);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        nomProjet.setText("Nom Projet : " + Projet.getNomProjet());

        dateDepart.setText("Date Depart : " + sdf.format(Projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(Projet.getDateFinProjet()));

        ArrayList<ObjectId> idSeances = Projet.getListeSeances();

        for (ObjectId idSeance : idSeances) {
            Seance = model.getSeance(idSeance);
            String elemTache = "Date Seance "
                    + sdf.format(Seance.getDateDepartSeance()) + " - Heur Debut : "
                    + Seance.getDateDepartSeance().getHours() + ":00 - Heur Fin : " + Seance.getDateFinSeance()
                            .getHours()
                    + ":00";

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
                openSeance(idSeance, idProjet);
            });

            supprimerTache.setOnMouseClicked(event -> {
                supprimerSeanceProjet(idProjet, idSeance);
            });

            hbox.getChildren().addAll(LabelTache, supprimerTache);
            seanceListe.getChildren().add(hbox);
        }

    }
}