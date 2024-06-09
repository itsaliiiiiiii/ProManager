package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.Desktop;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.POJO.Document_;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Presentation.DB.ProjetModel.Taches.AffichageTachesModel;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AffichageTaches;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AjouterDocumentTacheProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    private ArrayList<Document_> filterDocuments;

    private Button rechercheButton;
    private TextField rechercheInput;

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
        filterDocuments = new ArrayList<>();
        rechercheButton = view.getRechercheButton();
        rechercheInput = view.getRechercheInput();

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
        fill(model.getDocuTache(idTache));
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

    public void fill(ArrayList<Document_> documents) {

        documentListe.getChildren().clear();

        Tache = model.get_Tache(idTache);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        categorie.setText("Categorie : " + Tache.getCategorieTache());
        dateDepart.setText("Date Depart : " + sdf.format(Tache.getDateDepartTache()));
        dateFin.setText("Date Fin : " + sdf.format(Tache.getDateFinTache()));
        description.setText(Tache.getDescriptionTache());
        
        if (idsDocuments != null) {
            for (Document_ document : documents) {

                String[] pathDoc = (document.getPathDocument()).split("/");
                elemDocument = "Description : " + document.getDescriptionDocument() + " - Nom : "
                        + pathDoc[pathDoc.length - 1] + " - Date Ajout : " + sdf.format(document.getDateAjout());

                Label LabelDocument_ = new Label(elemDocument);
                LabelDocument_.setFont(Font.font(18));
                LabelDocument_.setPrefHeight(40);
                LabelDocument_.setPrefWidth(900);
                LabelDocument_.setStyle(
                        "-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: #6a82ab;-fx-opacity:0.5;-fx-text-fill: #FFF;-fx-padding: 15px;-fx-background-radius:13px;-fx-border-radius:13px;");

                Button SupprimerDoc = new Button("Supprimer");

                HBox hbox = new HBox();
                SupprimerDoc.setPrefHeight(40);
                SupprimerDoc.setPrefWidth(150);
                SupprimerDoc.setStyle(
                        "-fx-background-color: #6a82ab; -fx-text-fill: white;-fx-background-radius:20px;-fx-border-radius:20px;-fx-border-color: black; -fx-border-width: 1px;-fx-padding: 15px;-fx-opacity:0.5;");
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
                    supprimerDocProjet(document.getIdDocument(), idTache, idProjet);
                });
                rechercheButton.setOnAction(event -> {
                    ArrayList<Document_> Documents = new ArrayList<>();
                    Documents = model.getDocuTache(idTache);

                    filterDocuments = Documents.stream()
                            .filter(doc -> doc.getDescriptionDocument().toLowerCase().contains(rechercheInput.getText().toLowerCase()))
                            .collect(Collectors.toCollection(ArrayList::new));
                    fill(filterDocuments);
                });

                hbox.setSpacing(30);
                hbox.getChildren().addAll(LabelDocument_, SupprimerDoc);
                documentListe.getChildren().add(hbox);
            }
        }
    }
}