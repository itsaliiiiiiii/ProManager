package com.promanager.promanager.Presentation.View;

import com.promanager.promanager.Presentation.Controller.ProjetsPageController;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ProjetsPage extends AnchorPane {
    private AnchorPane background;
    private Pane sideBar;
    private Button Projets;
    private Button Listes;
    private Button Historiques;
    private Button Statistiques;
    private Text projetsText;
    private ComboBox<String> CategorieFilter;
    private ComboBox<String> TypeFilter;
    private ProjetsPageController controller;
    private TextField rechercheInput;
    private Button rechercheButton;
    private Button AjouterProjet;

    public ProjetsPage() {
        this.background = new AnchorPane();
        this.sideBar = new Pane();
        this.Projets = new Button("Projets");
        this.Listes = new Button("Listes");
        this.Historiques = new Button("Historiques");
        this.Statistiques = new Button("Statistiques");
        this.projetsText = new Text("Projets");
        this.CategorieFilter = new ComboBox<>();
        this.TypeFilter = new ComboBox<>();
        this.rechercheInput = new TextField();
        this.rechercheButton = new Button();
        this.controller = new ProjetsPageController(this);

        design();
    }

    public AnchorPane getBack() {
        return background;
    }

    public Pane getSideBar() {
        return sideBar;
    }

    public Button getProjets() {
        return Projets;
    }

    public Button getListes() {
        return Listes;
    }

    public Button getHistoriques() {
        return Historiques;
    }

    public Button getStatistiques() {
        return Statistiques;
    }

    public Text getProjetsText() {
        return projetsText;
    }

    public ComboBox<String> getCategorieFilter() {
        return CategorieFilter;
    }

    public ComboBox<String> getTypeFilter() {
        return TypeFilter;
    }

    public ProjetsPageController getController() {
        return controller;
    }

    public TextField getRechercheInput() {
        return rechercheInput;
    }

    public Button getRechercheButton() {
        return rechercheButton;
    }

    public void design() {
        sideBar = new Pane();
        sideBar.setLayoutX(-29.0);
        sideBar.setLayoutY(-2.0);
        sideBar.setPrefHeight(805.0);
        sideBar.setPrefWidth(240.0);
        sideBar.setStyle(
                "-fx-background-color: #6a82ab; -fx-background-radius: 20; -fx-border-radius: 20; -fx-border-color: black; -fx-opacity:0.8;");

        Projets = new Button("Projets");
        Projets.setLayoutX(0.0);
        Projets.setLayoutY(30.0);
        Projets.setPrefHeight(70.0);
        Projets.setPrefWidth(210.0);
        Projets.setStyle("-fx-background-color: transparent; ");
        Projets.setTextFill(javafx.scene.paint.Color.WHITE);
        Projets.setFont(Font.font("Arial Bold", 31.0));

        Listes = new Button("Listes");
        Listes.setLayoutX(0.0);
        Listes.setLayoutY(100.0);
        Listes.setPrefHeight(70.0);
        Listes.setPrefWidth(210.0);
        Listes.setStyle("-fx-background-color: transparent; ");
        Listes.setTextFill(javafx.scene.paint.Color.WHITE);
        Listes.setFont(Font.font("Arial Bold", 31.0));

        Historiques = new Button("Historiques");
        Historiques.setLayoutX(0.0);
        Historiques.setLayoutY(170.0);
        Historiques.setPrefHeight(70.0);
        Historiques.setPrefWidth(210.0);
        Historiques.setStyle("-fx-background-color: transparent; ");
        Historiques.setTextFill(javafx.scene.paint.Color.WHITE);
        Historiques.setFont(Font.font("Arial Bold", 31.0));

        Statistiques = new Button("Statistiques");
        Statistiques.setLayoutX(0.0);
        Statistiques.setLayoutY(240.0);
        Statistiques.setPrefHeight(70.0);
        Statistiques.setPrefWidth(210.0);
        Statistiques.setStyle("-fx-background-color: transparent; ");
        Statistiques.setTextFill(javafx.scene.paint.Color.WHITE);
        Statistiques.setFont(Font.font("Arial Bold", 31.0));

        this.Statistiques.setOnMouseEntered(event -> {
            this.Statistiques.setStyle(
                    "-fx-background-color: #6a82ab; ");
        });
        this.Statistiques.setOnMouseExited(event -> {
            this.Statistiques.setStyle(
                    "-fx-background-color: transparent; ");
        });
        this.Historiques.setOnMouseEntered(event -> {
            this.Historiques.setStyle(
                    "-fx-background-color: #6a82ab; ");
        });
        this.Historiques.setOnMouseExited(event -> {
            this.Historiques.setStyle(
                    "-fx-background-color: transparent; ");
        });
        this.Listes.setOnMouseEntered(event -> {
            this.Listes.setStyle(
                    "-fx-background-color: #6a82ab; ");
        });
        this.Listes.setOnMouseExited(event -> {
            this.Listes.setStyle(
                    "-fx-background-color: transparent; ");
        });
        this.Projets.setOnMouseEntered(event -> {
            this.Projets.setStyle(
                    "-fx-background-color: #6a82ab; ");
        });
        this.Projets.setOnMouseExited(event -> {
            this.Projets.setStyle(
                    "-fx-background-color: transparent; ");
        });

        projetsText = new Text("Projets");
        projetsText.setLayoutX(240.0);
        projetsText.setLayoutY(96.0);
        projetsText.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        projetsText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        projetsText.setStrokeWidth(0.0);
        projetsText.setFont(Font.font("System Bold", FontWeight.BOLD, 44.0));
        projetsText.setWrappingWidth(188.78101640354225);

        CategorieFilter = new ComboBox<>();
        CategorieFilter.setLayoutX(406.0);
        CategorieFilter.setLayoutY(72.0);
        CategorieFilter.setPrefHeight(26.0);
        CategorieFilter.setPrefWidth(130.0);
        CategorieFilter.setPromptText("Categorie");
        CategorieFilter.setStyle("-fx-background-color: #6a82abcc;");

        TypeFilter = new ComboBox<>();
        TypeFilter.setLayoutX(555.0);
        TypeFilter.setLayoutY(72.0);
        TypeFilter.setPrefHeight(26.0);
        TypeFilter.setPrefWidth(108.0);
        TypeFilter.setPromptText("Type");
        TypeFilter.setStyle("-fx-background-color: #6a82abcc;");

        rechercheInput = new TextField();
        rechercheInput.setLayoutX(876.0);
        rechercheInput.setLayoutY(72.0);
        rechercheInput.setStyle("-fx-border-color: #6a82ab; -fx-border-radius: 5; -fx-background-radius: 5;");

        rechercheButton = new Button("Rechercher");
        rechercheButton.setLayoutX(1040.0);
        rechercheButton.setLayoutY(72.0);
        rechercheButton.setStyle("-fx-background-color: #6a82ab;");
        rechercheButton.setTextFill(javafx.scene.paint.Color.WHITE);

        AjouterProjet = new Button("Ajouter Projet");
        AjouterProjet.setLayoutX(1133.0);
        AjouterProjet.setLayoutY(72.0);
        AjouterProjet.setPrefHeight(26.0);
        AjouterProjet.setPrefWidth(125.0);
        AjouterProjet.setStyle("-fx-background-color: #6a82ab;");
        AjouterProjet.setTextFill(javafx.scene.paint.Color.WHITE);
        AjouterProjet.setFont(Font.font("System Italic", 13.0));

        CategorieFilter.getItems().addAll("Tout","Enseignement", "Encadrement");
        TypeFilter.getItems().addAll("Tout","PFE", "PFA", "Cours", "Exam");

        getChildren().addAll(sideBar, Projets, Listes, Historiques, Statistiques, projetsText, CategorieFilter,
                TypeFilter, rechercheInput, rechercheButton, AjouterProjet);

    }
}
