package com.promanager.promanager.Presentation.Controller.HistoriqueController.Taches;

import com.promanager.promanager.Presentation.DB.HistoriqueModel.Taches.TachesProjetHistoriqueModel;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageProjetHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Taches.AffichageTacheHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Taches.TachesProjetHistorique;
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

import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Persistance.DAOprojet;

@SuppressWarnings("unused")
public class TachesProjetHistoriqueController {
    private Button PrecedentButton;
    private Stage stage;
    private ObjectId idProj;
    private Projet projet;

    private Text nomProjet;
    private Text categorie;
    private Text type;
    private Text dateDepart;
    private Text dateFin;
    private String elemTache;
    private VBox tacheListe;
    private TachesProjetHistoriqueModel model;


    public TachesProjetHistoriqueController(TachesProjetHistorique view, Stage stage, ObjectId id) {
        this.PrecedentButton = view.getPrecedentButton();
        this.stage = stage;
        this.idProj = id;
        projet = new Projet();
        model = new TachesProjetHistoriqueModel();


        nomProjet = view.getNomProjet();
        categorie = view.getCategorie();
        type = view.getType();
        dateDepart = view.getDateDepart();
        dateFin = view.getDateFin();
        tacheListe = view.getTacheListe();

        PrecedentButton.setOnAction(event -> {
            Precedent();
        });
        fill();
    }

    public void openTache(ObjectId id, ObjectId idProjet) {
        AffichageTacheHistorique AjouterPage = new AffichageTacheHistorique(id, idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void fill() {
        projet = model.getProjet(idProj);

        ArrayList<ObjectId> idsTaches = projet.getListeTaches();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        nomProjet.setText("Nom Projet : " + projet.getNomProjet());
        categorie.setText("Categorie : " + projet.getCategorieProjet());
        type.setText("Type : " + projet.getTypeProjet());
        dateDepart.setText("Date Depart : " + sdf.format(projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(projet.getDateFinProjet()));

        idsTaches = projet.getListeTaches();

        for (ObjectId idTache : idsTaches) {
            Tache tache = model.getTache(idTache);
            elemTache = "Categorie : " + tache.getCategorieTache() + " - Date Depart : "
                    + sdf.format(tache.getDateDepartTache()) + " - Date Fin : " + sdf.format(tache.getDateFinTache());

            Label LabelTache = new Label(elemTache);
            HBox hbox = new HBox();

            LabelTache.setFont(Font.font(25));
            LabelTache.setPrefHeight(60);
            LabelTache.setPrefWidth(900);
            LabelTache.setStyle(
                    "-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: #6a82ab;-fx-opacity:0.5;-fx-text-fill: #FFF;-fx-padding: 20px;-fx-background-radius:20px;-fx-border-radius:20px;");

            hbox.setSpacing(20);

            LabelTache.setOnMouseClicked(event -> {
                openTache(idTache, idProj);
            });

            hbox.getChildren().addAll(LabelTache);
            tacheListe.getChildren().add(hbox);
        }
    }

    public void Precedent() {
            AffichageProjetHistorique historiqueProjet = new AffichageProjetHistorique(idProj, stage);
            Scene projectsScene = new Scene(historiqueProjet, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
    }

}