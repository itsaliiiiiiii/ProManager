package com.promanager.promanager.Presentation.View.ProjetView.Taches;

import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.model.TaskList;
import com.google.api.services.tasks.model.TaskLists;
import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Metier.Service.GoogleCalendarAuth;
import com.promanager.promanager.Persistance.DAOconfiguration;
import com.promanager.promanager.Presentation.Controller.ProjetController.Taches.ImporterTacheController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("unused")
public class ImporterTache extends AnchorPane {
    private Button addFromGoogleCalendarButton;
    private ListView<String> calendarEventListView;
    private Stage stage;
    private ImporterTacheController controller;
    private Button AjouterButton;
    private Button AnnulerButton;
    private ObjectId idProjet;
    private ComboBox<String> comboBoxCategorie;
    private Text Categorie;
    private DAOconfiguration config;

    public ImporterTache(Stage stage, ObjectId id) {
        this.addFromGoogleCalendarButton = new Button("Add from Google Calendar");
        this.calendarEventListView = new ListView<>();
        this.controller = new ImporterTacheController(this, stage);
        this.stage = stage;
        this.idProjet = id;
        this.AjouterButton = new Button("Ajouter");
        this.AnnulerButton = new Button("Annuler");
        Categorie = new Text("Categorie : ");
        comboBoxCategorie = new ComboBox<>();
        design();
    }

    public Button getAddFromGoogleCalendarButton() {
        return addFromGoogleCalendarButton;
    }

    public ListView<String> getCalendarEventListView() {
        return calendarEventListView;
    }

    public ImporterTacheController getController() {
        return controller;
    }

    public Button getAjouterButton() {
        return AjouterButton;
    }

    public Button getAnnulerButton() {
        return AnnulerButton;
    }

    public ComboBox<String> getComboBoxCategorie() {
        return comboBoxCategorie;
    }

    public Text getCategorie() {
        return Categorie;
    }

    void design() {
        addFromGoogleCalendarButton.setLayoutX(200);
        addFromGoogleCalendarButton.setLayoutY(300);
        addFromGoogleCalendarButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        addFromGoogleCalendarButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");

        AjouterButton.setLayoutX(1020);
        AjouterButton.setLayoutY(650);
        AjouterButton.setPrefWidth(150.0);
        AjouterButton.setPrefHeight(40.0);
        AjouterButton.setFont(new Font(18.0));
        AjouterButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        AjouterButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        AnnulerButton.setLayoutX(100);
        AnnulerButton.setLayoutY(650);
        AnnulerButton.setPrefWidth(150.0);
        AnnulerButton.setPrefHeight(40.0);
        AnnulerButton.setFont(new Font(18.0));
        AnnulerButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        AnnulerButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        addFromGoogleCalendarButton.setOnMouseClicked(event -> {
            fetchTasksData();
        });
        AnnulerButton.setOnMouseClicked(event -> {
            controller.openTachesProjet(idProjet);
        });

        this.config = new DAOconfiguration();
        config.getCategorie();
        comboBoxCategorie.getItems().addAll(config.getCategorie());

        Categorie.setLayoutX(900);
        Categorie.setLayoutY(260);
        Categorie.setFont(Font.font("Arial", FontWeight.BOLD, 24.0));
        Categorie.setFill(Color.web("#6a82ab"));
        Categorie.setText("Catégorie");

        comboBoxCategorie.setLayoutX(900);
        comboBoxCategorie.setLayoutY(280);
        comboBoxCategorie.setPrefWidth(200);
        comboBoxCategorie.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #546379; -fx-border-radius: 5px;");

        VBox root = new VBox(10);
        root.setLayoutX(200);
        root.setLayoutY(160);
        root.setPrefWidth(650);
        root.setPrefHeight(400);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(this.addFromGoogleCalendarButton, this.calendarEventListView);
        this.getChildren().addAll(root, AjouterButton, AnnulerButton, Categorie, comboBoxCategorie);
    }

    private void fetchTasksData() {
        try {
            Tasks service = GoogleCalendarAuth.getTasksService();

            Tasks.Tasklists.List requestLists = service.tasklists().list();
            TaskLists taskLists = requestLists.execute();
            ArrayList<Tache> Taches = new ArrayList<>();
            calendarEventListView.getItems().clear();
            for (TaskList list : taskLists.getItems()) {
                Tasks.TasksOperations.List requestTasks = service.tasks().list(list.getId());
                com.google.api.services.tasks.model.Tasks tasks = requestTasks.execute();

                for (com.google.api.services.tasks.model.Task task : tasks.getItems()) {

                    String summary = task.getTitle();
                    String description = task.getNotes();
                    String startDate = String.valueOf(task.getDue());
                    String endDate = String.valueOf(task.getDue());

                    Tache t = new Tache(" ", description, controller.parseDate(startDate),
                            controller.parseDate(endDate));
                    Taches.add(t);
                    if (task.getDue() != null && task.getDue().getValue() > new Date().getTime()) {
                        calendarEventListView.getItems()
                                .add(Taches.indexOf(t) + "- " + "Tâche : " + task.getTitle() + "- DateDebut :"
                                        + startDate.substring(0, 10) + "- DateFin :" + endDate.substring(0, 10));
                    }
                }
            }
            AjouterButton.setOnMouseClicked(event -> {
                String selectedEvent = calendarEventListView.getSelectionModel().getSelectedItem();
                String categorie = comboBoxCategorie.getSelectionModel().getSelectedItem();
                try {
                    controller.initialize(selectedEvent, Taches, idProjet, categorie);
                } catch (ProjetExeption e) {
                    e.MessageErreurAjouterProjet();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
