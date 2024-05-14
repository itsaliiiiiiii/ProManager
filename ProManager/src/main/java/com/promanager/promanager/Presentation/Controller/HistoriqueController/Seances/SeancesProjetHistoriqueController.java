package com.promanager.promanager.Presentation.Controller.HistoriqueController.Seances;

import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Presentation.Model.HistoriqueModel.Seances.SeancesProjetHistoriqueModel;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageProjetHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Seances.AffichageSeancesHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Seances.SeancesProjetHistorique;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.bson.types.ObjectId;

public class SeancesProjetHistoriqueController {
    private Button PrecedentButton;
    private Stage stage;
    private ObjectId idProjet;


    private SeancesProjetHistoriqueModel model;
    private Projet projet;
    private Seance seance;

    private Text nomProjet;
    private Text dateDepart;
    private Text dateFin;
    private Text categorieProjet;
    private Text typeProjet;

    private VBox seanceListe;

    public SeancesProjetHistoriqueController(SeancesProjetHistorique view, Stage stage, ObjectId id) {
        this.PrecedentButton = view.getPrecedentButton();
        this.stage = stage;
        this.idProjet = id;
        model = new SeancesProjetHistoriqueModel();
        projet = new Projet();
        seance = new Seance();

        nomProjet = view.getNomProjet();
        dateDepart = view.getDateDepart();
        dateFin = view.getDateFin();
        seanceListe = view.getSeanceListe();
        categorieProjet = view.getCategorieProjet();
        typeProjet = view.getTypeProjet();


        PrecedentButton.setOnAction(event -> {
            Precedent();
        });
        fill();
    }

    public void openSeance(ObjectId id, ObjectId idProjet) {
        AffichageSeancesHistorique AjouterPage = new AffichageSeancesHistorique(id, idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    private void fill() {
        projet = model.getProjet(idProjet);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        nomProjet.setText("Nom Projet : " + projet.getNomProjet());
        categorieProjet.setText("Categorie : " + projet.getCategorieProjet());
        typeProjet.setText("Type : " + projet.getTypeProjet());
        dateDepart.setText("Date Depart : " + sdf.format(projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(projet.getDateFinProjet()));

        ArrayList<ObjectId> idSeances = projet.getListeSeances();

        for (ObjectId idSeance : idSeances) {
            seance = model.getSeance(idSeance);
            String elemTache = "Date Depart : "
                    + sdf.format(seance.getDateDepartSeance()) + " - Date Fin : "
                    + sdf.format(seance.getDateFinSeance());

            Label LabelTache = new Label(elemTache);
            HBox hbox = new HBox();

            LabelTache.setFont(Font.font(25));
            LabelTache.setPrefHeight(60);
            LabelTache.setPrefWidth(900);
            LabelTache.setStyle(
                    "-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: #6a82ab;-fx-opacity:0.5;-fx-text-fill: #FFF;-fx-padding: 20px;-fx-background-radius:20px;-fx-border-radius:20px;");

            hbox.setSpacing(20);

            LabelTache.setOnMouseClicked(event -> {
                openSeance(idSeance, idProjet);
            });

            hbox.getChildren().addAll(LabelTache);
            seanceListe.getChildren().add(hbox);
        }
    }

    private void Precedent() {
            AffichageProjetHistorique AjouterPage = new AffichageProjetHistorique(idProjet, stage);
            Scene projectsScene = new Scene(AjouterPage, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
    }

}