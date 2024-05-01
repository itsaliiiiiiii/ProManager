package com.promanager.promanager.Presentation.View.ProjetView.Taches;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Metier.Service.GoogleCalendarAuth;
import com.promanager.promanager.Presentation.Controller.ProjetController.Taches.ImporterTacheController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.List;

public class ImporterTache extends AnchorPane {
    private Button addFromGoogleCalendarButton;
    private ListView<String> calendarEventListView;
    private Stage stage;
    private ImporterTacheController controller;
    private Button AjouterButton;
    private ObjectId idProjet;

    public ImporterTache(Stage stage, ObjectId id) {
        this.addFromGoogleCalendarButton =  new Button("Add from Google Calendar");
        this.calendarEventListView =  new ListView<>();
        this.controller=new ImporterTacheController(this,stage);
        this.stage=stage;
        this.idProjet=id;
        this.AjouterButton=new Button("Ajouter");
        design();
    }

    public Button getAddFromGoogleCalendarButton() {
        return addFromGoogleCalendarButton;
    }
    public ListView<String> getCalendarEventListView() {
        return calendarEventListView;
    }
    void design(){
        addFromGoogleCalendarButton.setLayoutX(200);
        addFromGoogleCalendarButton.setLayoutY(300);
        addFromGoogleCalendarButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        AjouterButton.setLayoutX(1020);
        AjouterButton.setLayoutY(540);
        AjouterButton.setPrefWidth(150.0);
        AjouterButton.setPrefHeight(40.0);
        AjouterButton.setFont(new Font(18.0));
        AjouterButton.setStyle("-fx-background-color: #6a82ab; -fx-text-fill: white;");
        AjouterButton.setFont(Font.font("Arial", FontWeight.BOLD, 18.0));

        addFromGoogleCalendarButton.setOnMouseClicked(event->{
            fetchCalendarData();
        });
        AjouterButton.setOnMouseClicked(event -> {
            String selectedEvent = calendarEventListView.getSelectionModel().getSelectedItem();
            try {
                controller.initialize(selectedEvent,idProjet);
            } catch (ProjetExeption e) {
                throw new RuntimeException(e);
            }
        });

        VBox root = new VBox(10);
        root.setLayoutX(300);
        root.setLayoutY(120);
        root.setPrefWidth(800);
        root.setPrefHeight(400);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(this.addFromGoogleCalendarButton, this.calendarEventListView);
        this.getChildren().addAll(root,AjouterButton);
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
                calendarEventListView.getItems().add(summary + "- Description: " + event.getDescription() + "- Début: " + startDate + "- Fin: " + endDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
