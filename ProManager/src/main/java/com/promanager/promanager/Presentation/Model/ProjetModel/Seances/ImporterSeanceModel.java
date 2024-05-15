package com.promanager.promanager.Presentation.Model.ProjetModel.Seances;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Metier.Service.GoogleCalendarAuth;
import com.promanager.promanager.Presentation.Controller.ProjetController.Seances.ImporterSeanceController;

public class ImporterSeanceModel {
    private ImporterSeanceController controller;
    private ObjectId idProjet;

    public ImporterSeanceModel(ImporterSeanceController controller, ObjectId idProjet) {
        this.controller = controller;
        this.idProjet = idProjet;
    }

    public void initialize(String selectedEvent, ArrayList<Seance> Seances, ObjectId idProjet) throws ProjetExeption {
        if (selectedEvent != null) {
            String[] parts = selectedEvent.split("- ");
            Integer index = Integer.parseInt(parts[0]);

            Seance S = Seances.get(index);

            gestionSeance gSeance = new gestionSeance();
            gestionProjet gProjet = new gestionProjet();
            ObjectId id = gSeance.add(S.getDescriptionSeance(), S.getDateDepartSeance(), S.getDateFinSeance(), " ");

            ArrayList<ObjectId> SEANCES = new ArrayList<>();
            SEANCES = gProjet.get(idProjet).getListeSeances();
            SEANCES.add(id);
            gProjet.update(idProjet, "Seances", SEANCES);
            controller.openTachesProjet(idProjet);

        } else {
            System.out.println("Aucune tâche sélectionnée.");
        }
    }

    public void fetchCalendarData() {
        try {
            Calendar service = GoogleCalendarAuth.getCalendarService();
            Calendar.Events.List request = service.events().list("primary");
            List<Event> events = request.execute().getItems();

            controller.getCalendarEventListView().getItems().clear();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            ArrayList<Seance> Seances = new ArrayList<>();
            for (Event event : events) {
                System.out.println(event);
                if (event.getStart().getDateTime().getValue() > new Date().getTime()) {
                    System.out.println(event.getStart().getDateTime().getValue());
                    String description = event.getDescription();
                    String startDate = sdf.format(event.getStart().getDateTime().getValue());
                    String endDate = sdf.format(event.getEnd().getDateTime().getValue());

                    Seance S = new Seance(description, parseDate(startDate), parseDate(endDate),
                            " ");
                    Seances.add(S);
                    controller.getCalendarEventListView().getItems()
                            .add(Seances.indexOf(S) + "- Description: " + description + "- Début: "
                                    + startDate + "- Fin: " + endDate);
                }
            }

            controller.getAjouterButton().setOnMouseClicked(event -> {
                String selectedEvent = controller.getCalendarEventListView().getSelectionModel().getSelectedItem();
                try {
                    initialize(selectedEvent, Seances, idProjet);
                } catch (ProjetExeption e) {
                    e.MessageErreurAjouterProjet();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}