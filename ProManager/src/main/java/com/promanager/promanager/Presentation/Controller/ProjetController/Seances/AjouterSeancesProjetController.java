package com.promanager.promanager.Presentation.Controller.ProjetController.Seances;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionSeance;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.AjouterSeancesProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Seances.SeancesProjet;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjouterSeancesProjetController {
    private Button Annule;
    private Button Ajouter;
    private Stage stage;
    private DatePicker PickerDateDepart;
    private DatePicker PickerDateFin;
    private TextArea InputDescription;
    private TextField Note;
    private gestionSeance gSeance;
    private gestionProjet gProjet;
    private ArrayList<ObjectId> listeTaches;

    private ObjectId idProj;

    public AjouterSeancesProjetController(AjouterSeancesProjet view, Stage stage, ObjectId idProj) {
        Annule = view.getButtonAnnuler();
        Ajouter = view.getButtonAjouter();
        PickerDateDepart = view.getPickerDateDepart();
        PickerDateFin = view.getPickerDateFin();
        InputDescription = view.getInputDescription();
        gSeance = new gestionSeance();
        gProjet = new gestionProjet();
        Note = view.getNote();
        listeTaches = new ArrayList<>();

        this.idProj = idProj;
        this.stage = stage;
        Ajouter.setOnAction(event -> {
            try {
                AjouterTacheProjet();
                Back();
            } catch (ProjetExeption e) {
                e.MessageErreurAjouterProjet();
            }

        });
        Annule.setOnAction(event -> {
            Back();
        });
    }

    private void AjouterTacheProjet() throws ProjetExeption {
        if (PickerDateDepart.getValue() != null &&
                PickerDateFin.getValue() != null && Note.getText() != null) {
            ObjectId id = gSeance.add( InputDescription.getText(),
                    Date.from(Instant.from((PickerDateDepart
                            .getValue()).atStartOfDay(ZoneId.systemDefault()))),
                    Date.from(Instant.from((PickerDateFin
                            .getValue()).atStartOfDay(ZoneId.systemDefault()))),
                    Note.getText());
            listeTaches = gProjet.get(idProj).getListeSeances();
            listeTaches.add(id);
            gProjet.update(idProj, "Seances", listeTaches);
        } else {
            throw new ProjetExeption();
        }
    }

    private void Back() {
        SeancesProjet AjouterPage = new SeancesProjet(idProj, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void addTacheToProjet(ObjectId idTache) {
        listeTaches = gProjet.get(idProj).getListeSeances();
        listeTaches.add(idTache);
        gProjet.update(idProj, "Seances", listeTaches);

        this.Back();
    }
}