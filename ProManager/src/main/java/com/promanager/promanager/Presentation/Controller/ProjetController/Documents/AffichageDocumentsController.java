package com.promanager.promanager.Presentation.Controller.ProjetController.Documents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.awt.Desktop;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Documents.AffichageDocuments;
import com.promanager.promanager.Presentation.View.ProjetView.Documents.AjouterDocumentProjet;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AffichageDocumentsController {
    private Button PrecedentButton;
    private Button AjouterButton;
    private Stage stage;
    private gestionProjet gProjet;
    private Document_ document;
    private gestionDocument gDocument;
    private VBox documentListe;

    private ObjectId idProjet;

    private Text description;
    private Text dateFin;
    private Text dateDepart;

    public AffichageDocumentsController(AffichageDocuments view, Stage stage, ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();
        this.AjouterButton = view.getAjouterButton();
        gProjet = new gestionProjet();
        this.idProjet = idProjet;
        description = view.getDescription();
        dateDepart = view.getDateDepart();
        dateFin = view.getDateFin();
        gDocument = new gestionDocument();
        documentListe = view.getDocumentListe();

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
        AffichageProjet AjouterPage = new AffichageProjet(idProjet, stage);
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
        AjouterDocumentProjet AjouterPage = new AjouterDocumentProjet(stage, idProjet);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void supprimerDocProjet(ObjectId idoc, ObjectId idProj) {
        ArrayList<ObjectId> listDoc = gProjet.get(idProj).getListeDocument();
        listDoc.remove(idoc);
        gProjet.update(idProj, "Documents", listDoc);

        AffichageDocuments root = new AffichageDocuments(idProj, stage);
        Scene projectsScene = new Scene(root, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    private void fill() {
        Projet projet = gProjet.get(idProjet);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        dateDepart.setText("Date Depart : " + sdf.format(projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(projet.getDateFinProjet()));
        description.setText(projet.getDescriptionProjet());
        ArrayList<ObjectId> idsDocuments = projet.getListeDocument();

        if (idsDocuments != null) {
            for (ObjectId idDoc : idsDocuments) {
                document = gDocument.get(idDoc);

                String[] pathDoc = (document.getPathDocument()).split("/");
                String elemDocument = "Description : " + document.getDescriptionDocument() + " - Nom : "
                        + pathDoc[pathDoc.length - 1] + " - Date Ajout : " + sdf.format(document.getDateAjout());

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
                    File file = new File(document.getPathDocument());
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                SupprimerDoc.setOnMouseClicked(event -> {
                    supprimerDocProjet(idDoc, idProjet);
                });

                hbox.setSpacing(30);
                hbox.getChildren().addAll(LabelDocument_, SupprimerDoc);
                documentListe.getChildren().add(hbox);
            }
        }
    }
}
