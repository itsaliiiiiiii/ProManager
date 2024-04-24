package com.promanager.promanager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;

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
}

