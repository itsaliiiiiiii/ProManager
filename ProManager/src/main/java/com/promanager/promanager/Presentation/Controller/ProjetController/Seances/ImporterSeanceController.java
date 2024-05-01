package com.promanager.promanager.Presentation.Controller.ProjetController.Seances;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.model.TaskList;
import com.google.api.services.tasks.model.TaskLists;
import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Metier.Service.GoogleCalendarAuth;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.ImporterSeance;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.ImporterTache;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImporterSeanceController {

    private Button addFromGoogleCalendarButton;
    private ListView<String> calendarEventListView;
    private Stage stage;

    public ImporterSeanceController(ImporterSeance view, Stage stage) {
        this.addFromGoogleCalendarButton = view.getAddFromGoogleCalendarButton();
        this.calendarEventListView=new ListView<>();
        this.stage = stage;
    }
    public void initialize(String selectedEvent, ArrayList<Seance> Seances, ObjectId idProjet) throws ProjetExeption {
        if (selectedEvent != null) {
            String[] parts = selectedEvent.split("- ");
            Integer index=Integer.parseInt(parts[0]);

            Seance S = Seances.get(index);

            gestionSeance gSeance=new gestionSeance();
            gestionProjet gProjet = new gestionProjet();
            ObjectId id = gSeance.add(S.getDescriptionSeance(),S.getDateDepartSeance(),S.getDateFinSeance()," ");

            ArrayList<ObjectId> SEANCES = new ArrayList<>();
            SEANCES=gProjet.get(idProjet).getListeSeances();
            SEANCES.add(id);
            gProjet.update(idProjet,"Seances",SEANCES);
            openTachesProjet(idProjet);

        } else {
            System.out.println("Aucune tâche sélectionnée.");
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
    public void openTachesProjet(ObjectId idProjet) {
        SeancesProjet SeancesPage = new SeancesProjet(idProjet, stage);
        Parent projetsRoot = SeancesPage;
        Scene projectsScene = new Scene(projetsRoot, 1300, 800);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.setResizable(false);
        stage.setScene(projectsScene);
        stage.show();
    }
}
