package com.promanager.promanager.Presentation.Controller.HistoriqueController.Documents;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.promanager.promanager.Presentation.DB.HistoriqueModel.Documents.AffichageDocumentsHistoriqueModel;
import com.promanager.promanager.Presentation.View.HistoriqueView.Documents.AffichageDocumentsHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageProjetHistorique;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Projet;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AffichageDocumentsHistoriqueController {
    private Button PrecedentButton;
    private Stage stage;
    private AffichageDocumentsHistoriqueModel model;
    private ObjectId idProj;
    private VBox documentListe;


    private Text description;
    private Text dateFin;
    private Text dateDepart;

    private Document_ document;

    public AffichageDocumentsHistoriqueController(AffichageDocumentsHistorique view, Stage stage, ObjectId idProjet) {
        this.PrecedentButton = view.getPrecedentButton();
        this.stage = stage;
        this.idProj = idProjet;
        document = new Document_();
        description = view.getDescription();
        dateDepart = view.getDateDepart();
        dateFin = view.getDateFin();
        documentListe = view.getDocumentListe();
        model = new AffichageDocumentsHistoriqueModel();

        PrecedentButton.setOnAction(event -> {
            Precedent();
        });
        fill();
    }
    private void Precedent(){
        stage.setWidth(1300);
            stage.setHeight(800);
            AffichageProjetHistorique AjouterPage = new AffichageProjetHistorique(idProj, stage);
            Scene projectsScene = new Scene(AjouterPage, 1300, 800);
            stage.setScene(projectsScene);
            stage.setTitle("ProManager");
            stage.setResizable(false);
            stage.setMinWidth(1300);
            stage.setMinHeight(800);
            stage.show();
    }

    private void fill() {
        Projet projet = model.getProjet(idProj);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        dateDepart.setText("Date Depart : " + sdf.format(projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(projet.getDateFinProjet()));
        description.setText(projet.getDescriptionProjet());
        ArrayList<ObjectId> idsDocuments = projet.getListeDocument();

        if (idsDocuments != null) {
            for (ObjectId idDoc : idsDocuments) {
                document = model.getDocument(idDoc);

                String[] pathDoc = (document.getPathDocument()).split("/");
                String elemDocument = "Description : " + document.getDescriptionDocument() + " - Nom : "
                        + pathDoc[pathDoc.length - 1] + " - Date Ajout : " + sdf.format(document.getDateAjout());

                Label LabelDocument_ = new Label(elemDocument);
                LabelDocument_.setFont(Font.font(18));
                LabelDocument_.setPrefHeight(40);
                LabelDocument_.setPrefWidth(900);
                LabelDocument_.setStyle(
                        "-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: #6a82ab;-fx-opacity:0.5;-fx-text-fill: #FFF;-fx-padding: 15px;-fx-background-radius:13px;-fx-border-radius:13px;");

                HBox hbox = new HBox();

                LabelDocument_.setOnMouseClicked(event -> {
                    File file = new File(document.getPathDocument());
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
}
