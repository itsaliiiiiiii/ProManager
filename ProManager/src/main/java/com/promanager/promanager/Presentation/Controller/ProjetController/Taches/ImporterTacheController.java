package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.model.TaskList;
import com.google.api.services.tasks.model.TaskLists;
import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Metier.POJO.Tache;
import com.promanager.promanager.Metier.Service.GoogleCalendarAuth;
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

public class ImporterTacheController {

    private Button addFromGoogleCalendarButton;
    private ListView<String> calendarEventListView;
    private Stage stage;

    public ImporterTacheController(ImporterTache view, Stage stage) {
        this.addFromGoogleCalendarButton = view.getAddFromGoogleCalendarButton();
        this.calendarEventListView=new ListView<>();
        this.stage = stage;
    }
    public void initialize(String selectedEvent,ArrayList<Tache> taches,ObjectId idProjet,String categorie) throws ProjetExeption {
            if (selectedEvent != null) {
                String[] parts = selectedEvent.split("- ");
                Integer index=Integer.parseInt(parts[0]);


                Tache t = taches.get(index);
                t.setCategorieTache(categorie);

                System.out.println(t.getCategorieTache());

                gestionTache gTache=new gestionTache();
                gestionProjet gProjet = new gestionProjet();
                ObjectId id = gTache.add(t.getCategorieTache(),t.getDescriptionTache(),t.getDateDepartTache(),t.getDateFinTache());

                ArrayList<ObjectId> TACHES = new ArrayList<>();
                TACHES=gProjet.get(idProjet).getListeTaches();
                TACHES.add(id);
                gProjet.update(idProjet,"Taches",TACHES);

                openTachesProjet(idProjet);

            } else {
                System.out.println("Aucune tâche sélectionnée.");
            }
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
}
