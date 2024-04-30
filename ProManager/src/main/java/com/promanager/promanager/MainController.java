package com.promanager.promanager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.model.TaskList;
import com.google.api.services.tasks.model.TaskLists;

import java.text.SimpleDateFormat;
import java.util.List;

public class MainController {
    @FXML
    private Button addFromGoogleCalendarButton;

    @FXML
    private ListView<String> calendarEventListView;

    @FXML
    private void initialize() {
        addFromGoogleCalendarButton.setOnAction(event -> fetchCalendarData());

        // addFromGoogleCalendarButton.setOnAction(event -> fetchTasksData());
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
                String startDate = sdf.format(event.getStart().getDateTime().getValue());
                String endDate = sdf.format(event.getEnd().getDateTime().getValue());
                calendarEventListView.getItems().add(summary + " - Début: " + startDate + " Fin: " + endDate);
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

}
