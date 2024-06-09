package com.promanager.promanager.Presentation.Controller.HistoriqueController.Projets;

import com.promanager.promanager.Metier.POJO.Projet;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.DB.HistoriqueModel.Projets.AffichageHistoriqueModel;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageHistorique;
import com.promanager.promanager.Presentation.View.HistoriqueView.Projets.AffichageProjetHistorique;
import com.promanager.promanager.Presentation.View.ListesView.ListesPage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;

import com.promanager.promanager.Presentation.View.ProjetView.ProjetsPage;
import com.promanager.promanager.Presentation.View.StatistiqueView.StatistiquePage;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AffichageHistoriqueController {

    private Button buttonProjets;
    private Button buttonListe;
    private Button buttonStat;
    private Stage stage;
    private GridPane gridPane;
    private ArrayList<Projet> filterProjets_;
    private ArrayList<Projet> filterProjets;
    private ComboBox<String> CategorieFilter;
    private ComboBox<String> TypeFilter;
    private Button rechercheButton;
    private TextField rechercheInput;
    private ComboBox<String> Trier;
    private AffichageHistoriqueModel model;
    private DAOconfiguration config;


    public AffichageHistoriqueController(AffichageHistorique view, Stage stage) {
        this.gridPane = view.getGridPane();
        this.CategorieFilter=view.getCategorieFilter();
        this.TypeFilter=view.getTypeFilter();
        this.stage = stage;
        this.buttonProjets = view.getProjets();
        this.buttonListe = view.getListes();
        buttonStat = view.getStatistiques();
        filterProjets_ = new ArrayList<>();
        filterProjets = new ArrayList<>();
        TypeFilter = view.getTypeFilter();
        rechercheButton = view.getRechercheButton();
        rechercheInput=view.getRechercheInput();
        model = new AffichageHistoriqueModel();
        Trier = view.getTrier();
        this.config = new DAOconfiguration();


        CategorieFilter.getItems().add("tout");
        CategorieFilter.getItems().addAll(config.getCategorie());
        TypeFilter.getItems().add("tout");
        TypeFilter.getItems().addAll(config.getType());
        Trier.getItems().addAll("Nom", "Date Depart", "Date Fin");


        this.buttonProjets.setOnAction(event -> {
            this.openProjetsPage();
        });

        this.buttonListe.setOnAction(event -> {
            this.openListesPage();
        });

        this.buttonStat.setOnAction(event -> {
            this.openStatisticPage();
        });


        fill();
        actualiserPage();
    };

    private void openStatisticPage() {
        StatistiquePage Listespage = new StatistiquePage(stage);
        Scene projectsScene = new Scene(Listespage, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    public void afficherProjet(ObjectId id) {
        stage.setWidth(1300);
        stage.setHeight(800);
        AffichageProjetHistorique historiquePage = new AffichageProjetHistorique(id, stage);
        Parent root = historiquePage;
        Scene projectsScene = new Scene(root, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    private void openProjetsPage() {
        ProjetsPage projetsPage = new ProjetsPage(stage);
        Parent projetsRoot = projetsPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    private void openListesPage() {
        ListesPage Listespage = new ListesPage(stage);
        Scene projectsScene = new Scene(Listespage, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    public void fill() {
        for (int i = 0; i < 4; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
            column.setMinWidth(10.0);
            column.setPrefWidth(100.0);
            gridPane.getColumnConstraints().add(column);
        }

        ArrayList<Projet> listProjets = model.getAllProjets();
        int numRows = (int) Math.ceil((double) listProjets.size() / 4);
        for (int i = 0; i < numRows; i++) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(200.0);
            row.setPrefHeight(30.0);
            row.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
            gridPane.getRowConstraints().add(row);
        }
        filterProjets_ = listProjets.stream()
                .filter(project -> project.getStatus().equals("Termine"))
                .collect(Collectors.toCollection(ArrayList::new));

        if (CategorieFilter.getValue() == null || TypeFilter.getValue() == null) {
            filterProjets = new ArrayList<>(filterProjets_);
        }

        rechercheButton.setOnAction(event -> {
            filterProjets_ = listProjets.stream()
                    .filter(project -> project.getStatus().equals("Termine"))
                    .collect(Collectors.toCollection(ArrayList::new));
            filterProjets = filterProjets_.stream()
                    .filter(project -> project.getDescriptionProjet().contains(rechercheInput.getText()))
                    .collect(Collectors.toCollection(ArrayList::new));
            filterProjets_ = new ArrayList<>(filterProjets);
            CategorieFilter.setValue("tout");
            TypeFilter.setValue("tout");

            filtrerProj();
            actualiserPage();
        });

        CategorieFilter.setOnAction(event -> {
            filtrerProj();
            actualiserPage();
        });

        TypeFilter.setOnAction(event -> {
            filtrerProj();
            actualiserPage();
        });

        Trier.setOnAction(event -> {
            String Sort = Trier.getValue();
            if (Sort != null) {
                switch (Sort) {
                    case "Nom":
                        filterProjets.sort(Comparator.comparing(Projet::getNomProjet));
                        break;
                    case "Date Depart":
                        filterProjets.sort(Comparator.comparing(Projet::getDateDepartProjet));
                        break;
                    case "Date Fin":
                        filterProjets.sort(Comparator.comparing(Projet::getDateFinProjet));
                        break;
                    default:
                        break;
                }
                actualiserPage();
            }
        });

    }

    private void actualiserPage() {
        int row = 0;
        int col = 0;
        gridPane.getChildren().clear();
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
            vbox.setPrefHeight(100.0);
            vbox.setPrefWidth(223.0);

            elemProjet.getChildren().add(vbox);
            elemProjet.setPrefHeight(20.0);
            elemProjet.setPrefWidth(20.0);

            Label Nom = new Label(proj.getNomProjet());
            Nom.setStyle("-fx-font-size: 45px; -fx-font-weight: bold;");
            Label Categorie = new Label(proj.getCategorieProjet());
            Label type = new Label(proj.getTypeProjet());
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
                    afficherProjet(projectId);
                }
            });
        }
    }
    private void filtrerProj() {
        String categorieFilterValue = CategorieFilter.getValue();
        String typeFilterValue = TypeFilter.getValue();

        if (("tout".equals(categorieFilterValue) && "tout".equals(typeFilterValue))
                || (categorieFilterValue == null && typeFilterValue == null)
                || (categorieFilterValue == null && "tout".equals(typeFilterValue))
                || ("tout".equals(categorieFilterValue) && typeFilterValue == null)) {
            filterProjets = new ArrayList<>(filterProjets_);
        } else if (!"tout".equals(categorieFilterValue) && categorieFilterValue != null
                && ("tout".equals(typeFilterValue) || typeFilterValue == null)) {
            filterProjets = filterProjets_.stream()
                    .filter(project -> categorieFilterValue.equals(project.getCategorieProjet()))
                    .collect(Collectors.toCollection(ArrayList::new));
        } else if (!"tout".equals(typeFilterValue) && typeFilterValue != null
                && ("tout".equals(categorieFilterValue) || categorieFilterValue == null)) {
            filterProjets = filterProjets_.stream()
                    .filter(project -> typeFilterValue.equals(project.getTypeProjet()))
                    .collect(Collectors.toCollection(ArrayList::new));
        } else if (categorieFilterValue != null && typeFilterValue != null) {
            filterProjets = filterProjets_.stream()
                    .filter(project -> typeFilterValue.equals(project.getTypeProjet()))
                    .filter(project -> categorieFilterValue.equals(project.getCategorieProjet()))
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }
}