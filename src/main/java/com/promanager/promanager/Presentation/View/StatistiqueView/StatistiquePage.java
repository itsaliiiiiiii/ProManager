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
    private VBox vbox;

    private Stage stage;

    private Text titreSemaine;

    private Text nombreHeuresSemaine;
    private ComboBox<Date> semaine;

    private Text nombreHeuresMois;
    private ComboBox<Date> mois;

    private Text nombreHeuresAnnee;
    private ComboBox<Date> annee;

    private Text titreCategorieEncadrement;

    private Text nombreHeuresSemaineCategorieEncadrement;
    private ComboBox<Date> semaineCategorieEncadrement;

    private Text nombreHeuresMoisCategorieEncadrement;
    private ComboBox<Date> moisCategorieEncadrement;

    private Text nombreHeuresAnneeCategorieEncadrement;
    private ComboBox<Date> anneeCategorieEncadrement;

    private Text titreCategorieEnseignement;

    private Text nombreHeuresSemaineCategorieEnseignement;
    private ComboBox<Date> semaineCategorieEnseignement;

    private Text nombreHeuresMoisCategorieEnseignement;
    private ComboBox<Date> moisCategorieEnseignement;

    private Text nombreHeuresAnneeCategorieEnseignement;
    private ComboBox<Date> anneeCategorieEnseignement;


    private Text titreTypePFA;

    private Text nombreHeuresSemaineTypePFA;
    private ComboBox<Date> semaineTypePFA;

    private Text nombreHeuresMoisTypePFA;
    private ComboBox<Date> moisTypePFA;

    private Text nombreHeuresAnneeTypePFA;
    private ComboBox<Date> anneeTypePFA;

    private Text titreTypePFE;

    private Text nombreHeuresSemaineTypePFE;
    private ComboBox<Date> semaineTypePFE;

    private Text nombreHeuresMoisTypePFE;
    private ComboBox<Date> moisTypePFE;

    private Text nombreHeuresAnneeTypePFE;
    private ComboBox<Date> anneeTypePFE;

    private Text titreTypeCours;

    private Text nombreHeuresSemaineTypeCours;
    private ComboBox<Date> semaineTypeCours;

    private Text nombreHeuresMoisTypeCours;
    private ComboBox<Date> moisTypeCours;

    private Text nombreHeuresAnneeTypeCours;
    private ComboBox<Date> anneeTypeCours;

    private Text titreTypeExam;

    private Text nombreHeuresSemaineTypeExam;
    private ComboBox<Date> semaineTypeExam;

    private Text nombreHeuresMoisTypeExam;
    private ComboBox<Date> moisTypeExam;

    private Text nombreHeuresAnneeTypeExam;
    private ComboBox<Date> anneeTypeExam;

    public StatistiquePage(Stage stage) {

        this.stage = stage;
        this.sideBar = new Pane();
        this.Projets = new Button("Projets");
        this.Listes = new Button("Listes");
        this.Historiques = new Button("Historiques");
        this.Statistiques = new Button("Statistiques");

        titleStat = new Text("Statistiques");
        titreSemaine = new Text("Seances :");
        titreCategorieEncadrement = new Text("Categorie : Encadrement");
        titreCategorieEnseignement = new Text("Categorie : Enseignement");
        titreTypePFA = new Text("Type : PFA");
        titreTypePFE = new Text("Type : PFE");
        titreTypeCours = new Text("Type : Cours");
        titreTypeExam = new Text("Type : Exam");

        semaine = new ComboBox<>();
        nombreHeuresSemaine = new Text();
        mois = new ComboBox<>();
        nombreHeuresMois = new Text();
        annee = new ComboBox<>();
        nombreHeuresAnnee = new Text();

        semaineCategorieEncadrement = new ComboBox<>();
        nombreHeuresSemaineCategorieEncadrement = new Text();
        moisCategorieEncadrement = new ComboBox<>();
        nombreHeuresMoisCategorieEncadrement = new Text();
        anneeCategorieEncadrement = new ComboBox<>();
        nombreHeuresAnneeCategorieEncadrement = new Text();

        semaineCategorieEncadrement = new ComboBox<>();
        nombreHeuresSemaineCategorieEncadrement = new Text();
        moisCategorieEncadrement = new ComboBox<>();
        nombreHeuresMoisCategorieEncadrement = new Text();
        anneeCategorieEncadrement = new ComboBox<>();
        nombreHeuresAnneeCategorieEncadrement = new Text();

        semaineCategorieEnseignement = new ComboBox<>();
        nombreHeuresSemaineCategorieEnseignement = new Text();
        moisCategorieEnseignement = new ComboBox<>();
        nombreHeuresMoisCategorieEnseignement = new Text();
        anneeCategorieEnseignement = new ComboBox<>();
        nombreHeuresAnneeCategorieEnseignement = new Text();

        semaineTypePFA = new ComboBox<>();
        nombreHeuresSemaineTypePFA = new Text();
        moisTypePFA = new ComboBox<>();
        nombreHeuresMoisTypePFA = new Text();
        anneeTypePFA = new ComboBox<>();
        nombreHeuresAnneeTypePFA = new Text();

        semaineTypePFE = new ComboBox<>();
        nombreHeuresSemaineTypePFE = new Text();
        moisTypePFE = new ComboBox<>();
        nombreHeuresMoisTypePFE = new Text();
        anneeTypePFE = new ComboBox<>();
        nombreHeuresAnneeTypePFE = new Text();

        semaineTypeCours = new ComboBox<>();
        nombreHeuresSemaineTypeCours = new Text();
        moisTypeCours = new ComboBox<>();
        nombreHeuresMoisTypeCours = new Text();
        anneeTypeCours = new ComboBox<>();
        nombreHeuresAnneeTypeCours = new Text();

        semaineTypeExam = new ComboBox<>();
        nombreHeuresSemaineTypeExam = new Text();
        moisTypeExam = new ComboBox<>();
        nombreHeuresMoisTypeExam = new Text();
        anneeTypeExam = new ComboBox<>();
        nombreHeuresAnneeTypeExam = new Text();

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

    public Text getNombreHeuresSemaineCategorieEncadrement() {
        return nombreHeuresSemaineCategorieEncadrement;
    }

    public ComboBox<Date> getSemaineCategorieEncadrement() {
        return semaineCategorieEncadrement;
    }

    public Text getNombreHeuresSemaineCategorieEnseignement() {
        return nombreHeuresSemaineCategorieEnseignement;
    }

    public ComboBox<Date> getSemaineCategorieEnseignement() {
        return semaineCategorieEnseignement;
    }

    public Text getNombreHeuresMoisCategorieEnseignement() {
        return nombreHeuresMoisCategorieEnseignement;
    }

    public ComboBox<Date> getMoisCategorieEnseignement() {
        return moisCategorieEnseignement;
    }

    public Text getNombreHeuresAnneeCategorieEnseignement() {
        return nombreHeuresAnneeCategorieEnseignement;
    }

    public ComboBox<Date> getAnneeCategorieEnseignement() {
        return anneeCategorieEnseignement;
    }

    public Text getNombreHeuresMoisCategorieEncadrement() {
        return nombreHeuresMoisCategorieEncadrement;
    }

    public ComboBox<Date> getMoisCategorieEncadrement() {
        return moisCategorieEncadrement;
    }

    public Text getNombreHeuresAnneeCategorieEncadrement() {
        return nombreHeuresAnneeCategorieEncadrement;
    }

    public ComboBox<Date> getAnneeCategorieEncadrement() {
        return anneeCategorieEncadrement;
    }

    public Text getNombreHeuresSemaineTypeCours() {
        return nombreHeuresSemaineTypeCours;
    }

    public ComboBox<Date> getSemaineTypeCours() {
        return semaineTypeCours;
    }

    public Text getNombreHeuresMoisTypeCours() {
        return nombreHeuresMoisTypeCours;
    }

    public ComboBox<Date> getMoisTypeCours() {
        return moisTypeCours;
    }

    public Text getNombreHeuresAnneeTypeCours() {
        return nombreHeuresAnneeTypeCours;
    }

    public ComboBox<Date> getAnneeTypeCours() {
        return anneeTypeCours;
    }

    public Button getHistoriques() {
        return Historiques;
    }

    public Text getNombreHeuresSemaineTypePFE() {
        return nombreHeuresSemaineTypePFE;
    }

    public ComboBox<Date> getSemaineTypePFE() {
        return semaineTypePFE;
    }

    public Text getNombreHeuresMoisTypePFE() {
        return nombreHeuresMoisTypePFE;
    }

    public ComboBox<Date> getMoisTypePFE() {
        return moisTypePFE;
    }

    public Text getNombreHeuresAnneeTypePFE() {
        return nombreHeuresAnneeTypePFE;
    }

    public ComboBox<Date> getAnneeTypePFE() {
        return anneeTypePFE;
    }

    public Text getTitreTypeExam() {
        return titreTypeExam;
    }

    public Text getNombreHeuresSemaineTypeExam() {
        return nombreHeuresSemaineTypeExam;
    }

    public ComboBox<Date> getSemaineTypeExam() {
        return semaineTypeExam;
    }

    public Text getNombreHeuresMoisTypeExam() {
        return nombreHeuresMoisTypeExam;
    }

    public ComboBox<Date> getMoisTypeExam() {
        return moisTypeExam;
    }

    public Text getNombreHeuresAnneeTypeExam() {
        return nombreHeuresAnneeTypeExam;
    }

    public ComboBox<Date> getAnneeTypeExam() {
        return anneeTypeExam;
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

    public Text getNombreHeuresSemaineTypePFA() {
        return nombreHeuresSemaineTypePFA;
    }

    public ComboBox<Date> getSemaineTypePFA() {
        return semaineTypePFA;
    }

    public Text getNombreHeuresMoisTypePFA() {
        return nombreHeuresMoisTypePFA;
    }

    public ComboBox<Date> getMoisTypePFA() {
        return moisTypePFA;
    }

    public Text getNombreHeuresAnneeTypePFA() {
        return nombreHeuresAnneeTypePFA;
    }

    public ComboBox<Date> getAnneeTypePFA() {
        return anneeTypePFA;
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

        // ------------------
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

        titreCategorieEncadrement.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        titreCategorieEncadrement.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        titreCategorieEncadrement.setStrokeWidth(0.0);
        titreCategorieEncadrement.setFont(Font.font("System Bold", FontWeight.BOLD, 30.0));
        // titreCategorieEncadrement.setWrappingWidth(300);

        this.semaineCategorieEncadrement.setPrefHeight(50.0);
        this.semaineCategorieEncadrement.setPrefWidth(230.0);
        this.semaineCategorieEncadrement.setPromptText("Semaine");
        this.semaineCategorieEncadrement.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.moisCategorieEncadrement.setPrefHeight(50.0);
        this.moisCategorieEncadrement.setPrefWidth(230.0);
        this.moisCategorieEncadrement.setPromptText("Mois");
        this.moisCategorieEncadrement.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.anneeCategorieEncadrement.setPrefHeight(50.0);
        this.anneeCategorieEncadrement.setPrefWidth(230.0);
        this.anneeCategorieEncadrement.setPromptText("Année");
        this.anneeCategorieEncadrement.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        nombreHeuresSemaineCategorieEncadrement.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresSemaineCategorieEncadrement.setText("# %");
        nombreHeuresSemaineCategorieEncadrement.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresSemaineCategorieEncadrement, new Insets(0, 0, 0, 15));

        nombreHeuresMoisCategorieEncadrement.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresMoisCategorieEncadrement.setText("# %");
        nombreHeuresMoisCategorieEncadrement.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresMoisCategorieEncadrement, new Insets(0, 0, 0, 15));

        nombreHeuresAnneeCategorieEncadrement.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresAnneeCategorieEncadrement.setText("# %");
        nombreHeuresAnneeCategorieEncadrement.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresAnneeCategorieEncadrement, new Insets(0, 0, 0, 15));

        VBox vbox4 = new VBox();
        vbox4.setSpacing(20);
        VBox vbox5 = new VBox();
        vbox5.setSpacing(20);
        VBox vbox6 = new VBox();
        vbox6.setSpacing(20);

        vbox4.getChildren().addAll(semaineCategorieEncadrement, nombreHeuresSemaineCategorieEncadrement);
        vbox5.getChildren().addAll(moisCategorieEncadrement, nombreHeuresMoisCategorieEncadrement);
        vbox6.getChildren().addAll(anneeCategorieEncadrement, nombreHeuresAnneeCategorieEncadrement);

        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(vbox4, vbox5, vbox6);
        HBox.setMargin(vbox4, new Insets(0, 25, 0, 30));
        HBox.setMargin(vbox5, new Insets(0, 20, 0, 20));
        HBox.setMargin(vbox6, new Insets(0, 30, 0, 25));
        // ------------------
        titreCategorieEnseignement.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        titreCategorieEnseignement.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        titreCategorieEnseignement.setStrokeWidth(0.0);
        titreCategorieEnseignement.setFont(Font.font("System Bold", FontWeight.BOLD, 30.0));
        // titreCategorieEnseignement.setWrappingWidth(300);

        this.semaineCategorieEnseignement.setPrefHeight(50.0);
        this.semaineCategorieEnseignement.setPrefWidth(230.0);
        this.semaineCategorieEnseignement.setPromptText("Semaine");
        this.semaineCategorieEnseignement.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.moisCategorieEnseignement.setPrefHeight(50.0);
        this.moisCategorieEnseignement.setPrefWidth(230.0);
        this.moisCategorieEnseignement.setPromptText("Mois");
        this.moisCategorieEnseignement.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.anneeCategorieEnseignement.setPrefHeight(50.0);
        this.anneeCategorieEnseignement.setPrefWidth(230.0);
        this.anneeCategorieEnseignement.setPromptText("Année");
        this.anneeCategorieEnseignement.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        nombreHeuresSemaineCategorieEnseignement.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresSemaineCategorieEnseignement.setText("# %");
        nombreHeuresSemaineCategorieEnseignement.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresSemaineCategorieEnseignement, new Insets(0, 0, 0, 15));

        nombreHeuresMoisCategorieEnseignement.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresMoisCategorieEnseignement.setText("# %");
        nombreHeuresMoisCategorieEnseignement.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresMoisCategorieEnseignement, new Insets(0, 0, 0, 15));

        nombreHeuresAnneeCategorieEnseignement.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresAnneeCategorieEnseignement.setText("# %");
        nombreHeuresAnneeCategorieEnseignement.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresAnneeCategorieEnseignement, new Insets(0, 0, 0, 15));

        VBox vbox7 = new VBox();
        vbox7.setSpacing(20);
        VBox vbox8 = new VBox();
        vbox8.setSpacing(20);
        VBox vbox9 = new VBox();
        vbox9.setSpacing(20);

        vbox7.getChildren().addAll(semaineCategorieEnseignement, nombreHeuresSemaineCategorieEnseignement);
        vbox8.getChildren().addAll(moisCategorieEnseignement, nombreHeuresMoisCategorieEnseignement);
        vbox9.getChildren().addAll(anneeCategorieEnseignement, nombreHeuresAnneeCategorieEnseignement);

        HBox hbox3 = new HBox();
        hbox3.getChildren().addAll(vbox7, vbox8, vbox9);
        HBox.setMargin(vbox7, new Insets(0, 25, 0, 30));
        HBox.setMargin(vbox8, new Insets(0, 20, 0, 20));
        HBox.setMargin(vbox9, new Insets(0, 30, 0, 25));
        // ------------------
        titreTypePFA.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        titreTypePFA.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        titreTypePFA.setStrokeWidth(0.0);
        titreTypePFA.setFont(Font.font("System Bold", FontWeight.BOLD, 30.0));
        // titreTypePFA.setWrappingWidth(300);

        this.semaineTypePFA.setPrefHeight(50.0);
        this.semaineTypePFA.setPrefWidth(230.0);
        this.semaineTypePFA.setPromptText("Semaine");
        this.semaineTypePFA.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.moisTypePFA.setPrefHeight(50.0);
        this.moisTypePFA.setPrefWidth(230.0);
        this.moisTypePFA.setPromptText("Mois");
        this.moisTypePFA.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.anneeTypePFA.setPrefHeight(50.0);
        this.anneeTypePFA.setPrefWidth(230.0);
        this.anneeTypePFA.setPromptText("Année");
        this.anneeTypePFA.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        nombreHeuresSemaineTypePFA.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresSemaineTypePFA.setText("# %");
        nombreHeuresSemaineTypePFA.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresSemaineTypePFA, new Insets(0, 0, 0, 15));

        nombreHeuresMoisTypePFA.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresMoisTypePFA.setText("# %");
        nombreHeuresMoisTypePFA.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresMoisTypePFA, new Insets(0, 0, 0, 15));

        nombreHeuresAnneeTypePFA.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresAnneeTypePFA.setText("# %");
        nombreHeuresAnneeTypePFA.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresAnneeTypePFA, new Insets(0, 0, 0, 15));

        VBox vbox10 = new VBox();
        vbox10.setSpacing(20);
        VBox vbox11 = new VBox();
        vbox11.setSpacing(20);
        VBox vbox12 = new VBox();
        vbox12.setSpacing(20);

        vbox10.getChildren().addAll(semaineTypePFA, nombreHeuresSemaineTypePFA);
        vbox11.getChildren().addAll(moisTypePFA, nombreHeuresMoisTypePFA);
        vbox12.getChildren().addAll(anneeTypePFA, nombreHeuresAnneeTypePFA);

        HBox hbox4 = new HBox();
        hbox4.getChildren().addAll(vbox10, vbox11, vbox12);
        HBox.setMargin(vbox10, new Insets(0, 25, 0, 30));
        HBox.setMargin(vbox11, new Insets(0, 20, 0, 20));
        HBox.setMargin(vbox12, new Insets(0, 30, 0, 25));
        // ------------------
        titreTypePFE.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        titreTypePFE.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        titreTypePFE.setStrokeWidth(0.0);
        titreTypePFE.setFont(Font.font("System Bold", FontWeight.BOLD, 30.0));
        // titreTypePFE.setWrappingWidth(300);

        this.semaineTypePFE.setPrefHeight(50.0);
        this.semaineTypePFE.setPrefWidth(230.0);
        this.semaineTypePFE.setPromptText("Semaine");
        this.semaineTypePFE.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.moisTypePFE.setPrefHeight(50.0);
        this.moisTypePFE.setPrefWidth(230.0);
        this.moisTypePFE.setPromptText("Mois");
        this.moisTypePFE.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.anneeTypePFE.setPrefHeight(50.0);
        this.anneeTypePFE.setPrefWidth(230.0);
        this.anneeTypePFE.setPromptText("Année");
        this.anneeTypePFE.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        nombreHeuresSemaineTypePFE.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresSemaineTypePFE.setText("# %");
        nombreHeuresSemaineTypePFE.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresSemaineTypePFE, new Insets(0, 0, 0, 15));

        nombreHeuresMoisTypePFE.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresMoisTypePFE.setText("# %");
        nombreHeuresMoisTypePFE.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresMoisTypePFE, new Insets(0, 0, 0, 15));

        nombreHeuresAnneeTypePFE.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresAnneeTypePFE.setText("# %");
        nombreHeuresAnneeTypePFE.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresAnneeTypePFE, new Insets(0, 0, 0, 15));

        VBox vbox13 = new VBox();
        vbox13.setSpacing(20);
        VBox vbox14 = new VBox();
        vbox14.setSpacing(20);
        VBox vbox15 = new VBox();
        vbox15.setSpacing(20);

        vbox13.getChildren().addAll(semaineTypePFE, nombreHeuresSemaineTypePFE);
        vbox14.getChildren().addAll(moisTypePFE, nombreHeuresMoisTypePFE);
        vbox15.getChildren().addAll(anneeTypePFE, nombreHeuresAnneeTypePFE);

        HBox hbox5 = new HBox();
        hbox5.getChildren().addAll(vbox13, vbox14, vbox15);
        HBox.setMargin(vbox13, new Insets(0, 25, 0, 30));
        HBox.setMargin(vbox14, new Insets(0, 20, 0, 20));
        HBox.setMargin(vbox15, new Insets(0, 30, 0, 25));
        // ------------------
        titreTypeCours.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        titreTypeCours.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        titreTypeCours.setStrokeWidth(0.0);
        titreTypeCours.setFont(Font.font("System Bold", FontWeight.BOLD, 30.0));
        // titreTypeCours.setWrappingWidth(300);

        this.semaineTypeCours.setPrefHeight(50.0);
        this.semaineTypeCours.setPrefWidth(230.0);
        this.semaineTypeCours.setPromptText("Semaine");
        this.semaineTypeCours.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.moisTypeCours.setPrefHeight(50.0);
        this.moisTypeCours.setPrefWidth(230.0);
        this.moisTypeCours.setPromptText("Mois");
        this.moisTypeCours.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.anneeTypeCours.setPrefHeight(50.0);
        this.anneeTypeCours.setPrefWidth(230.0);
        this.anneeTypeCours.setPromptText("Année");
        this.anneeTypeCours.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        nombreHeuresSemaineTypeCours.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresSemaineTypeCours.setText("# %");
        nombreHeuresSemaineTypeCours.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresSemaineTypeCours, new Insets(0, 0, 0, 15));

        nombreHeuresMoisTypeCours.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresMoisTypeCours.setText("# %");
        nombreHeuresMoisTypeCours.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresMoisTypeCours, new Insets(0, 0, 0, 15));

        nombreHeuresAnneeTypeCours.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresAnneeTypeCours.setText("# %");
        nombreHeuresAnneeTypeCours.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresAnneeTypeCours, new Insets(0, 0, 0, 15));

        VBox vbox16 = new VBox();
        vbox16.setSpacing(20);
        VBox vbox17 = new VBox();
        vbox17.setSpacing(20);
        VBox vbox18 = new VBox();
        vbox18.setSpacing(20);

        vbox16.getChildren().addAll(semaineTypeCours, nombreHeuresSemaineTypeCours);
        vbox17.getChildren().addAll(moisTypeCours, nombreHeuresMoisTypeCours);
        vbox18.getChildren().addAll(anneeTypeCours, nombreHeuresAnneeTypeCours);

        HBox hbox6 = new HBox();
        hbox6.getChildren().addAll(vbox16, vbox17, vbox18);
        HBox.setMargin(vbox16, new Insets(0, 25, 0, 30));
        HBox.setMargin(vbox17, new Insets(0, 20, 0, 20));
        HBox.setMargin(vbox18, new Insets(0, 30, 0, 25));
        // ------------------
        titreTypeExam.setFill(javafx.scene.paint.Color.web("#6a82ab"));
        titreTypeExam.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        titreTypeExam.setStrokeWidth(0.0);
        titreTypeExam.setFont(Font.font("System Bold", FontWeight.BOLD, 30.0));
        // titreTypeExam.setWrappingWidth(300);

        this.semaineTypeExam.setPrefHeight(50.0);
        this.semaineTypeExam.setPrefWidth(230.0);
        this.semaineTypeExam.setPromptText("Semaine");
        this.semaineTypeExam.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.moisTypeExam.setPrefHeight(50.0);
        this.moisTypeExam.setPrefWidth(230.0);
        this.moisTypeExam.setPromptText("Mois");
        this.moisTypeExam.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        this.anneeTypeExam.setPrefHeight(50.0);
        this.anneeTypeExam.setPrefWidth(230.0);
        this.anneeTypeExam.setPromptText("Année");
        this.anneeTypeExam.setStyle(
                "-fx-background-color: #6a82ab99;-fx-font-size: 15px;-fx-border-radius: 10px;-fx-background-radius: 10px;");

        nombreHeuresSemaineTypeExam.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresSemaineTypeExam.setText("# %");
        nombreHeuresSemaineTypeExam.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresSemaineTypeExam, new Insets(0, 0, 0, 15));

        nombreHeuresMoisTypeExam.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresMoisTypeExam.setText("# %");
        nombreHeuresMoisTypeExam.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresMoisTypeExam, new Insets(0, 0, 0, 15));

        nombreHeuresAnneeTypeExam.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        nombreHeuresAnneeTypeExam.setText("# %");
        nombreHeuresAnneeTypeExam.setStyle("-fx-fill: #6a82abcc;");
        VBox.setMargin(nombreHeuresAnneeTypeExam, new Insets(0, 0, 0, 15));

        VBox vbox19 = new VBox();
        vbox19.setSpacing(20);
        VBox vbox20 = new VBox();
        vbox20.setSpacing(20);
        VBox vbox21 = new VBox();
        vbox21.setSpacing(20);

        vbox19.getChildren().addAll(semaineTypeExam, nombreHeuresSemaineTypeExam);
        vbox20.getChildren().addAll(moisTypeExam, nombreHeuresMoisTypeExam);
        vbox21.getChildren().addAll(anneeTypeExam, nombreHeuresAnneeTypeExam);

        HBox hbox7 = new HBox();
        hbox7.getChildren().addAll(vbox19, vbox20, vbox21);
        HBox.setMargin(vbox19, new Insets(0, 25, 0, 30));
        HBox.setMargin(vbox20, new Insets(0, 20, 0, 20));
        HBox.setMargin(vbox21, new Insets(0, 30, 0, 25));
        // ------------------
        scroll.setLayoutX(330.0);
        scroll.setLayoutY(140.0);
        scroll.setPrefHeight(650.0);
        scroll.setPrefWidth(1000.0);
        scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        scroll.setStyle(
                "-fx-background-color:transparent; -fx-background: transparent; -fx-border-color: transparent;");

        vbox.setSpacing(30);
        VBox.setMargin(titreSemaine, new Insets(10, 0, 0, 0));
        vbox.getChildren().addAll(titreSemaine, hbox1);
        vbox.getChildren().addAll(titreCategorieEncadrement, hbox2);
        vbox.getChildren().addAll(titreCategorieEnseignement, hbox3);
        vbox.getChildren().addAll(titreTypePFA, hbox4);
        vbox.getChildren().addAll(titreTypePFE, hbox5);
        vbox.getChildren().addAll(titreTypeCours, hbox6);
        vbox.getChildren().addAll(titreTypeExam, hbox7);
        scroll.setContent(vbox);

        

        getChildren().addAll(sideBar, Projets, Listes, Historiques, Statistiques, titleStat,
                scroll);
    }
}
