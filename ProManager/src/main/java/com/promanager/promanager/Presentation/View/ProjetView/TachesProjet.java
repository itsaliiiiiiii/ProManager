package com.promanager.promanager.Presentation.View.ProjetView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Presentation.Controller.ProjetController.TachesProjetController;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class TachesProjet extends AnchorPane {
    private ObjectId idProjet;
    private Text nomProjet;
    private Text categorie;
    private Text type;
    private Text dateDepart;
    private TextFlow description;
    private Text dateFin;
    private Button PrecedentButton;
    @SuppressWarnings("unused")
    private TachesProjetController controller;
    private gestionProjet gProjet;
    private Projet Projet;
    private gestionTache gTaches;

    public TachesProjet(ObjectId id, Stage stage) {
        this.idProjet = id;
        nomProjet = new Text("Nom Projet");
        categorie = new Text("Categorie");
        type = new Text("type");
        dateDepart = new Text("Date Depart");
        description = new TextFlow();
        dateFin = new Text("Date Fin");
        PrecedentButton = new Button("Precedent");
        gProjet = new gestionProjet();
        gTaches = new gestionTache();
        Projet = new Projet();
        this.controller = new TachesProjetController(this, stage, idProjet);
        design();
    }

    public ObjectId getIdProjet() {
        return idProjet;
    }

    public Text getNomProjet() {
        return nomProjet;
    }

    public Text getCategorie() {
        return categorie;
    }

    public Text getType() {
        return type;
    }

    public Text getDateDepart() {
        return dateDepart;
    }

    public TextFlow getDescription() {
        return description;
    }

    public Text getDateFin() {
        return dateFin;
    }

    public Button getPrecedentButton() {
        return PrecedentButton;
    }

    private void design() {
        nomProjet.setFill(javafx.scene.paint.Color.valueOf("#6a82ab"));
        nomProjet.setLayoutX(50.0);
        nomProjet.setLayoutY(90.0);
        nomProjet.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

        categorie.setLayoutX(50.0);
        categorie.setLayoutY(140.0);
        categorie.setFont(new Font(20.0));

        type.setLayoutX(50.0);
        type.setLayoutY(190.0);
        type.setFont(new Font(20.0));

        dateDepart.setLayoutX(50.0);
        dateDepart.setLayoutY(240.0);
        dateDepart.setFont(new Font(20.0));

        description.setLayoutX(50.0);
        description.setLayoutY(310.0);
        description.setPrefHeight(400.0);
        description.setPrefWidth(50.0);

        dateFin.setLayoutX(50.0);
        dateFin.setLayoutY(290.0);
        dateFin.setFont(new Font(20.0));

        PrecedentButton.setLayoutX(1100.0);
        PrecedentButton.setLayoutY(50.0);
        PrecedentButton.setPrefWidth(150.0);
        PrecedentButton.setPrefHeight(40.0);
        PrecedentButton.setFont(new Font(18.0));
        PrecedentButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        PrecedentButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        Projet = gProjet.get(idProjet);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        nomProjet.setText("Nom Projet : " + Projet.getNomProjet());
        categorie.setText("Categorie : " + Projet.getCategorieProjet());
        type.setText("Type : " + Projet.getTypeProjet());
        Label desc = new Label(Projet.getDescriptionProjet());
        desc.setFont(new Font(15.0));
        description.getChildren().add(desc);
        dateDepart.setText("Date Depart : " + sdf.format(Projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(Projet.getDateFinProjet()));

        ArrayList<ObjectId> idsTaches = Projet.getListeTaches();
        ScrollPane scroll = new ScrollPane();
        ListView<HBox> listTaches = new ListView<>();
        scroll.setPrefSize(819.0, 600.0);
        scroll.setLayoutX(338.0);
        scroll.setLayoutY(171.0);
        scroll.setStyle("-fx-background-color: transparent;");
        Tache tache = new Tache();
        for (ObjectId idTache : idsTaches) {
            HBox elemTache = new HBox();
            tache = gTaches.get(idTache);
            elemTache.getChildren().addAll(new Label(tache.getCategorieTache()),
                    new Label(sdf.format(tache.getDateDepartTache())), new Label(sdf.format(tache.getDateFinTache())),
                    new Label(tache.getDescriptionTache()));
            listTaches.getItems().add(elemTache);
        }
        scroll.setContent(listTaches);
        getChildren().addAll(
                nomProjet, categorie, type, dateDepart,
                description, dateFin, PrecedentButton, scroll);
    }
}