package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.POJO.Liste;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Presentation.Model.ProjetModel.Taches.AjouterTacheProjetModel;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AjouterTacheProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AjouterTacheProjetController {
    private Button Annule;
    private Button Ajouter;
    private Stage stage;
    private ComboBox<String> comboBoxCategorie;
    private DatePicker PickerDateDepart;
    private DatePicker PickerDateFin;
    private TextArea InputDescription;
    private VBox mainVBox;
    private AjouterTacheProjetModel model;


    private ObjectId idProj;

    public AjouterTacheProjetController(AjouterTacheProjet view, Stage stage, ObjectId idProj) {
        Annule = view.getButtonAnnuler();
        Ajouter = view.getButtonAjouter();
        comboBoxCategorie = view.getComboBoxCategorie();
        PickerDateDepart = view.getPickerDateDepart();
        PickerDateFin = view.getPickerDateFin();
        InputDescription = view.getInputDescription();
        mainVBox = view.getMainVBox();
        model = new AjouterTacheProjetModel();
        // here
        view.setProj(model.getProjet(idProj).getNomProjet());

        this.idProj = idProj;
        this.stage = stage;
        Ajouter.setOnAction(event -> {
            try {
                model.AjouterTacheProjet(
                        idProj, comboBoxCategorie.getSelectionModel().getSelectedItem(), PickerDateDepart.getValue(),
                        PickerDateFin.getValue(),
                        InputDescription.getText());
                Back();
            } catch (ProjetExeption e) {
                e.MessageErreurAjouterProjet();
            }

        });
        Annule.setOnAction(event -> {
            Back();
        });

        fillData();
    }

    private void Back() {
        TachesProjet AjouterPage = new TachesProjet(idProj, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void addTacheToProjet(ObjectId idTache) {
        model.addTacheToprojet(idProj, idTache);
        this.Back();
    }

    private void fillData() {
        for (Liste liste : model.getAllListe()) {
            VBox listeVBox = new VBox(20);

            Text nomListe = new Text(" ~ Liste: " + liste.getNomListe());
            nomListe.setFont(Font.font("Arial", FontWeight.BOLD, 28));
            nomListe.setFill(Color.web("#6a82ab"));

            Text descListeText = new Text("Description: " + liste.getDescriptionListe());
            descListeText.setFont(Font.font(20));
            descListeText.setFill(Color.BLACK);

            VBox tachesVBox = new VBox();
            tachesVBox.setSpacing(5);
            tachesVBox.setStyle("-fx-padding: 0 0 0 50px;");

            for (ObjectId idTache : liste.getListeTache()) {
                Tache tache = model.get_Tache(idTache);
                if (tache != null) {

                    Label tache_ = new Label(
                            "Categorie : " + tache.getCategorieTache() + " - Description : "
                                    + tache.getDescriptionTache());
                    tache_.setFont(Font.font(25));
                    tache_.setPrefHeight(60);
                    tache_.setPrefWidth(1000);
                    tache_.setLayoutX(100);
                    tache_.setStyle(
                            "-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: #6a82ab;-fx-opacity:0.5;-fx-text-fill: #FFF;-fx-padding: 20px;-fx-background-radius:20px;-fx-border-radius:20px;");

                    tache_.setOnMouseClicked(event -> {
                        this.addTacheToProjet(idTache);
                    });
                    tachesVBox.getChildren().add(tache_);
                }
            }

            listeVBox.getChildren().addAll(nomListe, tachesVBox);
            mainVBox.getChildren().add(listeVBox);
        }
    }
}