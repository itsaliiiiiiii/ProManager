package com.promanager.promanager.Presentation.Controller.HistoriqueController.Taches;

import com.promanager.promanager.Presentation.Model.HistoriqueModel.Taches.AffichageTacheHistoriqueModel;
import com.promanager.promanager.Presentation.Model.ProjetModel.Taches.AffichageTachesModel;
import com.promanager.promanager.Presentation.View.HistoriqueView.Taches.AffichageTacheHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Taches.TachesProjetHistorique;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Tache;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class AffichageTacheHistoriqueController {
    private Button PrecedentButton;
    private Stage stage;
    private ArrayList<ObjectId> idsDocuments;
    private ObjectId idProjet;
    private ObjectId idTache;

    private Text categorie;
    private Text dateFin;
    private Text dateDepart;
    private Text description;
    private VBox documentListe;

    private String elemDocument;
    private Document_ document_;

    private Tache Tache;
    private AffichageTacheHistoriqueModel model;

    public AffichageTacheHistoriqueController(AffichageTacheHistorique view, Stage stage, ObjectId idTache,
            ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();
        model = new AffichageTacheHistoriqueModel();
        idsDocuments = new ArrayList<>();
        Tache = new Tache();

        categorie = view.getCategorie();
        dateDepart = view.getDateDepart();
        dateFin = view.getDateFin();
        description = view.getDescription();
        documentListe = view.getDocumentListe();

        this.idProjet = idProjet;
        this.idTache = idTache;
        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            Precedent();
        });
        fill();
    }

    public void fill() {
        Tache = model.get_Tache(idTache);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        categorie.setText("Categorie : " + Tache.getCategorieTache());
        dateDepart.setText("Date Depart : " + sdf.format(Tache.getDateDepartTache()));
        dateFin.setText("Date Fin : " + sdf.format(Tache.getDateFinTache()));
        description.setText(Tache.getDescriptionTache());

        idsDocuments = Tache.getListeDocument();
        if (idsDocuments != null) {
            for (ObjectId idDoc : idsDocuments) {
                document_ = model.getDocument(idDoc);

                String[] pathDoc = (document_.getPathDocument()).split("/");
                elemDocument = "Description : " + document_.getDescriptionDocument() + " - Nom : "
                        + pathDoc[pathDoc.length - 1] + " - Date Ajout : " + sdf.format(document_.getDateAjout());

                Label LabelDocument_ = new Label(elemDocument);
                LabelDocument_.setFont(Font.font(25));
                LabelDocument_.setPrefHeight(60);
                LabelDocument_.setPrefWidth(900);
                LabelDocument_.setStyle(
                        "-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: #6a82ab;-fx-opacity:0.5;-fx-text-fill: #FFF;-fx-padding: 20px;-fx-background-radius:20px;-fx-border-radius:20px;");

                HBox hbox = new HBox();

                LabelDocument_.setOnMouseClicked(event -> {
                    File file = new File(document_.getPathDocument());
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                hbox.setSpacing(30);
                hbox.getChildren().addAll(LabelDocument_);
                documentListe.getChildren().add(hbox);
            }
        }
    }

    public void Precedent() {
            stage.setWidth(1300);
            stage.setHeight(800);
            TachesProjetHistorique button = new TachesProjetHistorique(idProjet, stage);
            Scene projectsScene = new Scene(button, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
    }
}
