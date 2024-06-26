package com.promanager.promanager.Presentation.View.ProjetView;

import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.Controller.ProjetController.ProjetsPageController;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProjetsPage extends AnchorPane {
    private Pane sideBar;
    private Button Projets;
    private Button Listes;
    private Button Historiques;
    private Button Statistiques;
    private Text projetsText;
    private ComboBox<String> CategorieFilter;
    private ComboBox<String> Trier;
    private ComboBox<String> TypeFilter;
    private TextField rechercheInput;
    private Button rechercheButton;
    private Button buttonAjouter;
    private Stage stage;
    private ProjetsPageController controller;
    private ReadOnlyDoubleProperty heightWindow;
    private ReadOnlyDoubleProperty widthWindow;

    private GridPane gridPane;

    private DAOconfiguration config;

    public ProjetsPage(Stage stage) {
        this.stage = stage;
        this.sideBar = new Pane();
        this.Projets = new Button("Projets");
        this.Listes = new Button("Listes");
        this.Historiques = new Button("Historiques");
        this.Statistiques = new Button("Statistiques");
        this.projetsText = new Text("Projets");
        this.CategorieFilter = new ComboBox<>();
        this.TypeFilter = new ComboBox<>();
        this.rechercheInput = new TextField();
        this.rechercheButton = new Button("Rechercher");
        this.buttonAjouter = new Button("Ajouter Projet");
        this.gridPane = new GridPane();
        Trier = new ComboBox<>();
        this.controller = new ProjetsPageController(this, stage);
        this.heightWindow = stage.heightProperty();
        this.widthWindow = stage.widthProperty();

        this.config = new DAOconfiguration();
        design();
    }

    public Pane getSideBar() {
        return sideBar;
    }

    public ComboBox<String> getTrier() {
        return Trier;
    }

    public Stage getStage() {
        return stage;
    }

    public ReadOnlyDoubleProperty getHeightWindow() {
        return heightWindow;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public Button getProjets() {
        return Projets;
    }

    public Button getButtonAjouter() {
        return buttonAjouter;
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

    public void design() {
        this.sideBar.setLayoutX(-29.0);
        this.sideBar.setLayoutY(0);
        this.sideBar.setPrefHeight(805.0);
        this.sideBar.setPrefWidth(240.0);
        this.sideBar.prefHeightProperty().bind(heightWindow().subtract(25));
        this.sideBar.setStyle(
                "-fx-background-color: #6a82ab; -fx-background-radius: 20; -fx-border-radius: 20; -fx-border-color: black; -fx-opacity:0.8;");

        this.Projets.setLayoutX(0.0);
        this.Projets.setLayoutY(30.0);
        this.Projets.setPrefHeight(70.0);
        this.Projets.setPrefWidth(210.0);
        this.Projets.setStyle("-fx-background-color: #4a628a; ");
        this.Projets.setTextFill(javafx.scene.paint.Color.WHITE);
        this.Projets.setFont(Font.font("Arial Bold", 31.0));

        this.Listes.setLayoutX(0.0);
        this.Listes.setLayoutY(100.0);
        this.Listes.setPrefHeight(70.0);
        this.Listes.setPrefWidth(210.0);
        this.Listes.setStyle("-fx-background-color: transparent; ");
        this.Listes.setTextFill(javafx.scene.paint.Color.WHITE);
        this.Listes.setFont(Font.font("Arial Bold", 31.0));

        this.Historiques.setLayoutX(0.0);
        this.Historiques.setLayoutY(170.0);
        this.Historiques.setPrefHeight(70.0);
        this.Historiques.setPrefWidth(210.0);
        this.Historiques.setStyle("-fx-background-color: transparent; ");
        this.Historiques.setTextFill(javafx.scene.paint.Color.WHITE);
        this.Historiques.setFont(Font.font("Arial Bold", 31.0));

        this.Statistiques.setLayoutX(0.0);
        this.Statistiques.setLayoutY(240.0);
        this.Statistiques.setPrefHeight(70.0);
        this.Statistiques.setPrefWidth(210.0);
        this.Statistiques.setStyle("-fx-background-color: transparent; ");
        this.Statistiques.setTextFill(javafx.scene.paint.Color.WHITE);
        this.Statistiques.setFont(Font.font("Arial Bold", 31.0));

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

        this.projetsText.setLayoutX(240.0);
        this.projetsText.setLayoutY(96.0);
        this.projetsText.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        this.projetsText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        this.projetsText.setStrokeWidth(0.0);
        this.projetsText.setFont(Font.font("System Bold", FontWeight.BOLD, 44.0));
        this.projetsText.setWrappingWidth(188);

        this.CategorieFilter.setLayoutX(406.0);
        this.CategorieFilter.setLayoutY(72.0);
        this.CategorieFilter.setPrefHeight(26.0);
        this.CategorieFilter.setPrefWidth(130.0);
        this.CategorieFilter.setPromptText("Categorie");
        this.CategorieFilter.setStyle("-fx-background-color: #6a82abcc;");

        this.Trier.setLayoutX(680.0);
        this.Trier.setLayoutY(72.0);
        this.Trier.setPrefHeight(26.0);
        this.Trier.setPrefWidth(130.0);
        this.Trier.setPromptText("Trier");
        this.Trier.setStyle("-fx-background-color: #6a82abcc;");

        this.TypeFilter.setLayoutX(545.0);
        this.TypeFilter.setLayoutY(72.0);
        this.TypeFilter.setPrefHeight(26.0);
        this.TypeFilter.setPrefWidth(108.0);
        this.TypeFilter.setPromptText("Type");
        this.TypeFilter.setStyle("-fx-background-color: #6a82abcc;");

        this.rechercheInput.setPrefWidth(100);
        this.rechercheInput.setPrefWidth(150.0);
        this.rechercheInput.setLayoutY(72.0);
        this.rechercheInput.setLayoutX(886);
        this.rechercheInput.setStyle("-fx-border-color: #6a82ab; -fx-border-radius: 5; -fx-background-radius: 5;");

        this.rechercheButton.setLayoutX(1050);
        this.rechercheButton.setLayoutY(72.0);
        this.rechercheButton.setStyle("-fx-background-color: #6a82ab;");
        this.rechercheButton.setTextFill(javafx.scene.paint.Color.WHITE);

        this.buttonAjouter.setLayoutX(1132.0);
        this.buttonAjouter.setLayoutY(72.0);
        this.buttonAjouter.setMnemonicParsing(false);

        this.buttonAjouter.setPrefHeight(26.0);
        this.buttonAjouter.setPrefWidth(125.0);
        this.buttonAjouter.setStyle("-fx-background-color: #6a82ab;");
        this.buttonAjouter.setTextFill(javafx.scene.paint.Color.WHITE);
        this.buttonAjouter.setFont(Font.font("System", 13.0));
        this.buttonAjouter.setDisable(false);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(1000.0, 600.0);
        scrollPane.setLayoutX(300.0);
        scrollPane.setLayoutY(171.0);
        scrollPane.setStyle("-fx-background-color: transparent;");

        gridPane.setPrefWidth(917.0);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.prefHeightProperty().bind(scrollPane.prefHeightProperty());
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        scrollPane.setContent(gridPane);

        config.getCategorie();
        CategorieFilter.getItems().add("tout");
        CategorieFilter.getItems().addAll(config.getCategorie());
        TypeFilter.getItems().add("tout");
        TypeFilter.getItems().addAll(config.getType());
        Trier.getItems().addAll("Nom", "Date Depart", "Date Fin");

        getChildren().addAll(sideBar, Projets, Listes, Historiques, Statistiques, projetsText, CategorieFilter, Trier,
                TypeFilter, rechercheInput, rechercheButton, buttonAjouter,
                scrollPane);
    }

}