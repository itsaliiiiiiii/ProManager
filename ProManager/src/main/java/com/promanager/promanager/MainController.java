package com.promanager.promanager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;

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
            for (Event event : events) {
                calendarEventListView.getItems().add(event.getSummary());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
