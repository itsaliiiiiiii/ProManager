package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Metier.Service.GoogleCalendarAuth;
import com.promanager.promanager.Persistance.DAOprojet;
import com.promanager.promanager.Presentation.View.ProjetView.AffichageProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AffichageTaches;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.ImporterTache;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.model.TaskList;
import com.google.api.services.tasks.model.TaskLists;
import javafx.stage.Stage;
import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImporterTacheController {

    private Button addFromGoogleCalendarButton;
    private ListView<String> calendarEventListView;
    private Stage stage;

    public ImporterTacheController(ImporterTache view, Stage stage) {
        this.addFromGoogleCalendarButton = view.getAddFromGoogleCalendarButton();
        this.calendarEventListView=new ListView<>();
        this.stage = stage;
//        PrecedentButton.setOnAction(event -> {
//            AffichageProjet AjouterPage = new AffichageProjet(id, stage);
//            Scene projectsScene = new Scene(AjouterPage, 1300, 800);
//            stage.setScene(projectsScene);
//            stage.setTitle("ProManager");
//            stage.setResizable(false);
//            stage.setMinWidth(1300);
//            stage.setMinHeight(800);
//            stage.show();
//        });
    }
    public void initialize(String selectedEvent,ObjectId idProjet) throws ProjetExeption {
            if (selectedEvent != null) {
                String[] parts = selectedEvent.split("- ");
                String description = parts[1].substring(parts[1].indexOf(":") + 2);
                String dateDebut = parts[2].substring(parts[2].indexOf(":") + 2); // Extrait la date de début
                String dateFin = parts[3].substring(parts[3].indexOf(":") + 2); // Extrait la date de fin

                System.out.println(description);
                System.out.println(dateDebut);
                System.out.println(dateFin);

                gestionTache gTache=new gestionTache();
                gestionProjet gProjet = new gestionProjet();

                ObjectId id = gTache.add("Enseignement",description,parseDate(dateDebut),parseDate(dateFin));
                ArrayList<ObjectId> taches = new ArrayList<>();
                taches=gProjet.get(idProjet).getListeTaches();
                taches.add(id);
                gProjet.update(idProjet,"Taches",taches);

                openTachesProjet(idProjet);

            } else {
                System.out.println("Aucune tâche sélectionnée.");
            }
    }

    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void fetchCalendarData() {
        try {
            Calendar service = GoogleCalendarAuth.getCalendarService();
            Calendar.Events.List request = service.events().list("primary");
            List<Event> events = request.execute().getItems();

            calendarEventListView.getItems().clear();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            for (Event event : events) {
                String summary = event.getSummary();
                String description = event.getDescription();
                String startDate = sdf.format(event.getStart().getDateTime().getValue());
                String endDate = sdf.format(event.getEnd().getDateTime().getValue());
                calendarEventListView.getItems().add(summary + "- Description: " + description + "- Début: " + startDate + "- Fin: " + endDate);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchTasksData() {
        try {
            Tasks service = GoogleCalendarAuth.getTasksService();

            // Récupérer la liste des listes de tâches
            Tasks.Tasklists.List requestLists = service.tasklists().list();
            TaskLists taskLists = requestLists.execute();

            // Parcourir chaque liste de tâches
            for (TaskList list : taskLists.getItems()) {
                // Récupérer les tâches de chaque liste
                Tasks.TasksOperations.List requestTasks = service.tasks().list(list.getId());
                com.google.api.services.tasks.model.Tasks tasks = requestTasks.execute();

                // Afficher les tâches de la liste actuelle
                for (com.google.api.services.tasks.model.Task task : tasks.getItems()) {
                    calendarEventListView.getItems().add("Tâche : " + task.getTitle());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void openTachesProjet(ObjectId idProjet) {
        TachesProjet tachesProjet = new TachesProjet(idProjet, stage);
        Parent projetsRoot = tachesProjet;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}
