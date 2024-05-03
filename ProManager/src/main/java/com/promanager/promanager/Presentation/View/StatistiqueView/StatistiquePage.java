package com.promanager.promanager.Presentation.View.StatistiqueView;

import java.util.Date;

import com.promanager.promanager.Presentation.Controller.StatistiqueController.StatistiquePageController;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class StatistiquePage extends AnchorPane {
    private Pane sideBar;
    private Button Projets;
    private Button Listes;
    private Button Historiques;
    private Button Statistiques;

    private ReadOnlyDoubleProperty heightWindow;
    private StatistiquePageController controller;

    private Text titleStat;
    private ScrollPane scroll;

    private Stage stage;
    private Text nombreHeures;
    private ComboBox<Date> semaine;

    public StatistiquePage(Stage stage) {

        this.stage = stage;
        this.sideBar = new Pane();
        this.Projets = new Button("Projets");
        this.Listes = new Button("Listes");
        this.Historiques = new Button("Historiques");
        this.Statistiques = new Button("Statistiques");

        semaine = new ComboBox<>();
        titleStat = new Text("Statistiques");
        scroll = new ScrollPane();
        nombreHeures = new Text();
        controller = new StatistiquePageController(stage, this);

        this.heightWindow = stage.heightProperty();

        design();
    }

    public ComboBox<Date> getSemaine() {
        return semaine;
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

    public ReadOnlyDoubleProperty heightWindow() {
        return heightWindow;
    }

    public Text getNombreHeures() {
        return nombreHeures;
    }

    private void design() {
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
        this.Statistiques.setStyle("-fx-background-color: #4a628a; ");
        this.Statistiques.setTextFill(javafx.scene.paint.Color.WHITE);
        this.Statistiques.setFont(Font.font("Arial Bold", 31.0));

        this.nombreHeures.setLayoutX(600);
        this.nombreHeures.setLayoutY(600);

        this.semaine.setLayoutX(700);
        this.semaine.setLayoutY(600);

        this.Projets.setOnMouseEntered(event -> {
            this.Projets.setStyle(
                    "-fx-background-color: #6a82ab; ");
        });
        this.Projets.setOnMouseExited(event -> {
            this.Projets.setStyle(
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

        titleStat.setLayoutX(280.0);
        titleStat.setLayoutY(110.0);
        titleStat.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        titleStat.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        titleStat.setStrokeWidth(0.0);
        titleStat.setFont(Font.font("System Bold", FontWeight.BOLD, 50.0));
        titleStat.setWrappingWidth(300);

        scroll.setLayoutX(280.0);
        scroll.setLayoutY(140.0);

        getChildren().addAll(sideBar, Projets, Listes, Historiques, Statistiques, titleStat, nombreHeures, semaine);
    }
}
