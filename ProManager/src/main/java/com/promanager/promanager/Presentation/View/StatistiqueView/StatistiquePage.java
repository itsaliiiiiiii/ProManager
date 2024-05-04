package com.promanager.promanager.Presentation.View.StatistiqueView;

import java.util.Date;

import com.promanager.promanager.Presentation.Controller.StatistiqueController.StatistiquePageController;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
    private Text titreSemaine;
    private VBox vbox;

    private Stage stage;

    private Text nombreHeuresSemaine;
    private ComboBox<Date> semaine;

    private Text nombreHeuresMois;
    private ComboBox<Date> mois;

    private Text nombreHeuresAnnee;
    private ComboBox<Date> annee;

    public StatistiquePage(Stage stage) {

        this.stage = stage;
        this.sideBar = new Pane();
        this.Projets = new Button("Projets");
        this.Listes = new Button("Listes");
        this.Historiques = new Button("Historiques");
        this.Statistiques = new Button("Statistiques");

        titleStat = new Text("Statistiques");
        titreSemaine = new Text("Seances :");

        semaine = new ComboBox<>();
        nombreHeuresSemaine = new Text();
        mois = new ComboBox<>();
        nombreHeuresMois = new Text();
        annee = new ComboBox<>();
        nombreHeuresAnnee = new Text();

        scroll = new ScrollPane();
        vbox = new VBox();
        controller = new StatistiquePageController(stage, this);

        this.heightWindow = stage.heightProperty();

        design();
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

    public ComboBox<Date> getSemaine() {
        return semaine;
    }

    public Text getNombreHeuresSemaine() {
        return nombreHeuresSemaine;
    }

    public Text getNombreHeuresMois() {
        return nombreHeuresMois;
    }

    public ComboBox<Date> getMois() {
        return mois;
    }

    public Text getNombreHeuresAnnee() {
        return nombreHeuresAnnee;
    }

    public ComboBox<Date> getAnnee() {
        return annee;
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

        titreSemaine.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        titreSemaine.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        titreSemaine.setStrokeWidth(0.0);
        titreSemaine.setFont(Font.font("System Bold", FontWeight.BOLD, 30.0));
        titreSemaine.setWrappingWidth(300);

        this.semaine.setPrefHeight(50.0);
        this.semaine.setPrefWidth(230.0);
        this.semaine.setPromptText("Semaine");
        this.semaine.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.mois.setPrefHeight(50.0);
        this.mois.setPrefWidth(230.0);
        this.mois.setPromptText("Mois");
        this.mois.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.annee.setPrefHeight(50.0);
        this.annee.setPrefWidth(230.0);
        this.annee.setPromptText("Année");
        this.annee.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        nombreHeuresSemaine.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresSemaine.setText("# Heures");
        nombreHeuresSemaine.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresSemaine, new Insets(0, 0, 0, 15));

        nombreHeuresMois.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresMois.setText("# Heures");
        nombreHeuresMois.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresMois, new Insets(0, 0, 0, 15));

        nombreHeuresAnnee.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresAnnee.setText("# Heures");
        nombreHeuresAnnee.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresAnnee, new Insets(0, 0, 0, 15));

        VBox vbox1 = new VBox();
        vbox1.setSpacing(20);
        VBox vbox2 = new VBox();
        vbox2.setSpacing(20);
        VBox vbox3 = new VBox();
        vbox3.setSpacing(20);

        vbox1.getChildren().addAll(semaine, nombreHeuresSemaine);
        vbox2.getChildren().addAll(mois, nombreHeuresMois);
        vbox3.getChildren().addAll(annee, nombreHeuresAnnee);

        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(vbox1, vbox2, vbox3);
        HBox.setMargin(vbox1, new Insets(0, 25, 0, 30));
        HBox.setMargin(vbox2, new Insets(0, 20, 0, 20));
        HBox.setMargin(vbox3, new Insets(0, 30, 0, 25));

        scroll.setLayoutX(330.0);
        scroll.setLayoutY(140.0);
        scroll.setPrefHeight(650.0);
        scroll.setPrefWidth(850.0);
        scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        scroll.setStyle("-fx-background-color:transparent; -fx-background: transparent; -fx-border-color: transparent;");

        vbox.setSpacing(30);
        VBox.setMargin(titreSemaine, new Insets(10, 0, 0, 0));
        vbox.getChildren().addAll(titreSemaine, hbox1);
        scroll.setContent(vbox);

        getChildren().addAll(sideBar, Projets, Listes, Historiques, Statistiques, titleStat,
                scroll);
    }
}
