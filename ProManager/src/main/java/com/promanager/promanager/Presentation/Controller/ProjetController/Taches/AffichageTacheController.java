package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.Desktop;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Presentation.Model.ProjetModel.Taches.AffichageTachesModel;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AffichageTaches;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AjouterDocumentTacheProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AffichageTacheController {
    private Button PrecedentButton;
    private Button AjouterButton;
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
    private AffichageTachesModel model;

    public AffichageTacheController(AffichageTaches view, Stage stage, ObjectId idTache, ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();
        this.AjouterButton = view.getAjouterButton();
        idsDocuments = new ArrayList<>();
        Tache = new Tache();

        categorie = view.getCategorie();
        dateDepart = view.getDateDepart();
        dateFin = view.getDateFin();
        description = view.getDescription();
        documentListe = view.getDocumentListe();
        model = new AffichageTachesModel();

        this.idProjet = idProjet;
        this.idTache = idTache;
        this.stage = stage;

        PrecedentButton.setOnAction(event -> {
            Precedent();
        });

        AjouterButton.setOnAction(event -> {
            ajouter();
        });
        fill();
    }

    public void ajouter() {
        stage.setWidth(1300);
        stage.setHeight(800);
        AjouterDocumentTacheProjet AjouterPage = new AjouterDocumentTacheProjet(stage, idTache, idProjet);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void Precedent() {
        stage.setWidth(1300);
        stage.setHeight(800);
        TachesProjet AjouterPage = new TachesProjet(idProjet, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void supprimerDocProjet(ObjectId idoc, ObjectId idTache, ObjectId idProj) {
        ArrayList<ObjectId> listTaches = model.get_Tache(idTache).getListeDocument();
        System.out.println(listTaches);
        listTaches.remove(idoc);
        System.out.println(listTaches);
        model.updateTache(idTache, listTaches);

        AffichageTaches tache = new AffichageTaches(idTache, idProj, stage);
        Scene projectsScene = new Scene(tache, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
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
                    supprimerDocProjet(idDoc, idTache, idProjet);
                });

                hbox.setSpacing(30);
                hbox.getChildren().addAll(LabelDocument_, SupprimerDoc);
                documentListe.getChildren().add(hbox);
            }
        }
    }
}