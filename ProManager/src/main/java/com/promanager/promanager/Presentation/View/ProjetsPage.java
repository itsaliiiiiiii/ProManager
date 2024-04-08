package com.promanager.promanager.Presentation.View;

import java.util.ArrayList;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.Controller.ProjetsPageController;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;

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
    private Button FiltrerButton;
    private Stage stage;
    private ReadOnlyDoubleProperty heightWindow;
    private ReadOnlyDoubleProperty widthWindow;
    private gestionProjet gProjet;

    private DAOconfiguration config;

    public ProjetsPage(Stage stage) {
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
        this.FiltrerButton = new Button();
        this.controller = new ProjetsPageController(this);
        this.stage = stage;
        this.heightWindow = stage.heightProperty();
        this.widthWindow = stage.widthProperty();

        this.config = new DAOconfiguration();
        this.gProjet = new gestionProjet();

        init();
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

    public Button getAjouterProjet() {
        return AjouterProjet;
    }

    public Button getFiltrerButton() {
        return FiltrerButton;
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

    public ReadOnlyDoubleProperty heightWindow() {
        return heightWindow;
    }

    public ReadOnlyDoubleProperty widthWindow() {
        return widthWindow;
    }

    public void init() {
        sideBar = new Pane();
        sideBar.setLayoutX(-29.0);
        sideBar.setLayoutY(0);
        sideBar.setPrefHeight(805.0);
        sideBar.setPrefWidth(240.0);
        sideBar.prefHeightProperty().bind(heightWindow().subtract(25));
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
        TypeFilter.setLayoutX(545.0);
        TypeFilter.setLayoutY(72.0);
        TypeFilter.setPrefHeight(26.0);
        TypeFilter.setPrefWidth(108.0);
        TypeFilter.setPromptText("Type");
        TypeFilter.setStyle("-fx-background-color: #6a82abcc;");

        FiltrerButton = new Button("Filtrer");
        FiltrerButton.setLayoutX(660.0);
        FiltrerButton.setLayoutY(72.0);
        FiltrerButton.setStyle("-fx-background-color: #6a82ab;");
        FiltrerButton.setTextFill(javafx.scene.paint.Color.WHITE);

        rechercheInput = new TextField();
        rechercheInput.setPrefWidth(100);
        rechercheInput.setPrefWidth(150.0);
        rechercheInput.setLayoutY(72.0);
        rechercheInput.setLayoutX(886);
        rechercheInput.setStyle("-fx-border-color: #6a82ab; -fx-border-radius: 5; -fx-background-radius: 5;");

        rechercheButton = new Button("Rechercher");
        rechercheButton.setLayoutX(1030.0);
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

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            rechercheInput.setLayoutX(newVal.doubleValue() - 410);
            rechercheButton.setLayoutX(newVal.doubleValue() - 250);
            AjouterProjet.setLayoutX(newVal.doubleValue() - 150);
        });

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(819.0, 584.0);
        scrollPane.setLayoutX(338.0);
        scrollPane.setLayoutY(171.0);
        scrollPane.setStyle("-fx-background-color: transparent;");

        scrollPane.prefHeightProperty().bind(Bindings.createDoubleBinding(
                () -> 584 + (-800 + heightWindow().get()),
                heightWindow()));
        scrollPane.prefWidthProperty().bind(Bindings.createDoubleBinding(
                () -> 819 + (-1300 + widthWindow().get()),
                widthWindow()));
        GridPane gridPane = new GridPane();
        gridPane.setPrefWidth(917.0);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.prefHeightProperty().bind(scrollPane.prefHeightProperty());
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        for (int i = 0; i < 4; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
            column.setMinWidth(10.0);
            column.setPrefWidth(100.0);
            gridPane.getColumnConstraints().add(column);
        }

        ArrayList<Projet> listProjets = gProjet.getAll();
        int numRows = (int) Math.ceil((double) listProjets.size() / 4);
        for (int i = 0; i < numRows; i++) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(10.0);
            row.setPrefHeight(30.0);
            row.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }

        scrollPane.setContent(gridPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        int row = 0;
        int col = 0;
        for (Projet proj : listProjets) {
            Pane elemProjet = new Pane();
            elemProjet.setPrefHeight(100.0);
            elemProjet.setPrefWidth(250.0);
            elemProjet.setMaxHeight(150);
            elemProjet.setMaxWidth(250);
            elemProjet.setStyle(
                    "-fx-background-color: #6a82ab88;;");

            VBox vbox = new VBox();
            vbox.setLayoutX(-4.0);
            vbox.setPrefHeight(211.0);
            vbox.setPrefWidth(223.0);

            elemProjet.getChildren().add(vbox);
            elemProjet.setPrefHeight(20.0);
            elemProjet.setPrefWidth(20.0);

            Label Nom = new Label(proj.getNomProjet());
            Label Categorie = new Label(proj.getCategorieProjet());
            Label Description = new Label(proj.getDescriptionProjet());
            Label Type = new Label(proj.getTypeProjet());
            Label DateDepart = new Label((proj.getDateDepartProjet()).toString());
            Label DateFin = new Label((proj.getDateFinProjet().toString()));

            Nom.setTextFill(Color.WHITE);
            Categorie.setTextFill(Color.WHITE);
            Description.setTextFill(Color.WHITE);
            Type.setTextFill(Color.WHITE);
            DateDepart.setTextFill(Color.WHITE);
            DateFin.setTextFill(Color.WHITE);

            vbox.getChildren().addAll(Nom,Categorie, Description, Type, DateDepart, DateFin);

            gridPane.add(elemProjet, col, row);

            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        scrollPane.setContent(gridPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        config.getCategorie();
        CategorieFilter.getItems().add("Tout");
        CategorieFilter.getItems().addAll(config.getCategorie());
        TypeFilter.getItems().add("Tout");
        TypeFilter.getItems().addAll(config.getType());

        scrollPane.setContent(gridPane);

        getChildren().addAll(sideBar, Projets, Listes, Historiques, Statistiques, projetsText, CategorieFilter,
                TypeFilter, rechercheInput, rechercheButton, AjouterProjet,
                FiltrerButton, scrollPane);

    }
}
