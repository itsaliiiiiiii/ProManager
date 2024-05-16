package com.promanager.promanager.Presentation.Controller.ProjetController.Seances;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.Desktop;

import com.promanager.promanager.Presentation.Model.ProjetModel.Seances.AffichageSeancesModel;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.AffichageSeances;
import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.AjouterDocumentSeancesProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AffichageSeancesController {
    private Button PrecedentButton;
    private Button AjouterButton;
    private Stage stage;
    private ObjectId idProjet;
    private ObjectId idSeance;

    private Seance Seance;
    private VBox documentListe;

    private Text description;
    private Text note;
    private Text dateFin;
    private Text dateDepart;
    private AffichageSeancesModel model;

    private ArrayList<ObjectId> idsDocuments;

    public AffichageSeancesController(AffichageSeances view, Stage stage, ObjectId idSeance, ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();
        this.AjouterButton = view.getAjouterButton();
        this.idProjet = idProjet;
        this.idSeance = idSeance;

        documentListe = view.getDocumentListe();
        model = new AffichageSeancesModel();

        description = view.getDescription();
        note = view.getNote();
        dateFin = view.getDateFin();
        dateDepart = view.getDateDepart();
        idsDocuments = new ArrayList<>();

        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            Precedent();
        });

        AjouterButton.setOnAction(event -> {
            Ajouter();
        });

        fill();
    }

    private void Precedent() {
        stage.setWidth(1300);
        stage.setHeight(800);
        SeancesProjet AjouterPage = new SeancesProjet(idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    private void Ajouter() {
        stage.setWidth(1300);
        stage.setHeight(800);
        AjouterDocumentSeancesProjet AjouterPage = new AjouterDocumentSeancesProjet(stage, idSeance, idProjet);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void supprimerDocProjet(ObjectId idoc, ObjectId idSeance, ObjectId idProj) {
        ArrayList<ObjectId> listTaches = model.getSeance(idSeance).getListeDocument();
        listTaches.remove(idoc);
        model.updateSeance(idSeance, listTaches);

        AffichageSeances tache = new AffichageSeances(idSeance, idProj, stage);
        Scene projectsScene = new Scene(tache, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    private void fill() {
        Seance = model.getSeance(idSeance);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dateDepart.setText("Date Depart : " + sdf.format(Seance.getDateDepartSeance()));
        dateFin.setText("Date Fin : " + sdf.format(Seance.getDateFinSeance()));
        description.setText("Description : " + Seance.getDescriptionSeance());
        note.setText("Note : "+ Seance.getNote());
        idsDocuments = Seance.getListeDocument();

        if (idsDocuments != null) {
            for (ObjectId idDoc : idsDocuments) {
                Document_ document_ = model.getDocument(idDoc);

                String[] pathDoc = (document_.getPathDocument()).split("/");
                String elemDocument = "Description : " + document_.getDescriptionDocument() + " - Nom : "
                        + pathDoc[pathDoc.length - 1] + " - Date Ajout : " + sdf.format(document_.getDateAjout());

                Label LabelDocument_ = new Label(elemDocument);
                LabelDocument_.setFont(Font.font(25));
                LabelDocument_.setPrefHeight(60);
                LabelDocument_.setPrefWidth(900);
                LabelDocument_.setStyle(
                        "-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: #6a82ab;-fx-opacity:0.5;-fx-text-fill: #FFF;-fx-padding: 20px;-fx-background-radius:20px;-fx-border-radius:20px;");

                Button SupprimerDoc = new Button("Supprimer");

                HBox hbox = new HBox();
                SupprimerDoc.setPrefHeight(60);
                SupprimerDoc.setPrefWidth(200);
                SupprimerDoc.setStyle(
                        "-fx-background-color: #6a82ab; -fx-text-fill: white;-fx-background-radius:20px;-fx-border-radius:20px;-fx-border-color: black; -fx-border-width: 1px;-fx-padding: 20px;-fx-opacity:0.5;");
                SupprimerDoc.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

                LabelDocument_.setOnMouseClicked(event -> {
                    File file = new File(document_.getPathDocument());
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                SupprimerDoc.setOnMouseClicked(event -> {
                    supprimerDocProjet(idDoc, idSeance, idProjet);
                });

                hbox.setSpacing(30);
                hbox.getChildren().addAll(LabelDocument_, SupprimerDoc);
                documentListe.getChildren().add(hbox);
            }
        }
    }
}
