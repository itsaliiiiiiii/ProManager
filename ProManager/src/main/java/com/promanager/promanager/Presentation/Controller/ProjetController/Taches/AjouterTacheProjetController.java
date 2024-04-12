package com.promanager.promanager.Presentation.Controller.ProjetController.Taches;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;

import com.promanager.promanager.Metier.Exeptions.ProjetExeption;
import com.promanager.promanager.Metier.Gestion.gestionDocument;
import com.promanager.promanager.Metier.Gestion.gestionProjet;
import com.promanager.promanager.Metier.Gestion.gestionTache;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.AjouterTacheProjet;
import com.promanager.promanager.Presentation.View.ProjetView.Taches.TachesProjet;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class AjouterTacheProjetController {
    private Button Annule;
    private Button Ajouter;
    private Stage stage;
    private ComboBox<String> comboBoxCategorie;
    private DatePicker PickerDateDepart;
    private DatePicker PickerDateFin;
    private TextArea InputDescription;
    private gestionTache gTache;
    private gestionProjet gProjet;
    private ArrayList<ObjectId> listeTaches;

    private ObjectId idProj;

    public AjouterTacheProjetController(AjouterTacheProjet view, Stage stage, ObjectId idProj) {
        Annule = view.getButtonAnnuler();
        Ajouter = view.getButtonAjouter();
        comboBoxCategorie = view.getComboBoxCategorie();
        PickerDateDepart = view.getPickerDateDepart();
        PickerDateFin = view.getPickerDateFin();
        InputDescription = view.getInputDescription();
        gTache = new gestionTache();
        gProjet = new gestionProjet();
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
        if (comboBoxCategorie.getSelectionModel().getSelectedItem() != null &&
                PickerDateDepart.getValue() != null &&
                PickerDateFin.getValue() != null) {
            ObjectId id = gTache.add(
                    comboBoxCategorie.getSelectionModel().getSelectedItem(), InputDescription.getText(),
                    Date.from(Instant.from((PickerDateDepart
                            .getValue()).atStartOfDay(ZoneId.systemDefault()))),
                    Date.from(Instant.from((PickerDateFin
                            .getValue()).atStartOfDay(ZoneId.systemDefault()))));
            listeTaches = gProjet.get(idProj).getListeTaches();
            listeTaches.add(id);
            gProjet.update(idProj, "Taches", listeTaches);
        } else {
            throw new ProjetExeption();
        }
    }

    private void Back() {
        TachesProjet AjouterPage = new TachesProjet(idProj, stage);
        Scene projectsScene = new Scene(AjouterPage, 1300, 800);
        stage.setScene(projectsScene);
        stage.setTitle("ProManager");
        stage.setResizable(false);
        stage.setMinWidth(1300);
        stage.setMinHeight(800);
        stage.show();
    }

    public void addTacheToProjet(ObjectId idTache) {
        listeTaches = gProjet.get(idProj).getListeTaches();
        listeTaches.add(idTache);
        gProjet.update(idProj, "Taches", listeTaches);
        
        this.Back();
    }
}