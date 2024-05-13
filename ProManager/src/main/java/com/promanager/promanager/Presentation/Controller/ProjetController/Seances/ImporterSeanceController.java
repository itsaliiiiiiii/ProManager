package com.promanager.promanager.Presentation.Controller.ProjetController.Seances;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Metier.POJO.Seance;
import com.promanager.promanager.Metier.Service.GoogleCalendarAuth;
import com.promanager.promanager.Presentation.Model.ProjetModel.Seances.ImporterSeanceModel;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.ImporterSeance;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;
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

@SuppressWarnings("unused")
public class ImporterSeanceController {

    private Button addFromGoogleCalendarButton;
    private Button AnnulerButton;
    private Button AjouterButton;
    private ListView<String> calendarEventListView;
    private Stage stage;
    private ObjectId idProjet;
    private ImporterSeanceModel model;

    public ImporterSeanceController(ImporterSeance view, Stage stage, ObjectId idProjet) {
        this.addFromGoogleCalendarButton = view.getAddFromGoogleCalendarButton();
        this.calendarEventListView = new ListView<>();
        AnnulerButton = view.getAnnulerButton();
        AjouterButton = view.getAjouterButton();
        this.stage = stage;
        this.idProjet = idProjet;
        model = new ImporterSeanceModel(this,idProjet);

        addFromGoogleCalendarButton.setOnMouseClicked(event -> {
            model.fetchCalendarData();
        });

        AnnulerButton.setOnMouseClicked(event -> {
            openTachesProjet(idProjet);
        });
    }

    public Button getAjouterButton() {
        return AjouterButton;
    }

    public ListView<String> getCalendarEventListView() {
        return calendarEventListView;
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
