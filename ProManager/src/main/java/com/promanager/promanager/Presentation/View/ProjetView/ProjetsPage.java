package com.promanager.promanager.Presentation.View.ProjetView;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.Controller.ProjetController.ProjetsPageController;

import java.text.SimpleDateFormat;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    private TextField rechercheInput;
    private Button rechercheButton;
    private Button buttonAjouter;
    private Button FiltrerButton;
    private Stage stage;
    private ProjetsPageController controller;
    private ReadOnlyDoubleProperty heightWindow;
    private ReadOnlyDoubleProperty widthWindow;
    private gestionProjet gProjet;
    private String[] FiltrageProj;

    private DAOconfiguration config;

    public ProjetsPage(Stage stage, String Ftype, String Fcategorie) {
        this.stage = stage;
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
        this.rechercheButton = new Button("Rechercher");
        this.FiltrerButton = new Button("Filtrer");
        this.buttonAjouter = new Button("Ajouter Projet");
        this.controller = new ProjetsPageController(this, stage);
        this.heightWindow = stage.heightProperty();
        this.widthWindow = stage.widthProperty();
        FiltrageProj = new String[2];
        this.FiltrageProj[0] = Ftype;
        this.FiltrageProj[1] = Fcategorie;

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

    public Button getButtonAjouter() {
        return buttonAjouter;
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
        this.Projets.setStyle("-fx-background-color: transparent; ");
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
        this.Projets.setOnMouseEntered(event -> {
            this.Projets.setStyle(
                    "-fx-background-color: #6a82ab; ");
        });
        this.Projets.setOnMouseExited(event -> {
            this.Projets.setStyle(
                    "-fx-background-color: transparent; ");
        });

        this.projetsText.setLayoutX(240.0);
        this.projetsText.setLayoutY(96.0);
        this.projetsText.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        this.projetsText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        this.projetsText.setStrokeWidth(0.0);
        this.projetsText.setFont(Font.font("System Bold", FontWeight.BOLD, 44.0));
        this.projetsText.setWrappingWidth(188.78101640354225);

        this.CategorieFilter.setLayoutX(406.0);
        this.CategorieFilter.setLayoutY(72.0);
        this.CategorieFilter.setPrefHeight(26.0);
        this.CategorieFilter.setPrefWidth(130.0);
        this.CategorieFilter.setPromptText("Categorie");
        this.CategorieFilter.setStyle("-fx-background-color: #6a82abcc;");

        this.TypeFilter.setLayoutX(545.0);
        this.TypeFilter.setLayoutY(72.0);
        this.TypeFilter.setPrefHeight(26.0);
        this.TypeFilter.setPrefWidth(108.0);
        this.TypeFilter.setPromptText("Type");
        this.TypeFilter.setStyle("-fx-background-color: #6a82abcc;");

        this.FiltrerButton.setLayoutX(660.0);
        this.FiltrerButton.setLayoutY(72.0);
        this.FiltrerButton.setStyle("-fx-background-color: #6a82ab;");
        this.FiltrerButton.setTextFill(javafx.scene.paint.Color.WHITE);

        this.rechercheInput.setPrefWidth(100);
        this.rechercheInput.setPrefWidth(150.0);
        this.rechercheInput.setLayoutY(72.0);
        this.rechercheInput.setLayoutX(886);
        this.rechercheInput.setStyle("-fx-border-color: #6a82ab; -fx-border-radius: 5; -fx-background-radius: 5;");

        this.rechercheButton.setLayoutX(1030.0);
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

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            rechercheInput.setLayoutX(newVal.doubleValue() - 410);
            rechercheButton.setLayoutX(newVal.doubleValue() - 250);
            buttonAjouter.setLayoutX(newVal.doubleValue() - 150);
        });

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(819.0, 500.0);
        scrollPane.setLayoutX(338.0);
        scrollPane.setLayoutY(171.0);
        scrollPane.setStyle("-fx-background-color: transparent;");

        scrollPane.prefHeightProperty().bind(Bindings.createDoubleBinding(
                () -> 400 + (-800 + heightWindow().get()),
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
        ArrayList<Projet> filterProjets;

        if (!FiltrageProj[0].equals("tout") && !FiltrageProj[1].equals("tout")) {
            filterProjets = listProjets.stream()
                    .filter(project -> project.getTypeProjet().equals(FiltrageProj[0]) &&
                            project.getCategorieProjet().equals(FiltrageProj[1]))
                    .collect(Collectors.toCollection(ArrayList::new));
        } else if (!FiltrageProj[0].equals("tout")) {
            filterProjets = listProjets.stream()
                    .filter(project -> project.getTypeProjet().equals(FiltrageProj[0]))
                    .collect(Collectors.toCollection(ArrayList::new));
        } else if (!FiltrageProj[1].equals("tout")) {
            filterProjets = listProjets.stream()
                    .filter(project -> project.getCategorieProjet().equals(FiltrageProj[1]))
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            filterProjets = new ArrayList<>(listProjets);
        }

        for (Projet proj : filterProjets) {
            Pane elemProjet = new Pane();
            elemProjet.setPrefHeight(100.0);
            elemProjet.setPrefWidth(250.0);
            elemProjet.setMaxHeight(150);
            elemProjet.setMinHeight(130);
            elemProjet.setMaxWidth(250);
            elemProjet.setStyle(
                    "-fx-background-color: #6a82ab88;-fx-border:#000;-fx-background-radius:5;-fx-border-radius:5;");

            VBox vbox = new VBox(5);
            vbox.setPadding(new Insets(10, 0, 0, 30));

            vbox.setLayoutX(-4.0);
            vbox.setPrefHeight(211.0);
            vbox.setPrefWidth(223.0);

            elemProjet.getChildren().add(vbox);
            elemProjet.setPrefHeight(20.0);
            elemProjet.setPrefWidth(20.0);

            Label Nom = new Label(proj.getNomProjet());
            Nom.setStyle("-fx-font-size: 45px; -fx-font-weight: bold;");
            Label Categorie = new Label(proj.getCategorieProjet());
            Label type = new Label(proj.getTypeProjet());
            // Label DateFin = new Label((proj.getDateFinProjet().toString()));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Label DateFin = new Label(sdf.format(proj.getDateFinProjet()));

            Nom.setTextFill(Color.WHITE);
            type.setTextFill(Color.WHITE);
            Categorie.setTextFill(Color.WHITE);
            DateFin.setTextFill(Color.WHITE);

            vbox.getChildren().addAll(Nom, Categorie, type, DateFin);
            gridPane.add(elemProjet, col, row);

            col++;
            if (col == 4) {
                col = 0;
                row++;
            }

            elemProjet.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    ObjectId projectId = proj.getIdProjet();
                    controller.afficherProjet(projectId);
                }
            });
        }

        scrollPane.setContent(gridPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        config.getCategorie();
        CategorieFilter.getItems().add("tout");
        CategorieFilter.getItems().addAll(config.getCategorie());
        TypeFilter.getItems().add("tout");
        TypeFilter.getItems().addAll(config.getType());

        scrollPane.setContent(gridPane);

        getChildren().addAll(sideBar, Projets, Listes, Historiques, Statistiques, projetsText, CategorieFilter,
                TypeFilter, rechercheInput, rechercheButton, buttonAjouter,
                FiltrerButton, scrollPane);
    }
}
