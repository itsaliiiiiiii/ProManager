package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.model.TaskList;
import com.google.api.services.tasks.model.TaskLists;
import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Metier.Service.GoogleCalendarAuth;
import com.promanager.promanager.Presentation.DB.ProjetModel.Taches.ImporterTacheModel;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.ImporterTache;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ImporterTacheController {

    private Button addFromGoogleCalendarButton;
    private ListView<String> calendarEventListView;
    private Stage stage;
    private Button AnnulerButton;
    private Button AjouterButton;
    private ObjectId idProjet;
    private ComboBox<String> comboBoxCategorie;
    private ImporterTacheModel model;


    public ImporterTacheController(ImporterTache view, Stage stage, ObjectId idProjet) {
        this.addFromGoogleCalendarButton = view.getAddFromGoogleCalendarButton();
        this.calendarEventListView = view.getCalendarEventListView();
        AnnulerButton = view.getAnnulerButton();
        AjouterButton = view.getAjouterButton();
        this.idProjet = idProjet;
        comboBoxCategorie = view.getComboBoxCategorie();

        this.stage = stage;
        model = new ImporterTacheModel(this);

        addFromGoogleCalendarButton.setOnMouseClicked(event -> {
            fetchTasksData();
        });
        
        AnnulerButton.setOnMouseClicked(event -> {
            openTachesProjet(idProjet);
        });
        
    }

    public Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void openTachesProjet(ObjectId idProjet) {
        TachesProjet tachesProjet = new TachesProjet(idProjet, stage);
        Parent projetsRoot = tachesProjet;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }

    public void fetchTasksData() {
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

                    String description = task.getNotes();
                    String startDate = String.valueOf(task.getDue());
                    String endDate = String.valueOf(task.getDue());

                    Tache t = new Tache(" ", description, parseDate(startDate),
                            parseDate(endDate));
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
                    model.initialize(selectedEvent, Taches, idProjet, categorie);
                } catch (ProjetExeption e) {
                    e.MessageErreurAjouterProjet();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
