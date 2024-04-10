package com.promanager.promanager.Presentation.View.ProjetView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Persistance.DAOtache;
import com.promanager.promanager.Presentation.Controller.ProjetController.TachesProjetController;

import javafx.beans.binding.Bindings;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class TachesProjet extends AnchorPane {
    private ObjectId idProjet;
    private Text nomProjet;
    private Text categorie;
    private Text type;
    private Text dateDepart;
    private TextFlow description;
    private Text dateFin;
    private Button PrecedentButton;
    private Button SupprimerButton;
    private Button AjouterButton;
    private TachesProjetController controller;
    private gestionProjet gProjet;
    private Projet Projet;
    private DAOtache gTaches;
    private Stage stage;
    private Label textTaches;
    private ListView<HBox> listTaches;
    private ArrayList<ObjectId> idsTaches;
    private HBox elemTache;
    private Pane content;
    private Tache tache;
    private Label Desc;
    private Label dateDep;
    private Label dateFin_;
    private Label cat;

    public TachesProjet(ObjectId id, Stage stage) {
        this.idProjet = id;
        nomProjet = new Text("Nom Projet");
        categorie = new Text("Categorie");
        type = new Text("type");
        dateDepart = new Text("Date Depart");
        description = new TextFlow();
        listTaches = new ListView<>();
        dateFin = new Text("Date Fin");
        PrecedentButton = new Button("Precedent");
        AjouterButton = new Button("Ajouter");
        SupprimerButton = new Button("Supprimer");
        gProjet = new gestionProjet();
        gTaches = new DAOtache();
        tache = new Tache();
        Projet = new Projet();
        textTaches = new Label("> Liste Taches");
        idsTaches = new ArrayList<>();
        elemTache = new HBox();
        content = new Pane();
        this.stage = stage;
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

    public Button getSupprimerButton() {
        return SupprimerButton;
    }

    public Button getAjouterButton() {
        return AjouterButton;
    }

    public ListView<HBox> getListTaches() {
        return listTaches;
    }

    private void design() {
        ScrollPane BigScroll = new ScrollPane();
        nomProjet.setFill(javafx.scene.paint.Color.valueOf("#6a82ab"));
        nomProjet.setLayoutX(50.0);
        nomProjet.setLayoutY(90.0);
        nomProjet.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

        textTaches.setStyle(" -fx-text-fill: #6a82ab;");
        textTaches.setLayoutX(50.0);
        textTaches.setLayoutY(340.0);
        textTaches.setFont(Font.font("Arial", FontWeight.BOLD, 30.0));

        categorie.setLayoutX(50.0);
        categorie.setLayoutY(140.0);
        categorie.setFont(new Font(20.0));

        type.setLayoutX(50.0);
        type.setLayoutY(190.0);
        type.setFont(new Font(20.0));

        dateDepart.setLayoutX(50.0);
        dateDepart.setLayoutY(240.0);
        dateDepart.setFont(new Font(20.0));

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

        SupprimerButton.setLayoutX(1100.0);
        SupprimerButton.setLayoutY(340.0);
        SupprimerButton.setPrefWidth(150.0);
        SupprimerButton.setPrefHeight(40.0);
        SupprimerButton.setFont(new Font(18.0));
        SupprimerButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        SupprimerButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        AjouterButton.setLayoutX(930.0);
        AjouterButton.setLayoutY(340.0);
        AjouterButton.setPrefWidth(150.0);
        AjouterButton.setPrefHeight(40.0);
        AjouterButton.setFont(new Font(18.0));
        AjouterButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        AjouterButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        Projet = gProjet.get(idProjet);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        nomProjet.setText("Nom Projet : " + Projet.getNomProjet());
        categorie.setText("Categorie : " + Projet.getCategorieProjet());
        type.setText("Type : " + Projet.getTypeProjet());

        dateDepart.setText("Date Depart : " + sdf.format(Projet.getDateDepartProjet()));
        dateFin.setText("Date Fin : " + sdf.format(Projet.getDateFinProjet()));

        idsTaches = Projet.getListeTaches();
        listTaches = new ListView<>();
        listTaches.setLayoutX(50.0);
        listTaches.setLayoutY(400.0);
        listTaches.setPrefWidth(1200);
        listTaches.setPrefHeight(270);
        listTaches.setStyle(" -fx-selection-bar: #6a82ab;fx-border-color: transparent;-fx-background-color: inherit;");

        for (ObjectId idTache : idsTaches) {
            elemTache = new HBox();
            elemTache.setSpacing(30);
            tache = gTaches.get(idTache);

            cat = new Label("Categorie : " + tache.getCategorieTache());
            cat.setFont(Font.font("Arial", 20));
            dateDep = new Label("Date Depart : " + sdf.format(tache.getDateDepartTache()));
            dateDep.setFont(Font.font("Arial", 20));
            dateFin_ = new Label("Date Fin : " + sdf.format(tache.getDateFinTache()));
            dateFin.setFont(Font.font("Arial", 20));
            Desc = new Label("Description  : " + tache.getDescriptionTache());
            Desc.setFont(Font.font("Arial", 20));

            elemTache.getChildren().addAll(cat, dateDep, dateFin, Desc);
            listTaches.getItems().add(elemTache);
        }
        listTaches.getItems().add(new HBox(new Label("  ")));

        content.getChildren().addAll(nomProjet, categorie, type, dateDepart, dateFin, PrecedentButton, listTaches,
                textTaches,
                AjouterButton, SupprimerButton);

        BigScroll.setContent(content);
        BigScroll.setPrefSize(1300.0, 800.0);

        getChildren().add(BigScroll);
    }
}